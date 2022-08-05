package org.canonymous.chat.server;

import org.canonymous.chat.user.UserHandler;
import org.h2.engine.User;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RoomManager {

    private final int MAX_USERS = 2;
    private final int PORT = 8080;
    public ArrayList<UserHandler> users = new ArrayList<>();
    private ServerSocket socket;
    private int connections = 0;
    ExecutorService pool;
    private UserHandler userHandler;

   public void listen() {
       UserHandler userHandler;
        try {
            connections = 0;
            socket = new ServerSocket(PORT);
           pool = Executors.newFixedThreadPool(MAX_USERS);
            while (connections != 2) {
                Socket clientSocket = socket.accept();

                userHandler = new UserHandler(clientSocket,this);
                connections++;


                users.add(userHandler);
            }

            for (UserHandler usersFromList : users) {
                pool.submit(usersFromList);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean test() {
       if (connections >= 2) {
           return true;
       } else {
           return false;
       }
    }

}
