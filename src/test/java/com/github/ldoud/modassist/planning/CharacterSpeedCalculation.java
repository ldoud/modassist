package com.github.ldoud.modassist.planning;

import com.github.ldoud.modassist.constants.CharacterName;
import com.github.ldoud.modassist.data.Mod;
import com.github.ldoud.modassist.data.ModType;
import com.github.ldoud.modassist.io.ModDataFromXmlFile;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class CharacterSpeedCalculation {

    private static ModDataFromXmlFile dataFromFile;

    @BeforeAll
    static void setUp() throws IOException, SAXException, ParserConfigurationException {
        dataFromFile = ModDataFromXmlFile.getInstance();
    }

    @Test
    void testTransmitterOnly() {
        Mod modToTest = dataFromFile.getMod(CharacterName.Shoretrooper, ModType.Transmitter);
        Character testCharacter = new Character();
        testCharacter.setTransmitter(modToTest);
        int speed = testCharacter.getSpeed();
        Assertions.assertEquals(5, speed, "Speed calculation");
    }

    @Test
    void testReceiverOnly() {
        Mod modToTest = dataFromFile.getMod(CharacterName.JynErso, ModType.Receiver);
        Character testCharacter = new Character();
        testCharacter.setReceiver(modToTest);
        int speed = testCharacter.getSpeed();
        Assertions.assertEquals(30, speed, "Speed calculation");
    }

    @Test
    void testProcessorOnly() {
        Mod modToTest = dataFromFile.getMod(CharacterName.Snowtrooper, ModType.Processor);
        Character testCharacter = new Character();
        testCharacter.setProcessor(modToTest);
        int speed = testCharacter.getSpeed();
        Assertions.assertEquals(9, speed, "Speed calculation");
    }

    @Test
    void testHoloArrayOnly() {
        Mod modToTest = dataFromFile.getMod(CharacterName.Snowtrooper, ModType.HoloArray);
        Character testCharacter = new Character();
        testCharacter.setHoloArray(modToTest);
        int speed = testCharacter.getSpeed();
        Assertions.assertEquals(5, speed, "Speed calculation");
    }

    @Test
    void testDataBusOnly() {
        Mod modToTest = dataFromFile.getMod(CharacterName.GrandAdmiralThrawn, ModType.DataBus);
        Character testCharacter = new Character();
        testCharacter.setDataBus(modToTest);
        int speed = testCharacter.getSpeed();
        Assertions.assertEquals(10, speed, "Speed calculation");
    }

    @Test
    void testMultiplexerOnly() {
        Mod modToTest = dataFromFile.getMod(CharacterName.GeneralKenobi, ModType.Multiplexer);
        Character testCharacter = new Character();
        testCharacter.setMultiplexer(modToTest);
        int speed = testCharacter.getSpeed();
        Assertions.assertEquals(5, speed, "Speed calculation");
    }

    @Test
    void testAllModSlots() {
        Character testCharacter = new Character();

        Mod transmitter = dataFromFile.getMod(CharacterName.Shoretrooper, ModType.Transmitter); // 5
        testCharacter.setTransmitter(transmitter);

        Mod receiver = dataFromFile.getMod(CharacterName.JynErso, ModType.Receiver); // 30
        testCharacter.setReceiver(receiver);

        Mod processor = dataFromFile.getMod(CharacterName.Snowtrooper, ModType.Processor); // 9
        testCharacter.setProcessor(processor);

        Mod holoArray = dataFromFile.getMod(CharacterName.Snowtrooper, ModType.HoloArray); // 5
        testCharacter.setHoloArray(holoArray);

        Mod dataBus = dataFromFile.getMod(CharacterName.GrandAdmiralThrawn, ModType.DataBus); // 10
        testCharacter.setDataBus(dataBus);

        Mod multiplexer = dataFromFile.getMod(CharacterName.GeneralKenobi, ModType.Multiplexer); // 5
        testCharacter.setMultiplexer(multiplexer);

        int speed = testCharacter.getSpeed();
        Assertions.assertEquals(64, speed, "Speed calculation");
    }

    @Test
    void testRemovingByAddingNull() {
        Character testCharacter = new Character();

        Mod transmitter = dataFromFile.getMod(CharacterName.Shoretrooper, ModType.Transmitter); // 5
        testCharacter.setTransmitter(transmitter);

        Mod receiver = dataFromFile.getMod(CharacterName.JynErso, ModType.Receiver); // 30
        testCharacter.setReceiver(receiver);

        Mod processor = dataFromFile.getMod(CharacterName.Snowtrooper, ModType.Processor); // 9
        testCharacter.setProcessor(processor);

        Mod holoArray = dataFromFile.getMod(CharacterName.Snowtrooper, ModType.HoloArray); // 5
        testCharacter.setHoloArray(holoArray);

        Mod dataBus = dataFromFile.getMod(CharacterName.GrandAdmiralThrawn, ModType.DataBus); // 10
        testCharacter.setDataBus(dataBus);

        Mod multiplexer = dataFromFile.getMod(CharacterName.GeneralKenobi, ModType.Multiplexer); // 5
        testCharacter.setMultiplexer(multiplexer);

        testCharacter.setReceiver(null);

        int speed = testCharacter.getSpeed();
        Assertions.assertEquals(34, speed, "Speed calculation");
    }
}
