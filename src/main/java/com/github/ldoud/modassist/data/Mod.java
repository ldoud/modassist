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
    }

    private Collection<Stat> stats = new ArrayList<>();

}
