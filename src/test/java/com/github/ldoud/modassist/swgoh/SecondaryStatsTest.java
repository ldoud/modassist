package com.github.ldoud.modassist.swgoh;

import com.github.ldoud.modassist.base.SecondaryStatsBaseTest;
import com.github.ldoud.modassist.constants.Character;
import com.github.ldoud.modassist.constants.Mod;
import com.github.ldoud.modassist.constants.Stat;
import org.dom4j.Node;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

class SecondaryStatsTest extends SecondaryStatsBaseTest {

    private static final String XPATH_STAT = "stat[@name='${statName}' and @type='secondary']";

    private static TestXmlData data;

    @BeforeAll
    static void setUp() throws ParserConfigurationException, IOException, TransformerException {
        data = TestXmlData.getInstance();
    }

    @Override
    protected void assertSecondaryStat(Character toon, Mod mod, Stat secondaryStat, String expectedStatValue) {
        Node modXml = data.getMod(toon, mod);
        Node stat = modXml.selectSingleNode(XPATH_STAT.replace("${statName}", secondaryStat.toString()));
        Assertions.assertNotNull(stat, "Found secondary stat: "+stat+" for character: "+modXml.selectSingleNode("@character").getText());

        String asserting = modXml.selectSingleNode("@character").getText()+"'s "+secondaryStat.toString();
        Assertions.assertEquals(expectedStatValue, stat.selectSingleNode("@value").getText(), asserting);
    }

}
