package com.github.ldoud.modassist.planning;

import com.github.ldoud.modassist.data.Mod;
import com.github.ldoud.modassist.data.StatName;
import org.optaplanner.core.impl.heuristic.move.CompositeMove;

import java.util.Collection;
import java.util.Comparator;

public class ModSetComparator implements Comparator<CompositeMove> {
    @Override
    public int compare(CompositeMove firstSet, CompositeMove secondSet) {
        Collection<Mod> modsInFirstSet = (Collection<Mod>)firstSet.getPlanningValues();
        long speedOfFirstSet = modsInFirstSet.stream()
                .filter(m -> m != null)
                .mapToInt(Mod::getSpeed)
                .count();

        Collection<Mod> modsInSecondSet = (Collection<Mod>)secondSet.getPlanningValues();
        long speedOfSecondSet = modsInFirstSet.stream()
                .filter(m -> m != null)
                .mapToInt(Mod::getSpeed)
                .count();

        return (int)(speedOfFirstSet - speedOfSecondSet);
    }
}
