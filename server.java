// ChatServer.java

import java.io.*;
import java.net.*;
import java.util.*;

public class server {
    private static Set<Socket> clientSockets = new HashSet<>();

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(12345);
        System.out.println("Server started on port 12345...");

        while (true) {
            Socket clientSocket = serverSocket.accept();
            clientSockets.add(clientSocket);
            System.out.println("New client connected: " + clientSocket);

            new Thread(new ClientHandler(clientSocket)).start();
        }
    }

    static class ClientHandler implements Runnable {
        private Socket socket;
        private BufferedReader input;
        private PrintWriter output;

        public ClientHandler(Socket socket) {
            this.socket = socket;
            try {
                input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                output = new PrintWriter(socket.getOutputStream(), true);
            } catch (IOException e) {
                System.out.println("ClientHandler error: " + e.getMessage());
            }
        }

        public void run() {
            String message;
            try {
                while ((message = input.readLine()) != null) {
                    System.out.println("Received: " + message);
                    broadcast(message);
                }
            } catch (IOException e) {
                System.out.println("Client disconnected: " + socket);
            } finally {
                try {
                    socket.close();
                    clientSockets.remove(socket);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        private void broadcast(String message) {
            for (Socket s : clientSockets) {
                try {
                    PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
                    pw.println(message);
                } catch (IOException e) {
                    System.out.println("Broadcast error: " + e.getMessage());
                }
            }
        }
    }
}
