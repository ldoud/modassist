package com.github.ldoud.modassist.readers;

import org.htmlcleaner.DomSerializer;
import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.TagNode;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class HtmlDataMiner {

    private Transformer xslt;

    /**
     * Create a data miner that uses a particular XSL.
     * @param pathToXsl Which XSL file to load.
     * @throws TransformerConfigurationException If there is an issue loading XSL file.
     */
    public HtmlDataMiner(String pathToXsl) throws TransformerConfigurationException {
        StreamSource xsl = new StreamSource(ClassLoader.getSystemResourceAsStream(pathToXsl));
        xslt = TransformerFactory.newInstance().newTransformer(xsl);
    }

    public Node extractData(String url) throws IOException, ParserConfigurationException, TransformerException {
        URL webpage = new URL(url); // MalformedURLException

        // Retrieve and format webpage as XML.
        HtmlCleaner cleaner = new HtmlCleaner();
        TagNode node = cleaner.clean(webpage); // IOException

        // Turn into a document so it can be transformed.
        DomSerializer serializer = new DomSerializer(cleaner.getProperties());
        Document webpageAsXml = serializer.createDOM(node); // ParserConfigurationException

//        TransformerFactory.newInstance().newTransformer().transform(new DOMSource(webpageAsXml),new StreamResult(System.out));

        DOMResult results = new DOMResult();
        xslt.transform(new DOMSource(webpageAsXml), results); // TransformerException

        return results.getNode();
    }

}
