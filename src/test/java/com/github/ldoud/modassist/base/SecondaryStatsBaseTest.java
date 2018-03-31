package com.github.ldoud.modassist.base;

import com.github.ldoud.modassist.constants.Character;
import com.github.ldoud.modassist.constants.ModType;
import com.github.ldoud.modassist.constants.Stat;
import org.junit.jupiter.api.Test;

public abstract class SecondaryStatsBaseTest {

    @Test
    void testSpeed() {
        assertSecondaryStat(Character.AskokaTano, ModType.Transmitter, Stat.Speed, "4");
        assertSecondaryStat(Character.HothRebelScout, ModType.Transmitter, Stat.Speed, "5");
        assertSecondaryStat(Character.BiggsDarklighter, ModType.Transmitter, Stat.Speed, "9");
    }

    @Test
    void testOffenseFlatAmount() {
        assertSecondaryStat(Character.AskokaTano, ModType.Transmitter, Stat.Offense, "24");
        assertSecondaryStat(Character.GrandMoffTarkin, ModType.Transmitter, Stat.Offense, "97");
        assertSecondaryStat(Character.CaptainHanSolo, ModType.Transmitter, Stat.Offense, "29");

        // Has both percent and flat amount.
        assertSecondaryStat(Character.CommanderLukeSkywalker, ModType.HoloArray, Stat.Offense, "119");
        assertSecondaryStat(Character.FirstOrderTIEPilot, ModType.Multiplexer, Stat.Offense, "115");
    }

    @Test
    void testOffensePercent() {
        // Has both percent and flat amount.
        assertSecondaryStat(Character.CommanderLukeSkywalker, ModType.HoloArray, Stat.OffensePercent, "0.38");
        assertSecondaryStat(Character.FirstOrderTIEPilot, ModType.Multiplexer, Stat.OffensePercent, "0.37");
    }

    @Test
    void testCriticalChance() {
        assertSecondaryStat(Character.JediConsular, ModType.Transmitter, Stat.CriticalChance, "1.72");
        assertSecondaryStat(Character.Shoretrooper, ModType.Transmitter, Stat.CriticalChance, "1.72");
        assertSecondaryStat(Character.Magmatrooper, ModType.Transmitter, Stat.CriticalChance, "4.98");
    }

    @Test
    void testDefenseFlatAmount() {
        assertSecondaryStat(Character.AskokaTano, ModType.Transmitter, Stat.Defense, "5");
        assertSecondaryStat(Character.WedgeAntilles, ModType.Transmitter, Stat.Defense, "8");
        assertSecondaryStat(Character.ResistanceTrooper, ModType.Transmitter, Stat.Defense, "14");
    }

    @Test
    void testDefensePercent() {
        assertSecondaryStat(Character.ResistancePilot, ModType.Transmitter, Stat.DefensePercent, "1.55");
        assertSecondaryStat(Character.BiggsDarklighter, ModType.Transmitter, Stat.DefensePercent, "4.06");
        assertSecondaryStat(Character.PrincessLeia, ModType.Transmitter, Stat.DefensePercent, "0.99");
    }

    @Test
    void testPotency() {
        assertSecondaryStat(Character.CadBane, ModType.Transmitter, Stat.Potency, "1.25");
        assertSecondaryStat(Character.BobaFett, ModType.Transmitter, Stat.Potency, "1.46");
        assertSecondaryStat(Character.DarthSion, ModType.Transmitter, Stat.Potency, "2.24");
    }

    @Test
    void testHealthFlatAmount() {
        assertSecondaryStat(Character.DarthMaul, ModType.Transmitter, Stat.Health, "232");
        assertSecondaryStat(Character.CadBane, ModType.Transmitter, Stat.Health, "609");
        assertSecondaryStat(Character.FirstOrderTIEPilot, ModType.Transmitter, Stat.Health, "223");
        assertSecondaryStat(Character.GrandMoffTarkin, ModType.Transmitter, Stat.Health, "310");
    }

    @Test
    void testHealthPercent() {
        assertSecondaryStat(Character.DarthMaul, ModType.Transmitter, Stat.HealthPercent, "0.94");
        assertSecondaryStat(Character.ResistancePilot, ModType.Transmitter, Stat.HealthPercent, "0.59");
        assertSecondaryStat(Character.EmperorPalpatine, ModType.Transmitter, Stat.HealthPercent, "0.87");
    }

    @Test
    void testTenacity() {
        assertSecondaryStat(Character.PrincessLeia, ModType.Transmitter, Stat.Tenacity, "2.64");
        assertSecondaryStat(Character.JynErso, ModType.Transmitter, Stat.Tenacity, "1.26");
        assertSecondaryStat(Character.SabineWren, ModType.Transmitter, Stat.Tenacity, "2.53");
    }

    @Test
    void testProtectionFlatAmount() {
        assertSecondaryStat(Character.RoyalGuard, ModType.DataBus, Stat.Protection, "3737");
        assertSecondaryStat(Character.PrincessLeia, ModType.Multiplexer, Stat.Protection, "1531");
        assertSecondaryStat(Character.Shoretrooper, ModType.Transmitter, Stat.Protection, "1658");
    }

    @Test
    void testProtectionPercent() {
        assertSecondaryStat(Character.DarthSion, ModType.Processor, Stat.ProtectionPercent, "1.33");
        assertSecondaryStat(Character.GeneralVeers, ModType.HoloArray, Stat.ProtectionPercent, "3.19");
        assertSecondaryStat(Character.SabineWren, ModType.Processor, Stat.ProtectionPercent, "1.24");
    }

    protected abstract void assertSecondaryStat(Character toon, ModType modType, Stat secondaryStat, String expectedStatValue);
}
