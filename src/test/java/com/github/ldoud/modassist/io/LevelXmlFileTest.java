package com.github.ldoud.modassist.io;

import com.github.ldoud.modassist.base.LevelBaseTest;
import com.github.ldoud.modassist.constants.CharacterName;
import com.github.ldoud.modassist.data.Mod;
import com.github.ldoud.modassist.data.ModType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class LevelXmlFileTest extends LevelBaseTest {
    private static ModDataFromXmlFile dataFromFile;

    @BeforeAll
    static void setUp() throws IOException, SAXException, ParserConfigurationException {
        dataFromFile = ModDataFromXmlFile.getInstance();
    }

    @Override
    protected void assertNumberOLevels(CharacterName toon, ModType modType, String expectedNumberOfLevels) {
        Mod modToTest = dataFromFile.getMod(toon, modType);
        Assertions.assertEquals(Integer.parseInt(expectedNumberOfLevels), modToTest.getLevel(), "Number of levels");
    }
}
