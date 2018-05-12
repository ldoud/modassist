package com.github.ldoud.modassist.optimizer;

import com.github.ldoud.modassist.data.Mod;
import com.github.ldoud.modassist.data.ModType;
import com.github.ldoud.modassist.data.StatName;
import com.github.ldoud.modassist.sets.ModSet;
import org.optaplanner.core.api.solver.SolverFactory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    private Collection<Mod> mods = new ArrayList<>();
    private Set<ModType> slotsInUse = new HashSet<>();

    public Solution(ModSet initalModSet) {
        addSet(initalModSet);
    }

    public Solution() {}

    public Solution clone() {
        Solution clone = new Solution();
        clone.mods.addAll(this.mods);
        clone.slotsInUse.addAll(this.slotsInUse);
        return clone;
    }

    public boolean offer(ModSet modSet) {
        Set<ModType> slotsToBeUsed = new HashSet<>();
        slotsToBeUsed.addAll(slotsInUse);
        slotsToBeUsed.addAll(modSet.getSlotsUsedBySet());

        boolean allModsWillBeAdded = slotsInUse.size() + modSet.getSlotsUsedBySet().size() == slotsToBeUsed.size();
        if(allModsWillBeAdded) {
            addSet(modSet);
        }

        return allModsWillBeAdded;
    }

    public boolean offer(Mod modToAdd){
        boolean slotFree = !slotsInUse.contains(modToAdd.getSlot());

        if (slotFree) {
            mods.add(modToAdd);
            slotsInUse.add(modToAdd.getSlot());
        }

        return slotFree;
    }

    public int getNumberOfMods() {
        return mods.size();
    }

    public boolean isComplete() {
        return slotsInUse.size() == 6;
    }

    private void addSet(ModSet set) {
        mods.addAll(set.getMods());
        slotsInUse.addAll(set.getSlotsUsedBySet());
    }
}
