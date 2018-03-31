package com.github.ldoud.modassist.base;

import com.github.ldoud.modassist.constants.CharacterName;
import com.github.ldoud.modassist.constants.ModType;
import org.junit.jupiter.api.Test;

public abstract class LevelBaseTest {

    @Test
    void testLevelOne() {
        assertNumberOLevels(CharacterName.OldDaka, ModType.Transmitter, "1");
    }

    @Test
    void testLevelSix() {
        assertNumberOLevels(CharacterName.DirectorKrennic, ModType.Receiver, "6");
    }

    @Test
    void testLevelNine() {
        assertNumberOLevels(CharacterName.StormtrooperHan, ModType.Multiplexer, "9");
        assertNumberOLevels(CharacterName.FirstOrderStormtrooper, ModType.HoloArray, "9");
    }

    @Test
    void testLevelEleven() {
        assertNumberOLevels(CharacterName.StormtrooperHan, ModType.DataBus, "11");
    }

    protected abstract void assertNumberOLevels(CharacterName toon, ModType modType, String expectedNumberOfLevels);
}
