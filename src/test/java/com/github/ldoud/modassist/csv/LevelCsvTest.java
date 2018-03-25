package com.github.ldoud.modassist.csv;

import com.github.ldoud.modassist.base.DotsBaseTest;
import com.github.ldoud.modassist.base.LevelBaseTest;
import com.github.ldoud.modassist.constants.Character;
import com.github.ldoud.modassist.constants.Mod;
import org.dom4j.DocumentException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

class LevelCsvTest extends LevelBaseTest {

    private static TestCsvFile csv;

    @BeforeAll
    static void setUp() throws ParserConfigurationException, IOException, TransformerException, DocumentException {
        csv = new TestCsvFile();
    }

    @Override
    protected void assertNumberOLevels(Character toon, Mod mod, String expectedNumberOfLevels) {
        String levelActual = csv.getLevel(toon, mod);
        Assertions.assertNotNull(levelActual, "Found level for: "+toon.toString()+"'s "+mod.toString());
        Assertions.assertEquals(expectedNumberOfLevels, levelActual, "Level for: "+toon.toString()+"'s "+mod.toString());
    }
}