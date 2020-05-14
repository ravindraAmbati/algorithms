package com.learn.algorithms.utility;

/* @author ravin @date 14-05-2020 @time 11:07 */

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface ExtractURLs {

    static Set<URL> extractURLs(String rawHTML, String regex) throws RuntimeException, MalformedURLException {

        Set<URL> urls = new HashSet<>();
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(rawHTML);
        while (matcher.find()) {
            urls.add(new URL(matcher.group()));
        }
        return urls;
    }

    static Set<URL> extractHTTPURLs(String rawHTML) throws RuntimeException, MalformedURLException {

        String regex = "\\b(http?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
        return extractURLs(rawHTML,regex);
    }

    static Set<URL> extractHTTPSURLs(String rawHTML) throws RuntimeException, MalformedURLException {

        String regex = "\\b(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
        return extractURLs(rawHTML,regex);
    }

}
