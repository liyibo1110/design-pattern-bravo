package com.github.liyibo1110.pattern.command.demo;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * @author liyibo
 * @date 2025-12-05 17:29
 */
public class Client {
    public static void main(String[] args) throws IOException {
        try(Socket socket = new Socket("127.0.0.1", 8080)) {
            Server.Command command = (a, b) -> a + b + 10;
            ObjectOutputStream os = new ObjectOutputStream(socket.getOutputStream());
            os.writeObject(command);
            os.flush();
        }
    }
}
