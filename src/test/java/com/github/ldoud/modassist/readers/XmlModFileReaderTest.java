package com.github.ldoud.modassist.readers;

import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;

class XmlModFileReaderTest {

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @Test
    public void testStuff() throws Exception {
        HtmlDataMiner miner = new HtmlDataMiner("swgoh_mods.xsl");
        Node document = miner.extractData("https://swgoh.gg/u/wasssup/mods/");

        TransformerFactory.newInstance().newTransformer().transform(new DOMSource(document),new StreamResult(System.out));
    }
}