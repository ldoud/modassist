package com.github.ldoud.modassist.apps;

import com.github.ldoud.modassist.readers.HtmlDataMiner;
import org.dom4j.Node;
import org.dom4j.io.DOMReader;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.net.URL;
import java.util.logging.*;

public class SwgohGgToCsv {
    private static Logger LOG = Logger.getLogger(SwgohGgToCsv.class.getName());

    private static final String USAGE = "SwgohGgToCsv -username YourSwgohGGUsername -filename csvFileToWrite";
    private static final String BASE_URL = "https://swgoh.gg/u/${username}/mods";
    private static final String MOD_PAGE_URL = BASE_URL+"/?page=${page}";

    private String username;
    private String csvOutputFilename;
    private Document newDocWithMods;
    private HtmlDataMiner miner;

    private SwgohGgToCsv() throws TransformerConfigurationException, ParserConfigurationException {
        miner = new HtmlDataMiner("swgoh_mods.xsl");
    }

    public static int findNumberOfWebpagesToRead(URL webpage) throws IOException, ParserConfigurationException, TransformerException {
        Document doc = HtmlDataMiner.retreiveWebpageAsXML(webpage);

        DOMReader reader = new DOMReader();
        org.dom4j.Document dom4j = reader.read(doc);
        Node n = dom4j.selectSingleNode("//ul[@class='pagination m-t-0']/li/a[@href='javascript:;']");
        String numberOfPages = n.getText();
        numberOfPages = numberOfPages.substring(numberOfPages.indexOf("of")+3);

        return Integer.parseInt(numberOfPages);
    }

    private void parseArgs(String[] args) {
        if (args.length != 4) {
            System.err.println("Wrong number of args");
            System.out.println(USAGE);
            System.exit(-1);
        }

        for(int currentArg=0; currentArg < args.length; currentArg++) {
            switch (args[currentArg]) {
                case "-username":
                    username = args[++currentArg];
                    break;
                case "-filename":
                    csvOutputFilename = args[++currentArg];
                    break;
            }
        }

        if (username == null || csvOutputFilename == null) {
            System.err.println("Missing required parameters");
            System.out.println(USAGE);
            System.exit(-1);
        }
    }

    private void logModListXml() throws TransformerException {
        if(LOG.isLoggable(Level.FINE)) {
            StringWriter xmlStringWritter = new StringWriter();
            TransformerFactory.newInstance().newTransformer().transform(new DOMSource(newDocWithMods), new StreamResult(xmlStringWritter));
            LOG.fine(xmlStringWritter.toString());
        }
    }

    private void retreiveDataFromWebsite() throws ParserConfigurationException, TransformerException, IOException {
        int numberOfWebpagesToRead = findNumberOfWebpagesToRead(new URL(BASE_URL.replace("${username}", username)));

        String baseURL = MOD_PAGE_URL.replace("${username}", username);
        URL[] webpages = new URL[numberOfWebpagesToRead];

        for(int page=1; page <= numberOfWebpagesToRead; page++) {
            String webpageURL = baseURL.replace("${page}",page+"");
            webpages[page-1] = new URL(webpageURL);
        }

        newDocWithMods = miner.extractData(webpages);
    }

    private void saveToCsv() throws TransformerException {
        StreamSource xsl = new StreamSource(ClassLoader.getSystemResourceAsStream("data_to_csv.xsl"));
        Transformer xslt = TransformerFactory.newInstance().newTransformer(xsl);

        if (LOG.isLoggable(Level.FINE)) {
            xslt.transform(new DOMSource(newDocWithMods), new StreamResult(System.out));
        }
        xslt.transform(new DOMSource(newDocWithMods), new StreamResult(new File(csvOutputFilename)));
    }

    public static void main(String[] args) throws TransformerException, ParserConfigurationException, IOException {
        SwgohGgToCsv app = new SwgohGgToCsv();
        app.parseArgs(args);
        app.retreiveDataFromWebsite();
        app.logModListXml();
        app.saveToCsv();
    }

}
