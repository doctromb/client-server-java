package org.app.apptypes;

import org.app.enums.Mode;
import org.app.utils.Args;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppFactoryTest {

    @Test
    void createClientTest() {
        var factory = new AppFactory(Args.builder().mode(Mode.CLIENT).build());
        var app = factory.createApp();
        assertNotNull(app);
        assertInstanceOf(Client.class, app);
    }

    @Test
    void createServerTest() {
        var factory = new AppFactory(Args.builder().mode(Mode.SERVER).build());
        var app = factory.createApp();
        assertNotNull(app);
        assertInstanceOf(Server.class, app);
    }

    @Test
    void tryCreateUnknownAppTest() {
        var factory = new AppFactory(Args.builder().mode(Mode.NULL).build());
        assertThrows(IllegalArgumentException.class, factory::createApp);
    }
}