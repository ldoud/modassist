package com.github.ldoud.modassist.swgoh;

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

class PrimaryStatTest {

    private static final String XPATH_STAT = "stat[@name='${statName}' and @type='primary']";

    private static TestXmlData data;

    @BeforeAll
    static void setUp() throws ParserConfigurationException, IOException, TransformerException {
        data = TestXmlData.getInstance();
    }

    @Test
    void testCriticalChance() {
        assertPrimaryStat(data.getMod(Character.JynErso, Mod.HoloArray), Stat.CriticalChance, "12");
        assertPrimaryStat(data.getMod(Character.GrandMasterYoda, Mod.HoloArray), Stat.CriticalChance, "9.75");
    }

    @Test
    void testCriticalDamage() {
        assertPrimaryStat(data.getMod(Character.Magmatrooper, Mod.HoloArray), Stat.CriticalDamage, "36");
        assertPrimaryStat(data.getMod(Character.PrincessLeia, Mod.HoloArray), Stat.CriticalDamage, "31.5");
    }

    @Test
    void testPotency() {
        assertPrimaryStat(data.getMod(Character.BobaFett, Mod.Multiplexer), Stat.Potency, "24");
        assertPrimaryStat(data.getMod(Character.RoyalGuard, Mod.Multiplexer), Stat.Potency, "19.5");
    }

    @Test
    void testTenacity() {
        assertPrimaryStat(data.getMod(Character.WedgeAntilles, Mod.Multiplexer), Stat.Tenacity, "24");
        assertPrimaryStat(data.getMod(Character.SithAssassin, Mod.Multiplexer), Stat.Tenacity, "19.5");
    }

    @Test
    void testAccuracy() {
        assertPrimaryStat(data.getMod(Character.ResistancePilot, Mod.Receiver), Stat.Accuracy, "12");
        assertPrimaryStat(data.getMod(Character.OldDaka, Mod.Receiver), Stat.Accuracy, "7.5");
    }

    @Test
    void testCriticalAvoidance() {
        assertPrimaryStat(data.getMod(Character.AskokaTano, Mod.Receiver), Stat.CriticalAvoidance, "24");
        assertPrimaryStat(data.getMod(Character.CloneWarsChewbacca, Mod.Receiver), Stat.CriticalAvoidance, "15");
    }

    @Test
    void testOffense() {
        assertPrimaryStat(data.getMod(Character.CommanderLukeSkywalker, Mod.Transmitter), Stat.OffensePercent, "5.88");
        assertPrimaryStat(data.getMod(Character.SithAssassin, Mod.Receiver), Stat.OffensePercent, "4.75");
    }

    @Test
    void testDefense() {
        assertPrimaryStat(data.getMod(Character.GeneralKenobi, Mod.Processor), Stat.DefensePercent, "11.75");
        assertPrimaryStat(data.getMod(Character.K2SO, Mod.Processor), Stat.DefensePercent, "9.5");
    }

    @Test
    void testHealth() {
        assertPrimaryStat(data.getMod(Character.CommanderLukeSkywalker, Mod.DataBus), Stat.HealthPercent, "5.88");
        assertPrimaryStat(data.getMod(Character.BobaFett, Mod.HoloArray), Stat.HealthPercent, "5.88");
        assertPrimaryStat(data.getMod(Character.DeathTrooper, Mod.Receiver), Stat.HealthPercent, "5.88");
    }

    @Test
    void testProtection() {
        assertPrimaryStat(data.getMod(Character.EmperorPalpatine, Mod.HoloArray), Stat.ProtectionPercent, "23.5");
        assertPrimaryStat(data.getMod(Character.FirstOrderTIEPilot, Mod.DataBus), Stat.ProtectionPercent, "23.5");
        assertPrimaryStat(data.getMod(Character.GrandAdmiralThrawn, Mod.Multiplexer), Stat.ProtectionPercent, "23.5");
        assertPrimaryStat(data.getMod(Character.RoyalGuard, Mod.DataBus), Stat.ProtectionPercent, "19");
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
