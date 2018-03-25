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

class SetTest {
    private static TestData data;

    @BeforeAll
    static void setUp() throws ParserConfigurationException, IOException, TransformerException {
        data = new TestData();
    }

    @Test
    void testHealthSet() {
        assertSetName(data.getMod(Character.CommanderLukeSkywalker, Mod.Transmitter), "Health");
        assertSetName(data.getMod(Character.Shoretrooper, Mod.Receiver), "Health");
        assertSetName(data.getMod(Character.GeneralKenobi, Mod.Processor), "Health");
        assertSetName(data.getMod(Character.WedgeAntilles, Mod.HoloArray), "Health");
        assertSetName(data.getMod(Character.CommanderLukeSkywalker, Mod.DataBus), "Health");
        assertSetName(data.getMod(Character.GeneralKenobi, Mod.Multiplexer), "Health");
    }

    @Test
    void testDefenseSet() {
        assertSetName(data.getMod(Character.GeneralVeers, Mod.Transmitter), "Defense");
        assertSetName(data.getMod(Character.AskokaTano, Mod.Receiver), "Defense");
        assertSetName(data.getMod(Character.KyloRen, Mod.Processor), "Defense");
        assertSetName(data.getMod(Character.DarthSion, Mod.HoloArray), "Defense");
        assertSetName(data.getMod(Character.AsajjVentress, Mod.DataBus), "Defense");
        assertSetName(data.getMod(Character.GrandAdmiralThrawn, Mod.Multiplexer), "Defense");
    }

    @Test
    void testCriticalDamageSet() {
        assertSetName(data.getMod(Character.DarthMaul, Mod.Transmitter), "Critical Damage");
        assertSetName(data.getMod(Character.GrandMoffTarkin, Mod.Receiver), "Critical Damage");
        assertSetName(data.getMod(Character.BobaFett, Mod.Processor), "Critical Damage");
        assertSetName(data.getMod(Character.DeathTrooper, Mod.HoloArray), "Critical Damage");
        assertSetName(data.getMod(Character.PrincessLeia, Mod.DataBus), "Critical Damage");
        assertSetName(data.getMod(Character.JynErso, Mod.Multiplexer), "Critical Damage");
    }

    @Test
    void testCriticalChanceSet() {
        assertSetName(data.getMod(Character.DarthMaul, Mod.Receiver), "Critical Chance");
        assertSetName(data.getMod(Character.BiggsDarklighter, Mod.HoloArray), "Critical Chance");
    }

    @Test
    void testTenacitySet() {
        assertSetName(data.getMod(Character.ZamWesell, Mod.Processor), "Tenacity");
        assertSetName(data.getMod(Character.Shoretrooper, Mod.HoloArray), "Tenacity");
        assertSetName(data.getMod(Character.JynErso, Mod.DataBus), "Tenacity");
    }

    @Test
    void testOffenseSet() {
        assertSetName(data.getMod(Character.OldDaka, Mod.HoloArray), "Offense");
        assertSetName(data.getMod(Character.EwokElder, Mod.Multiplexer), "Offense");
    }

    @Test
    void testPotencySet() {
        assertSetName(data.getMod(Character.ResistancePilot, Mod.Transmitter), "Potency");
        assertSetName(data.getMod(Character.BobaFett, Mod.Receiver), "Potency");
        assertSetName(data.getMod(Character.JynErso, Mod.Processor), "Potency");
        assertSetName(data.getMod(Character.GrandMoffTarkin, Mod.HoloArray), "Potency");
        assertSetName(data.getMod(Character.AskokaTano, Mod.DataBus), "Potency");
        assertSetName(data.getMod(Character.ResistanceTrooper, Mod.Multiplexer), "Potency");
    }

    @Test
    void testSpeedSet() {
        assertSetName(data.getMod(Character.GrandAdmiralThrawn, Mod.Transmitter), "Speed");
        assertSetName(data.getMod(Character.CommanderLukeSkywalker, Mod.Receiver), "Speed");
        assertSetName(data.getMod(Character.GeneralVeers, Mod.Processor), "Speed");
        assertSetName(data.getMod(Character.GeneralKenobi, Mod.HoloArray), "Speed");
        assertSetName(data.getMod(Character.K2SO, Mod.DataBus), "Speed");
        assertSetName(data.getMod(Character.ZamWesell, Mod.Multiplexer), "Speed");
    }

    private void assertSetName(Node mod, String expectedSetName) {
        String xpath = "@set";
        String characterName = mod.selectSingleNode("@character").getText(); // used in assert message only

        Node setName = mod.selectSingleNode(xpath);
        Assertions.assertNotNull(setName, characterName+"'s set on mod: "+xpath);
        Assertions.assertEquals(expectedSetName, setName.getText(), "Set name on mod");
    }
}
