package net.currency.util;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class UtilWeb {

    public static String getURLResponse(String getURL) {
        try {
            URL url = new URL(getURL);
            URLConnection con = url.openConnection();
            InputStream in = con.getInputStream();
            String encoding = con.getContentEncoding();
            encoding = encoding == null ? "UTF-8" : encoding;
            String body = IOUtils.toString(in, encoding);
            return body;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
