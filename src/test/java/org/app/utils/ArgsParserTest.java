package org.app.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArgsParserTest {

    @Test
    void testParseServerArgs() {

        var args = new String[] { "server", "8000", "*" };
        var res = ArgsParser.parse(args);

        assertNotNull(res);
        assertEquals("server", res.mode().modeName());
        assertEquals(8000, res.port());
        assertEquals("*", res.operation().operation());
    }

    @Test
    void testParseClientArgs() {

        var args = new String[] { "client", "localhost", "8000", "2", "3" };
        var res = ArgsParser.parse(args);

        assertNotNull(res);
        assertEquals("client", res.mode().modeName());
        assertEquals("localhost", res.inetAddress().getHostName());
        assertEquals(8000, res.port());
        assertEquals("2", String.valueOf(res.values().first()));
        assertEquals("3", String.valueOf(res.values().second()));
    }

    @Test
    void tryParseUnexpectedArgs() {
        var args = new String[] { };
        assertThrows(IllegalArgumentException.class, () -> ArgsParser.parse(args));
    }

    @Test
    void testUnknownHost() {
        var args = new String[] { "client", "lclhst", "8000", "2", "3" };
        assertThrows(UndefinedHostException.class, () -> ArgsParser.parse(args));
    }
}