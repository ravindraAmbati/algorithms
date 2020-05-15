package com.learn.algorithms.utility;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class ExtractURLsTest {

    @Test
    void extractHTTPSURLsTest() throws IOException {

        URL url = new URL("https://www.bbc.com");
        assertNotNull(ExtractURLs.extractHTTPSURLs(ReadHTML.readHTML(url)));
    }

    @Test
    void extractHTTPURLsTest() throws IOException {

        URL url = new URL("https://www.bbc.com");
        assertNotNull(ExtractURLs.extractHTTPURLs(ReadHTML.readHTML(url)));
    }
}