package ru.geekbrains;

import ru.geekbrains.domain.HttpResponse;

public interface ResponseSerializerInt {
    public String serialize(HttpResponse response);
}
