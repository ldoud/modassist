package com.github.ldoud.modassist.csv;

import com.github.ldoud.modassist.base.SecondaryStatsBaseTest;
import com.github.ldoud.modassist.constants.CharacterName;
import com.github.ldoud.modassist.data.StatName;
import com.github.ldoud.modassist.data.ModType;
import org.dom4j.DocumentException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

class SecondaryStatNameCsvTest extends SecondaryStatsBaseTest {

    private static TestCsvFile csv;

    @BeforeAll
    static void setUp() throws ParserConfigurationException, IOException, TransformerException, DocumentException {
        csv = new TestCsvFile();
    }

    @Override
    protected void assertSecondaryStat(CharacterName toon, ModType modType, StatName secondaryStatName, String expectedStatValue) {
        String secondaryStatActual = csv.getSecondary(toon, modType, secondaryStatName);
        Assertions.assertNotNull(secondaryStatActual, "Found secondary stat value for: "+toon.toString()+"'s "+ modType.toString());
        Assertions.assertEquals(expectedStatValue, secondaryStatActual, "Secondary stat value for: "+toon.toString()+"'s "+ modType.toString());
    }
}
