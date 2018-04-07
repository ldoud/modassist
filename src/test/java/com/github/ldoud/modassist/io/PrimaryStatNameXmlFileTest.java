package com.github.ldoud.modassist.io;

import com.github.ldoud.modassist.base.PrimaryStatNameBaseTest;
import com.github.ldoud.modassist.constants.CharacterName;
import com.github.ldoud.modassist.data.Mod;
import com.github.ldoud.modassist.data.ModType;
import com.github.ldoud.modassist.data.Stat;
import com.github.ldoud.modassist.data.StatName;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PrimaryStatNameXmlFileTest extends PrimaryStatNameBaseTest {

    private static ModDataFromXmlFile dataFromFile;

    @BeforeAll
    static void setUp() throws IOException, SAXException, ParserConfigurationException {
        dataFromFile = ModDataFromXmlFile.getInstance();
    }

    @Override
    protected void assertPrimaryStat(CharacterName toon, ModType modType, StatName primaryStatName, String expectedStatValue) {
        Mod modToTest = dataFromFile.getMod(toon, modType);

        List<Stat> primaryList = modToTest.getStats().stream().filter(p -> p.getType() == Stat.Type.PRIMARY).collect(Collectors.toList());
        Assertions.assertEquals(primaryList.size(), 1, "Mod has exactly one primary stat");

        Assertions.assertEquals(primaryList.get(0).getName(), primaryStatName, "Name of primary stat");
        Assertions.assertEquals(primaryList.get(0).getValue(), Double.parseDouble(expectedStatValue), "Value of primary stat");
    }
}
