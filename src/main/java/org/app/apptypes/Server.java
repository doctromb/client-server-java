package org.app.apptypes;

import org.app.utils.Args;

import java.io.*;
import java.net.ServerSocket;

public class Server implements App {

    private final Args args;

    public Server(Args args) {
        this.args = args;
    }

    public void run() {
        System.out.println(">> Started Server with operation " + args.operation().operation() + " on port " + args.port());
        try (var serverSocket = new ServerSocket(args.port())) {
            while (true) {

                try (var clientSocket = serverSocket.accept();
                     var reader = new DataInputStream(clientSocket.getInputStream());
                     var writer = new DataOutputStream(clientSocket.getOutputStream())
                ) {

                    var request = reader.readUTF();
                    System.out.println(">> Received request: " + request);

                    var array = request.split(" ");
                    var var1 = Integer.parseInt(array[0].trim());
                    var var2 = Integer.parseInt(array[1].trim());
                    var result = operationResult(request);

                    System.out.println(">> Accepted client: "
                            + var1 + " " + args.operation().operation() + " "
                            + var2 + " = " + result);

                    writer.writeUTF(String.valueOf(result));
                    writer.flush();
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Can't start server on port " + args.port());
        }
    }

    private int operationResult(String request) {

        var array = request.split(" ");
        var var1 = Integer.parseInt(array[0].trim());
        var var2 = Integer.parseInt(array[1].trim());

        switch (args.operation().operation()) {
            case "+" -> {
                return var1 + var2;
            }
            case "-" -> {
                return var1 - var2;
            }
            case "*" -> {
                return var1 * var2;
            }
            case "/" -> {
                return var1 / var2;
            }
            default -> throw new IllegalArgumentException("Invalid operation type.");
        }
    }
}
