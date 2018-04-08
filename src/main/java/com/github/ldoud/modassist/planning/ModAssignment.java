package com.github.ldoud.modassist.planning;

import com.github.ldoud.modassist.data.Mod;
import com.github.ldoud.modassist.data.ModType;
import org.optaplanner.core.api.domain.solution.PlanningEntityCollectionProperty;
import org.optaplanner.core.api.domain.solution.PlanningScore;
import org.optaplanner.core.api.domain.solution.PlanningSolution;
import org.optaplanner.core.api.domain.solution.drools.ProblemFactCollectionProperty;
import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider;
import org.optaplanner.core.api.score.Score;
import org.optaplanner.core.api.score.buildin.simple.SimpleScore;

import java.util.*;
import java.util.stream.Collectors;

@PlanningSolution
public class ModAssignment {

    private Map<ModType, List<Mod>> modsByType = new HashMap<>(0);
    private Collection<Character> characters = new ArrayList<>();

    private SimpleScore score;

    @PlanningEntityCollectionProperty
    public Collection<Character> getCharacters() {
        return characters;
    }

    public void setCharacters(Collection<Character> characters) {
        this.characters = characters;
    }

    @ValueRangeProvider(id = "transmitter")
    @ProblemFactCollectionProperty
    public Collection<Mod> getTransmitters() {
        return modsByType.get(ModType.Transmitter);
    }

    @ValueRangeProvider(id = "receiver")
    @ProblemFactCollectionProperty

    public Collection<Mod> getReceivers() {
        return modsByType.get(ModType.Receiver);
    }

    @ValueRangeProvider(id = "processor")
    @ProblemFactCollectionProperty
    public Collection<Mod> getProcessors() {
        return modsByType.get(ModType.Processor);
    }

    @ValueRangeProvider(id = "holoArray")
    @ProblemFactCollectionProperty
    public Collection<Mod> getHoloArrays() {
        return modsByType.get(ModType.HoloArray);
    }

    @ValueRangeProvider(id = "dataBus")
    @ProblemFactCollectionProperty
    public Collection<Mod> getDataBuses() {
        return modsByType.get(ModType.DataBus);
    }

    @ValueRangeProvider(id = "multiplexer")
    @ProblemFactCollectionProperty
    public Collection<Mod> getMultiplexers() {
        return modsByType.get(ModType.Multiplexer);
    }

    public void setMods(Collection<Mod> allMods) {
        modsByType = allMods.stream().collect(Collectors.groupingBy(p -> p.getSlot()));
    }

    @PlanningScore
    public SimpleScore getScore() {
        return score;
    }

    public void setScore(SimpleScore score) {
        this.score = score;
    }
}
