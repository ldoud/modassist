package com.github.ldoud.modassist.base;

import com.github.ldoud.modassist.constants.CharacterName;
import com.github.ldoud.modassist.data.StatName;
import com.github.ldoud.modassist.data.ModType;
import org.junit.jupiter.api.Test;

public abstract class SecondaryStatsBaseTest {

    @Test
    void testSpeed() {
        assertSecondaryStat(CharacterName.AskokaTano, ModType.Transmitter, StatName.Speed, "4");
        assertSecondaryStat(CharacterName.HothRebelScout, ModType.Transmitter, StatName.Speed, "5");
        assertSecondaryStat(CharacterName.BiggsDarklighter, ModType.Transmitter, StatName.Speed, "9");
    }

    @Test
    void testOffenseFlatAmount() {
        assertSecondaryStat(CharacterName.AskokaTano, ModType.Transmitter, StatName.Offense, "24");
        assertSecondaryStat(CharacterName.GrandMoffTarkin, ModType.Transmitter, StatName.Offense, "97");
        assertSecondaryStat(CharacterName.CaptainHanSolo, ModType.Transmitter, StatName.Offense, "29");

        // Has both percent and flat amount.
        assertSecondaryStat(CharacterName.CommanderLukeSkywalker, ModType.HoloArray, StatName.Offense, "119");
        assertSecondaryStat(CharacterName.FirstOrderTIEPilot, ModType.Multiplexer, StatName.Offense, "115");
    }

    @Test
    void testOffensePercent() {
        // Has both percent and flat amount.
        assertSecondaryStat(CharacterName.CommanderLukeSkywalker, ModType.HoloArray, StatName.OffensePercent, "0.38");
        assertSecondaryStat(CharacterName.FirstOrderTIEPilot, ModType.Multiplexer, StatName.OffensePercent, "0.37");
    }

    @Test
    void testCriticalChance() {
        assertSecondaryStat(CharacterName.JediConsular, ModType.Transmitter, StatName.CriticalChance, "1.72");
        assertSecondaryStat(CharacterName.Shoretrooper, ModType.Transmitter, StatName.CriticalChance, "1.72");
        assertSecondaryStat(CharacterName.Magmatrooper, ModType.Transmitter, StatName.CriticalChance, "4.98");
    }

    @Test
    void testDefenseFlatAmount() {
        assertSecondaryStat(CharacterName.AskokaTano, ModType.Transmitter, StatName.Defense, "5");
        assertSecondaryStat(CharacterName.WedgeAntilles, ModType.Transmitter, StatName.Defense, "8");
        assertSecondaryStat(CharacterName.ResistanceTrooper, ModType.Transmitter, StatName.Defense, "14");
    }

    @Test
    void testDefensePercent() {
        assertSecondaryStat(CharacterName.ResistancePilot, ModType.Transmitter, StatName.DefensePercent, "1.55");
        assertSecondaryStat(CharacterName.BiggsDarklighter, ModType.Transmitter, StatName.DefensePercent, "4.06");
        assertSecondaryStat(CharacterName.PrincessLeia, ModType.Transmitter, StatName.DefensePercent, "0.99");
    }

    @Test
    void testPotency() {
        assertSecondaryStat(CharacterName.CadBane, ModType.Transmitter, StatName.Potency, "1.25");
        assertSecondaryStat(CharacterName.BobaFett, ModType.Transmitter, StatName.Potency, "1.46");
        assertSecondaryStat(CharacterName.DarthSion, ModType.Transmitter, StatName.Potency, "2.24");
    }

    @Test
    void testHealthFlatAmount() {
        assertSecondaryStat(CharacterName.DarthMaul, ModType.Transmitter, StatName.Health, "232");
        assertSecondaryStat(CharacterName.CadBane, ModType.Transmitter, StatName.Health, "609");
        assertSecondaryStat(CharacterName.FirstOrderTIEPilot, ModType.Transmitter, StatName.Health, "223");
        assertSecondaryStat(CharacterName.GrandMoffTarkin, ModType.Transmitter, StatName.Health, "310");
    }

    @Test
    void testHealthPercent() {
        assertSecondaryStat(CharacterName.DarthMaul, ModType.Transmitter, StatName.HealthPercent, "0.94");
        assertSecondaryStat(CharacterName.ResistancePilot, ModType.Transmitter, StatName.HealthPercent, "0.59");
        assertSecondaryStat(CharacterName.EmperorPalpatine, ModType.Transmitter, StatName.HealthPercent, "0.87");
    }

    @Test
    void testTenacity() {
        assertSecondaryStat(CharacterName.PrincessLeia, ModType.Transmitter, StatName.Tenacity, "2.64");
        assertSecondaryStat(CharacterName.JynErso, ModType.Transmitter, StatName.Tenacity, "1.26");
        assertSecondaryStat(CharacterName.SabineWren, ModType.Transmitter, StatName.Tenacity, "2.53");
    }

    @Test
    void testProtectionFlatAmount() {
        assertSecondaryStat(CharacterName.RoyalGuard, ModType.DataBus, StatName.Protection, "3737");
        assertSecondaryStat(CharacterName.PrincessLeia, ModType.Multiplexer, StatName.Protection, "1531");
        assertSecondaryStat(CharacterName.Shoretrooper, ModType.Transmitter, StatName.Protection, "1658");
    }

    @Test
    void testProtectionPercent() {
        assertSecondaryStat(CharacterName.DarthSion, ModType.Processor, StatName.ProtectionPercent, "1.33");
        assertSecondaryStat(CharacterName.GeneralVeers, ModType.HoloArray, StatName.ProtectionPercent, "3.19");
        assertSecondaryStat(CharacterName.SabineWren, ModType.Processor, StatName.ProtectionPercent, "1.24");
    }

    protected abstract void assertSecondaryStat(CharacterName toon, ModType modType, StatName secondaryStatName, String expectedStatValue);
}
