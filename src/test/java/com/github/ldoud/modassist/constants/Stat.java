package com.github.ldoud.modassist.constants;

public enum Stat {
    Accuracy("Accuracy"),
    CriticalChance("Critical Chance"),
    CriticalDamage("Critical Damage"),
    Defense("Defense"),
    DefensePercent("DefensePercent"),
    Health("Health"),
    HealthPercent("HealthPercent"),
    Offense("Offense"),
    OffensePercent("OffensePercent"),
    Potency("Potency"),
    Speed("Speed"),
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
