package com.github.ldoud.modassist.planning;

import com.github.ldoud.modassist.data.Mod;
import com.github.ldoud.modassist.data.StatName;
import org.optaplanner.core.impl.heuristic.selector.common.decorator.SelectionFilter;
import org.optaplanner.core.impl.score.director.ScoreDirector;

public class SpeedModSelectionFilter implements SelectionFilter<ModAssignment, Mod> {
    @Override
    public boolean accept(ScoreDirector<ModAssignment> scoreDirector, Mod mod) {
        System.out.println("Filter");
        return mod.getSet() == StatName.Speed;
    }
}
