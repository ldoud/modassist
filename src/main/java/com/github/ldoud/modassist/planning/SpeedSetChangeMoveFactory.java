package com.github.ldoud.modassist.planning;

import com.github.ldoud.modassist.data.Mod;
import com.github.ldoud.modassist.data.ModType;
import com.github.ldoud.modassist.data.StatName;
import org.optaplanner.core.impl.heuristic.move.CompositeMove;
import org.optaplanner.core.impl.heuristic.move.Move;
import org.optaplanner.core.impl.heuristic.selector.move.factory.MoveListFactory;

import java.util.*;
import java.util.stream.Collectors;

public class SpeedSetChangeMoveFactory implements MoveListFactory<ModAssignment> {

    @Override
    public List<? extends Move<ModAssignment>> createMoveList(ModAssignment modAssignment) {
        List<Mod> fastestSpeedMods = new ArrayList<>();
        extractFastestSpeedMod(modAssignment.getReceivers()).ifPresent(m -> fastestSpeedMods.add(m));
        extractFastestSpeedMod(modAssignment.getDataBuses()).ifPresent(m -> fastestSpeedMods.add(m));
        extractFastestSpeedMod(modAssignment.getHoloArrays()).ifPresent(m -> fastestSpeedMods.add(m));
        extractFastestSpeedMod(modAssignment.getMultiplexers()).ifPresent(m -> fastestSpeedMods.add(m));
        extractFastestSpeedMod(modAssignment.getProcessors()).ifPresent(m -> fastestSpeedMods.add(m));
        extractFastestSpeedMod(modAssignment.getTransmitters()).ifPresent(m -> fastestSpeedMods.add(m));

        ModChangeMove move = new ModChangeMove(modAssignment.getCharacters().stream().findFirst().get(), fastestSpeedMods);

        return Collections.singletonList(move);
    }

    private Optional<Mod> extractFastestSpeedMod(Collection<Mod> modsOfAllSets) {
        List<Mod> speedMods = modsOfAllSets.stream()
                .filter(mod -> mod.getSet() == StatName.Speed)
                .collect(Collectors.toList());

        Collections.sort(speedMods, new ModComparator());

        return Optional.ofNullable(speedMods.get(0));
    }
}
