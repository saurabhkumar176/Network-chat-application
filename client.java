// ChatClient.java

import java.io.*;
import java.net.*;

public class client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 12345);
        System.out.println("Connected to server.");

        BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader serverInput = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter serverOutput = new PrintWriter(socket.getOutputStream(), true);

        // Thread to listen for messages from the server
        new Thread(() -> {
            String response;
            try {
                while ((response = serverInput.readLine()) != null) {
                    System.out.println("Server: " + response);
                }
            } catch (IOException e) {
                System.out.println("Connection closed.");
            }
        }).start();

        // Main thread sends user input to server
        String message;
        while ((message = userInput.readLine()) != null) {
            serverOutput.println(message);
        }

        socket.close();
    }
}

