package ru.geekbrains;

import ru.geekbrains.domain.HttpRequest;
import ru.geekbrains.domain.HttpResponse;
import ru.geekbrains.service.FileService;
import ru.geekbrains.service.SocketService;

import java.io.IOException;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class RequestHandler implements Runnable {

    private final SocketService socketService;

    private final FileService fileService;

    public RequestHandler(SocketService socketService, FileService fileService) {
        this.socketService = socketService;
        this.fileService = fileService;
    }

    @Override
    public void run() {
        Deque<String> rawRequest = socketService.readRequest();

        HttpRequest httpRequest = new RequestParser().parse(rawRequest);


        if (!fileService.exists(httpRequest.getPath())) {
            HttpResponse httpResponse = new HttpResponse();
            httpResponse.setHttpVers(httpRequest.getHttpVers());
            httpResponse.setStatusCode(" 404 NOT_FOUND");
            Map<String, String> mapResp = new HashMap<>();
            mapResp.put("Content-Type:", "text/html; charset=utf-8");
            httpResponse.setHeaders(mapResp);
            httpResponse.setBody("Файл не найден!");
            socketService.writeResponse(new ResponseSerializer().serialize(httpResponse));
            return;
        }

        HttpResponse httpResponse = new HttpResponse();
        httpResponse.setHttpVers(httpRequest.getHttpVers());
        httpResponse.setStatusCode(" 200 OK");
        Map<String, String> mapResp = new HashMap<>();
        mapResp.put("Content-Type:", "text/html; charset=utf-8");
        httpResponse.setHeaders(mapResp);
        httpResponse.setBody(fileService.readFile(httpRequest.getPath()));
        ResponseSerializer responseSerializer = new ResponseSerializer();
        System.out.println(responseSerializer.serialize(httpResponse)); // test
        socketService.writeResponse(responseSerializer.serialize(httpResponse));

        try {
            socketService.close();
        } catch (IOException ex) {
            throw new IllegalStateException(ex);
        }
        System.out.println("Client disconnected!");
    }
}
