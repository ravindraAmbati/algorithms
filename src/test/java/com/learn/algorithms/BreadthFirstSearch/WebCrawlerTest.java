package com.learn.algorithms.BreadthFirstSearch;

import com.learn.algorithms.common.Node;
import org.junit.jupiter.api.*;

import java.net.MalformedURLException;
import java.net.URL;


class WebCrawlerTest {

    private BFS<URL> testClass = null;

    @BeforeEach
    void setUp() {
        testClass = new WebCrawler<>();
    }

    @AfterEach
    void tearDown() {
        testClass = null;
    }

    @Disabled
    @Test
    @Timeout(60)
    void bfs() throws MalformedURLException {
        Node<URL> root = new Node<>(new URL("https://www.bbc.com"));
        System.out.println(testClass.bfs(root));
    }
}