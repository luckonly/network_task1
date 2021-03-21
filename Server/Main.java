package network_task1.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {
        int port = 8080;
        try (ServerSocket serverSocket = new ServerSocket(port);
             Socket clientSocket = serverSocket.accept();
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));) {
            out.println("Server output line");
            System.out.println("New connection accepted");
            final String name = in.readLine();
            System.out.println(String.format("Hi %s, your port is %d", name, clientSocket.getPort()));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
