package com.github.ldoud.modassist.base;

import com.github.ldoud.modassist.constants.CharacterName;
import com.github.ldoud.modassist.planning.ModType;
import com.github.ldoud.modassist.constants.Stat;
import org.junit.jupiter.api.Test;

public abstract class SecondaryStatsBaseTest {

    @Test
    void testSpeed() {
        assertSecondaryStat(CharacterName.AskokaTano, ModType.Transmitter, Stat.Speed, "4");
        assertSecondaryStat(CharacterName.HothRebelScout, ModType.Transmitter, Stat.Speed, "5");
        assertSecondaryStat(CharacterName.BiggsDarklighter, ModType.Transmitter, Stat.Speed, "9");
    }

    @Test
    void testOffenseFlatAmount() {
        assertSecondaryStat(CharacterName.AskokaTano, ModType.Transmitter, Stat.Offense, "24");
        assertSecondaryStat(CharacterName.GrandMoffTarkin, ModType.Transmitter, Stat.Offense, "97");
        assertSecondaryStat(CharacterName.CaptainHanSolo, ModType.Transmitter, Stat.Offense, "29");

        // Has both percent and flat amount.
        assertSecondaryStat(CharacterName.CommanderLukeSkywalker, ModType.HoloArray, Stat.Offense, "119");
        assertSecondaryStat(CharacterName.FirstOrderTIEPilot, ModType.Multiplexer, Stat.Offense, "115");
    }

    @Test
    void testOffensePercent() {
        // Has both percent and flat amount.
        assertSecondaryStat(CharacterName.CommanderLukeSkywalker, ModType.HoloArray, Stat.OffensePercent, "0.38");
        assertSecondaryStat(CharacterName.FirstOrderTIEPilot, ModType.Multiplexer, Stat.OffensePercent, "0.37");
    }

    @Test
    void testCriticalChance() {
        assertSecondaryStat(CharacterName.JediConsular, ModType.Transmitter, Stat.CriticalChance, "1.72");
        assertSecondaryStat(CharacterName.Shoretrooper, ModType.Transmitter, Stat.CriticalChance, "1.72");
        assertSecondaryStat(CharacterName.Magmatrooper, ModType.Transmitter, Stat.CriticalChance, "4.98");
    }

    @Test
    void testDefenseFlatAmount() {
        assertSecondaryStat(CharacterName.AskokaTano, ModType.Transmitter, Stat.Defense, "5");
        assertSecondaryStat(CharacterName.WedgeAntilles, ModType.Transmitter, Stat.Defense, "8");
        assertSecondaryStat(CharacterName.ResistanceTrooper, ModType.Transmitter, Stat.Defense, "14");
    }

    @Test
    void testDefensePercent() {
        assertSecondaryStat(CharacterName.ResistancePilot, ModType.Transmitter, Stat.DefensePercent, "1.55");
        assertSecondaryStat(CharacterName.BiggsDarklighter, ModType.Transmitter, Stat.DefensePercent, "4.06");
        assertSecondaryStat(CharacterName.PrincessLeia, ModType.Transmitter, Stat.DefensePercent, "0.99");
    }

    @Test
    void testPotency() {
        assertSecondaryStat(CharacterName.CadBane, ModType.Transmitter, Stat.Potency, "1.25");
        assertSecondaryStat(CharacterName.BobaFett, ModType.Transmitter, Stat.Potency, "1.46");
        assertSecondaryStat(CharacterName.DarthSion, ModType.Transmitter, Stat.Potency, "2.24");
    }

    @Test
    void testHealthFlatAmount() {
        assertSecondaryStat(CharacterName.DarthMaul, ModType.Transmitter, Stat.Health, "232");
        assertSecondaryStat(CharacterName.CadBane, ModType.Transmitter, Stat.Health, "609");
        assertSecondaryStat(CharacterName.FirstOrderTIEPilot, ModType.Transmitter, Stat.Health, "223");
        assertSecondaryStat(CharacterName.GrandMoffTarkin, ModType.Transmitter, Stat.Health, "310");
    }

    @Test
    void testHealthPercent() {
        assertSecondaryStat(CharacterName.DarthMaul, ModType.Transmitter, Stat.HealthPercent, "0.94");
        assertSecondaryStat(CharacterName.ResistancePilot, ModType.Transmitter, Stat.HealthPercent, "0.59");
        assertSecondaryStat(CharacterName.EmperorPalpatine, ModType.Transmitter, Stat.HealthPercent, "0.87");
    }

    @Test
    void testTenacity() {
        assertSecondaryStat(CharacterName.PrincessLeia, ModType.Transmitter, Stat.Tenacity, "2.64");
        assertSecondaryStat(CharacterName.JynErso, ModType.Transmitter, Stat.Tenacity, "1.26");
        assertSecondaryStat(CharacterName.SabineWren, ModType.Transmitter, Stat.Tenacity, "2.53");
    }

    @Test
    void testProtectionFlatAmount() {
        assertSecondaryStat(CharacterName.RoyalGuard, ModType.DataBus, Stat.Protection, "3737");
        assertSecondaryStat(CharacterName.PrincessLeia, ModType.Multiplexer, Stat.Protection, "1531");
        assertSecondaryStat(CharacterName.Shoretrooper, ModType.Transmitter, Stat.Protection, "1658");
    }

    @Test
    void testProtectionPercent() {
        assertSecondaryStat(CharacterName.DarthSion, ModType.Processor, Stat.ProtectionPercent, "1.33");
        assertSecondaryStat(CharacterName.GeneralVeers, ModType.HoloArray, Stat.ProtectionPercent, "3.19");
        assertSecondaryStat(CharacterName.SabineWren, ModType.Processor, Stat.ProtectionPercent, "1.24");
    }

    protected abstract void assertSecondaryStat(CharacterName toon, ModType modType, Stat secondaryStat, String expectedStatValue);
}
