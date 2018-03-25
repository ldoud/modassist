package com.github.ldoud.modassist.base;

import com.github.ldoud.modassist.constants.Character;
import com.github.ldoud.modassist.constants.Mod;
import com.github.ldoud.modassist.swgoh.TestXmlData;
import org.dom4j.Node;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

public abstract class SetBaseTest {

    @Test
    void testHealthSet() {
        assertSetName(Character.CommanderLukeSkywalker, Mod.Transmitter, "Health");
        assertSetName(Character.Shoretrooper, Mod.Receiver, "Health");
        assertSetName(Character.GeneralKenobi, Mod.Processor, "Health");
        assertSetName(Character.WedgeAntilles, Mod.HoloArray, "Health");
        assertSetName(Character.CommanderLukeSkywalker, Mod.DataBus, "Health");
        assertSetName(Character.GeneralKenobi, Mod.Multiplexer, "Health");
    }

    @Test
    void testDefenseSet() {
        assertSetName(Character.GeneralVeers, Mod.Transmitter, "Defense");
        assertSetName(Character.AskokaTano, Mod.Receiver, "Defense");
        assertSetName(Character.KyloRen, Mod.Processor, "Defense");
        assertSetName(Character.DarthSion, Mod.HoloArray, "Defense");
        assertSetName(Character.AsajjVentress, Mod.DataBus, "Defense");
        assertSetName(Character.GrandAdmiralThrawn, Mod.Multiplexer, "Defense");
    }

    @Test
    void testCriticalDamageSet() {
        assertSetName(Character.DarthMaul, Mod.Transmitter, "Critical Damage");
        assertSetName(Character.GrandMoffTarkin, Mod.Receiver, "Critical Damage");
        assertSetName(Character.BobaFett, Mod.Processor, "Critical Damage");
        assertSetName(Character.DeathTrooper, Mod.HoloArray, "Critical Damage");
        assertSetName(Character.PrincessLeia, Mod.DataBus, "Critical Damage");
        assertSetName(Character.JynErso, Mod.Multiplexer, "Critical Damage");
    }

    @Test
    void testCriticalChanceSet() {
        assertSetName(Character.DarthMaul, Mod.Receiver, "Critical Chance");
        assertSetName(Character.BiggsDarklighter, Mod.HoloArray, "Critical Chance");
    }

    @Test
    void testTenacitySet() {
        assertSetName(Character.ZamWesell, Mod.Processor, "Tenacity");
        assertSetName(Character.Shoretrooper, Mod.HoloArray, "Tenacity");
        assertSetName(Character.JynErso, Mod.DataBus, "Tenacity");
    }

    @Test
    void testOffenseSet() {
        assertSetName(Character.OldDaka, Mod.HoloArray, "Offense");
        assertSetName(Character.EwokElder, Mod.Multiplexer, "Offense");
    }

    @Test
    void testPotencySet() {
        assertSetName(Character.ResistancePilot, Mod.Transmitter, "Potency");
        assertSetName(Character.BobaFett, Mod.Receiver, "Potency");
        assertSetName(Character.JynErso, Mod.Processor, "Potency");
        assertSetName(Character.GrandMoffTarkin, Mod.HoloArray, "Potency");
        assertSetName(Character.AskokaTano, Mod.DataBus, "Potency");
        assertSetName(Character.ResistanceTrooper, Mod.Multiplexer, "Potency");
    }

    @Test
    void testSpeedSet() {
        assertSetName(Character.GrandAdmiralThrawn, Mod.Transmitter, "Speed");
        assertSetName(Character.CommanderLukeSkywalker, Mod.Receiver, "Speed");
        assertSetName(Character.GeneralVeers, Mod.Processor, "Speed");
        assertSetName(Character.GeneralKenobi, Mod.HoloArray, "Speed");
        assertSetName(Character.K2SO, Mod.DataBus, "Speed");
        assertSetName(Character.ZamWesell, Mod.Multiplexer, "Speed");
    }

    protected abstract void assertSetName(Character toon, Mod mod, String expectedSetName);
}
