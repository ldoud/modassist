package com.github.ldoud.modassist.sets;

import com.github.ldoud.modassist.data.Mod;
import com.github.ldoud.modassist.data.ModType;
import com.github.ldoud.modassist.data.StatName;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;

public class ModSetTest {
    private Mod transmitter = new Mod();
    private Mod receiver = new Mod();
    private Mod processor = new Mod();
    private Mod holoArray = new Mod();
    private Mod dataBus = new Mod();
    private Mod multiplexer = new Mod();

    private Collection<Mod> allMods = new ArrayList<>();

    @BeforeEach
    void initMods() {
        transmitter.setSlot(ModType.Transmitter);
        transmitter.setSet(StatName.Speed);

        receiver.setSlot(ModType.Receiver);
        receiver.setSet(StatName.Speed);

        processor.setSlot(ModType.Processor);
        processor.setSet(StatName.Speed);

        holoArray.setSlot(ModType.HoloArray);
        holoArray.setSet(StatName.Speed);

        dataBus.setSlot(ModType.DataBus);
        dataBus.setSet(StatName.Speed);

        multiplexer.setSlot(ModType.Multiplexer);
        multiplexer.setSet(StatName.Speed);

        allMods.clear();
        allMods.add(transmitter);
        allMods.add(receiver);
        allMods.add(processor);
        allMods.add(holoArray);
        allMods.add(dataBus);
        allMods.add(multiplexer);
    }

    @Test
    void testFillingFourModSet() {
        ModSet ss = new ModSet(StatName.Speed);
        allMods.stream().forEach(mod -> mod.setSet(StatName.Speed));

        Assertions.assertFalse(ss.isSetComplete(), "Set empty");
        Assertions.assertTrue(ss.offer(transmitter), "Transmitter accepted");
        Assertions.assertFalse(ss.isSetComplete(), "Set has 1");
        Assertions.assertTrue(ss.offer(receiver), "Receiver accepted");
        Assertions.assertFalse(ss.isSetComplete(), "Set has 2");
        Assertions.assertTrue(ss.offer(processor), "Processor accepted");
        Assertions.assertFalse(ss.isSetComplete(), "Set has 3");
        Assertions.assertTrue(ss.offer(holoArray), "HoloArray accepted");
        Assertions.assertTrue(ss.isSetComplete(), "Set full");
    }

    @Test
    void testFillingTwoModSet() {
        ModSet modSet = new ModSet(StatName.Health);
        allMods.stream().forEach(mod -> mod.setSet(StatName.Health));

        Assertions.assertFalse(modSet.isSetComplete(), "Set empty");
        Assertions.assertTrue(modSet.offer(transmitter), "Transmitter accepted");
        Assertions.assertFalse(modSet.isSetComplete(), "Set has 1");
        Assertions.assertTrue(modSet.offer(receiver), "Receiver accepted");
        Assertions.assertTrue(modSet.isSetComplete(), "Set full");
    }

    @Test
    void testOverFillingFourModSet() {
        ModSet modSet = new ModSet(StatName.Offense);
        allMods.stream().forEach(mod -> mod.setSet(StatName.Offense));

        Assertions.assertTrue(modSet.offer(dataBus), "DataBus accepted");
        Assertions.assertTrue(modSet.offer(multiplexer), "Multiplexer accepted");
        Assertions.assertTrue(modSet.offer(processor), "Processor accepted");
        Assertions.assertTrue(modSet.offer(holoArray), "HoloArray accepted");
        Assertions.assertTrue(modSet.isSetComplete(), "Set full");

        // Try overfilling.
        Assertions.assertFalse(modSet.offer(transmitter), "Won't accept another mod");
        Assertions.assertTrue(modSet.isSetComplete(), "Set still full");
    }

    @Test
    void testOverFillingTwoModSet() {
        ModSet modSet = new ModSet(StatName.Potency);
        allMods.stream().forEach(mod -> mod.setSet(StatName.Potency));

        Assertions.assertTrue(modSet.offer(transmitter), "Transmitter accepted");
        Assertions.assertTrue(modSet.offer(receiver), "Receiver accepted");
        Assertions.assertTrue(modSet.isSetComplete(), "Set full");

        // Try overfilling.
        Assertions.assertFalse(modSet.offer(transmitter), "Won't accept another mod");
        Assertions.assertTrue(modSet.isSetComplete(), "Set still full");
    }

    @Test
    void testRejectModsOfWrongSet() {
        ModSet modSet = new ModSet(StatName.Speed);
        allMods.stream().forEach(mod -> mod.setSet(StatName.CriticalDamage));

        Assertions.assertFalse(modSet.isSetComplete(), "Set empty");

        Assertions.assertFalse(modSet.offer(transmitter), "Transmitter rejected");
        Assertions.assertFalse(modSet.offer(receiver), "Receiver rejected");
        Assertions.assertFalse(modSet.offer(processor),"Processor rejected");
        Assertions.assertFalse(modSet.offer(holoArray),"HoloArray reject");
        Assertions.assertFalse(modSet.isSetComplete(), "Set is empty");
    }

    @Test
    void testAttempConstructingModSetWithBadStat() {
        try {
            ModSet modSet = new ModSet(StatName.ProtectionPercent);
            Assertions.fail("Created mod set with bad stat");
        } catch (RuntimeException e){
            // Expected
        }
    }

}
