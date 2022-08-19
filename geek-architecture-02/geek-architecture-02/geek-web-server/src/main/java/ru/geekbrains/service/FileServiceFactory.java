package ru.geekbrains.service;

import ru.geekbrains.config.ServerConfig;

public final class FileServiceFactory {


    public static FileServiceInt create(String rootDir){
        return new FileService(rootDir);
    }

}
