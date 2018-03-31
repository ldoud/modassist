package com.github.ldoud.modassist.csv;

import com.github.ldoud.modassist.base.PrimaryStatBaseTest;
import com.github.ldoud.modassist.constants.Character;
import com.github.ldoud.modassist.constants.ModType;
import com.github.ldoud.modassist.constants.Stat;
import org.dom4j.DocumentException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

class PrimaryStatCsvTest extends PrimaryStatBaseTest {

    private static TestCsvFile csv;

    @BeforeAll
    static void setUp() throws ParserConfigurationException, IOException, TransformerException, DocumentException {
        csv = new TestCsvFile();
    }

    @Override
    protected void assertPrimaryStat(Character toon, ModType modType, Stat primaryStat, String expectedStatValue) {
        String primaryStatActual = csv.getPrimaryValue(toon, modType);
        Assertions.assertNotNull(primaryStatActual, "Found primary stat value for: "+toon.toString()+"'s "+ modType.toString());
        Assertions.assertEquals(expectedStatValue, primaryStatActual, "Primary stat value for: "+toon.toString()+"'s "+ modType.toString());

        String primaryStatName = csv.getPrimaryStat(toon, modType);
        Assertions.assertNotNull(primaryStatName, "Found primary stat name for: "+toon.toString()+"'s "+ modType.toString());
        Assertions.assertEquals(primaryStatName, primaryStat.toString(), "Primary stat value for: "+toon.toString()+"'s "+ modType.toString());
    }
}
