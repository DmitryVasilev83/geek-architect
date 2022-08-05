package ru.geekbrains;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class ResponceHandler {

    WorkWithFiles workWithFiles;
    Socket socket;
    PrintWriter output;

    public ResponceHandler(WorkWithFiles workWithFiles, Socket socket, PrintWriter output) {
        this.workWithFiles = workWithFiles;
        this.socket = socket;
        this.output = output;
    }

    public void responce_200() throws IOException {
        output.println("HTTP/1.1 200 OK");
        output.println("Content-Type: text/html; charset=utf-8");
        output.println();
        workWithFiles.getFile().transferTo(output);
    }

    public void responce_404(){
        output.println("HTTP/1.1 404 NOT_FOUND");
        output.println("Content-Type: text/html; charset=utf-8");
        output.println();
        output.println("<h1>Файл не найден!</h1>");
        output.flush();
    }
}
