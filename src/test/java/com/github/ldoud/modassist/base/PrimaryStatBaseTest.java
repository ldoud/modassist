package com.github.ldoud.modassist.base;

import com.github.ldoud.modassist.constants.Character;
import com.github.ldoud.modassist.constants.ModType;
import com.github.ldoud.modassist.constants.Stat;
import org.junit.jupiter.api.Test;

public abstract class PrimaryStatBaseTest {

    @Test
    void testCriticalChance() {
        assertPrimaryStat(Character.JynErso, ModType.HoloArray, Stat.CriticalChance, "12");
        assertPrimaryStat(Character.GrandMasterYoda, ModType.HoloArray, Stat.CriticalChance, "9.75");
    }

    @Test
    void testCriticalDamage() {
        assertPrimaryStat(Character.Magmatrooper, ModType.HoloArray, Stat.CriticalDamage, "36");
        assertPrimaryStat(Character.PrincessLeia, ModType.HoloArray, Stat.CriticalDamage, "31.5");
    }

    @Test
    void testPotency() {
        assertPrimaryStat(Character.BobaFett, ModType.Multiplexer, Stat.Potency, "24");
        assertPrimaryStat(Character.RoyalGuard, ModType.Multiplexer, Stat.Potency, "19.5");
    }

    @Test
    void testTenacity() {
        assertPrimaryStat(Character.WedgeAntilles, ModType.Multiplexer, Stat.Tenacity, "24");
        assertPrimaryStat(Character.SithAssassin, ModType.Multiplexer, Stat.Tenacity, "19.5");
    }

    @Test
    void testAccuracy() {
        assertPrimaryStat(Character.ResistancePilot, ModType.Receiver, Stat.Accuracy, "12");
        assertPrimaryStat(Character.OldDaka, ModType.Receiver, Stat.Accuracy, "7.5");
    }

    @Test
    void testCriticalAvoidance() {
        assertPrimaryStat(Character.AskokaTano, ModType.Receiver, Stat.CriticalAvoidance, "24");
        assertPrimaryStat(Character.CloneWarsChewbacca, ModType.Receiver, Stat.CriticalAvoidance, "15");
    }

    @Test
    void testOffense() {
        assertPrimaryStat(Character.CommanderLukeSkywalker, ModType.Transmitter, Stat.OffensePercent, "5.88");
        assertPrimaryStat(Character.SithAssassin, ModType.Receiver, Stat.OffensePercent, "4.75");
    }

    @Test
    void testDefense() {
        assertPrimaryStat(Character.GeneralKenobi, ModType.Processor, Stat.DefensePercent, "11.75");
        assertPrimaryStat(Character.K2SO, ModType.Processor, Stat.DefensePercent, "9.5");
    }

    @Test
    void testHealth() {
        assertPrimaryStat(Character.CommanderLukeSkywalker, ModType.DataBus, Stat.HealthPercent, "5.88");
        assertPrimaryStat(Character.BobaFett, ModType.HoloArray, Stat.HealthPercent, "5.88");
        assertPrimaryStat(Character.DeathTrooper, ModType.Receiver, Stat.HealthPercent, "5.88");
    }

    @Test
    void testProtection() {
        assertPrimaryStat(Character.EmperorPalpatine, ModType.HoloArray, Stat.ProtectionPercent, "23.5");
        assertPrimaryStat(Character.FirstOrderTIEPilot, ModType.DataBus, Stat.ProtectionPercent, "23.5");
        assertPrimaryStat(Character.GrandAdmiralThrawn, ModType.Multiplexer, Stat.ProtectionPercent, "23.5");
        assertPrimaryStat(Character.RoyalGuard, ModType.DataBus, Stat.ProtectionPercent, "19");
    }

    protected abstract void assertPrimaryStat(Character toon, ModType modType, Stat primaryStat, String expectedStatValue);
}
