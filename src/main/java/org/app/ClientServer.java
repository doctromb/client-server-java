package org.app;

import org.app.apptypes.AppFactory;
import org.app.utils.ArgsParser;

public class ClientServer {

    public static void main(String[] args) {
        var factory = new AppFactory(ArgsParser.parse(args));
        var app = factory.createApp();
        var appThread = new Thread(app);
        appThread.start();
    }
}
