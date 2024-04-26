package org.app.utils;

import org.app.enums.Mode;
import org.app.enums.Operation;

import java.net.InetAddress;

public final class Args {

    private final Mode mode;
    private final int port;
    private final Operation operation;
    private final InetAddress inetAddress;
    private final Pair<Integer, Integer> values;

    private Args(ArgsBuilder builder) {
        this.mode = builder.mode;
        this.port = builder.port;
        this.operation = builder.operation;
        this.inetAddress = builder.inetAddress;
        this.values = builder.values;
    }

    public static ArgsBuilder builder() {
        return new ArgsBuilder();
    }

    public Mode mode() {
        return mode;
    }

    public int port() {
        return port;
    }

    public Operation operation() {
        return operation;
    }

    public InetAddress inetAddress() {
        return inetAddress;
    }

    public Pair<Integer, Integer> values() {
        return values;
    }

    public static final class ArgsBuilder {

        private Mode mode;
        private int port;
        private Operation operation;
        private InetAddress inetAddress;
        private Pair<Integer, Integer> values;

        public ArgsBuilder mode(Mode mode) {
            this.mode = mode;
            return this;
        }

        public ArgsBuilder port(int port) {
            this.port = port;
            return this;
        }

        public ArgsBuilder operation(Operation operation) {
            this.operation = operation;
            return this;
        }

        public ArgsBuilder inetAddress(InetAddress inetAddress) {
            this.inetAddress = inetAddress;
            return this;
        }

        public ArgsBuilder values(Pair<Integer, Integer> values) {
            this.values = values;
            return this;
        }

        public Args build() {
            return new Args(this);
        }
    }
}
