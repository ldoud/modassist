package com.github.ldoud.modassist.csv;

import com.github.ldoud.modassist.base.DotsBaseTest;
import com.github.ldoud.modassist.base.SetBaseTest;
import com.github.ldoud.modassist.constants.Character;
import com.github.ldoud.modassist.constants.Mod;
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
    protected void assertSetName(Character toon, Mod mod, String expectedSetName) {
        String setNameActual = csv.getSet(toon, mod);
        Assertions.assertNotNull(setNameActual, "Found set for: "+toon.toString()+"'s "+mod.toString());
        Assertions.assertEquals(expectedSetName, setNameActual, "Set for: "+toon.toString()+"'s "+mod.toString());
    }
}
