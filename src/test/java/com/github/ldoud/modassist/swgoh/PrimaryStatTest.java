package com.github.ldoud.modassist.swgoh;

import com.github.ldoud.modassist.constants.Character;
import com.github.ldoud.modassist.constants.Mod;
import com.github.ldoud.modassist.constants.Stat;
import org.dom4j.Node;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

public class PrimaryStatTest {

    private static final String XPATH_STAT = "stat[@name='${statName}' and @type='primary']";

    private static TestData data;

    @BeforeAll
    static void setUp() throws ParserConfigurationException, IOException, SAXException, TransformerException {
        data = new TestData();
    }

    @Test
    public void testCritcalChance() {
        assertPrimaryStat(data.getMod(Character.JynErso, Mod.HoloArray), Stat.CriticalChance, "12");
        assertPrimaryStat(data.getMod(Character.GrandMasterYoda, Mod.HoloArray), Stat.CriticalChance, "9.75");
    }

    @Test
    public void testCriticalDamage() {
        assertPrimaryStat(data.getMod(Character.Magmatrooper, Mod.HoloArray), Stat.CriticalDamage, "36");
        assertPrimaryStat(data.getMod(Character.PrincessLeia, Mod.HoloArray), Stat.CriticalDamage, "31.5");
    }

    @Test
    public void testDefense() {
        assertPrimaryStat(data.getMod(Character.GeneralKenobi, Mod.Processor), Stat.DefensePercent, "11.75");
        assertPrimaryStat(data.getMod(Character.K2SO, Mod.Processor), Stat.DefensePercent, "9.5");
    }

    @Test
    public void testPotency() {
        assertPrimaryStat(data.getMod(Character.BobaFett, Mod.Multiplexer), Stat.Potency, "24");
        assertPrimaryStat(data.getMod(Character.RoyalGuard, Mod.Multiplexer), Stat.Potency, "19.5");
    }

    @Test
    public void testTenacity() {
        assertPrimaryStat(data.getMod(Character.WedgeAntilles, Mod.Multiplexer), Stat.Tenacity, "24");
        assertPrimaryStat(data.getMod(Character.SithAssassin, Mod.Multiplexer), Stat.Tenacity, "19.5");
    }

    @Test
    public void testAccuracy() {
        assertPrimaryStat(data.getMod(Character.ResistancePilot, Mod.Receiver), Stat.Accuracy, "12");
        assertPrimaryStat(data.getMod(Character.OldDaka, Mod.Receiver), Stat.Accuracy, "7.5");
    }

    private void assertPrimaryStat(Node mod, Stat primaryStat, String expectedStatValue) {
        String xpath = XPATH_STAT.replace("${statName}", primaryStat.toString());
        String characterName = mod.selectSingleNode("@character").getText(); // used in assert message only

        Node stat = mod.selectSingleNode(xpath);
        Assertions.assertNotNull(stat, characterName+"'s primary: "+xpath);

        String asserting = mod.selectSingleNode("@character").getText()+"'s "+primaryStat.toString();
        Assertions.assertEquals(expectedStatValue, stat.selectSingleNode("@value").getText(), asserting);
    }
}
