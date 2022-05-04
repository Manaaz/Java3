package messenger.chatServer;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class EventLogging {
    private final Logger LoggerConsole;
    private final Logger LoggerFile;

    public EventLogging() {
        LoggerConsole = Logger.getLogger("serverConsole");
        LoggerFile = Logger.getLogger("file");
        PropertyConfigurator.configure("src/main/resources/logs/configs/log4j.properties");
    }

    public void eventLog(String eventMessage, String event) {
        if (event.equals("info")) {
            LoggerConsole.info(eventMessage);
            LoggerFile.info(eventMessage);
        } else if (event.equals("error")) {
            LoggerConsole.error(eventMessage);
            LoggerFile.error(eventMessage);
        }
    }
}
