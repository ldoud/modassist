package com.github.ldoud.modassist.sets;

import com.github.ldoud.modassist.data.Mod;
import com.github.ldoud.modassist.data.StatName;

import java.util.*;

public class SetFactory {
    TreeSet<Mod> modsBySpeed = new TreeSet<>(new ModSpeedComparator());

    public SetFactory(Collection<Mod> mods) {
        modsBySpeed.addAll(mods);
    }

    public List<SpeedSet> getSpeedSets() {
        ArrayList<SpeedSet> incompleteSpeedSets = new ArrayList<>();
        ArrayList<SpeedSet> completeSpeedSets = new ArrayList<>();

        for (Mod m : modsBySpeed) {
            if (m.getSet() == StatName.Speed) {
                boolean modAccepted = false;

                // Offer to each existing speed set.
                for (Iterator speedSetIt = incompleteSpeedSets.iterator(); !modAccepted && speedSetIt.hasNext();) {
                    SpeedSet candidateSet = (SpeedSet)speedSetIt.next();
                    modAccepted = candidateSet.offer(m);

                    if(candidateSet.isSetComplete()) {
                        speedSetIt.remove();
                        completeSpeedSets.add(candidateSet);
                    }
                }

                // Make a new set to put this into if it didn't go into another set.
                if(!modAccepted) {
                    SpeedSet emptySet = new SpeedSet();
                    incompleteSpeedSets.add(emptySet);
                    emptySet.offer(m);
                }
            }
        }

        return completeSpeedSets;
    }
}
