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

class LevelTest {

    private static TestData data;

    @BeforeAll
    static void setUp() throws ParserConfigurationException, IOException, TransformerException {
        data = new TestData();
    }

    @Test
    void testLevelOne() {
        assertNumberOLevels(data.getMod(Character.OldDaka, Mod.Transmitter), "1");
    }

    @Test
    void testLevelSix() {
        assertNumberOLevels(data.getMod(Character.DirectorKrennic, Mod.Receiver), "6");
    }

    @Test
    void testLevelNine() {
        assertNumberOLevels(data.getMod(Character.StormtrooperHan, Mod.Multiplexer), "9");
        assertNumberOLevels(data.getMod(Character.FirstOrderStormtrooper, Mod.HoloArray), "9");
    }

    @Test
    void testLevelEleven() {
        assertNumberOLevels(data.getMod(Character.StormtrooperHan, Mod.DataBus), "11");
    }

    private void assertNumberOLevels(Node mod, String expectedNumberOfLevels) {
        String xpath = "@level";
        String characterName = mod.selectSingleNode("@character").getText(); // used in assert message only

        Node level = mod.selectSingleNode(xpath);
        Assertions.assertNotNull(level, characterName+"'s level on mod: "+xpath);
        Assertions.assertEquals(expectedNumberOfLevels, level.getText(), "Number of levels on mods");
    }
}
