package com.github.ldoud.modassist.swgoh;

import com.github.ldoud.modassist.base.PrimaryStatBaseTest;
import com.github.ldoud.modassist.constants.CharacterName;
import com.github.ldoud.modassist.constants.ModType;
import com.github.ldoud.modassist.constants.Stat;
import org.dom4j.Node;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

class PrimaryStatXmlTest extends PrimaryStatBaseTest {

    private static final String XPATH_STAT = "stat[@name='${statName}' and @type='primary']";

    private static TestXmlData data;

    @BeforeAll
    static void setUp() throws ParserConfigurationException, IOException, TransformerException {
        data = TestXmlData.getInstance();
    }

    @Override
    protected void assertPrimaryStat(CharacterName toon, ModType modType, Stat primaryStat, String expectedStatValue) {
        Node modXml = data.getMod(toon, modType);
        String xpath = XPATH_STAT.replace("${statName}", primaryStat.toString());
        String characterName = modXml.selectSingleNode("@character").getText(); // used in assert message only

        Node stat = modXml.selectSingleNode(xpath);
        Assertions.assertNotNull(stat, characterName+"'s primary: "+xpath);

        String asserting = modXml.selectSingleNode("@character").getText()+"'s "+primaryStat.toString();
        Assertions.assertEquals(expectedStatValue, stat.selectSingleNode("@value").getText(), asserting);
    }
}
