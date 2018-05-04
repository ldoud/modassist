package com.github.ldoud.modassist.planning;

import com.github.ldoud.modassist.data.Mod;
import com.github.ldoud.modassist.data.StatName;
import org.optaplanner.core.impl.heuristic.move.CompositeMove;
import org.optaplanner.core.impl.heuristic.selector.common.decorator.SelectionFilter;
import org.optaplanner.core.impl.score.director.ScoreDirector;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

public class SpeedSetMoveChangeFilter implements SelectionFilter<ModAssignment, CompositeMove>{
    @Override
    public boolean accept(ScoreDirector<ModAssignment> scoreDirector, CompositeMove compositeMove) {
        boolean accepted = false;

        Collection<Mod> mods = (Collection<Mod>)compositeMove.getPlanningValues();
        Collection<Mod> speedMods = mods.stream()
                .filter(m -> m != null)
                .filter(m -> m.getSet() == StatName.Speed)
                .collect(Collectors.toList());

        if(speedMods.size() == 4){
            Collection<Character> characters = (Collection<Character>)compositeMove.getPlanningEntities();
            int currentSpeedFromSpeedMods = characters.stream().mapToInt(Character::getSpeedFromSpeedMods).sum();
            int futureSpeedFromSpeedMods = speedMods.stream().mapToInt(Mod::getSpeed).sum();
            accepted = futureSpeedFromSpeedMods > currentSpeedFromSpeedMods;
        }

        return accepted;
    }
}
