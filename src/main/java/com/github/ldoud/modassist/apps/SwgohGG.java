package com.github.ldoud.modassist.apps;

import com.github.ldoud.modassist.io.HtmlDataMiner;
import org.dom4j.Node;
import org.dom4j.io.DOMReader;
import org.w3c.dom.Document;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.net.URL;
import java.util.logging.*;

public class SwgohGG {
    enum OutputFormat {CSV, XML};

    private static Logger LOG = Logger.getLogger(SwgohGG.class.getName());

    private static final String USAGE = "SwgohGG -username YourSwgohGGUsername (-csvfilename | -xmlFilename) filename)";
    private static final String BASE_URL = "https://swgoh.gg/u/${username}/mods";
    private static final String MOD_PAGE_URL = BASE_URL+"/?page=${page}";

    private String username;
    private String outputFilename;
    private Document newDocWithMods;
    private HtmlDataMiner miner;
    private OutputFormat outputFormat = null;

    private SwgohGG() throws TransformerConfigurationException, ParserConfigurationException {
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
                case "-csvFilename":
                    outputFilename = args[++currentArg];
                    outputFormat = OutputFormat.CSV;
                    break;
                case "-xmlFilename":
                    outputFilename = args[++currentArg];
                    outputFormat = OutputFormat.XML;
                    break;
            }
        }

        if (username == null || outputFormat == null) {
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

    private void saveToFile() throws TransformerException {
        Transformer xslt;
        if (outputFormat == OutputFormat.CSV) {
            StreamSource xsl = new StreamSource(ClassLoader.getSystemResourceAsStream("data_to_csv.xsl"));
            xslt = TransformerFactory.newInstance().newTransformer(xsl);
        }
        else {
            xslt = TransformerFactory.newInstance().newTransformer();
        }

        if (LOG.isLoggable(Level.FINE)) {
            xslt.transform(new DOMSource(newDocWithMods), new StreamResult(System.out));
        }
        xslt.transform(new DOMSource(newDocWithMods), new StreamResult(new File(outputFilename)));
    }

    public static void main(String[] args) throws TransformerException, ParserConfigurationException, IOException {
        SwgohGG app = new SwgohGG();
        app.parseArgs(args);
        app.retreiveDataFromWebsite();
        app.logModListXml();
        app.saveToFile();
    }

}
