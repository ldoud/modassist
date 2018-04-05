package com.github.ldoud.modassist.base;

import com.github.ldoud.modassist.constants.CharacterName;
import com.github.ldoud.modassist.data.ModStat;
import com.github.ldoud.modassist.data.ModType;
import org.junit.jupiter.api.Test;

public abstract class PrimaryModStatBaseTest {

    @Test
    void testCriticalChance() {
        assertPrimaryStat(CharacterName.JynErso, ModType.HoloArray, ModStat.CriticalChance, "12");
        assertPrimaryStat(CharacterName.GrandMasterYoda, ModType.HoloArray, ModStat.CriticalChance, "9.75");
    }

    @Test
    void testCriticalDamage() {
        assertPrimaryStat(CharacterName.Magmatrooper, ModType.HoloArray, ModStat.CriticalDamage, "36");
        assertPrimaryStat(CharacterName.PrincessLeia, ModType.HoloArray, ModStat.CriticalDamage, "31.5");
    }

    @Test
    void testPotency() {
        assertPrimaryStat(CharacterName.BobaFett, ModType.Multiplexer, ModStat.Potency, "24");
        assertPrimaryStat(CharacterName.RoyalGuard, ModType.Multiplexer, ModStat.Potency, "19.5");
    }

    @Test
    void testTenacity() {
        assertPrimaryStat(CharacterName.WedgeAntilles, ModType.Multiplexer, ModStat.Tenacity, "24");
        assertPrimaryStat(CharacterName.SithAssassin, ModType.Multiplexer, ModStat.Tenacity, "19.5");
    }

    @Test
    void testAccuracy() {
        assertPrimaryStat(CharacterName.ResistancePilot, ModType.Receiver, ModStat.Accuracy, "12");
        assertPrimaryStat(CharacterName.OldDaka, ModType.Receiver, ModStat.Accuracy, "7.5");
    }

    @Test
    void testCriticalAvoidance() {
        assertPrimaryStat(CharacterName.AskokaTano, ModType.Receiver, ModStat.CriticalAvoidance, "24");
        assertPrimaryStat(CharacterName.CloneWarsChewbacca, ModType.Receiver, ModStat.CriticalAvoidance, "15");
    }

    @Test
    void testOffense() {
        assertPrimaryStat(CharacterName.CommanderLukeSkywalker, ModType.Transmitter, ModStat.OffensePercent, "5.88");
        assertPrimaryStat(CharacterName.SithAssassin, ModType.Receiver, ModStat.OffensePercent, "4.75");
    }

    @Test
    void testDefense() {
        assertPrimaryStat(CharacterName.GeneralKenobi, ModType.Processor, ModStat.DefensePercent, "11.75");
        assertPrimaryStat(CharacterName.K2SO, ModType.Processor, ModStat.DefensePercent, "9.5");
    }

    @Test
    void testHealth() {
        assertPrimaryStat(CharacterName.CommanderLukeSkywalker, ModType.DataBus, ModStat.HealthPercent, "5.88");
        assertPrimaryStat(CharacterName.BobaFett, ModType.HoloArray, ModStat.HealthPercent, "5.88");
        assertPrimaryStat(CharacterName.DeathTrooper, ModType.Receiver, ModStat.HealthPercent, "5.88");
    }

    @Test
    void testProtection() {
        assertPrimaryStat(CharacterName.EmperorPalpatine, ModType.HoloArray, ModStat.ProtectionPercent, "23.5");
        assertPrimaryStat(CharacterName.FirstOrderTIEPilot, ModType.DataBus, ModStat.ProtectionPercent, "23.5");
        assertPrimaryStat(CharacterName.GrandAdmiralThrawn, ModType.Multiplexer, ModStat.ProtectionPercent, "23.5");
        assertPrimaryStat(CharacterName.RoyalGuard, ModType.DataBus, ModStat.ProtectionPercent, "19");
    }

    protected abstract void assertPrimaryStat(CharacterName toon, ModType modType, ModStat primaryModStat, String expectedStatValue);
}
