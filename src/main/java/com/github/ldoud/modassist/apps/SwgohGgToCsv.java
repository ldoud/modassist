package com.github.ldoud.modassist.apps;

import com.github.ldoud.modassist.readers.HtmlDataMiner;
import com.oracle.tools.packager.Log;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilderFactory;
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
import java.util.logging.*;

public class SwgohGgToCsv {
    private static Logger LOG = Logger.getLogger(SwgohGgToCsv.class.getName());

    private static final String USAGE = "SwgohGgToCsv -username YourSwgohGGUsername -filename csvFileToWrite";
    private static final String RAW_URL = "https://swgoh.gg/u/${username}/mods/?page=${page}";

    private String username;
    private String csvOutputFilename;
    Document newDocWithMods;
    private Element modListXML;
    private HtmlDataMiner miner;

    private SwgohGgToCsv() throws TransformerConfigurationException, ParserConfigurationException {
        miner = new HtmlDataMiner("swgoh_mods.xsl");

        // Create new XML document containing an empty list of "mods".
        newDocWithMods = DocumentBuilderFactory.newDefaultInstance().newDocumentBuilder().newDocument();
        modListXML = newDocWithMods.createElement("mods");
    }

    private void addMods(Node newMods) {
        NodeList modList = newMods.getFirstChild().getChildNodes();
        for(int currentMod=0; currentMod < modList.getLength(); currentMod++) {
            Node mod = modList.item(currentMod).cloneNode(true);
            newDocWithMods.adoptNode(mod);
            modListXML.appendChild(mod.cloneNode(true));
        }
    }

    // TODO Read from the SWGOH website.
    private int findNumberOfWebpagesToRead() {
        return 10;
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
            TransformerFactory.newInstance().newTransformer().transform(new DOMSource(modListXML), new StreamResult(xmlStringWritter));
            LOG.fine(xmlStringWritter.toString());
        }
    }

    private void retreiveDataFromWebsite() throws ParserConfigurationException, TransformerException, IOException {
        String baseURL = RAW_URL.replace("${username}", username);
        int numberOfWebpagesToRead = findNumberOfWebpagesToRead();

        for(int page=1; page <= numberOfWebpagesToRead; page++) {
            String webpageURL = baseURL.replace("${page}",page+"");
            addMods(miner.extractData(webpageURL));
        }
    }

    private void saveToCsv() throws TransformerException {
        StreamSource xsl = new StreamSource(ClassLoader.getSystemResourceAsStream("data_to_csv.xsl"));
        Transformer xslt = TransformerFactory.newInstance().newTransformer(xsl);

        if (LOG.isLoggable(Level.FINE)) {
            xslt.transform(new DOMSource(modListXML), new StreamResult(System.out));
        }
        xslt.transform(new DOMSource(modListXML), new StreamResult(new File(csvOutputFilename)));
    }

    public static void main(String[] args) throws TransformerException, ParserConfigurationException, IOException {
        SwgohGgToCsv app = new SwgohGgToCsv();
        app.parseArgs(args);
        app.retreiveDataFromWebsite();
        app.logModListXml();
        app.saveToCsv();
    }

}
