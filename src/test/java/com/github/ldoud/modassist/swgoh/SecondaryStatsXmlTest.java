package com.github.ldoud.modassist.swgoh;

import com.github.ldoud.modassist.base.SecondaryStatsBaseTest;
import com.github.ldoud.modassist.constants.CharacterName;
import com.github.ldoud.modassist.data.ModType;
import com.github.ldoud.modassist.data.StatName;
import org.dom4j.Node;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

class SecondaryStatsXmlTest extends SecondaryStatsBaseTest {

    private static final String XPATH_STAT = "stat[@name='${statName}' and @type='secondary']";

    private static TestXmlData data;

    @BeforeAll
    static void setUp() throws ParserConfigurationException, IOException, TransformerException {
        data = TestXmlData.getInstance();
    }

    @Override
    protected void assertSecondaryStat(CharacterName toon, ModType modType, StatName secondaryStatName, String expectedStatValue) {
        Node modXml = data.getMod(toon, modType);
        Node stat = modXml.selectSingleNode(XPATH_STAT.replace("${statName}", secondaryStatName.toString()));
        Assertions.assertNotNull(stat, "Found secondary stat: "+stat+" for character: "+modXml.selectSingleNode("@character").getText());

        String asserting = modXml.selectSingleNode("@character").getText()+"'s "+ secondaryStatName.toString();
        Assertions.assertEquals(expectedStatValue, stat.selectSingleNode("@value").getText(), asserting);
    }

}
