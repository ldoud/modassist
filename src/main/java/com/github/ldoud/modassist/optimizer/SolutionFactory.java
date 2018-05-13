package com.github.ldoud.modassist.optimizer;


import com.github.ldoud.modassist.data.Mod;
import com.github.ldoud.modassist.data.StatName;
import com.github.ldoud.modassist.sets.ModSet;
import com.github.ldoud.modassist.sets.ModSetFactory;

import java.util.*;

public class SolutionFactory {

    private ModSetFactory setFactory;

    public SolutionFactory(Collection<Mod> mods) {
        setFactory = new ModSetFactory(mods);
    }

    public Collection<Solution> createSolutions() {
        List<Mod> mods = setFactory.getSingleModsInOrder();

        Solution singleSolution = new Solution();
        for(Iterator<Mod> modToOffer = mods.iterator(); modToOffer.hasNext() && !singleSolution.isComplete();) {
            singleSolution.offer(modToOffer.next());
        }

        return List.of(singleSolution);
    }

    public Collection<Solution> createSolutions(StatName ... requiredSets) {
        int slotsRequiredBySets = Arrays.stream(requiredSets).mapToInt(s -> s.getNumberOfModsInSet()).sum();
        if (slotsRequiredBySets > 6) {
            throw new RuntimeException("Too many slots required by sets: "+slotsRequiredBySets);
        }

        List<StatName> reqSetsAsList = Arrays.asList(requiredSets);
        Collections.sort(reqSetsAsList, new Comparator<StatName>() {
            @Override
            public int compare(StatName o1, StatName o2) {
                return o1.getNumberOfModsInSet() - o2.getNumberOfModsInSet();
            }
        });

        List<Solution> solutionsWithRequiredSets = createSetCombinations(reqSetsAsList);
        List<Solution> completedSets = completeSolutions(solutionsWithRequiredSets);

        return completedSets;
    }

    private List<Solution> createSetCombinations(List<StatName> requiredSets) {
        if(requiredSets.size() == 1) {
            return createInitialCombinations(requiredSets.get(0));
        }

        StatName setToPopulate = requiredSets.get(0);
        List<ModSet> setsToOffer = setFactory.createModSet(setToPopulate);

        List<Solution> solutionsToBuildOn = createSetCombinations(requiredSets.subList(1, requiredSets.size()));
        List<Solution> newCombinations = new ArrayList<>();

        for (Solution templateSolution : solutionsToBuildOn) {
            for (ModSet set : setsToOffer) {
                Solution solution = templateSolution.clone();
                if (solution.offer(set)) {
                    newCombinations.add(solution);
                }
            }
        }

        return newCombinations;
    }

    private List<Solution> createInitialCombinations(StatName requiredSet) {
        List<Solution> possibleSolutions = new ArrayList<>();
        List<ModSet> setsToOffer = setFactory.createModSet(requiredSet);
        for (ModSet set : setsToOffer) {
            possibleSolutions.add(new Solution(set));
        }
        return possibleSolutions;
    }

    private List<Solution> completeSolutions(List<Solution> solutionsWithRequiredSets) {
        List<Solution> completedSets =  new ArrayList<>();
        List<Mod> modsInOrder = setFactory.getSingleModsInOrder();
        for(Solution toFinish : solutionsWithRequiredSets) {
            for(Mod candidateMod : modsInOrder) {
                toFinish.offer(candidateMod);
                if(toFinish.isComplete()) {
                    completedSets.add(toFinish);
                    break;
                }
            }
        }
        return completedSets;
    }

}
