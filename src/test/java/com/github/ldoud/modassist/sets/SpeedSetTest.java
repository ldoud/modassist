package com.github.ldoud.modassist.sets;

import com.github.ldoud.modassist.data.Mod;
import com.github.ldoud.modassist.data.ModType;
import com.github.ldoud.modassist.data.StatName;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SpeedSetTest {
    private Mod transmitter = new Mod();
    private Mod receiver = new Mod();
    private Mod processor = new Mod();
    private Mod holoArray = new Mod();
    private Mod dataBus = new Mod();
    private Mod multiplexer = new Mod();

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
    }

    @Test
    void testOfferingDupesAfterFilling() {
        SpeedSet ss = new SpeedSet();
        Assertions.assertFalse(ss.isSetComplete(), "Set empty");
        Assertions.assertTrue(ss.offer(transmitter), "Transmitter accepted");
        Assertions.assertFalse(ss.isSetComplete(), "Set has 1");
        Assertions.assertTrue(ss.offer(receiver), "Receiver accepted");
        Assertions.assertFalse(ss.isSetComplete(), "Set has 2");
        Assertions.assertTrue(ss.offer(processor),"Processor accepted");
        Assertions.assertFalse(ss.isSetComplete(), "Set has 3");
        Assertions.assertTrue(ss.offer(holoArray),"HoloArray accepted");
        Assertions.assertTrue(ss.isSetComplete(), "Set full");

        // Try overfilling.
        Assertions.assertFalse(ss.offer(dataBus), "Won't accept another mod");
        Assertions.assertTrue(ss.isSetComplete(), "Set still full");
        Assertions.assertFalse(ss.offer(transmitter), "Won't accept mod already in set");
        Assertions.assertTrue(ss.isSetComplete(), "Set full after offering dupe");
    }

    @Test
    void testOfferingDupesPriorToFilling() {
        SpeedSet ss = new SpeedSet();
        Assertions.assertFalse(ss.isSetComplete(), "Set empty");

        Assertions.assertTrue(ss.offer(transmitter), "Transmitter accepted");
        Assertions.assertFalse(ss.offer(transmitter), "Transmitter rejected");
        Assertions.assertFalse(ss.isSetComplete(), "Set has 1");

        Assertions.assertTrue(ss.offer(receiver), "Receiver accepted");
        Assertions.assertFalse(ss.offer(receiver), "Receiver rejected");
        Assertions.assertFalse(ss.isSetComplete(), "Set has 2");

        Assertions.assertTrue(ss.offer(processor),"Processor accepted");
        Assertions.assertFalse(ss.isSetComplete(), "Set has 3");
        Assertions.assertTrue(ss.offer(holoArray),"HoloArray accepted");
        Assertions.assertTrue(ss.isSetComplete(), "Set full");

        // Try overfilling.
        Assertions.assertFalse(ss.offer(dataBus), "Won't accept another mod");
        Assertions.assertTrue(ss.isSetComplete(), "Set still full");
        Assertions.assertFalse(ss.offer(transmitter), "Won't accept mod already in set");
        Assertions.assertTrue(ss.isSetComplete(), "Set full after offering dupe");
    }

    @Test
    void testRejectSetCritChance() {
        assertSetRejected(transmitter, StatName.CriticalChance);
    }

    @Test
    void testRejectSetCritDmg() {
        assertSetRejected(transmitter, StatName.CriticalDamage);
    }

    @Test
    void testRejectSetCritAvoidance() {
        assertSetRejected(transmitter, StatName.CriticalAvoidance);
    }

    @Test
    void testRejectSetTenacity() {
        assertSetRejected(transmitter, StatName.Tenacity);
    }

    @Test
    void testRejectSetPotency() {
        assertSetRejected(transmitter, StatName.Potency);
    }

    @Test
    void testRejectSetAccuracy() {
        assertSetRejected(transmitter, StatName.Accuracy);
    }

    @Test
    void testRejectSetOffense() {
        assertSetRejected(transmitter, StatName.Offense);
    }

    @Test
    void testRejectSetHealth() {
        assertSetRejected(transmitter, StatName.Health);
    }

    @Test
    void testRejectSetProtection() {
        assertSetRejected(transmitter, StatName.Protection);
    }

    @Test
    void testRejectSetDefense() {
        assertSetRejected(transmitter, StatName.Defense);
    }

    void assertSetRejected(Mod m, StatName stat) {
        SpeedSet ss = new SpeedSet();
        m.setSet(stat);
        Assertions.assertFalse(ss.offer(m), stat.name() + " set rejected");
    }

}
