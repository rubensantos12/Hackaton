package org.canonymous.chat.user;

import org.canonymous.chat.server.RoomManager;

import java.net.Socket;

public class UserHandler implements Runnable{

    private Socket clientSocket;
    private RoomManager roomManager;

    public UserHandler(Socket clientSocket, RoomManager roomManager) {
        this.clientSocket = clientSocket;
        this.roomManager = roomManager;
    }

    @Override
    public void run() {

    }
}
