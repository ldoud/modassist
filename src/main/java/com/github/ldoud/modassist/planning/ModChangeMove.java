package com.github.ldoud.modassist.planning;

import com.github.ldoud.modassist.data.Mod;
import org.optaplanner.core.impl.heuristic.move.AbstractMove;
import org.optaplanner.core.impl.score.director.ScoreDirector;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

public class ModChangeMove extends AbstractMove<ModAssignment> {

    private Collection<Mod> mods = new LinkedList<>();
    private Character toon;

    public ModChangeMove(Character toonToChange, Collection<Mod> modsToChange) {
        mods.addAll(modsToChange);
        toon = toonToChange;
    }

    @Override
    protected AbstractMove<ModAssignment> createUndoMove(ScoreDirector<ModAssignment> scoreDirector) {
        Collection<Mod> originalMods = new LinkedList<>();
        for (Mod newMod: mods) {
            Mod orignalMod = toon.getModBySlot(newMod.getSlot());
            originalMods.add(orignalMod);
        }

        return new ModChangeMove(toon, originalMods);
    }

    @Override
    protected void doMoveOnGenuineVariables(ScoreDirector<ModAssignment> scoreDirector) {
        for (Mod newMod: mods) {
            scoreDirector.beforeVariableChanged(toon, newMod.getSlot().getPlanningVariableName());
            toon.setMod(newMod);
            scoreDirector.afterVariableChanged(toon, newMod.getSlot().getPlanningVariableName());
        }
    }

    @Override
    public boolean isMoveDoable(ScoreDirector<ModAssignment> scoreDirector) {
        return mods.size() > 0;
    }

    @Override
    public Collection<?> getPlanningEntities() {
        return Collections.singletonList(toon);
    }

    @Override
    public Collection<?> getPlanningValues() {
        return mods;
    }
}
