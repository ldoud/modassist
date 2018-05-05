package com.github.ldoud.modassist.apps;

import com.github.ldoud.modassist.data.Mod;
import com.github.ldoud.modassist.io.XmlDataFile;
import com.github.ldoud.modassist.planning.Character;
import com.github.ldoud.modassist.planning.ModAssignment;
import org.optaplanner.core.api.solver.Solver;
import org.optaplanner.core.api.solver.SolverFactory;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.CharArrayWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ModPlanner {

    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {
        String modFileLocation = "E:\\source\\modassist\\src\\test\\resources\\all_mods.xml";
        XmlDataFile modFile = new XmlDataFile(modFileLocation);
        Collection<Mod> allMods = modFile.readMods();
        Collection<Mod> modsWithSpeed = allMods.stream().filter(Mod::hasSpeedStat).collect(Collectors.toList());

        Character thrawn = new Character();
        List<Character> toons = new ArrayList<>();
        toons.add(thrawn);

        ModAssignment assignmentOfMods = new ModAssignment();
        assignmentOfMods.setMods(modsWithSpeed);
        assignmentOfMods.setCharacters(toons);
        System.out.println("Number of combinations: "+assignmentOfMods.getNumberOfCombinations());

        SolverFactory<ModAssignment> solverFactory = SolverFactory.createFromXmlResource("modAssignmentSolverConfig.xml");
        Solver<ModAssignment> solver = solverFactory.buildSolver();
        long startTime = System.currentTimeMillis();
        solver.solve(assignmentOfMods);
        double elapsedMS = System.currentTimeMillis() - startTime;
        System.out.println("Elapsed time (seconds): "+elapsedMS / 1000.0);

        System.out.println("Thrawn's speed: "+thrawn.getSpeed());
        System.out.println(thrawn.getReceiver());
        System.out.println(thrawn.getTransmitter());
        System.out.println(thrawn.getProcessor());
        System.out.println(thrawn.getHoloArray());
        System.out.println(thrawn.getDataBus());
        System.out.println(thrawn.getMultiplexer());

    }
}
