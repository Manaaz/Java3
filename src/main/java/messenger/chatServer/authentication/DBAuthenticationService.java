package messenger.chatServer.authentication;

import messenger.chatServer.DbConnector;
import messenger.chatServer.EventLogging;

import java.sql.SQLException;
public class DBAuthenticationService implements AuthenticationService{

    private static final EventLogging eventLogging = new EventLogging();

    DbConnector dbConnector;

    public DBAuthenticationService() {
        this.dbConnector = new DbConnector();
    }

    @Override
    public String getUsernameByLoginAndPassword(String login, String password) {
        try {
            dbConnector.connection();
            String userName =  dbConnector.getUsernameByLoginAndPassword(login, password);
            dbConnector.disconnect();
            return userName;
        } catch (SQLException e) {
            //e.printStackTrace();
            eventLogging.eventLog("Произошла ошибка: " + e.getMessage(), "error");
        } catch (ClassNotFoundException e) {
            //e.printStackTrace();
            eventLogging.eventLog("Произошла ошибка: " + e.getMessage(), "error");
        }
        return null;
    }

    @Override
    public void startAuthentication() {
        //System.out.println("Старт аутентификации");
        eventLogging.eventLog("Старт аутентификации", "info");
    }

    @Override
    public void endAuthentication() {
        //System.out.println("Конец аутентификации");
        eventLogging.eventLog("Конец аутентификации", "info");
    }

    @Override
    public boolean renameUser(String login, String newUserName) {
        try {
            dbConnector.connection();
            dbConnector.updateUsername(login, newUserName);
            dbConnector.disconnect();
            return true;
        } catch (SQLException e) {
            //e.printStackTrace();
            eventLogging.eventLog("Произошла ошибка: " + e.getMessage(), "error");
        } catch (ClassNotFoundException e) {
            //e.printStackTrace();
            eventLogging.eventLog("Произошла ошибка: " + e.getMessage(), "error");
        }
        return false;
    }


}
