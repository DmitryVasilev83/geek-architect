package ru.geekbrains.service;

import java.util.Deque;

public interface SocketServiceInt {

    public Deque<String> readRequest();
    public void writeResponse(String rawResponse);
    public void close();
}
