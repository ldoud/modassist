package com.github.ldoud.modassist.io;

import com.github.ldoud.modassist.base.SecondaryStatsBaseTest;
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
import java.util.stream.Collectors;

public class SecondaryStatsXmlFileTest extends SecondaryStatsBaseTest {
    private static ModDataFromXmlFile dataFromFile;

    @BeforeAll
    static void setUp() throws IOException, SAXException, ParserConfigurationException {
        dataFromFile = ModDataFromXmlFile.getInstance();
    }

    @Override
    protected void assertSecondaryStat(CharacterName toon, ModType modType, StatName secondaryStatName, String expectedStatValue) {
        Mod modToTest = dataFromFile.getMod(toon, modType);

        List<Stat> secondaryToTest = modToTest.getStats().stream()
                .filter(p -> p.getType() == Stat.Type.SECONDARY)
                .filter(p -> p.getName() == secondaryStatName)
                .collect(Collectors.toList());

        Assertions.assertEquals(secondaryToTest.size(), 1, "Mod has this secondary stat exactly once: "+secondaryStatName);
        Assertions.assertEquals(secondaryToTest.get(0).getValue(), Double.parseDouble(expectedStatValue), "Value of primary stat");
    }
}
