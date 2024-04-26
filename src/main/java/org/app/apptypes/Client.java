package org.app.apptypes;

import org.app.utils.Args;

import java.io.*;
import java.net.Socket;

public final class Client implements App {

    private final Args args;

    public Client(Args args) {
        this.args = args;
    }

    public void run() {
        try (
                var socket = new Socket(args.inetAddress(), args.port());
                var reader = new DataInputStream(socket.getInputStream());
                var writer = new DataOutputStream(socket.getOutputStream())
        ) {

            var request = args.values().first() + " " + args.values().second();
            System.out.println(">> Sending request: " + request);

            writer.writeUTF(request);
            writer.flush();

            System.out.println(">> Getting result: " + reader.readUTF());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
