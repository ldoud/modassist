package com.github.ldoud.modassist.base;

import com.github.ldoud.modassist.constants.CharacterName;
import com.github.ldoud.modassist.constants.ModType;
import org.junit.jupiter.api.Test;

public abstract class SetBaseTest {

    @Test
    void testHealthSet() {
        assertSetName(CharacterName.CommanderLukeSkywalker, ModType.Transmitter, "Health");
        assertSetName(CharacterName.Shoretrooper, ModType.Receiver, "Health");
        assertSetName(CharacterName.GeneralKenobi, ModType.Processor, "Health");
        assertSetName(CharacterName.WedgeAntilles, ModType.HoloArray, "Health");
        assertSetName(CharacterName.CommanderLukeSkywalker, ModType.DataBus, "Health");
        assertSetName(CharacterName.GeneralKenobi, ModType.Multiplexer, "Health");
    }

    @Test
    void testDefenseSet() {
        assertSetName(CharacterName.GeneralVeers, ModType.Transmitter, "Defense");
        assertSetName(CharacterName.AskokaTano, ModType.Receiver, "Defense");
        assertSetName(CharacterName.KyloRen, ModType.Processor, "Defense");
        assertSetName(CharacterName.DarthSion, ModType.HoloArray, "Defense");
        assertSetName(CharacterName.AsajjVentress, ModType.DataBus, "Defense");
        assertSetName(CharacterName.GrandAdmiralThrawn, ModType.Multiplexer, "Defense");
    }

    @Test
    void testCriticalDamageSet() {
        assertSetName(CharacterName.DarthMaul, ModType.Transmitter, "Critical Damage");
        assertSetName(CharacterName.GrandMoffTarkin, ModType.Receiver, "Critical Damage");
        assertSetName(CharacterName.BobaFett, ModType.Processor, "Critical Damage");
        assertSetName(CharacterName.DeathTrooper, ModType.HoloArray, "Critical Damage");
        assertSetName(CharacterName.PrincessLeia, ModType.DataBus, "Critical Damage");
        assertSetName(CharacterName.JynErso, ModType.Multiplexer, "Critical Damage");
    }

    @Test
    void testCriticalChanceSet() {
        assertSetName(CharacterName.DarthMaul, ModType.Receiver, "Critical Chance");
        assertSetName(CharacterName.BiggsDarklighter, ModType.HoloArray, "Critical Chance");
    }

    @Test
    void testTenacitySet() {
        assertSetName(CharacterName.ZamWesell, ModType.Processor, "Tenacity");
        assertSetName(CharacterName.Shoretrooper, ModType.HoloArray, "Tenacity");
        assertSetName(CharacterName.JynErso, ModType.DataBus, "Tenacity");
    }

    @Test
    void testOffenseSet() {
        assertSetName(CharacterName.OldDaka, ModType.HoloArray, "Offense");
        assertSetName(CharacterName.EwokElder, ModType.Multiplexer, "Offense");
    }

    @Test
    void testPotencySet() {
        assertSetName(CharacterName.ResistancePilot, ModType.Transmitter, "Potency");
        assertSetName(CharacterName.BobaFett, ModType.Receiver, "Potency");
        assertSetName(CharacterName.JynErso, ModType.Processor, "Potency");
        assertSetName(CharacterName.GrandMoffTarkin, ModType.HoloArray, "Potency");
        assertSetName(CharacterName.AskokaTano, ModType.DataBus, "Potency");
        assertSetName(CharacterName.ResistanceTrooper, ModType.Multiplexer, "Potency");
    }

    @Test
    void testSpeedSet() {
        assertSetName(CharacterName.GrandAdmiralThrawn, ModType.Transmitter, "Speed");
        assertSetName(CharacterName.CommanderLukeSkywalker, ModType.Receiver, "Speed");
        assertSetName(CharacterName.GeneralVeers, ModType.Processor, "Speed");
        assertSetName(CharacterName.GeneralKenobi, ModType.HoloArray, "Speed");
        assertSetName(CharacterName.K2SO, ModType.DataBus, "Speed");
        assertSetName(CharacterName.ZamWesell, ModType.Multiplexer, "Speed");
    }

    protected abstract void assertSetName(CharacterName toon, ModType modType, String expectedSetName);
}
