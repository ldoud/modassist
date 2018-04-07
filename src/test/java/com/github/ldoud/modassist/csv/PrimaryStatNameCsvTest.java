package com.github.ldoud.modassist.csv;

import com.github.ldoud.modassist.base.PrimaryStatNameBaseTest;
import com.github.ldoud.modassist.constants.CharacterName;
import com.github.ldoud.modassist.data.StatName;
import com.github.ldoud.modassist.data.ModType;
import org.dom4j.DocumentException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

class PrimaryStatNameCsvTest extends PrimaryStatNameBaseTest {

    private static TestCsvFile csv;

    @BeforeAll
    static void setUp() throws ParserConfigurationException, IOException, TransformerException, DocumentException {
        csv = new TestCsvFile();
    }

    @Override
    protected void assertPrimaryStat(CharacterName toon, ModType modType, StatName primaryStatType, String expectedStatValue) {
        String primaryStatActual = csv.getPrimaryValue(toon, modType);
        Assertions.assertNotNull(primaryStatActual, "Found primary stat value for: "+toon.toString()+"'s "+ modType.toString());
        Assertions.assertEquals(expectedStatValue, primaryStatActual, "Primary stat value for: "+toon.toString()+"'s "+ modType.toString());

        String primaryStatName = csv.getPrimaryStat(toon, modType);
        Assertions.assertNotNull(primaryStatName, "Found primary stat name for: "+toon.toString()+"'s "+ modType.toString());
        Assertions.assertEquals(primaryStatName, primaryStatType.toString(), "Primary stat value for: "+toon.toString()+"'s "+ modType.toString());
    }
}
