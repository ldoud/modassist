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

public abstract class PrimaryStatBaseTest {

    @Test
    void testCriticalChance() {
        assertPrimaryStat(Character.JynErso, Mod.HoloArray, Stat.CriticalChance, "12");
        assertPrimaryStat(Character.GrandMasterYoda, Mod.HoloArray, Stat.CriticalChance, "9.75");
    }

    @Test
    void testCriticalDamage() {
        assertPrimaryStat(Character.Magmatrooper, Mod.HoloArray, Stat.CriticalDamage, "36");
        assertPrimaryStat(Character.PrincessLeia, Mod.HoloArray, Stat.CriticalDamage, "31.5");
    }

    @Test
    void testPotency() {
        assertPrimaryStat(Character.BobaFett, Mod.Multiplexer, Stat.Potency, "24");
        assertPrimaryStat(Character.RoyalGuard, Mod.Multiplexer, Stat.Potency, "19.5");
    }

    @Test
    void testTenacity() {
        assertPrimaryStat(Character.WedgeAntilles, Mod.Multiplexer, Stat.Tenacity, "24");
        assertPrimaryStat(Character.SithAssassin, Mod.Multiplexer, Stat.Tenacity, "19.5");
    }

    @Test
    void testAccuracy() {
        assertPrimaryStat(Character.ResistancePilot, Mod.Receiver, Stat.Accuracy, "12");
        assertPrimaryStat(Character.OldDaka, Mod.Receiver, Stat.Accuracy, "7.5");
    }

    @Test
    void testCriticalAvoidance() {
        assertPrimaryStat(Character.AskokaTano, Mod.Receiver, Stat.CriticalAvoidance, "24");
        assertPrimaryStat(Character.CloneWarsChewbacca, Mod.Receiver, Stat.CriticalAvoidance, "15");
    }

    @Test
    void testOffense() {
        assertPrimaryStat(Character.CommanderLukeSkywalker, Mod.Transmitter, Stat.OffensePercent, "5.88");
        assertPrimaryStat(Character.SithAssassin, Mod.Receiver, Stat.OffensePercent, "4.75");
    }

    @Test
    void testDefense() {
        assertPrimaryStat(Character.GeneralKenobi, Mod.Processor, Stat.DefensePercent, "11.75");
        assertPrimaryStat(Character.K2SO, Mod.Processor, Stat.DefensePercent, "9.5");
    }

    @Test
    void testHealth() {
        assertPrimaryStat(Character.CommanderLukeSkywalker, Mod.DataBus, Stat.HealthPercent, "5.88");
        assertPrimaryStat(Character.BobaFett, Mod.HoloArray, Stat.HealthPercent, "5.88");
        assertPrimaryStat(Character.DeathTrooper, Mod.Receiver, Stat.HealthPercent, "5.88");
    }

    @Test
    void testProtection() {
        assertPrimaryStat(Character.EmperorPalpatine, Mod.HoloArray, Stat.ProtectionPercent, "23.5");
        assertPrimaryStat(Character.FirstOrderTIEPilot, Mod.DataBus, Stat.ProtectionPercent, "23.5");
        assertPrimaryStat(Character.GrandAdmiralThrawn, Mod.Multiplexer, Stat.ProtectionPercent, "23.5");
        assertPrimaryStat(Character.RoyalGuard, Mod.DataBus, Stat.ProtectionPercent, "19");
    }

    protected abstract void assertPrimaryStat(Character toon, Mod mod, Stat primaryStat, String expectedStatValue);
}
