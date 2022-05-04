package messenger.chatServer;

import lombok.extern.log4j.Log4j2;
import messenger.chatServer.authentication.AuthenticationService;
import messenger.chatServer.authentication.BaseAuthenticationService;
import messenger.chatServer.authentication.DBAuthenticationService;
import messenger.chatServer.handler.ClientHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MyServer {

    private static final EventLogging eventLogging = new EventLogging();

    private final ServerSocket serverSocket;
    private final AuthenticationService authenticationService;
    private final List<ClientHandler> clients;

    public MyServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        authenticationService = new DBAuthenticationService(); //new BaseAuthenticationService();
        clients = new ArrayList<>();
    }

    public void start() {
        eventLogging.eventLog("СЕРВЕР ЗАПУЩЕН!", "info");
        eventLogging.eventLog("----------------", "info");

        try {
            while(true) {

                waitAndProcessNewClientConnection();
            }
        } catch (IOException e) {
            //e.printStackTrace();
            eventLogging.eventLog("Произошла ошибка: " + e.getMessage(), "error");
        }

    }

    private void waitAndProcessNewClientConnection() throws IOException {
        //System.out.println("Ожидание клиента...");
        eventLogging.eventLog("Ожидание клиента...", "info");

        Socket socket = serverSocket.accept();

        //System.out.println("Клиент подключился!");
        eventLogging.eventLog("Клиент подключился!", "info");

        processClientConnection(socket);
    }

    private void processClientConnection(Socket socket) throws IOException {
        ClientHandler handler = new ClientHandler(this, socket);
        handler.handle();
    }

    public synchronized void subscribe(ClientHandler clientHandler) {
        clients.add(clientHandler);
    }

    public synchronized void unSubscribe(ClientHandler clientHandler) {
        clients.remove(clientHandler);
    }

    public synchronized boolean isUsernameBusy(String username) {
        for (ClientHandler client : clients) {
            if (client.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    public AuthenticationService getAuthenticationService() {
        return authenticationService;
    }

    public synchronized void broadcastMessage(String message, ClientHandler sender, boolean isServerMessage) throws IOException {
        for (ClientHandler client : clients) {
            if (client == sender) {
                continue;
            }
            client.sendMessage(message, isServerMessage ? null : sender.getUsername());
        }
    }

    public synchronized void broadcastMessageToSender(String message, ClientHandler sender, boolean isServerMessage) throws IOException {
        for (ClientHandler client : clients) {
            if (client == sender) {
                client.sendMessage(message, isServerMessage ? null : sender.getUsername());
            }
        }
    }

    public synchronized void broadcastMessage(String message, ClientHandler sender) throws IOException {
        broadcastMessage(message, sender, false);
    }

    public synchronized void sendPrivateMessage(String privateMessage, ClientHandler sender, String recipient) throws IOException {
        for (ClientHandler client : clients) {
            if (client.getUsername().equals(recipient)) {
                client.sendMessage(sender.getUsername(), privateMessage);
            }
        }
    }

    public String getClients() {
        String stringUserList = "";
        for (ClientHandler s : clients) {
            stringUserList += s.getUsername()
                                + System.lineSeparator();
        }
        return stringUserList;
    }

    public boolean renameUser(String login, String newUserName) {

        authenticationService.renameUser(login, newUserName);

        return false;
    }
}
