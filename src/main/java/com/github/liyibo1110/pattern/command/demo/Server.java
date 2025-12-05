package com.github.liyibo1110.pattern.command.demo;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author liyibo
 * @date 2025-12-05 17:22
 */
@Slf4j
public class Server {

    /**
     * 由Client负责来实现
     */
    public interface Command extends Serializable {
        int calculate(int a, int b);
    }

    /**
     * 持续监听Client传递来的Command并执行，此时的Command就是进行了行为参数化
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        log.info("server start...");

        ExecutorService executor = Executors.newFixedThreadPool(10);
        while(true) {
            Socket socket = server.accept();
            executor.submit(() -> {
               try(var is = new ObjectInputStream(socket.getInputStream())) {
                   Command command = (Command)is.readObject();
                   int a = queryDataFromDB();
                   int b = queryDataFromDB();
                   log.info("client: {}, a: {}, b: {}, result: {}",
                           socket.getRemoteSocketAddress().toString(),
                           a, b, command.calculate(a, b));
               } catch (Exception e) {
                   throw new RuntimeException(e);
               }
            });
        }
    }

    private static int queryDataFromDB() {
        return ThreadLocalRandom.current().nextInt(10);
    }
}
