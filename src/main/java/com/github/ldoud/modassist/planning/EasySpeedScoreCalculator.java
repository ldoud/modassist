package com.github.ldoud.modassist.planning;

import org.optaplanner.core.api.score.Score;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import org.optaplanner.core.api.score.buildin.simple.SimpleScore;
import org.optaplanner.core.impl.score.director.easy.EasyScoreCalculator;

public class EasySpeedScoreCalculator implements EasyScoreCalculator<ModAssignment>{

    @Override
    public Score calculateScore(ModAssignment modAssignment) {
        int assignedMods = modAssignment.getCharacters().stream()
                .mapToInt(character -> character.getCountOfUnassignedMods())
                .sum();

        int totalSpeed = modAssignment.getCharacters().stream().mapToInt(p -> p.getSpeed()).sum();

        return HardSoftScore.valueOf(-1 * assignedMods, totalSpeed);
    }
}
