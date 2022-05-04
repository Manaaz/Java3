package messenger.chatServer;

import java.io.IOException;
import java.util.logging.Logger;

public class ServerApp {

    private static final EventLogging eventLogging = new EventLogging();

    private static final int DEFAULT_PORT = 8187;

    public static void main(String[] args) {
        try {
            new MyServer(DEFAULT_PORT).start();
        } catch (IOException e) {
            //e.printStackTrace();
            eventLogging.eventLog("Произошла ошибка: " + e.getMessage(), "error");
        }
    }
}
