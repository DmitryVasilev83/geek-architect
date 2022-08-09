package ru.geekbrains;

import ru.geekbrains.domain.HttpResponse;

public class ResponseSerializer {

    public String serialize(HttpResponse response) {

        String rawResponse =
                    response.getHttpVers() +
                    response.getStatusCode() + "\n" +
                    "Content-Type: " + response.getHeaders().get("Content-Type:") +
                    "\n" + "\n" +
                    "<h1>" + response.getBody() + "</h1>";
        return rawResponse;
    }
}
