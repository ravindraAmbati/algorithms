package com.learn.algorithms.utility;

/* @author ravin @date 14-05-2020 @time 11:07 */

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface ExtractURLs {

    static List<URL> extractURLs(String rawHTML, String regex) throws RuntimeException, MalformedURLException {

        List<URL> urls = new ArrayList<>();
        Pattern patt = Pattern.compile(regex);
        Matcher matcher = patt.matcher(rawHTML);
        while (matcher.find()) {
            urls.add(new URL(matcher.group()));
        }
        return urls;
    }

    static List<URL> extractHTTPURLs(String rawHTML) throws RuntimeException, MalformedURLException {

        String regex = "\\b(http?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
        return extractURLs(rawHTML,regex);
    }

    static List<URL> extractHTTPSURLs(String rawHTML) throws RuntimeException, MalformedURLException {

        String regex = "\\b(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
        return extractURLs(rawHTML,regex);
    }

}
