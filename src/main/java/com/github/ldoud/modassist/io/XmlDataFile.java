package com.github.ldoud.modassist.io;

import com.github.ldoud.modassist.data.Mod;
import com.github.ldoud.modassist.data.ModType;
import com.github.ldoud.modassist.data.Stat;
import com.github.ldoud.modassist.data.StatName;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class XmlDataFile {
    private static String ELEMENT_MOD = "mod";
    private static String ELEMENT_STAT = "stat";

    private enum ModAttributes {
        CHARACTER, DOTS, LEVEL, SET, SLOT;

        @Override
        public String toString() {
            return super.toString().toLowerCase();
        }
    }

    private enum StatAttributes {
        NAME, TYPE, VALUE;

        @Override
        public String toString() {
            return super.toString().toLowerCase();
        }
    }

    private File xmlFile;

    public XmlDataFile(String pathToFile) {
        xmlFile = new File(pathToFile);
    }

    public Collection<Mod> readMods() throws ParserConfigurationException, IOException, SAXException {
        final ArrayList<Mod> modList = new ArrayList<>();

        DefaultHandler handler = new DefaultHandler() {
            private Mod currentMod;

            @Override
            public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                if(ELEMENT_MOD.equals(qName)) {
                    currentMod = parseModXML(attributes);
                    modList.add(currentMod);
                }
                else if (ELEMENT_STAT.equals(qName) && currentMod != null) {
                    Stat newStat = parseStatXML(attributes);
                    currentMod.add(newStat);
                }
            }
        };

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();
        saxParser.parse(xmlFile, handler);

        return modList;
    }

    private Mod parseModXML(Attributes attribs) {
        Mod modBeingParsed = new Mod();
        modBeingParsed.setCharacter(attribs.getValue(ModAttributes.CHARACTER.toString()));
        modBeingParsed.setDots(Integer.parseInt(attribs.getValue(ModAttributes.DOTS.toString())));
        modBeingParsed.setLevel(Integer.parseInt(attribs.getValue(ModAttributes.LEVEL.toString())));
        modBeingParsed.setSet(StatName.valueOf(attribs.getValue(ModAttributes.SET.toString()).replaceAll(" ", "")));
        modBeingParsed.setSlot(ModType.valueOf(attribs.getValue(ModAttributes.SLOT.toString()).replaceAll("-", "")));

        return modBeingParsed;
    }

    private Stat parseStatXML(Attributes attribs) {
        Stat statBeingParsed = new Stat();
        statBeingParsed.setName(StatName.valueOf(attribs.getValue(StatAttributes.NAME.toString()).replaceAll(" ", "")));
        statBeingParsed.setType(Stat.Type.valueOf(attribs.getValue(StatAttributes.TYPE.toString()).toUpperCase()));
        statBeingParsed.setValue(Double.parseDouble(attribs.getValue(StatAttributes.VALUE.toString())));

        return statBeingParsed;
    }
}
