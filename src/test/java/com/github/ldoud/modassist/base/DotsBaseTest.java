package com.github.ldoud.modassist.base;

import com.github.ldoud.modassist.constants.Character;
import com.github.ldoud.modassist.constants.ModType;
import org.junit.jupiter.api.Test;

public abstract class DotsBaseTest {

    @Test
    void testOneDot() {
        assertNumberOfDots(Character.OldDaka, ModType.Multiplexer, "1");
    }

    @Test
    void testTwoDots() {
        assertNumberOfDots(Character.RoyalGuard, ModType.Receiver, "2");
    }

    @Test
    void testThreeDots() {
        assertNumberOfDots(Character.HothRebelScout, ModType.HoloArray, "3");
    }

    @Test
    void testFourDots() {
        assertNumberOfDots(Character.StormtrooperHan, ModType.DataBus, "4");
    }

    @Test
    void testFiveDots() {
        assertNumberOfDots(Character.StormtrooperHan, ModType.Multiplexer, "5");
    }

    protected abstract void assertNumberOfDots(Character toon, ModType modType, String expectedNumberOfDots);
}