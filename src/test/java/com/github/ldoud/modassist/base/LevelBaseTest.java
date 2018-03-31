package com.github.ldoud.modassist.base;

import com.github.ldoud.modassist.constants.Character;
import com.github.ldoud.modassist.constants.ModType;
import org.junit.jupiter.api.Test;

public abstract class LevelBaseTest {

    @Test
    void testLevelOne() {
        assertNumberOLevels(Character.OldDaka, ModType.Transmitter, "1");
    }

    @Test
    void testLevelSix() {
        assertNumberOLevels(Character.DirectorKrennic, ModType.Receiver, "6");
    }

    @Test
    void testLevelNine() {
        assertNumberOLevels(Character.StormtrooperHan, ModType.Multiplexer, "9");
        assertNumberOLevels(Character.FirstOrderStormtrooper, ModType.HoloArray, "9");
    }

    @Test
    void testLevelEleven() {
        assertNumberOLevels(Character.StormtrooperHan, ModType.DataBus, "11");
    }

    protected abstract void assertNumberOLevels(Character toon, ModType modType, String expectedNumberOfLevels);
}
