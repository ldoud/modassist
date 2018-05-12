package com.github.ldoud.modassist.apps;

import com.github.ldoud.modassist.data.Mod;
import com.github.ldoud.modassist.io.XmlDataFile;
import com.github.ldoud.modassist.planning.Character;
import com.github.ldoud.modassist.planning.ModAssignment;
import org.optaplanner.core.api.solver.Solver;
import org.optaplanner.core.api.solver.SolverFactory;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ModOptimizer {

    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {
        String modFileLocation = "E:\\source\\modassist\\src\\test\\resources\\all_mods.xml";
        XmlDataFile modFile = new XmlDataFile(modFileLocation);
        Collection<Mod> allMods = modFile.readMods();

        Character thrawn = new Character();
        List<Character> toons = new ArrayList<>();
        toons.add(thrawn);


    }
}
