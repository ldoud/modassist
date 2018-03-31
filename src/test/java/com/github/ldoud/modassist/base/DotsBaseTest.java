package com.github.ldoud.modassist.base;

import com.github.ldoud.modassist.constants.CharacterName;
import com.github.ldoud.modassist.constants.ModType;
import org.junit.jupiter.api.Test;

public abstract class DotsBaseTest {

    @Test
    void testOneDot() {
        assertNumberOfDots(CharacterName.OldDaka, ModType.Multiplexer, "1");
    }

    @Test
    void testTwoDots() {
        assertNumberOfDots(CharacterName.RoyalGuard, ModType.Receiver, "2");
    }

    @Test
    void testThreeDots() {
        assertNumberOfDots(CharacterName.HothRebelScout, ModType.HoloArray, "3");
    }

    @Test
    void testFourDots() {
        assertNumberOfDots(CharacterName.StormtrooperHan, ModType.DataBus, "4");
    }

    @Test
    void testFiveDots() {
        assertNumberOfDots(CharacterName.StormtrooperHan, ModType.Multiplexer, "5");
    }

    protected abstract void assertNumberOfDots(CharacterName toon, ModType modType, String expectedNumberOfDots);
}