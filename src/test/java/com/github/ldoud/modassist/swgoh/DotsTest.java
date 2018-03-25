package com.github.ldoud.modassist.swgoh;

import com.github.ldoud.modassist.constants.Character;
import com.github.ldoud.modassist.constants.Mod;
import org.dom4j.Node;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

class DotsTest {

    private static TestData data;

    @BeforeAll
    static void setUp() throws ParserConfigurationException, IOException, TransformerException {
        data = new TestData();
    }

    @Test
    void testOneDot() {
        assertNumberOfDots(data.getMod(Character.OldDaka, Mod.Multiplexer), "1");
    }

    @Test
    void testTwoDots() {
        assertNumberOfDots(data.getMod(Character.RoyalGuard, Mod.Receiver), "2");
    }

    @Test
    void testThreeDots() {
        assertNumberOfDots(data.getMod(Character.HothRebelScout, Mod.HoloArray), "3");
    }

    @Test
    void testFourDots() {
        assertNumberOfDots(data.getMod(Character.StormtrooperHan, Mod.DataBus), "4");
    }

    @Test
    void testFiveDots() {
        assertNumberOfDots(data.getMod(Character.StormtrooperHan, Mod.Multiplexer), "5");
    }


    private void assertNumberOfDots(Node mod, String expectedNumberOfDots) {
        String xpath = "@dots";
        String characterName = mod.selectSingleNode("@character").getText(); // used in assert message only

        Node dots = mod.selectSingleNode(xpath);
        Assertions.assertNotNull(dots, characterName+"'s dots: "+xpath);
        Assertions.assertEquals(expectedNumberOfDots, dots.getText(), "Number of dots on mods");
    }
}
