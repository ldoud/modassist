package com.github.ldoud.modassist.swgoh;

import com.github.ldoud.modassist.base.PrimaryStatNameBaseTest;
import com.github.ldoud.modassist.constants.CharacterName;
import com.github.ldoud.modassist.data.ModType;
import com.github.ldoud.modassist.data.StatName;
import org.dom4j.Node;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;


class PrimaryStatNameXmlTest extends PrimaryStatNameBaseTest {

    private static final String XPATH_STAT = "stat[@name='${statName}' and @type='primary']";

    private static TestXmlData data;

    @BeforeAll
    static void setUp() throws ParserConfigurationException, IOException, TransformerException {
        data = TestXmlData.getInstance();
    }

    @Override
    protected void assertPrimaryStat(CharacterName toon, ModType modType, StatName primaryStatName, String expectedStatValue) {
        Node modXml = data.getMod(toon, modType);
        String xpath = XPATH_STAT.replace("${statName}", primaryStatName.toString());
        String characterName = modXml.selectSingleNode("@character").getText(); // used in assert message only

        Node stat = modXml.selectSingleNode(xpath);
        Assertions.assertNotNull(stat, characterName+"'s primary: "+xpath);

        String asserting = modXml.selectSingleNode("@character").getText()+"'s "+ primaryStatName.toString();
        Assertions.assertEquals(expectedStatValue, stat.selectSingleNode("@value").getText(), asserting);
    }
}
