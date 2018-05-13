package com.github.ldoud.modassist.sets;

import com.github.ldoud.modassist.constants.CharacterName;
import com.github.ldoud.modassist.data.Mod;
import com.github.ldoud.modassist.data.ModType;
import com.github.ldoud.modassist.data.Stat;
import com.github.ldoud.modassist.data.StatName;
import com.github.ldoud.modassist.io.ModDataFromXmlFile;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ModSetFactoryTest {

    private static ModDataFromXmlFile dataFromFile;

    @BeforeAll
    static void setUp() throws IOException, SAXException, ParserConfigurationException {
        dataFromFile = ModDataFromXmlFile.getInstance();
    }

    @Test
    void testNumberOfMods() {
        List<Mod> allMods = dataFromFile.getAllMods();
        ModSetFactory factory = new ModSetFactory(allMods);
        Assertions.assertEquals(allMods.size(), factory.getSingleModsInOrder().size(), "All mods in factory");
    }

    @Test
    void testOrderingOfMods() {
        Mod speed10 = dataFromFile.getMod(CharacterName.CommanderLukeSkywalker, ModType.Transmitter);
        Mod speed4 = dataFromFile.getMod(CharacterName.TieFighterPilot, ModType.Transmitter);
        Mod speed5 = dataFromFile.getMod(CharacterName.R2D2, ModType.HoloArray);
        Mod speed7 = dataFromFile.getMod(CharacterName.K2SO, ModType.Multiplexer);

        List<Mod> unordered = new ArrayList<>();
        unordered.add(speed7);
        unordered.add(speed4);
        unordered.add(speed10);
        unordered.add(speed5);

        ModSetFactory factory =  new ModSetFactory(unordered);
        List<Mod> ordered = factory.getSingleModsInOrder();
        Assertions.assertEquals(10, ordered.get(0).getSpeed());
        Assertions.assertEquals(7, ordered.get(1).getSpeed());
        Assertions.assertEquals(5, ordered.get(2).getSpeed());
        Assertions.assertEquals(4, ordered.get(3).getSpeed());
    }
}
