package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class IpInfo {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://api.2ip.ua/geo.json\n");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.connect();
        StringBuilder text = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))){

            String line; //= reader.readLine();
            //text.append(line);
            while ((line = reader.readLine()) != null){
                text.append(line);
            }
        } catch (IOException e){
            System.out.println(e.getMessage());
        }


        System.out.println(text);
        //byte[] decodedBytes = "\u0415\u0441\u0442\u043e\u043d\u0456\u044f".;
        //String str = new String(decodedBytes);
        //System.out.println(str);
        System.out.println(new String("\u0415\u0441\u0442\u043e\u043d\u0456\u044f"));
        System.out.println("\u0415\u0441\u0442\u043e\u043d\u0456\u044f");
    }
}
