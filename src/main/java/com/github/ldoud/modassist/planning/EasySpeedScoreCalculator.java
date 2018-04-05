package com.github.ldoud.modassist.planning;

import org.optaplanner.core.api.score.Score;
import org.optaplanner.core.api.score.buildin.simple.SimpleScore;
import org.optaplanner.core.impl.score.director.easy.EasyScoreCalculator;

public class EasySpeedScoreCalculator implements EasyScoreCalculator<ModAssignment>{

    @Override
    public Score calculateScore(ModAssignment modAssignment) {
        int totalSpeed = modAssignment.getCharacters().stream().mapToInt(p -> p.getSpeed()).sum();
        return SimpleScore.valueOf(totalSpeed);
    }
}
