package org.app.enums;

public enum Mode {
    NULL(""),
    SERVER("server"),
    CLIENT("client");

    private final String modeName;

    Mode(String modeName) {
        this.modeName = modeName;
    }

    public String modeName() {
        return modeName;
    }

    public static Mode of(String modeName) {
        for (Mode mode : Mode.values()) {
            if (mode.modeName().equals(modeName)) {
                return mode;
            }
        }
        return NULL;
    }
}
