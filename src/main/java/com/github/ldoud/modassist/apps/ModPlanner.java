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

public class ModPlanner {

    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {
        String modFileLocation = "E:\\source\\modassist\\src\\test\\resources\\all_mods.xml";
        XmlDataFile modFile = new XmlDataFile(modFileLocation);
        Collection<Mod> mods = modFile.readMods();

        Character thrawn = new Character();
        List<Character> toons = new ArrayList<>();
        toons.add(thrawn);

        ModAssignment assignmentOfMods = new ModAssignment();
        assignmentOfMods.setMods(mods);
        assignmentOfMods.setCharacters(toons);

        SolverFactory<ModAssignment> solverFactory = SolverFactory.createFromXmlResource("modAssignmentSolverConfig.xml");
        Solver<ModAssignment> solver = solverFactory.buildSolver();
        solver.solve(assignmentOfMods);

        System.out.println("Thrawn's speed: "+thrawn.getSpeed());
        System.out.println(thrawn.getReceiver());
        System.out.println(thrawn.getTransmitter());
        System.out.println(thrawn.getProcessor());
        System.out.println(thrawn.getHoloArray());
        System.out.println(thrawn.getDataBus());
        System.out.println(thrawn.getMultiplexer());

    }
}
