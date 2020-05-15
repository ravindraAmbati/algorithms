package com.learn.algorithms.BreadthFirstSearch;

import com.learn.algorithms.commons.Node;
import com.learn.algorithms.utility.ExtractURLs;
import com.learn.algorithms.utility.ReadHTML;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URL;

import static java.text.NumberFormat.getCurrencyInstance;

class BFSImplTest {

    private String expected = null;
    private String actual = null;
    private BFS<Integer> testClassInteger = null;
    private BFS<String> testClassString = null;
    private BFS<URL> testClassUrl = null;

    @BeforeEach
    void setUp() {
        expected = null;
        actual = null;
        testClassInteger = new BFSImpl<>();
        testClassString = new BFSImpl<>();
        testClassUrl = new BFSImpl<>();
    }

    @AfterEach
    void tearDown() {
        expected = null;
        actual = null;
        testClassInteger = null;
        testClassString = null;
        testClassUrl = null;
    }

    @Test
    void webCrawler() throws IOException {
        Node<URL> root = new Node<>(new URL("https://www.bbc.com"));
        String parentRegex = "\\b(https://www.bbc.com?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
        ExtractURLs.extractURLs(ReadHTML.readHTML(root.getValue()), parentRegex).forEach(
                url -> root.addNeighbours(new Node<>(url))
        );
        ExtractURLs.extractHTTPURLs(ReadHTML.readHTML(root.getValue())).forEach(
                url -> root.addNeighbours(new Node<>(url))
        );
        ExtractURLs.extractHTTPSURLs(ReadHTML.readHTML(root.getValue())).forEach(
                url -> root.addNeighbours(new Node<>(url))
        );
        testClassUrl.bfs(root);
    }

    @Test
    void bfsIntTest() {

        expected = "2 3 4 5 6 7 8 9 10 11 ";

        // init
        Node<Integer> integerNode1 = new Node<>(1);
        Node<Integer> integerNode2 = new Node<>(2);
        Node<Integer> integerNode3 = new Node<>(3);
        Node<Integer> integerNode4 = new Node<>(4);
        Node<Integer> integerNode5 = new Node<>(5);
        Node<Integer> integerNode6 = new Node<>(6);
        Node<Integer> integerNode7 = new Node<>(7);
        Node<Integer> integerNode8 = new Node<>(8);
        Node<Integer> integerNode9 = new Node<>(9);
        Node<Integer> integerNode10 = new Node<>(10);
        Node<Integer> integerNode11 = new Node<>(11);

        //chaining
        integerNode1.addNeighbours(integerNode2);
        integerNode1.addNeighbours(integerNode3);
        integerNode1.addNeighbours(integerNode4);
        integerNode1.addNeighbours(integerNode5);
        integerNode2.addNeighbours(integerNode6);
        integerNode2.addNeighbours(integerNode7);
        integerNode5.addNeighbours(integerNode8);
        integerNode5.addNeighbours(integerNode9);
        integerNode8.addNeighbours(integerNode10);
        integerNode10.addNeighbours(integerNode11);
        integerNode11.addNeighbours(integerNode1);

        actual = testClassInteger.bfs(integerNode1);
        Assertions.assertEquals(expected,actual);
    }

    @Test
    void bsfStringTest(){

        expected = "A B C D A1 A2 B3 B2 B1 E ";

        // init
        Node<String> a = new Node<>("A");
        Node<String> a1 = new Node<>("A1");
        Node<String> a2 = new Node<>("A2");
        Node<String> b = new Node<>("B");
        Node<String> b1 = new Node<>("B1");
        Node<String> b2 = new Node<>("B2");
        Node<String> b3 = new Node<>("B3");
        Node<String> r = new Node<>("R");
        Node<String> d = new Node<>("D");
        Node<String> c = new Node<>("C");
        Node<String> e = new Node<>("E");

        //chaining
        r.addNeighbours(a);
        r.addNeighbours(b);
        a.addNeighbours(a1);
        a.addNeighbours(a2);
        b.addNeighbours(b3);
        b.addNeighbours(b2);
        b.addNeighbours(b1);
        r.addNeighbours(c);
        r.addNeighbours(d);
        d.addNeighbours(e);
        e.addNeighbours(r);

        actual = testClassString.bfs(r);
        Assertions.assertEquals(expected,actual);
    }
}