package org.app.utils;

import org.app.enums.Mode;
import org.app.enums.Operation;

import java.net.InetAddress;
import java.net.UnknownHostException;

public final class ArgsParser {

    public static Args parse(String[] args) {
        if (args.length == 3) {

            return Args.builder()
                    .mode(Mode.of(args[0].trim().toLowerCase()))
                    .port(Integer.parseInt(args[1].trim()))
                    .operation(Operation.of(args[2].trim()))
                    .build();

        } else if (args.length == 5) {

            try {
                return Args.builder()
                        .mode(Mode.of(args[0].trim().toLowerCase()))
                        .inetAddress(InetAddress.getByName(args[1].trim().toLowerCase()))
                        .port(Integer.parseInt(args[2].trim()))
                        .values(Pair.of(Integer.parseInt(args[3].trim()), Integer.parseInt(args[4].trim())))
                        .build();
            } catch (UnknownHostException e) {
                throw new UndefinedHostException(e);
            }

        } else {
            throw new IllegalArgumentException("Invalid number of arguments: " + args.length);
        }
    }
}
