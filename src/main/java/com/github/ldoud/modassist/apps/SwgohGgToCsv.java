package com.github.ldoud.modassist.apps;

import com.github.ldoud.modassist.readers.HtmlDataMiner;
import com.oracle.tools.packager.Log;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.IOException;
import java.io.StringWriter;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

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
        return 13;
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

    public static void main(String[] args) throws TransformerException, ParserConfigurationException, IOException {

        // Logging
        ConsoleHandler handler = new ConsoleHandler();
        handler.setFormatter(new SimpleFormatter());
        handler.setLevel(Level.ALL);
//        Logger.getGlobal().addHandler(handler);
//        Logger.getGlobal().setLevel(Level.FINE);
        LOG.setLevel(Level.FINE);
        LOG.addHandler(handler);

        SwgohGgToCsv app = new SwgohGgToCsv();
        app.parseArgs(args);

        String baseURL = RAW_URL.replace("${username}", app.username);
        int numberOfWebpagesToRead = app.findNumberOfWebpagesToRead();

        for(int page=1; page <= numberOfWebpagesToRead; page++) {
            String webpageURL = baseURL.replace("${page}",page+"");
            app.addMods(app.miner.extractData(webpageURL));
        }

        if(LOG.isLoggable(Level.FINE)) {
            StringWriter xmlStringWritter = new StringWriter();
            TransformerFactory.newInstance().newTransformer().transform(new DOMSource(app.modListXML), new StreamResult(xmlStringWritter));
            LOG.fine(xmlStringWritter.toString());
        }

        // TODO Save to CSV
    }

}
