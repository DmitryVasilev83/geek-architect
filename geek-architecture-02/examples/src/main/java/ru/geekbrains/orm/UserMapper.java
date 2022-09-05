package ru.geekbrains.orm;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class UserMapper {

    private final Connection conn;

    private final PreparedStatement selectUser;

    private final Map<Long, User> identityMap = new HashMap<>();

    public UserMapper(Connection conn) {
        this.conn = conn;
        try {
            this.selectUser = conn.prepareStatement("select id, username, password from users where id = ?");
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    public Optional<User> findById(long id) {
        User user = identityMap.get(id);
        if (user != null) {
            return Optional.of(user);
        }
        try {
            selectUser.setLong(1, id);
            ResultSet rs = selectUser.executeQuery();
            if (rs.next()) {
                user = new User(rs.getLong(1), rs.getString(2), rs.getString(3));
                identityMap.put(id, user);
                return Optional.of(user);
            }
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
        return Optional.empty();
    }

    public void update(User user) {
        if (user.getId() == null) {
            throw new IllegalArgumentException("No id in entity to update");
        }
        User oldUser = findById(user.getId()).orElseThrow(() -> new IllegalStateException("No entity with id"));
        oldUser.setLogin(user.getLogin());
        oldUser.setPassword(user.getPassword());
        identityMap.put(oldUser.getId(), oldUser);
        // TODO
        // DZ 6
        try {
            PreparedStatement updateUser = conn.prepareStatement(
                    "UPDATE users SET username = ?, password = ? WHERE id = ?");
            updateUser.setString(1, user.getLogin());
            updateUser.setString(2, user.getPassword());
            updateUser.setString(3, user.getId().toString());
            updateUser.executeUpdate();

        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
        identityMap.put(user.getId(), user);

    }

    public User insert(User user) {
        if (user.getId() != null) {
            throw new IllegalArgumentException("New entity should not have id");
        }
        // TODO
        //user.setId(...);

        // DZ  7
        try {
            PreparedStatement insertUser = conn.prepareStatement("INSERT INTO users (username, password) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);
            insertUser.setString(1, user.getLogin());
            insertUser.setString(2, user.getPassword());
            insertUser.executeUpdate();
            ResultSet rs = insertUser.getGeneratedKeys();
            Long userId = null;
            if (rs.next()) {
                userId = rs.getLong(1);

            }
            user.setId(userId);
            identityMap.put(user.getId(), user);
        } catch (SQLException e) {
            throw new IllegalStateException(e);

        }
        return user;
    }

    public void delete(User user) {
        if (user.getId() == null) {
            throw new IllegalArgumentException("No id in entity to update");
        }
        try {
            PreparedStatement deleteUser = conn.prepareStatement(
                    "DELETE FROM users WHERE id = ?");
            deleteUser.setString(1, user.getId().toString());
            deleteUser.executeUpdate();
            if (identityMap.containsKey(user.getId())){
                identityMap.remove(user.getId(), user);
            }

        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }

    }

    public void beginTransaction(){
        try {
            conn.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void commitTransaction(){
        try {
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
