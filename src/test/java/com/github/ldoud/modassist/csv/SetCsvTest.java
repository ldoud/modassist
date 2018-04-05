package com.github.ldoud.modassist.csv;

import com.github.ldoud.modassist.base.SetBaseTest;
import com.github.ldoud.modassist.constants.CharacterName;
import com.github.ldoud.modassist.planning.ModType;
import org.dom4j.DocumentException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

class SetCsvTest extends SetBaseTest {

    private static TestCsvFile csv;

    @BeforeAll
    static void setUp() throws ParserConfigurationException, IOException, TransformerException, DocumentException {
        csv = new TestCsvFile();
    }

    @Override
    protected void assertSetName(CharacterName toon, ModType modType, String expectedSetName) {
        String setNameActual = csv.getSet(toon, modType);
        Assertions.assertNotNull(setNameActual, "Found set for: "+toon.toString()+"'s "+ modType.toString());
        Assertions.assertEquals(expectedSetName, setNameActual, "Set for: "+toon.toString()+"'s "+ modType.toString());
    }
}
