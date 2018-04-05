package com.github.ldoud.modassist.swgoh;

import com.github.ldoud.modassist.base.DotsBaseTest;
import com.github.ldoud.modassist.constants.CharacterName;
import com.github.ldoud.modassist.data.ModType;
import org.dom4j.Node;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

class DotsXmlTest extends DotsBaseTest {

    private static TestXmlData data;

    @BeforeAll
    static void setUp() throws ParserConfigurationException, IOException, TransformerException {
        data = TestXmlData.getInstance();
    }

    @Override
    protected void assertNumberOfDots(CharacterName toon, ModType modType, String expectedNumberOfDots) {
        Node modXml = data.getMod(toon, modType);
        String xpath = "@dots";
        String characterName = modXml.selectSingleNode("@character").getText(); // used in assert message only

        Node dots = modXml.selectSingleNode(xpath);
        Assertions.assertNotNull(dots, characterName+"'s dots: "+xpath);
        Assertions.assertEquals(expectedNumberOfDots, dots.getText(), "Number of dots on mods");
    }
}
