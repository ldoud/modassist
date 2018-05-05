package com.github.ldoud.modassist.data;

import com.github.ldoud.modassist.io.XmlDataFile;

import java.util.ArrayList;
import java.util.Collection;

public class Mod {

    private String character;
    private int dots;
    private int level;
    private StatName set;
    private ModType slot;
    private boolean modHasSpeed = false;
    private Collection<Stat> stats = new ArrayList<>();

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public int getDots() {
        return dots;
    }

    public void setDots(int dots) {
        this.dots = dots;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public StatName getSet() {
        return set;
    }

    public void setSet(StatName set) {
        this.set = set;
    }

    public ModType getSlot() {
        return slot;
    }

    public void setSlot(ModType slot) {
        this.slot = slot;
    }

    public Collection<Stat> getStats() {
        return stats;
    }

    public void setStats(Collection<Stat> stats) {
        this.stats = stats;
    }

    public void add(Stat stat) {
        stats.add(stat);
        if(stat.getName() == StatName.Speed) {
            modHasSpeed = true;
        }
    }

    public boolean hasSpeedStat() {
        return modHasSpeed;
    }

    public int getSpeed() {
        double speed = stats.stream()
                .filter(stat -> stat.getName() == StatName.Speed)
                .mapToDouble(stat -> stat.getValue())
                .sum();

        return (int)speed;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(slot.toString());
        builder.append("(");
        builder.append(set);
        builder.append(") ");
        builder.append(character);
        builder.append(" ");

        for (Stat s : stats) {
            builder.append(s.toString());
        }

        return builder.toString();
    }
}
