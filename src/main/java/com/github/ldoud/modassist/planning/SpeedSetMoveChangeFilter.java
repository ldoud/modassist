package com.github.ldoud.modassist.planning;

import com.github.ldoud.modassist.data.Mod;
import com.github.ldoud.modassist.data.StatName;
import org.optaplanner.core.impl.heuristic.move.CompositeMove;
import org.optaplanner.core.impl.heuristic.selector.common.decorator.SelectionFilter;
import org.optaplanner.core.impl.score.director.ScoreDirector;

import java.util.Arrays;
import java.util.Collection;

public class SpeedSetMoveChangeFilter implements SelectionFilter<ModAssignment, CompositeMove>{
    @Override
    public boolean accept(ScoreDirector<ModAssignment> scoreDirector, CompositeMove compositeMove) {
        Collection<Mod> mods = (Collection<Mod>)compositeMove.getPlanningValues();

        long speedModCount = mods.stream()
                .filter(m -> m != null)
                .filter(m -> m.getSet() == StatName.Speed)
                .count();

        return speedModCount == 4;
    }
}
