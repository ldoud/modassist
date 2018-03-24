package com.github.ldoud.modassist.xsl;

import com.github.ldoud.modassist.readers.HtmlDataMiner;
import org.dom4j.Document;
import org.dom4j.Node;
import org.dom4j.io.DOMReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.net.URL;

public class SecondaryStats {

    private static String XPATH_SLOT_ON_CHARACTER = "/mods/mod[@character='${characterName}' and @slot='${modType}']";
    private static String XPATH_STAT = "stat[@name='${statName}' and @type='secondary']";

    private static Document doc;

    @BeforeAll
    static void setUp() throws ParserConfigurationException, IOException, SAXException, TransformerException {
        // https://swgoh.gg/u/wasssup/mods/
        URL[] webpages = new URL[14];
        webpages[0] = ClassLoader.getSystemResource("html/swgoh_page1.html");
        webpages[1] = ClassLoader.getSystemResource("html/swgoh_page2.html");
        webpages[2] = ClassLoader.getSystemResource("html/swgoh_page3.html");
        webpages[3] = ClassLoader.getSystemResource("html/swgoh_page4.html");
        webpages[4] = ClassLoader.getSystemResource("html/swgoh_page5.html");
        webpages[5] = ClassLoader.getSystemResource("html/swgoh_page6.html");
        webpages[6] = ClassLoader.getSystemResource("html/swgoh_page7.html");
        webpages[7] = ClassLoader.getSystemResource("html/swgoh_page8.html");
        webpages[8] = ClassLoader.getSystemResource("html/swgoh_page9.html");
        webpages[9] = ClassLoader.getSystemResource("html/swgoh_page10.html");
        webpages[10] = ClassLoader.getSystemResource("html/swgoh_page11.html");
        webpages[11] = ClassLoader.getSystemResource("html/swgoh_page12.html");
        webpages[12] = ClassLoader.getSystemResource("html/swgoh_page13.html");
        webpages[13] = ClassLoader.getSystemResource("html/swgoh_page14.html");

        HtmlDataMiner miner = new HtmlDataMiner("swgoh_mods.xsl");
        org.w3c.dom.Node n = miner.extractData(webpages);
        DOMReader reader = new DOMReader();
        doc = reader.read((org.w3c.dom.Document)n);
    }

    @Test
    public void testSpeed() {
        assertSecondaryStat(getMod(Character.AskokaTano, Mod.Transmitter), "Speed", "4");
        assertSecondaryStat(getMod(Character.HothRebelScout, Mod.Transmitter), "Speed", "5");
        assertSecondaryStat(getMod(Character.BiggsDarklighter, Mod.Transmitter), "Speed", "9");
    }

    @Test
    public void testOffenseFlatAmount() {
        assertSecondaryStat(getMod(Character.AskokaTano, Mod.Transmitter), "Offense", "24");
        assertSecondaryStat(getMod(Character.GrandMoffTarkin, Mod.Transmitter), "Offense", "97");
        assertSecondaryStat(getMod(Character.CaptainHanSolo, Mod.Transmitter), "Offense", "29");

        // Has both precent and flat amount.
        assertSecondaryStat(getMod(Character.CommanderLukeSkywalker, Mod.HoloArray), "Offense", "119");
        assertSecondaryStat(getMod(Character.FirstOrderTIEPilot, Mod.Multiplexer), "Offense", "115");
    }

    @Test
    public void testOffensePercent() {
        assertSecondaryStat(getMod(Character.CommanderLukeSkywalker, Mod.HoloArray), "OffensePercent", "0.38");
        assertSecondaryStat(getMod(Character.FirstOrderTIEPilot, Mod.Multiplexer), "OffensePercent", "0.37");
    }

    @Test
    public void testCriticalChance() {
        assertSecondaryStat(getMod(Character.JediConsular, Mod.Transmitter), "Critical Chance", "1.72");
        assertSecondaryStat(getMod(Character.Shoretrooper, Mod.Transmitter), "Critical Chance", "1.72");
        assertSecondaryStat(getMod(Character.Magmatrooper, Mod.Transmitter), "Critical Chance", "4.98");
    }

    @Test
    public void testDefenseFlatAmount() {
        assertSecondaryStat(getMod(Character.AskokaTano, Mod.Transmitter), "Defense", "5");
        assertSecondaryStat(getMod(Character.WedgeAntilles, Mod.Transmitter), "Defense", "8");
        assertSecondaryStat(getMod(Character.ResistanceTrooper, Mod.Transmitter), "Defense", "14");
    }

    @Test
    public void testDefensePercent() {
        assertSecondaryStat(getMod(Character.ResistancePilot, Mod.Transmitter), "DefensePercent", "1.55");
        assertSecondaryStat(getMod(Character.BiggsDarklighter, Mod.Transmitter), "DefensePercent", "4.06");
        assertSecondaryStat(getMod(Character.PrincessLeia, Mod.Transmitter), "DefensePercent", "0.99");
    }

    @Test
    public void testPotency() {
        assertSecondaryStat(getMod(Character.CadBane, Mod.Transmitter), "Potency", "1.25");
        assertSecondaryStat(getMod(Character.BobaFett, Mod.Transmitter), "Potency", "1.46");
        assertSecondaryStat(getMod(Character.DarthSion, Mod.Transmitter), "Potency", "2.24");
    }

    @Test
    public void testHealthFlatAmount() {
        assertSecondaryStat(getMod(Character.DarthMaul, Mod.Transmitter), "Health", "232");
        assertSecondaryStat(getMod(Character.CadBane, Mod.Transmitter), "Health", "609");
        assertSecondaryStat(getMod(Character.FirstOrderTIEPilot, Mod.Transmitter), "Health", "223");
        assertSecondaryStat(getMod(Character.GrandMoffTarkin, Mod.Transmitter), "Health", "310");
    }

    @Test
    public void testHealthPercent() {
        assertSecondaryStat(getMod(Character.DarthMaul, Mod.Transmitter), "HealthPercent", "0.94");
        assertSecondaryStat(getMod(Character.ResistancePilot, Mod.Transmitter), "HealthPercent", "0.59");
        assertSecondaryStat(getMod(Character.EmperorPalpatine, Mod.Transmitter), "HealthPercent", "0.87");
    }

    @Test
    public void testTenacity() {
        assertSecondaryStat(getMod(Character.PrincessLeia, Mod.Transmitter), "Tenacity", "2.64");
        assertSecondaryStat(getMod(Character.JynErso, Mod.Transmitter), "Tenacity", "1.26");
        assertSecondaryStat(getMod(Character.SabineWren, Mod.Transmitter), "Tenacity", "2.53");
    }

    private Node getMod(Character toon, Mod slot) {
        String xpath = XPATH_SLOT_ON_CHARACTER
                .replace("${characterName}", toon.toString())
                .replace("${modType}", slot.toString());
        Node character = doc.selectSingleNode(xpath);

        Assertions.assertNotNull(character, "Character's mod found: "+xpath);
        return character;
    }

    private void assertSecondaryStat(Node character, String statName, String expectedStatValue) {
        Node stat = character.selectSingleNode(XPATH_STAT.replace("${statName}", statName));
        Assertions.assertNotNull(stat, "Found secondary stat: "+stat+" for character: "+character.selectSingleNode("@character").getText());

        String asserting = character.selectSingleNode("@character").getText()+"'s "+statName;
        Assertions.assertEquals(expectedStatValue, stat.selectSingleNode("@value").getText(), asserting);
    }
}
