package com.github.ldoud.modassist.swgoh;

import com.github.ldoud.modassist.base.LevelBaseTest;
import com.github.ldoud.modassist.constants.CharacterName;
import com.github.ldoud.modassist.constants.ModType;
import org.dom4j.Node;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

class LevelXmlTest extends LevelBaseTest {

    private static TestXmlData data;

    @BeforeAll
    static void setUp() throws ParserConfigurationException, IOException, TransformerException {
        data = TestXmlData.getInstance();
    }

    protected void assertNumberOLevels(CharacterName toon, ModType modType, String expectedNumberOfLevels) {
        Node modXml = data.getMod(toon, modType);

        String xpath = "@level";
        String characterName = modXml.selectSingleNode("@character").getText(); // used in assert message only

        Node level = modXml.selectSingleNode(xpath);
        Assertions.assertNotNull(level, characterName+"'s level on modType: "+xpath);
        Assertions.assertEquals(expectedNumberOfLevels, level.getText(), "Number of levels on mods");
    }
}
