package ru.geekbrains.service;

import java.net.Socket;

public final class SocketServiceFactory {

    public static SocketServiceInt create(Socket socket){
        return new SocketService(socket);
    }
}
