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

    @Test
    void testFourModSets() {
        Mod speedTransmitter7 = dataFromFile.getMod(CharacterName.GrandAdmiralThrawn, ModType.Transmitter);
        Mod speedTransmitter18 = dataFromFile.getMod(CharacterName.DarthVader, ModType.Transmitter);
        Mod speedTransmitter8 = dataFromFile.getMod(CharacterName.SabineWren, ModType.Transmitter);

        Mod speedReceiver30 = dataFromFile.getMod(CharacterName.GeneralKenobi, ModType.Receiver);

        Mod speedProcessor10 = dataFromFile.getMod(CharacterName.GrandAdmiralThrawn, ModType.Processor);
        Mod speedProcessor9 = dataFromFile.getMod(CharacterName.HanSolo, ModType.Processor);

        Mod speedHoloArray4 = dataFromFile.getMod(CharacterName.GeneralKenobi, ModType.HoloArray);
        Mod speedHoloArray5 = dataFromFile.getMod(CharacterName.GrandAdmiralThrawn, ModType.HoloArray);

        Mod speedMultiplexer7 = dataFromFile.getMod(CharacterName.SabineWren, ModType.Multiplexer);
        Mod speedDataBus2 = dataFromFile.getMod(CharacterName.BB8, ModType.DataBus);

        List<Mod> unordered = new ArrayList<>();
        unordered.add(speedTransmitter7);
        unordered.add(speedTransmitter18);
        unordered.add(speedTransmitter8);
        unordered.add(speedReceiver30);
        unordered.add(speedProcessor10);
        unordered.add(speedProcessor9);
        unordered.add(speedHoloArray4);
        unordered.add(speedHoloArray5);
        unordered.add(speedMultiplexer7);
        unordered.add(speedDataBus2);

        ModSetFactory factory =  new ModSetFactory(unordered);
        List<ModSet> modSets = factory.createModSet(StatName.Speed);

        ModSet firstSet = modSets.get(0);
        Assertions.assertEquals(18, firstSet.getModInSlot(ModType.Transmitter).getSpeed(), "First set, Transmitter");
        Assertions.assertEquals(30, firstSet.getModInSlot(ModType.Receiver).getSpeed(), "First set, Receiver");
        Assertions.assertEquals(10, firstSet.getModInSlot(ModType.Processor).getSpeed(), "First set, Processor");
        Assertions.assertEquals(7, firstSet.getModInSlot(ModType.Multiplexer).getSpeed(), "First set, Multiplexer");

        ModSet secondSet = modSets.get(1);
        Assertions.assertEquals(8, secondSet.getModInSlot(ModType.Transmitter).getSpeed(), "Second set, Transmitter");
        Assertions.assertEquals(9, secondSet.getModInSlot(ModType.Processor).getSpeed(), "Second set, Processor");
        Assertions.assertEquals(5, secondSet.getModInSlot(ModType.HoloArray).getSpeed(), "Second set, HoloArray");
        Assertions.assertEquals(2, secondSet.getModInSlot(ModType.DataBus).getSpeed(), "Second set, DataBus");
    }

    @Test
    void testTwoModSets() {
        Mod speed10 = dataFromFile.getMod(CharacterName.GrandAdmiralThrawn, ModType.DataBus);
        Mod speed4 = dataFromFile.getMod(CharacterName.TieFighterPilot, ModType.DataBus);
        Mod speed3 = dataFromFile.getMod(CharacterName.SabineWren, ModType.HoloArray);
        Mod speed2 = dataFromFile.getMod(CharacterName.PoeDameron, ModType.HoloArray);
        Mod speed21 = dataFromFile.getMod(CharacterName.ScarifRebelPathfinder, ModType.Receiver);

        List<Mod> unordered = new ArrayList<>();
        unordered.add(speed3);
        unordered.add(speed4);
        unordered.add(speed10);
        unordered.add(speed2);
        unordered.add(speed21);

        ModSetFactory factory =  new ModSetFactory(unordered);
        List<ModSet> modSets = factory.createModSet(StatName.Health);
        Assertions.assertEquals(2, modSets.size(), "Number of sets");

        ModSet firstSet = modSets.get(0);
        Assertions.assertEquals(10, firstSet.getModInSlot(ModType.DataBus).getSpeed(), "First set, databus");
        Assertions.assertEquals(21, firstSet.getModInSlot(ModType.Receiver).getSpeed(), "First set, receiver");

        ModSet secondSet = modSets.get(1);
        Assertions.assertEquals(4, secondSet.getModInSlot(ModType.DataBus).getSpeed(), "Second set, databus");
        Assertions.assertEquals(3, secondSet.getModInSlot(ModType.HoloArray).getSpeed(), "Second set, holoArray");
    }
}
