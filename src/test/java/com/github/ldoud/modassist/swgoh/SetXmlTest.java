package com.github.ldoud.modassist.swgoh;

import com.github.ldoud.modassist.base.SetBaseTest;
import com.github.ldoud.modassist.constants.CharacterName;
import com.github.ldoud.modassist.data.ModType;
import org.dom4j.Node;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

class SetXmlTest extends SetBaseTest {
    private static TestXmlData data;

    @BeforeAll
    static void setUp() throws ParserConfigurationException, IOException, TransformerException {
        data = TestXmlData.getInstance();
    }

    @Override
    protected void assertSetName(CharacterName toon, ModType modType, String expectedSetName) {
        Node modXml = data.getMod(toon, modType);
        String characterName = modXml.selectSingleNode("@character").getText(); // used in assert message only

        String xpath = "@set";
        Node setName = modXml.selectSingleNode(xpath);
        Assertions.assertNotNull(setName, characterName+"'s set on modType: "+xpath);
        Assertions.assertEquals(expectedSetName, setName.getText(), "Set name on modType");
    }
}
