package ru.geekbrains;

import ru.geekbrains.domain.HttpRequest;

import java.util.Deque;

public interface RequestParserInt {
    public HttpRequest parse(Deque<String> rawRequest);
}
