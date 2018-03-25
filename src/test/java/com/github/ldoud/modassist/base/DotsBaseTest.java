package com.github.ldoud.modassist.base;

import com.github.ldoud.modassist.constants.Character;
import com.github.ldoud.modassist.constants.Mod;
import com.github.ldoud.modassist.swgoh.TestXmlData;
import org.dom4j.Node;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

public abstract class DotsBaseTest {

    @Test
    public void testOneDot() {
        assertNumberOfDots(Character.OldDaka, Mod.Multiplexer, "1");
    }

    @Test
    public void testTwoDots() {
        assertNumberOfDots(Character.RoyalGuard, Mod.Receiver, "2");
    }

    @Test
    public void testThreeDots() {
        assertNumberOfDots(Character.HothRebelScout, Mod.HoloArray, "3");
    }

    @Test
    public void testFourDots() {
        assertNumberOfDots(Character.StormtrooperHan, Mod.DataBus, "4");
    }

    @Test
    public void testFiveDots() {
        assertNumberOfDots(Character.StormtrooperHan, Mod.Multiplexer, "5");
    }

    protected abstract void assertNumberOfDots(Character toon, Mod mod, String expectedNumberOfDots);
}