package net.currency.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class UtilWeb {

    public static String getURLResponse(String url) {
        try {
            URL website = new URL(url);
            URLConnection connection = website.openConnection();
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            connection.getInputStream()));

            StringBuilder response = new StringBuilder();
            String inputLine;

            while ((inputLine = in.readLine()) != null)
                response.append(inputLine);

            in.close();
            return response.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
