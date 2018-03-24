package com.github.ldoud.modassist.swgoh;

import com.github.ldoud.modassist.constants.Character;
import com.github.ldoud.modassist.constants.Mod;
import com.github.ldoud.modassist.readers.HtmlDataMiner;
import org.dom4j.Document;
import org.dom4j.Node;
import org.dom4j.io.DOMReader;
import org.junit.jupiter.api.Assertions;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.net.URL;

class TestData {

    private static final String XPATH_SLOT_ON_CHARACTER = "/mods/mod[@character='${characterName}' and @slot='${modType}']";

    private Document doc;

    public TestData() throws TransformerException, ParserConfigurationException, IOException {
        // https://swgoh.gg/u/wasssup/mods/
        URL[] webpages = new URL[14];
        webpages[0] = ClassLoader.getSystemResource("html/swgoh_page1.html");
        webpages[1] = ClassLoader.getSystemResource("html/swgoh_page2.html");
        webpages[2] = ClassLoader.getSystemResource("html/swgoh_page3.html");
        webpages[3] = ClassLoader.getSystemResource("html/swgoh_page4.html");
        webpages[4] = ClassLoader.getSystemResource("html/swgoh_page5.html");
        webpages[5] = ClassLoader.getSystemResource("html/swgoh_page6.html");
        webpages[6] = ClassLoader.getSystemResource("html/swgoh_page7.html");
        webpages[7] = ClassLoader.getSystemResource("html/swgoh_page8.html");
        webpages[8] = ClassLoader.getSystemResource("html/swgoh_page9.html");
        webpages[9] = ClassLoader.getSystemResource("html/swgoh_page10.html");
        webpages[10] = ClassLoader.getSystemResource("html/swgoh_page11.html");
        webpages[11] = ClassLoader.getSystemResource("html/swgoh_page12.html");
        webpages[12] = ClassLoader.getSystemResource("html/swgoh_page13.html");
        webpages[13] = ClassLoader.getSystemResource("html/swgoh_page14.html");

        HtmlDataMiner miner = new HtmlDataMiner("swgoh_mods.xsl");
        org.w3c.dom.Document d = miner.extractData(webpages);
        DOMReader reader = new DOMReader();
        doc = reader.read(d);

        TransformerFactory.newInstance().newTransformer().transform(new DOMSource(d),new StreamResult(System.out));
    }

    public Node getMod(Character toon, Mod slot) {
        String xpath = XPATH_SLOT_ON_CHARACTER
                .replace("${characterName}", toon.toString())
                .replace("${modType}", slot.toString());
        Node character = doc.selectSingleNode(xpath);

        Assertions.assertNotNull(character, "Character's mod found: "+xpath);
        return character;
    }
}
