package com.epam.websockets.server;

import java.util.HashMap;
import java.util.Scanner;

import javax.websocket.DeploymentException;

import org.glassfish.tyrus.server.Server;

import com.epam.websockets.endpoint.ChatEndpoint;

public class MyChatServer {

    public static void main(String[] args) {
		Server server = new Server("localhost", 8025, "/ws",new HashMap<>(), ChatEndpoint.class);
        try {
            server.start();
            System.out.println("Press any key to stop the server..");
            new Scanner(System.in).nextLine();
        } catch (DeploymentException e) {
            throw new RuntimeException(e);
        } finally {
            server.stop();
        }
    }

}