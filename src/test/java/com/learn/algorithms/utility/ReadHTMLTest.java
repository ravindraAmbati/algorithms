package com.learn.algorithms.utility;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URL;

class ReadHTMLTest {


    @Test
    void readHTML() throws IOException {
        URL url = new URL("https://www.bbc.com");
        Assertions.assertNotNull(ReadHTML.readHTML(url));
    }
}