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
import java.util.List;

public class SecondaryStats {

    private static String XPATH_CHARACTER = "/mods/mod[@character='${characterName}']";
    private static String XPATH_STAT = "stat[@name='${statName}' and @type='secondary']";

    private static Document doc;

    @BeforeAll
    static void setUp() throws ParserConfigurationException, IOException, SAXException, TransformerException {
        // https://swgoh.gg/u/wasssup/mods/
        URL html = ClassLoader.getSystemResource("html/swgoh_many_mods.html");
        HtmlDataMiner miner = new HtmlDataMiner("swgoh_mods.xsl");
        org.w3c.dom.Node n = miner.extractData(html);
        DOMReader reader = new DOMReader();
        doc = reader.read((org.w3c.dom.Document)n);
    }

    @Test
    public void testSpeed() {
        assertSecondaryStat(getCharacter(Character.AskokaTano.toString()), "Speed", "+4");
        assertSecondaryStat(getCharacter(Character.HothRebelScout.toString()), "Speed", "+5");
        assertSecondaryStat(getCharacter(Character.BiggsDarklighter.toString()), "Speed", "+9");
    }

    @Test
    public void testOffenseFlatAmount() {
        assertSecondaryStat(getCharacter(Character.AskokaTano.toString()), "Offense", "+24");
        assertSecondaryStat(getCharacter(Character.GrandMoffTarkin.toString()), "Offense", "+97");
        assertSecondaryStat(getCharacter(Character.CaptainHanSolo.toString()), "Offense", "+29");
    }

    @Test
    public void testOffensePercent() {
        // Need another webpage with offense percent
    }

    @Test
    public void testCriticalChance() {
        assertSecondaryStat(getCharacter(Character.JediConsular.toString()), "Critical Chance", "+1.72%");
        assertSecondaryStat(getCharacter(Character.Shoretrooper.toString()), "Critical Chance", "+1.72%");
        assertSecondaryStat(getCharacter(Character.Magmatrooper.toString()), "Critical Chance", "+4.98%");
    }

    @Test
    public void testDefenseFlatAmount() {
        assertSecondaryStat(getCharacter(Character.AskokaTano.toString()), "Defense", "+5");
        assertSecondaryStat(getCharacter(Character.WedgeAntilles.toString()), "Defense", "+8");
        assertSecondaryStat(getCharacter(Character.ResistanceTrooper.toString()), "Defense", "+14");
    }

    @Test
    public void testDefensePercent() {
        assertSecondaryStat(getCharacter(Character.ResistancePilot.toString()), "DefensePercent", "+1.55%");
        assertSecondaryStat(getCharacter(Character.BiggsDarklighter.toString()), "DefensePercent", "+4.06%");
        assertSecondaryStat(getCharacter(Character.PrincessLeia.toString()), "DefensePercent", "+0.99%");
    }

    @Test
    public void testPotency() {
        assertSecondaryStat(getCharacter(Character.CadBane.toString()), "Potency", "+1.25%");
        assertSecondaryStat(getCharacter(Character.BobaFett.toString()), "Potency", "+1.46%");
        assertSecondaryStat(getCharacter(Character.DarthSion.toString()), "Potency", "+2.24%");
    }

    @Test
    public void testHealthFlatAmount() {
        assertSecondaryStat(getCharacter(Character.DarthMaul.toString()), "Health", "+232");
        assertSecondaryStat(getCharacter(Character.CadBane.toString()), "Health", "+609");
        assertSecondaryStat(getCharacter(Character.FirstOrderTIEPilot.toString()), "Health", "+223");
        assertSecondaryStat(getCharacter(Character.GrandMoffTarkin.toString()), "Health", "+310");
    }

    @Test
    public void testHealthPercent() {
//        assertSecondaryStat(getCharacter(Character.DarthMaul.toString()), "HealthPercent", "+0.94%");
//        assertSecondaryStat(getCharacter(Character.ResistancePilot.toString()), "HealthPercent", "+0.59%");
        assertSecondaryStat(getCharacter(Character.EmperorPalpatine.toString()), "HealthPercent", "+0.87%");
    }

    @Test
    public void testTenacity() {
        assertSecondaryStat(getCharacter(Character.PrincessLeia.toString()), "Tenacity", "+2.64%");
        assertSecondaryStat(getCharacter(Character.JynErso.toString()), "Tenacity", "+1.26%");
        assertSecondaryStat(getCharacter(Character.SabineWren.toString()), "Tenacity", "+2.53%");
    }

    private Node getCharacter(String name) {
        Node character = doc.selectSingleNode(XPATH_CHARACTER.replace("${characterName}", name));
        Assertions.assertNotNull(character, "Character found: "+name);
        return character;
    }

    private void assertSecondaryStat(Node character, String statName, String expectedStatValue) {
        Node stat = character.selectSingleNode(XPATH_STAT.replace("${statName}", statName));
        Assertions.assertNotNull(stat, "Found secondary stat: "+stat+" for character: "+character.selectSingleNode("@character").getText());

        String asserting = character.selectSingleNode("@character").getText()+"'s "+statName;
        Assertions.assertEquals(expectedStatValue, stat.selectSingleNode("@value").getText(), asserting);
    }
}
