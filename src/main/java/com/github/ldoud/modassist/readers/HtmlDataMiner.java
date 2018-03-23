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
     * @param xslToApply Relative path of XSL file to load from classpath.
     * @throws TransformerConfigurationException If there is an issue loading XSL file.
     */
    public HtmlDataMiner(String xslToApply) throws TransformerConfigurationException {
        StreamSource xsl = new StreamSource(ClassLoader.getSystemResourceAsStream(xslToApply));
        xslt = TransformerFactory.newInstance().newTransformer(xsl);
    }

    public Node extractData(String url) throws IOException, ParserConfigurationException, TransformerException {
        return extractData(new URL(url));
    }

    public Node extractData(URL webpage) throws IOException, ParserConfigurationException, TransformerException {
        Document webpageAsXml = retreiveWebpageAsXML(webpage);

        DOMResult results = new DOMResult();
        xslt.transform(new DOMSource(webpageAsXml), results); // TransformerException

        return results.getNode();
    }

    private static Document retreiveWebpageAsXML(String url) throws IOException, ParserConfigurationException {
        return retreiveWebpageAsXML(new URL(url));
    }

    private static Document retreiveWebpageAsXML(URL webpage) throws IOException, ParserConfigurationException {
        // Retrieve and format webpage as XML.
        HtmlCleaner cleaner = new HtmlCleaner();
        TagNode node = cleaner.clean(webpage); // IOException

        // Turn into a document so it can be transformed.
        DomSerializer serializer = new DomSerializer(cleaner.getProperties());
        return serializer.createDOM(node);
    }

    public static void main(String[] args) throws IOException, ParserConfigurationException, TransformerException {
        if(args.length != 2) {
            System.err.println("Usage "+HtmlDataMiner.class.getName()+" <webpageURL> <targetSaveFile> ");
            System.exit(1);
        }

        Document webpageAsXml = retreiveWebpageAsXML(args[0]);
        TransformerFactory.newInstance().newTransformer().transform(new DOMSource(webpageAsXml),new StreamResult(new File(args[1])));
    }

}
