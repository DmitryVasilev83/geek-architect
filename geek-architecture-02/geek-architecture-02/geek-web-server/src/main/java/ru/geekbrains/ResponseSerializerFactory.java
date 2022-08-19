package ru.geekbrains;

import ru.geekbrains.config.ServerConfig;

public final class ResponseSerializerFactory {

    public static ResponseSerializer create(){
        return new ResponseSerializer();
    }
}
