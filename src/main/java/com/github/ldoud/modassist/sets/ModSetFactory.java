package com.github.ldoud.modassist.sets;

import com.github.ldoud.modassist.data.Mod;
import com.github.ldoud.modassist.data.StatName;

import java.util.*;

public class ModSetFactory {
    TreeSet<Mod> modsBySpeed = new TreeSet<>(new ModSpeedComparator());

    public ModSetFactory(Collection<Mod> mods) {
        modsBySpeed.addAll(mods);
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

                    if(candidateSet.isSetComplete()) {
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
}
