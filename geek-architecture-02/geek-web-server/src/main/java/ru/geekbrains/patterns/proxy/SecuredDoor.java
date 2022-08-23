package ru.geekbrains.patterns.proxy;

public class SecuredDoor {

    protected Door door;

    public SecuredDoor(Door door) {
        this.door = door;
    }

    public void open(String password) {

        if (authenticate(password)) {
            door.open();
        } else {
            System.out.println("Big no! It ain't possible.");;
        }
    }

    public boolean authenticate(String password)    {
        return password == "$ecr@t";
    }

    public void close()
    {
        door.close();
    }
}
