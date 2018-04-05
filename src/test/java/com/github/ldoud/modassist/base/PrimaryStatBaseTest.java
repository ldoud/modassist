package com.github.ldoud.modassist.base;

import com.github.ldoud.modassist.constants.CharacterName;
import com.github.ldoud.modassist.planning.ModType;
import com.github.ldoud.modassist.constants.Stat;
import org.junit.jupiter.api.Test;

public abstract class PrimaryStatBaseTest {

    @Test
    void testCriticalChance() {
        assertPrimaryStat(CharacterName.JynErso, ModType.HoloArray, Stat.CriticalChance, "12");
        assertPrimaryStat(CharacterName.GrandMasterYoda, ModType.HoloArray, Stat.CriticalChance, "9.75");
    }

    @Test
    void testCriticalDamage() {
        assertPrimaryStat(CharacterName.Magmatrooper, ModType.HoloArray, Stat.CriticalDamage, "36");
        assertPrimaryStat(CharacterName.PrincessLeia, ModType.HoloArray, Stat.CriticalDamage, "31.5");
    }

    @Test
    void testPotency() {
        assertPrimaryStat(CharacterName.BobaFett, ModType.Multiplexer, Stat.Potency, "24");
        assertPrimaryStat(CharacterName.RoyalGuard, ModType.Multiplexer, Stat.Potency, "19.5");
    }

    @Test
    void testTenacity() {
        assertPrimaryStat(CharacterName.WedgeAntilles, ModType.Multiplexer, Stat.Tenacity, "24");
        assertPrimaryStat(CharacterName.SithAssassin, ModType.Multiplexer, Stat.Tenacity, "19.5");
    }

    @Test
    void testAccuracy() {
        assertPrimaryStat(CharacterName.ResistancePilot, ModType.Receiver, Stat.Accuracy, "12");
        assertPrimaryStat(CharacterName.OldDaka, ModType.Receiver, Stat.Accuracy, "7.5");
    }

    @Test
    void testCriticalAvoidance() {
        assertPrimaryStat(CharacterName.AskokaTano, ModType.Receiver, Stat.CriticalAvoidance, "24");
        assertPrimaryStat(CharacterName.CloneWarsChewbacca, ModType.Receiver, Stat.CriticalAvoidance, "15");
    }

    @Test
    void testOffense() {
        assertPrimaryStat(CharacterName.CommanderLukeSkywalker, ModType.Transmitter, Stat.OffensePercent, "5.88");
        assertPrimaryStat(CharacterName.SithAssassin, ModType.Receiver, Stat.OffensePercent, "4.75");
    }

    @Test
    void testDefense() {
        assertPrimaryStat(CharacterName.GeneralKenobi, ModType.Processor, Stat.DefensePercent, "11.75");
        assertPrimaryStat(CharacterName.K2SO, ModType.Processor, Stat.DefensePercent, "9.5");
    }

    @Test
    void testHealth() {
        assertPrimaryStat(CharacterName.CommanderLukeSkywalker, ModType.DataBus, Stat.HealthPercent, "5.88");
        assertPrimaryStat(CharacterName.BobaFett, ModType.HoloArray, Stat.HealthPercent, "5.88");
        assertPrimaryStat(CharacterName.DeathTrooper, ModType.Receiver, Stat.HealthPercent, "5.88");
    }

    @Test
    void testProtection() {
        assertPrimaryStat(CharacterName.EmperorPalpatine, ModType.HoloArray, Stat.ProtectionPercent, "23.5");
        assertPrimaryStat(CharacterName.FirstOrderTIEPilot, ModType.DataBus, Stat.ProtectionPercent, "23.5");
        assertPrimaryStat(CharacterName.GrandAdmiralThrawn, ModType.Multiplexer, Stat.ProtectionPercent, "23.5");
        assertPrimaryStat(CharacterName.RoyalGuard, ModType.DataBus, Stat.ProtectionPercent, "19");
    }

    protected abstract void assertPrimaryStat(CharacterName toon, ModType modType, Stat primaryStat, String expectedStatValue);
}
