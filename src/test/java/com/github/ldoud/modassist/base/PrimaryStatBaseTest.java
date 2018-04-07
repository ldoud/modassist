package com.github.ldoud.modassist.base;

import com.github.ldoud.modassist.constants.CharacterName;
import com.github.ldoud.modassist.data.ModType;
import com.github.ldoud.modassist.data.Stat;
import com.github.ldoud.modassist.data.StatName;
import org.junit.jupiter.api.Test;

public abstract class PrimaryStatBaseTest {

    @Test
    void testCriticalChance() {
        assertPrimaryStat(CharacterName.JynErso, ModType.HoloArray, StatName.CriticalChance, "12");
        assertPrimaryStat(CharacterName.GrandMasterYoda, ModType.HoloArray, StatName.CriticalChance, "9.75");
    }

    @Test
    void testCriticalDamage() {
        assertPrimaryStat(CharacterName.Magmatrooper, ModType.HoloArray, StatName.CriticalDamage, "36");
        assertPrimaryStat(CharacterName.PrincessLeia, ModType.HoloArray, StatName.CriticalDamage, "31.5");
    }

    @Test
    void testPotency() {
        assertPrimaryStat(CharacterName.BobaFett, ModType.Multiplexer, StatName.Potency, "24");
        assertPrimaryStat(CharacterName.RoyalGuard, ModType.Multiplexer, StatName.Potency, "19.5");
    }

    @Test
    void testTenacity() {
        assertPrimaryStat(CharacterName.WedgeAntilles, ModType.Multiplexer, StatName.Tenacity, "24");
        assertPrimaryStat(CharacterName.SithAssassin, ModType.Multiplexer, StatName.Tenacity, "19.5");
    }

    @Test
    void testAccuracy() {
        assertPrimaryStat(CharacterName.ResistancePilot, ModType.Receiver, StatName.Accuracy, "12");
        assertPrimaryStat(CharacterName.OldDaka, ModType.Receiver, StatName.Accuracy, "7.5");
    }

    @Test
    void testCriticalAvoidance() {
        assertPrimaryStat(CharacterName.AskokaTano, ModType.Receiver, StatName.CriticalAvoidance, "24");
        assertPrimaryStat(CharacterName.CloneWarsChewbacca, ModType.Receiver, StatName.CriticalAvoidance, "15");
    }

    @Test
    void testOffense() {
        assertPrimaryStat(CharacterName.CommanderLukeSkywalker, ModType.Transmitter, StatName.OffensePercent, "5.88");
        assertPrimaryStat(CharacterName.SithAssassin, ModType.Receiver, StatName.OffensePercent, "4.75");
    }

    @Test
    void testDefense() {
        assertPrimaryStat(CharacterName.GeneralKenobi, ModType.Processor, StatName.DefensePercent, "11.75");
        assertPrimaryStat(CharacterName.K2SO, ModType.Processor, StatName.DefensePercent, "9.5");
    }

    @Test
    void testHealth() {
        assertPrimaryStat(CharacterName.CommanderLukeSkywalker, ModType.DataBus, StatName.HealthPercent, "5.88");
        assertPrimaryStat(CharacterName.BobaFett, ModType.HoloArray, StatName.HealthPercent, "5.88");
        assertPrimaryStat(CharacterName.DeathTrooper, ModType.Receiver, StatName.HealthPercent, "5.88");
    }

    @Test
    void testProtection() {
        assertPrimaryStat(CharacterName.EmperorPalpatine, ModType.HoloArray, StatName.ProtectionPercent, "23.5");
        assertPrimaryStat(CharacterName.FirstOrderTIEPilot, ModType.DataBus, StatName.ProtectionPercent, "23.5");
        assertPrimaryStat(CharacterName.GrandAdmiralThrawn, ModType.Multiplexer, StatName.ProtectionPercent, "23.5");
        assertPrimaryStat(CharacterName.RoyalGuard, ModType.DataBus, StatName.ProtectionPercent, "19");
    }

    protected abstract void assertPrimaryStat(CharacterName toon, ModType modType, StatName primaryStat, String expectedStatValue);
}
