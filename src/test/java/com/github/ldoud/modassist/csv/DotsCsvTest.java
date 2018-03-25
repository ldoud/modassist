package com.github.ldoud.modassist.csv;

import com.github.ldoud.modassist.base.DotsBaseTest;
import com.github.ldoud.modassist.constants.Character;
import com.github.ldoud.modassist.constants.Mod;
import com.github.ldoud.modassist.swgoh.TestXmlData;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

class DotsCsvTest extends DotsBaseTest {

    private static TestCsvFile csv;

    @BeforeAll
    static void setUp() throws ParserConfigurationException, IOException, TransformerException, DocumentException {
        csv = new TestCsvFile();
    }

    @Override
    protected void assertNumberOfDots(Character toon, Mod mod, String expectedNumberOfDots) {
        String dotActual =  csv.getDots(toon, mod);
        Assertions.assertNotNull(dotActual, "Found dots for: "+toon.toString()+"'s "+mod.toString());
        Assertions.assertEquals(expectedNumberOfDots, dotActual, "Number of dots for: "+toon.toString()+"'s "+mod.toString());
    }
}
