package com.github.ldoud.modassist.base;

import com.github.ldoud.modassist.constants.Character;
import com.github.ldoud.modassist.constants.Mod;
import org.junit.jupiter.api.Test;

public abstract class DotsBaseTest {

    @Test
    void testOneDot() {
        assertNumberOfDots(Character.OldDaka, Mod.Multiplexer, "1");
    }

    @Test
    void testTwoDots() {
        assertNumberOfDots(Character.RoyalGuard, Mod.Receiver, "2");
    }

    @Test
    void testThreeDots() {
        assertNumberOfDots(Character.HothRebelScout, Mod.HoloArray, "3");
    }

    @Test
    void testFourDots() {
        assertNumberOfDots(Character.StormtrooperHan, Mod.DataBus, "4");
    }

    @Test
    void testFiveDots() {
        assertNumberOfDots(Character.StormtrooperHan, Mod.Multiplexer, "5");
    }

    protected abstract void assertNumberOfDots(Character toon, Mod mod, String expectedNumberOfDots);
}