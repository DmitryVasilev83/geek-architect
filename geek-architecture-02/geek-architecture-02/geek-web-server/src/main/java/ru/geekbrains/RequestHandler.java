package ru.geekbrains;

import ru.geekbrains.domain.HttpRequest;
import ru.geekbrains.domain.HttpResponse;
import ru.geekbrains.service.FileService;
import ru.geekbrains.service.FileServiceInt;
import ru.geekbrains.service.SocketService;
import ru.geekbrains.service.SocketServiceInt;

import java.io.IOException;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class RequestHandler implements Runnable {

    private final SocketServiceInt socketService;
    private final FileServiceInt fileService;    //DZ 3
    private final RequestParserInt requestParser;
    private final ResponseSerializerInt responseSerializer;

    public RequestHandler(SocketServiceInt socketService,
                          FileServiceInt fileService,
                          RequestParserInt requestParser,
                          ResponseSerializerInt responseSerializer) {
        this.socketService = socketService;
        this.fileService = fileService;
        this.requestParser = requestParser;
        this.responseSerializer = responseSerializer;
    }

    @Override
    public void run() {
        Deque<String> rawRequest = socketService.readRequest();
        HttpRequest req = requestParser.parse(rawRequest);

        if (!fileService.exists(req.getUrl())) {
//            HttpResponse resp = new HttpResponse();
//            resp.setStatusCode(404);
//            resp.setStatusCodeName("NOT_FOUND");
//            resp.getHeaders().put("Content-Type", "text/html; charset=utf-8");

// DZ les 3
            Map<String, String> headers = new HashMap<>();
            headers.put("Content-Type", "text/html; charset=utf-8");
            HttpResponse resp = HttpResponse.createBuilder()
                    .withStatusCode(404)
                    .withStatusCodeName("NOT_FOUND")
                    .withHeaders(headers)
                    .build();
            socketService.writeResponse(responseSerializer.serialize(resp));
            return;
        }

//        HttpResponse resp = new HttpResponse();
//        resp.setStatusCode(200);
//        resp.setStatusCodeName("OK");
//        resp.getHeaders().put("Content-Type", "text/html; charset=utf-8");
//        resp.setBody(fileService.readFile(req.getUrl()));

        // DZ les 3
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "text/html; charset=utf-8");
        HttpResponse resp = HttpResponse.createBuilder()
                .withStatusCode(200)
                .withStatusCodeName("OK")
                .withHeaders(headers)
                .withBody(fileService.readFile(req.getUrl()))
                .build();

        socketService.writeResponse(responseSerializer.serialize(resp));

        socketService.close();
        System.out.println("Client disconnected!");
    }
}
