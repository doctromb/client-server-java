package org.app.enums;

public enum Operation {

    UNKNOWN(""),
    PLUS("+"),
    MINUS("-"),
    DIVIDE("/"),
    MULTIPLY("*");

    private final String operation;

    Operation(String operation) {
        this.operation = operation;
    }

    public String operation() {
        return operation;
    }

    public static Operation of(String operation) {
        for (Operation op : Operation.values()) {
            if (op.operation().equals(operation)) {
                return op;
            }
        }
        return UNKNOWN;
    }
}
