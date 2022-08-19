package ru.geekbrains.service;

public interface FileServiceInt {

    public boolean exists(String filename);
    public boolean isDirectory(String filename);
    public String readFile(String filename);
}
