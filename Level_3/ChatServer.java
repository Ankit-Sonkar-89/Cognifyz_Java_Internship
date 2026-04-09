package Level_3;
import java.io.*;
import java.net.*;  

// (The Host)

public class ChatServer {
    public static void main(String[] args) {
        System.out.println("=====================================");
        System.out.println("🛡️ PRO CHAT SERVER IS BOOTING UP...");
        System.out.println("=====================================");
        
        try (ServerSocket serverSocket = new ServerSocket(5000)) {
            System.out.println("✅ Server is live on Port 5000. Waiting for client connection...");
            Socket socket = serverSocket.accept();
            System.out.println("⚡ Client Connected Successfully!\n");

            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in));

            // Thread for receiving messages asynchronously
            Thread receiveThread = new Thread(() -> {
                try {
                    String message;
                    while ((message = input.readLine()) != null) {
                        System.out.println("💬 Client: " + message);
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
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}