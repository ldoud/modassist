package com.github.ldoud.modassist.swgoh;

import com.github.ldoud.modassist.base.LevelBaseTest;
import com.github.ldoud.modassist.constants.Character;
import com.github.ldoud.modassist.constants.Mod;
import org.dom4j.Node;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

class LevelXmlTest extends LevelBaseTest {

    private static TestXmlData data;

    @BeforeAll
    static void setUp() throws ParserConfigurationException, IOException, TransformerException {
        data = TestXmlData.getInstance();
    }

    protected void assertNumberOLevels(Character toon, Mod mod, String expectedNumberOfLevels) {
        Node modXml = data.getMod(toon, mod);

        String xpath = "@level";
        String characterName = modXml.selectSingleNode("@character").getText(); // used in assert message only

        Node level = modXml.selectSingleNode(xpath);
        Assertions.assertNotNull(level, characterName+"'s level on mod: "+xpath);
        Assertions.assertEquals(expectedNumberOfLevels, level.getText(), "Number of levels on mods");
    }
}
