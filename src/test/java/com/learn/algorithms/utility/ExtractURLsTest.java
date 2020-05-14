package com.learn.algorithms.utility;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;

class ExtractURLsTest {

    @Test
    void extractHTTPSURLsTest() throws IOException {
        
        URL url = new URL("https://www.bbc.com");
        System.out.println(ExtractURLs.extractHTTPSURLs(ReadHTML.readHTML(url)));
    }

    @Test
    void extractHTTPURLsTest() throws IOException {

        URL url = new URL("https://www.bbc.com");
        System.out.println(ExtractURLs.extractHTTPURLs(ReadHTML.readHTML(url)));
    }
}