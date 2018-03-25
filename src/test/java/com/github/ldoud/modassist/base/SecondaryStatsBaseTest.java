package com.github.ldoud.modassist.base;

import com.github.ldoud.modassist.constants.Character;
import com.github.ldoud.modassist.constants.Mod;
import com.github.ldoud.modassist.constants.Stat;
import com.github.ldoud.modassist.swgoh.TestXmlData;
import org.dom4j.Node;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

public abstract class SecondaryStatsBaseTest {

    @Test
    void testSpeed() {
        assertSecondaryStat(Character.AskokaTano, Mod.Transmitter, Stat.Speed, "4");
        assertSecondaryStat(Character.HothRebelScout, Mod.Transmitter, Stat.Speed, "5");
        assertSecondaryStat(Character.BiggsDarklighter, Mod.Transmitter, Stat.Speed, "9");
    }

    @Test
    void testOffenseFlatAmount() {
        assertSecondaryStat(Character.AskokaTano, Mod.Transmitter, Stat.Offense, "24");
        assertSecondaryStat(Character.GrandMoffTarkin, Mod.Transmitter, Stat.Offense, "97");
        assertSecondaryStat(Character.CaptainHanSolo, Mod.Transmitter, Stat.Offense, "29");

        // Has both percent and flat amount.
        assertSecondaryStat(Character.CommanderLukeSkywalker, Mod.HoloArray, Stat.Offense, "119");
        assertSecondaryStat(Character.FirstOrderTIEPilot, Mod.Multiplexer, Stat.Offense, "115");
    }

    @Test
    void testOffensePercent() {
        // Has both percent and flat amount.
        assertSecondaryStat(Character.CommanderLukeSkywalker, Mod.HoloArray, Stat.OffensePercent, "0.38");
        assertSecondaryStat(Character.FirstOrderTIEPilot, Mod.Multiplexer, Stat.OffensePercent, "0.37");
    }

    @Test
    void testCriticalChance() {
        assertSecondaryStat(Character.JediConsular, Mod.Transmitter, Stat.CriticalChance, "1.72");
        assertSecondaryStat(Character.Shoretrooper, Mod.Transmitter, Stat.CriticalChance, "1.72");
        assertSecondaryStat(Character.Magmatrooper, Mod.Transmitter, Stat.CriticalChance, "4.98");
    }

    @Test
    void testDefenseFlatAmount() {
        assertSecondaryStat(Character.AskokaTano, Mod.Transmitter, Stat.Defense, "5");
        assertSecondaryStat(Character.WedgeAntilles, Mod.Transmitter, Stat.Defense, "8");
        assertSecondaryStat(Character.ResistanceTrooper, Mod.Transmitter, Stat.Defense, "14");
    }

    @Test
    void testDefensePercent() {
        assertSecondaryStat(Character.ResistancePilot, Mod.Transmitter, Stat.DefensePercent, "1.55");
        assertSecondaryStat(Character.BiggsDarklighter, Mod.Transmitter, Stat.DefensePercent, "4.06");
        assertSecondaryStat(Character.PrincessLeia, Mod.Transmitter, Stat.DefensePercent, "0.99");
    }

    @Test
    void testPotency() {
        assertSecondaryStat(Character.CadBane, Mod.Transmitter, Stat.Potency, "1.25");
        assertSecondaryStat(Character.BobaFett, Mod.Transmitter, Stat.Potency, "1.46");
        assertSecondaryStat(Character.DarthSion, Mod.Transmitter, Stat.Potency, "2.24");
    }

    @Test
    void testHealthFlatAmount() {
        assertSecondaryStat(Character.DarthMaul, Mod.Transmitter, Stat.Health, "232");
        assertSecondaryStat(Character.CadBane, Mod.Transmitter, Stat.Health, "609");
        assertSecondaryStat(Character.FirstOrderTIEPilot, Mod.Transmitter, Stat.Health, "223");
        assertSecondaryStat(Character.GrandMoffTarkin, Mod.Transmitter, Stat.Health, "310");
    }

    @Test
    void testHealthPercent() {
        assertSecondaryStat(Character.DarthMaul, Mod.Transmitter, Stat.HealthPercent, "0.94");
        assertSecondaryStat(Character.ResistancePilot, Mod.Transmitter, Stat.HealthPercent, "0.59");
        assertSecondaryStat(Character.EmperorPalpatine, Mod.Transmitter, Stat.HealthPercent, "0.87");
    }

    @Test
    void testTenacity() {
        assertSecondaryStat(Character.PrincessLeia, Mod.Transmitter, Stat.Tenacity, "2.64");
        assertSecondaryStat(Character.JynErso, Mod.Transmitter, Stat.Tenacity, "1.26");
        assertSecondaryStat(Character.SabineWren, Mod.Transmitter, Stat.Tenacity, "2.53");
    }

    @Test
    void testProtectionFlatAmount() {
        assertSecondaryStat(Character.RoyalGuard, Mod.DataBus, Stat.Protection, "3737");
        assertSecondaryStat(Character.PrincessLeia, Mod.Multiplexer, Stat.Protection, "1531");
        assertSecondaryStat(Character.Shoretrooper, Mod.Transmitter, Stat.Protection, "1658");
    }

    @Test
    void testProtectionPercent() {
        assertSecondaryStat(Character.DarthSion, Mod.Processor, Stat.ProtectionPercent, "1.33");
        assertSecondaryStat(Character.GeneralVeers, Mod.HoloArray, Stat.ProtectionPercent, "3.19");
        assertSecondaryStat(Character.SabineWren, Mod.Processor, Stat.ProtectionPercent, "1.24");
    }

    protected abstract void assertSecondaryStat(Character toon, Mod mod, Stat secondaryStat, String expectedStatValue);
}
