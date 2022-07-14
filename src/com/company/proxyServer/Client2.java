package com.company.proxyServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client2 {
    public static void main(String[] args) throws IOException {
        System.out.println("Communication between clients");
        try (Socket connectToServerSocket = new Socket("localhost", 54322);
             BufferedReader in = new BufferedReader(
                     new InputStreamReader(connectToServerSocket.getInputStream()));
             PrintWriter out = new PrintWriter(connectToServerSocket.getOutputStream(), true);
             BufferedReader inu = new BufferedReader(new InputStreamReader(System.in));) {
            String userInput, serverOutput;
            while ((userInput = inu.readLine()) != null) {
                out.println(userInput);
                serverOutput = in.readLine();
                System.out.println(serverOutput);
                if (userInput.equalsIgnoreCase("exit")){
                    break;
                }
            }
        }
    }
}
