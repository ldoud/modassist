package com.github.ldoud.modassist.apps;

import com.github.ldoud.modassist.readers.HtmlDataMiner;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

public class SwgohGgToCsv {
    private static final String USAGE = "SwgohGgToCsv -username YourSwgohGGUsername -filename csvFileToWrite";
    private static final String RAW_URL = "https://swgoh.gg/u/${username}/mods/?page=${page}";

    private String username;
    private String csvOutputFilename;
    private Node allModsAsXml;
    private HtmlDataMiner miner;

    private SwgohGgToCsv() throws TransformerConfigurationException {
        miner = new HtmlDataMiner("swgoh_mods.xsl");
    }

    public static void main(String[] args) throws TransformerException, ParserConfigurationException, IOException {
        SwgohGgToCsv app = new SwgohGgToCsv();
        app.parseArgs(args);

        String baseURL = RAW_URL.replace("${username}", app.username);
        int numberOfWebpagesToRead = app.findNumberOfWebpagesToRead();

        for(int page=0; page < numberOfWebpagesToRead; page++) {
            String webpageURL = baseURL.replace("${page}",numberOfWebpagesToRead+"");
            app.addMods(app.miner.extractData(webpageURL));
        }
    }

    private void addMods(Node newMods) {
        if(allModsAsXml != null) {
            NodeList modList = newMods.getChildNodes();
            for(int currentMod=0; currentMod < modList.getLength(); currentMod++) {
                allModsAsXml.appendChild(modList.item(currentMod));
            }
        }
        else {
            allModsAsXml = newMods;
        }
    }

    private int findNumberOfWebpagesToRead() {
        return 1;
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


}
