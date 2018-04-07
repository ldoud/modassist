package com.github.ldoud.modassist.csv;

import com.github.ldoud.modassist.constants.CharacterName;
import com.github.ldoud.modassist.data.ModType;
import com.github.ldoud.modassist.data.StatName;
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

    public String getSet(CharacterName toon, ModType modType) {
        return getColumn(toon, modType, 2);
    }

    public String getLevel(CharacterName toon, ModType modType) {
        return getColumn(toon, modType, 3);
    }

    public String getDots(CharacterName toon, ModType modType) {
        return getColumn(toon, modType, 4);
    }

    public String getPrimaryStat(CharacterName toon, ModType modType) {
        return getColumn(toon, modType, 5);
    }

    public String getPrimaryValue(CharacterName toon, ModType modType) {
        return getColumn(toon, modType, 6);
    }

    public String getSecondary(CharacterName toon, ModType modType, StatName statName) {
        return getColumn(toon, modType, statName.getColumnIndexForSecondary());
    }

    private String getColumn(CharacterName toon, ModType modType, int columnIndex) {
        String key = toon.toString()+"-"+ modType.toString();
        String[] columns = csvLines.get(key);
        return columns[columnIndex];
    }
}
