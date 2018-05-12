package com.github.ldoud.modassist.sets;

import com.github.ldoud.modassist.data.Mod;
import com.github.ldoud.modassist.data.ModType;
import com.github.ldoud.modassist.data.StatName;

import java.util.HashMap;
import java.util.Map;

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
        if (offeredMod.getSet() == setStat && !isSetComplete() &&  !modSet.containsKey(offeredMod.getSlot())) {
            modSet.put(offeredMod.getSlot(), offeredMod);
            return true;
        }

        return false;
    }

    public boolean isSetComplete() {
        return modSet.size() == setStat.getNumberOfModsInSet();
    }
}
