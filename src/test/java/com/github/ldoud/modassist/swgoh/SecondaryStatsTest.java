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

public class SecondaryStatsTest {

    private static final String XPATH_STAT = "stat[@name='${statName}' and @type='secondary']";

    private static TestData data;

    @BeforeAll
    static void setUp() throws ParserConfigurationException, IOException, SAXException, TransformerException {
        data = new TestData();
    }

    @Test
    public void testSpeed() {
        assertSecondaryStat(data.getMod(Character.AskokaTano, Mod.Transmitter), Stat.Speed, "4");
        assertSecondaryStat(data.getMod(Character.HothRebelScout, Mod.Transmitter), Stat.Speed, "5");
        assertSecondaryStat(data.getMod(Character.BiggsDarklighter, Mod.Transmitter), Stat.Speed, "9");
    }

    @Test
    public void testOffenseFlatAmount() {
        assertSecondaryStat(data.getMod(Character.AskokaTano, Mod.Transmitter), Stat.Offense, "24");
        assertSecondaryStat(data.getMod(Character.GrandMoffTarkin, Mod.Transmitter), Stat.Offense, "97");
        assertSecondaryStat(data.getMod(Character.CaptainHanSolo, Mod.Transmitter), Stat.Offense, "29");

        // Has both precent and flat amount.
        assertSecondaryStat(data.getMod(Character.CommanderLukeSkywalker, Mod.HoloArray), Stat.Offense, "119");
        assertSecondaryStat(data.getMod(Character.FirstOrderTIEPilot, Mod.Multiplexer), Stat.Offense, "115");
    }

    @Test
    public void testOffensePercent() {
        // Has both precent and flat amount.
        assertSecondaryStat(data.getMod(Character.CommanderLukeSkywalker, Mod.HoloArray), Stat.OffensePercent, "0.38");
        assertSecondaryStat(data.getMod(Character.FirstOrderTIEPilot, Mod.Multiplexer), Stat.OffensePercent, "0.37");
    }

    @Test
    public void testCriticalChance() {
        assertSecondaryStat(data.getMod(Character.JediConsular, Mod.Transmitter), Stat.CriticalChance, "1.72");
        assertSecondaryStat(data.getMod(Character.Shoretrooper, Mod.Transmitter), Stat.CriticalChance, "1.72");
        assertSecondaryStat(data.getMod(Character.Magmatrooper, Mod.Transmitter), Stat.CriticalChance, "4.98");
    }

    @Test
    public void testDefenseFlatAmount() {
        assertSecondaryStat(data.getMod(Character.AskokaTano, Mod.Transmitter), Stat.Defense, "5");
        assertSecondaryStat(data.getMod(Character.WedgeAntilles, Mod.Transmitter), Stat.Defense, "8");
        assertSecondaryStat(data.getMod(Character.ResistanceTrooper, Mod.Transmitter), Stat.Defense, "14");
    }

    @Test
    public void testDefensePercent() {
        assertSecondaryStat(data.getMod(Character.ResistancePilot, Mod.Transmitter), Stat.DefensePercent, "1.55");
        assertSecondaryStat(data.getMod(Character.BiggsDarklighter, Mod.Transmitter), Stat.DefensePercent, "4.06");
        assertSecondaryStat(data.getMod(Character.PrincessLeia, Mod.Transmitter), Stat.DefensePercent, "0.99");
    }

    @Test
    public void testPotency() {
        assertSecondaryStat(data.getMod(Character.CadBane, Mod.Transmitter), Stat.Potency, "1.25");
        assertSecondaryStat(data.getMod(Character.BobaFett, Mod.Transmitter), Stat.Potency, "1.46");
        assertSecondaryStat(data.getMod(Character.DarthSion, Mod.Transmitter), Stat.Potency, "2.24");
    }

    @Test
    public void testHealthFlatAmount() {
        assertSecondaryStat(data.getMod(Character.DarthMaul, Mod.Transmitter), Stat.Health, "232");
        assertSecondaryStat(data.getMod(Character.CadBane, Mod.Transmitter), Stat.Health, "609");
        assertSecondaryStat(data.getMod(Character.FirstOrderTIEPilot, Mod.Transmitter), Stat.Health, "223");
        assertSecondaryStat(data.getMod(Character.GrandMoffTarkin, Mod.Transmitter), Stat.Health, "310");
    }

    @Test
    public void testHealthPercent() {
        assertSecondaryStat(data.getMod(Character.DarthMaul, Mod.Transmitter), Stat.HealthPercent, "0.94");
        assertSecondaryStat(data.getMod(Character.ResistancePilot, Mod.Transmitter), Stat.HealthPercent, "0.59");
        assertSecondaryStat(data.getMod(Character.EmperorPalpatine, Mod.Transmitter), Stat.HealthPercent, "0.87");
    }

    @Test
    public void testTenacity() {
        assertSecondaryStat(data.getMod(Character.PrincessLeia, Mod.Transmitter), Stat.Tenacity, "2.64");
        assertSecondaryStat(data.getMod(Character.JynErso, Mod.Transmitter), Stat.Tenacity, "1.26");
        assertSecondaryStat(data.getMod(Character.SabineWren, Mod.Transmitter), Stat.Tenacity, "2.53");
    }

    @Test
    public void testProtectionFlatAmount() {
        assertSecondaryStat(data.getMod(Character.RoyalGuard, Mod.DataBus), Stat.Protection, "3737");
        assertSecondaryStat(data.getMod(Character.PrincessLeia, Mod.Multiplexer), Stat.Protection, "1531");
        assertSecondaryStat(data.getMod(Character.Shoretrooper, Mod.Transmitter), Stat.Protection, "1658");
    }

    @Test
    public void testProtectionPercent() {
        assertSecondaryStat(data.getMod(Character.DarthSion, Mod.Processor), Stat.ProtectionPercent, "1.33");
        assertSecondaryStat(data.getMod(Character.GeneralVeers, Mod.HoloArray), Stat.ProtectionPercent, "3.19");
        assertSecondaryStat(data.getMod(Character.SabineWren, Mod.Processor), Stat.ProtectionPercent, "1.24");
    }


    private void assertSecondaryStat(Node character, Stat secondaryStat, String expectedStatValue) {
        Node stat = character.selectSingleNode(XPATH_STAT.replace("${statName}", secondaryStat.toString()));
        Assertions.assertNotNull(stat, "Found secondary stat: "+stat+" for character: "+character.selectSingleNode("@character").getText());

        String asserting = character.selectSingleNode("@character").getText()+"'s "+secondaryStat.toString();
        Assertions.assertEquals(expectedStatValue, stat.selectSingleNode("@value").getText(), asserting);
    }
}
