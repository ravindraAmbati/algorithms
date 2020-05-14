package com.learn.algorithms.utility;

/* @author ravin @date 14-05-2020 @time 10:58 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public interface ReadHTML {

    static String readHTML(URL url) throws IOException {

        StringBuilder rawHtml = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
        String inputLine = "";

        while (null != (inputLine = bufferedReader.readLine())) {
            rawHtml.append(inputLine);
        }
        return rawHtml.toString();
    }
}
