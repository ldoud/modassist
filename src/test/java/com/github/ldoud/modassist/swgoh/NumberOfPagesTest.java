package com.github.ldoud.modassist.swgoh;

import com.github.ldoud.modassist.apps.SwgohGG;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.net.URL;

class NumberOfPagesTest {

    @Test
    void testNumberOfPages() throws ParserConfigurationException, TransformerException, IOException {
        URL swgohWebpage = ClassLoader.getSystemResource("html/swgoh_page1.html");
        int pages = SwgohGG.findNumberOfWebpagesToRead(swgohWebpage);
        Assertions.assertEquals(14, pages, "Total pages of mods");
    }
}
