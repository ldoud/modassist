package com.github.ldoud.modassist.csv;

import com.github.ldoud.modassist.constants.Character;
import com.github.ldoud.modassist.constants.Mod;
import com.github.ldoud.modassist.constants.Stat;
import com.github.ldoud.modassist.swgoh.TestXmlData;
import org.dom4j.DocumentException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;
import java.util.HashMap;

public class TestCsvFile {

    private HashMap<String, String[]> csvLines = new HashMap<>();

    TestCsvFile() throws IOException, TransformerException, ParserConfigurationException, DocumentException {
        char[] csvFileContents = generateCsvFromTestXml();
        parseCsv(csvFileContents);
    }

    private char[] generateCsvFromTestXml() throws ParserConfigurationException, TransformerException, IOException, DocumentException {
        TestXmlData xmlData = TestXmlData.getInstance();

        // Transform test XML data into CSV file.
        StreamSource xsl = new StreamSource(ClassLoader.getSystemResourceAsStream("data_to_csv.xsl"));
        CharArrayWriter csvFile = new CharArrayWriter();
        xmlData.transform(new StreamResult(csvFile), xsl);

        return csvFile.toCharArray();
    }

    private void parseCsv(char[] csvContent) throws IOException {
        BufferedReader lineReader = new BufferedReader(new CharArrayReader(csvContent));
        String currentLine = lineReader.readLine(); // Advance past header.
        for(currentLine = lineReader.readLine(); currentLine !=null; currentLine = lineReader.readLine()) {
            String[] columns = currentLine.split(",");
            String key = columns[0]+"-"+columns[1];
            csvLines.put(key, columns);
        }
    }

    public String getSet(Character toon, Mod mod) {
        return getColumn(toon, mod, 2);
    }

    public String getLevel(Character toon, Mod mod) {
        return getColumn(toon, mod, 3);
    }

    public String getDots(Character toon, Mod mod) {
        return getColumn(toon, mod, 4);
    }

    public String getPrimaryStat(Character toon, Mod mod) {
        return getColumn(toon, mod, 5);
    }

    public String getPrimaryValue(Character toon, Mod mod) {
        return getColumn(toon, mod, 6);
    }

    public String getSecondary(Character toon, Mod mod, Stat stat) {
        return getColumn(toon, mod, stat.getColumnIndexForSecondary());
    }

    private String getColumn(Character toon, Mod mod, int columnIndex) {
        String key = toon.toString()+"-"+mod.toString();
        String[] columns = csvLines.get(key);
        return columns[columnIndex];
    }
}