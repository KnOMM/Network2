package com.company.proxyServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ProxySession {
    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket1 = new ServerSocket(54321);
             ServerSocket serverSocket2 = new ServerSocket(54322);
             Socket clientSocket1 = serverSocket1.accept();
             Socket clientSocket2 = serverSocket2.accept();
             BufferedReader in1 = new BufferedReader(new InputStreamReader(clientSocket1.getInputStream()));
             BufferedReader in2 = new BufferedReader(new InputStreamReader(clientSocket2.getInputStream()));
             PrintWriter out1 = new PrintWriter(clientSocket1.getOutputStream(), true);
             PrintWriter out2 = new PrintWriter(clientSocket2.getOutputStream(), true);
             ){
            System.out.println("Something that is MEGAcool!!!");
            System.out.println("Now, client1 can communicate with client2");

            String input1;
            String input2;
            String output1;
            String output2;

            System.out.println("Wait for messages");
            while (((input1 = in1.readLine()) != null) && (input2 = in2.readLine()) != null) {
                if (input1.equalsIgnoreCase("exit")) break;
                out2.println("Response ::: " + "echo -> " + input1);
                System.out.println(input1);
                if (input2.equalsIgnoreCase("exit")) break;
                out1.println("Response ::: " + "echo -> " + input2);
                System.out.println(input2);
            }


        }
    }
}
