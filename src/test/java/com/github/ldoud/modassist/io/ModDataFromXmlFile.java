package com.github.ldoud.modassist.io;

import com.github.ldoud.modassist.constants.CharacterName;
import com.github.ldoud.modassist.data.Mod;
import com.github.ldoud.modassist.data.ModType;
import org.junit.jupiter.api.Assertions;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class ModDataFromXmlFile {

    private static ModDataFromXmlFile SINGLETON;

    private Map<String, List<Mod>> modsForCharacters;

    private ModDataFromXmlFile() throws IOException, SAXException, ParserConfigurationException {
        String fileName = ClassLoader.getSystemResource("all_mods.xml").getFile();
        XmlDataFile fileReader = new XmlDataFile(fileName);
        Collection<Mod> modList = fileReader.readMods();
        modsForCharacters = modList.stream().collect(Collectors.groupingBy(p -> p.getCharacter()));
    }

    public static ModDataFromXmlFile getInstance() throws ParserConfigurationException, SAXException, IOException {
        if (SINGLETON == null) {
            SINGLETON = new ModDataFromXmlFile();
        }

        return SINGLETON;
    }

    public Mod getMod(CharacterName toon, ModType modType) {
        List<Mod> modsForThisToon = modsForCharacters.get(toon.toString());
        Assertions.assertNotNull(modsForThisToon, "List of mods found for this character");

        Optional<Mod> modToTest = modsForThisToon.stream().filter(p -> p.getSlot() == modType).findAny();
        Assertions.assertTrue(modToTest.isPresent(), "Found mod to test");

        return modToTest.get();
    }
}
