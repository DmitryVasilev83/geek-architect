package ru.geekbrains;

import ru.geekbrains.RequestParser;
import ru.geekbrains.RequestParserInt;
import ru.geekbrains.config.ServerConfig;

public final class RequestParserFactory {

    public static RequestParserInt create(){
        return new RequestParser();
    }

}
