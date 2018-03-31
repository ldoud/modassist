package com.github.ldoud.modassist.base;

import com.github.ldoud.modassist.constants.Character;
import com.github.ldoud.modassist.constants.ModType;
import org.junit.jupiter.api.Test;

public abstract class SetBaseTest {

    @Test
    void testHealthSet() {
        assertSetName(Character.CommanderLukeSkywalker, ModType.Transmitter, "Health");
        assertSetName(Character.Shoretrooper, ModType.Receiver, "Health");
        assertSetName(Character.GeneralKenobi, ModType.Processor, "Health");
        assertSetName(Character.WedgeAntilles, ModType.HoloArray, "Health");
        assertSetName(Character.CommanderLukeSkywalker, ModType.DataBus, "Health");
        assertSetName(Character.GeneralKenobi, ModType.Multiplexer, "Health");
    }

    @Test
    void testDefenseSet() {
        assertSetName(Character.GeneralVeers, ModType.Transmitter, "Defense");
        assertSetName(Character.AskokaTano, ModType.Receiver, "Defense");
        assertSetName(Character.KyloRen, ModType.Processor, "Defense");
        assertSetName(Character.DarthSion, ModType.HoloArray, "Defense");
        assertSetName(Character.AsajjVentress, ModType.DataBus, "Defense");
        assertSetName(Character.GrandAdmiralThrawn, ModType.Multiplexer, "Defense");
    }

    @Test
    void testCriticalDamageSet() {
        assertSetName(Character.DarthMaul, ModType.Transmitter, "Critical Damage");
        assertSetName(Character.GrandMoffTarkin, ModType.Receiver, "Critical Damage");
        assertSetName(Character.BobaFett, ModType.Processor, "Critical Damage");
        assertSetName(Character.DeathTrooper, ModType.HoloArray, "Critical Damage");
        assertSetName(Character.PrincessLeia, ModType.DataBus, "Critical Damage");
        assertSetName(Character.JynErso, ModType.Multiplexer, "Critical Damage");
    }

    @Test
    void testCriticalChanceSet() {
        assertSetName(Character.DarthMaul, ModType.Receiver, "Critical Chance");
        assertSetName(Character.BiggsDarklighter, ModType.HoloArray, "Critical Chance");
    }

    @Test
    void testTenacitySet() {
        assertSetName(Character.ZamWesell, ModType.Processor, "Tenacity");
        assertSetName(Character.Shoretrooper, ModType.HoloArray, "Tenacity");
        assertSetName(Character.JynErso, ModType.DataBus, "Tenacity");
    }

    @Test
    void testOffenseSet() {
        assertSetName(Character.OldDaka, ModType.HoloArray, "Offense");
        assertSetName(Character.EwokElder, ModType.Multiplexer, "Offense");
    }

    @Test
    void testPotencySet() {
        assertSetName(Character.ResistancePilot, ModType.Transmitter, "Potency");
        assertSetName(Character.BobaFett, ModType.Receiver, "Potency");
        assertSetName(Character.JynErso, ModType.Processor, "Potency");
        assertSetName(Character.GrandMoffTarkin, ModType.HoloArray, "Potency");
        assertSetName(Character.AskokaTano, ModType.DataBus, "Potency");
        assertSetName(Character.ResistanceTrooper, ModType.Multiplexer, "Potency");
    }

    @Test
    void testSpeedSet() {
        assertSetName(Character.GrandAdmiralThrawn, ModType.Transmitter, "Speed");
        assertSetName(Character.CommanderLukeSkywalker, ModType.Receiver, "Speed");
        assertSetName(Character.GeneralVeers, ModType.Processor, "Speed");
        assertSetName(Character.GeneralKenobi, ModType.HoloArray, "Speed");
        assertSetName(Character.K2SO, ModType.DataBus, "Speed");
        assertSetName(Character.ZamWesell, ModType.Multiplexer, "Speed");
    }

    protected abstract void assertSetName(Character toon, ModType modType, String expectedSetName);
}
