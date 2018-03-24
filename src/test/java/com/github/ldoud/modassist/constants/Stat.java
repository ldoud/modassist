package com.github.ldoud.modassist.constants;

public enum Stat {
    Speed("Speed"),
    Offense("Offense"),
    OffensePercent("OffensePercent"),
    CriticalChance("Critical Chance"),
    Defense("Defense"),
    DefensePercent("DefensePercent"),
    Potency("Potency"),
    Health("Health"),
    HealthPercent("HealthPercent"),
    Tenacity("Tenacity");

    private String name;

    Stat(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
