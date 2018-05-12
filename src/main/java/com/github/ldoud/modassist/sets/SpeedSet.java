package com.github.ldoud.modassist.sets;

import com.github.ldoud.modassist.data.Mod;
import com.github.ldoud.modassist.data.ModType;
import com.github.ldoud.modassist.data.StatName;

import java.util.HashMap;
import java.util.Map;

public class SpeedSet {

    private Map<ModType, Mod> modSet = new HashMap<>();

    public boolean offer(Mod offeredMod) {
        if (offeredMod.getSet() == StatName.Speed && !isSetComplete() &&  !modSet.containsKey(offeredMod.getSlot())) {
            modSet.put(offeredMod.getSlot(), offeredMod);
            return true;
        }

        return false;
    }

    public boolean isSetComplete() {
        return modSet.size() == 4;
    }
}
