package com.github.ldoud.modassist.base;

import com.github.ldoud.modassist.constants.Character;
import com.github.ldoud.modassist.constants.Mod;
import org.junit.jupiter.api.Test;

public abstract class LevelBaseTest {

    @Test
    void testLevelOne() {
        assertNumberOLevels(Character.OldDaka, Mod.Transmitter, "1");
    }

    @Test
    void testLevelSix() {
        assertNumberOLevels(Character.DirectorKrennic, Mod.Receiver, "6");
    }

    @Test
    void testLevelNine() {
        assertNumberOLevels(Character.StormtrooperHan, Mod.Multiplexer, "9");
        assertNumberOLevels(Character.FirstOrderStormtrooper, Mod.HoloArray, "9");
    }

    @Test
    void testLevelEleven() {
        assertNumberOLevels(Character.StormtrooperHan, Mod.DataBus, "11");
    }

    protected abstract void assertNumberOLevels(Character toon, Mod mod, String expectedNumberOfLevels);
}
