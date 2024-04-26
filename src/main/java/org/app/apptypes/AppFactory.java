package org.app.apptypes;

import org.app.enums.Mode;
import org.app.utils.Args;

public final class AppFactory {

    private final Args args;

    public AppFactory(Args args) {
        this.args = args;
    }

    public App createApp() {
        if (args.mode() == Mode.CLIENT) {
            return new Client(args);
        } else if (args.mode() == Mode.SERVER) {
            return new Server(args);
        } else {
            throw new IllegalArgumentException("Unsupported mode: " + args.mode());
        }
    }
}
