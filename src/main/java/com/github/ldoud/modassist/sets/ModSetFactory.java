package com.github.ldoud.modassist.sets;

import com.github.ldoud.modassist.data.Mod;
import com.github.ldoud.modassist.data.StatName;

import java.util.*;
import java.util.stream.Collectors;

public class ModSetFactory {
    ArrayList<Mod> modsBySpeed = new ArrayList<>();

    public ModSetFactory(Collection<Mod> mods) {
        modsBySpeed.addAll(mods);
        Collections.sort(modsBySpeed, new ModSpeedComparator());
    }

    public List<ModSet> createModSet(StatName statForSet) {
        if (!statForSet.isStatUsedForModSet()) {
            throw new RuntimeException("This is not a stat for a mod set: "+statForSet.name());
        }

        ArrayList<ModSet> incompleteSpeedSets = new ArrayList<>();
        ArrayList<ModSet> completeSpeedSets = new ArrayList<>();

        for (Mod m : modsBySpeed) {
            if (m.getSet() == statForSet) {
                boolean modAccepted = false;

                // Offer to each existing incomplete mod set.
                for (Iterator speedSetIt = incompleteSpeedSets.iterator(); !modAccepted && speedSetIt.hasNext();) {
                    ModSet candidateSet = (ModSet)speedSetIt.next();
                    modAccepted = candidateSet.offer(m);

                    if(candidateSet.isComplete()) {
                        speedSetIt.remove();
                        completeSpeedSets.add(candidateSet);
                    }
                }

                // Make a new set to put this into if it didn't go into another set.
                if(!modAccepted) {
                    ModSet emptySet = new ModSet(statForSet);
                    incompleteSpeedSets.add(emptySet);
                    emptySet.offer(m);
                }
            }
        }

        return completeSpeedSets;
    }

    public List<Mod> getSingleModsInOrder() {
        return modsBySpeed.stream().collect(Collectors.toList());
    }
}
