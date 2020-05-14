package com.learn.algorithms.BreadthFirstSearch;

import com.learn.algorithms.utility.ExtractURLs;
import com.learn.algorithms.utility.ReadHTML;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.print.DocFlavor;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import static java.text.NumberFormat.getCurrencyInstance;

class BFSImplTest {

    private BFSImpl<Integer> testClassInteger = null;
    private BFSImpl<String> testClassString = null;
    private BFSImpl<URL> testClassUrl = null;

    @BeforeEach
    void setUp() {
        testClassInteger = new BFSImpl<>();
        testClassString = new BFSImpl<>();
        testClassUrl = new BFSImpl<>();
    }

    @AfterEach
    void tearDown() {
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

        testClassInteger.bfs(integerNode1);
    }

    @Test
    void bsfStringTest(){

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

        testClassString.bfs(r);
    }
}