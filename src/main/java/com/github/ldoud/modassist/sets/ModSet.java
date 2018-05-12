package com.github.ldoud.modassist.sets;

import com.github.ldoud.modassist.data.Mod;
import com.github.ldoud.modassist.data.ModType;
import com.github.ldoud.modassist.data.StatName;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ModSet {

    private Map<ModType, Mod> modSet = new HashMap<>();
    private StatName setStat;

    public ModSet(StatName setStat) {
        this.setStat = setStat;
        if (!setStat.isStatUsedForModSet()) {
            throw new RuntimeException("This is not a stat for a mod set: "+setStat.name());
        }
    }

    public boolean offer(Mod offeredMod) {
        if (!isComplete() &&  isCorrectSet(offeredMod) && !modSet.containsKey(offeredMod.getSlot())) {
            modSet.put(offeredMod.getSlot(), offeredMod);
            return true;
        }

        return false;
    }

    public Set<ModType> getSlotsUsedBySet() {
        return modSet.keySet();
    }

    protected boolean isCorrectSet(Mod offeredMod) {
        return offeredMod.getSet() == setStat;
    }

    public Collection<Mod> getMods() {
        return modSet.values();
    }

    public boolean isComplete() {
        return modSet.size() == setStat.getNumberOfModsInSet();
    }
}
