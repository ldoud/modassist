package com.github.ldoud.modassist.base;

import com.github.ldoud.modassist.constants.CharacterName;
import com.github.ldoud.modassist.data.ModStat;
import com.github.ldoud.modassist.data.ModType;
import org.junit.jupiter.api.Test;

public abstract class SecondaryStatsBaseTest {

    @Test
    void testSpeed() {
        assertSecondaryStat(CharacterName.AskokaTano, ModType.Transmitter, ModStat.Speed, "4");
        assertSecondaryStat(CharacterName.HothRebelScout, ModType.Transmitter, ModStat.Speed, "5");
        assertSecondaryStat(CharacterName.BiggsDarklighter, ModType.Transmitter, ModStat.Speed, "9");
    }

    @Test
    void testOffenseFlatAmount() {
        assertSecondaryStat(CharacterName.AskokaTano, ModType.Transmitter, ModStat.Offense, "24");
        assertSecondaryStat(CharacterName.GrandMoffTarkin, ModType.Transmitter, ModStat.Offense, "97");
        assertSecondaryStat(CharacterName.CaptainHanSolo, ModType.Transmitter, ModStat.Offense, "29");

        // Has both percent and flat amount.
        assertSecondaryStat(CharacterName.CommanderLukeSkywalker, ModType.HoloArray, ModStat.Offense, "119");
        assertSecondaryStat(CharacterName.FirstOrderTIEPilot, ModType.Multiplexer, ModStat.Offense, "115");
    }

    @Test
    void testOffensePercent() {
        // Has both percent and flat amount.
        assertSecondaryStat(CharacterName.CommanderLukeSkywalker, ModType.HoloArray, ModStat.OffensePercent, "0.38");
        assertSecondaryStat(CharacterName.FirstOrderTIEPilot, ModType.Multiplexer, ModStat.OffensePercent, "0.37");
    }

    @Test
    void testCriticalChance() {
        assertSecondaryStat(CharacterName.JediConsular, ModType.Transmitter, ModStat.CriticalChance, "1.72");
        assertSecondaryStat(CharacterName.Shoretrooper, ModType.Transmitter, ModStat.CriticalChance, "1.72");
        assertSecondaryStat(CharacterName.Magmatrooper, ModType.Transmitter, ModStat.CriticalChance, "4.98");
    }

    @Test
    void testDefenseFlatAmount() {
        assertSecondaryStat(CharacterName.AskokaTano, ModType.Transmitter, ModStat.Defense, "5");
        assertSecondaryStat(CharacterName.WedgeAntilles, ModType.Transmitter, ModStat.Defense, "8");
        assertSecondaryStat(CharacterName.ResistanceTrooper, ModType.Transmitter, ModStat.Defense, "14");
    }

    @Test
    void testDefensePercent() {
        assertSecondaryStat(CharacterName.ResistancePilot, ModType.Transmitter, ModStat.DefensePercent, "1.55");
        assertSecondaryStat(CharacterName.BiggsDarklighter, ModType.Transmitter, ModStat.DefensePercent, "4.06");
        assertSecondaryStat(CharacterName.PrincessLeia, ModType.Transmitter, ModStat.DefensePercent, "0.99");
    }

    @Test
    void testPotency() {
        assertSecondaryStat(CharacterName.CadBane, ModType.Transmitter, ModStat.Potency, "1.25");
        assertSecondaryStat(CharacterName.BobaFett, ModType.Transmitter, ModStat.Potency, "1.46");
        assertSecondaryStat(CharacterName.DarthSion, ModType.Transmitter, ModStat.Potency, "2.24");
    }

    @Test
    void testHealthFlatAmount() {
        assertSecondaryStat(CharacterName.DarthMaul, ModType.Transmitter, ModStat.Health, "232");
        assertSecondaryStat(CharacterName.CadBane, ModType.Transmitter, ModStat.Health, "609");
        assertSecondaryStat(CharacterName.FirstOrderTIEPilot, ModType.Transmitter, ModStat.Health, "223");
        assertSecondaryStat(CharacterName.GrandMoffTarkin, ModType.Transmitter, ModStat.Health, "310");
    }

    @Test
    void testHealthPercent() {
        assertSecondaryStat(CharacterName.DarthMaul, ModType.Transmitter, ModStat.HealthPercent, "0.94");
        assertSecondaryStat(CharacterName.ResistancePilot, ModType.Transmitter, ModStat.HealthPercent, "0.59");
        assertSecondaryStat(CharacterName.EmperorPalpatine, ModType.Transmitter, ModStat.HealthPercent, "0.87");
    }

    @Test
    void testTenacity() {
        assertSecondaryStat(CharacterName.PrincessLeia, ModType.Transmitter, ModStat.Tenacity, "2.64");
        assertSecondaryStat(CharacterName.JynErso, ModType.Transmitter, ModStat.Tenacity, "1.26");
        assertSecondaryStat(CharacterName.SabineWren, ModType.Transmitter, ModStat.Tenacity, "2.53");
    }

    @Test
    void testProtectionFlatAmount() {
        assertSecondaryStat(CharacterName.RoyalGuard, ModType.DataBus, ModStat.Protection, "3737");
        assertSecondaryStat(CharacterName.PrincessLeia, ModType.Multiplexer, ModStat.Protection, "1531");
        assertSecondaryStat(CharacterName.Shoretrooper, ModType.Transmitter, ModStat.Protection, "1658");
    }

    @Test
    void testProtectionPercent() {
        assertSecondaryStat(CharacterName.DarthSion, ModType.Processor, ModStat.ProtectionPercent, "1.33");
        assertSecondaryStat(CharacterName.GeneralVeers, ModType.HoloArray, ModStat.ProtectionPercent, "3.19");
        assertSecondaryStat(CharacterName.SabineWren, ModType.Processor, ModStat.ProtectionPercent, "1.24");
    }

    protected abstract void assertSecondaryStat(CharacterName toon, ModType modType, ModStat secondaryModStat, String expectedStatValue);
}
