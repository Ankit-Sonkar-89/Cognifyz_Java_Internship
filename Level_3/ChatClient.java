package Level_3;

import java.io.*;
import java.net.*;

// (The User)

public class ChatClient {
    public static void main(String[] args) {
        System.out.println("=====================================");
        System.out.println("📱 PRO CHAT CLIENT IS BOOTING UP...");
        System.out.println("=====================================");

        try (Socket socket = new Socket("localhost", 5000)) {
            System.out.println("✅ Connected to the Server! You can start typing.\n");

            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in));

            // Thread for receiving messages asynchronously
            Thread receiveThread = new Thread(() -> {
                try {
                    String message;
                    while ((message = input.readLine()) != null) {
                        System.out.println("💬 Server: " + message);
                    }
                } catch (IOException e) {
                    System.out.println("⚠️ Connection closed.");
                }
            });
            receiveThread.start();

            // Main thread for sending messages
            String text;
            while ((text = consoleInput.readLine()) != null) {
                output.println(text);
                if (text.equalsIgnoreCase("exit")) break;
            }
        } catch (IOException e) {
            System.out.println("❌ Error: Server is not running! Start ChatServer first.");
        }
    }
}