package com.github.ldoud.modassist.constants;

public enum Stat {
    Accuracy("Accuracy"),
    CriticalAvoidance("Critical Avoidance"),
    CriticalChance("Critical Chance"),
    CriticalDamage("Critical Damage"),
    Defense("Defense"),
    DefensePercent("Defense Percent"),
    Health("Health"),
    HealthPercent("Health Percent"),
    Offense("Offense"),
    OffensePercent("Offense Percent"),
    Potency("Potency"),
    Protection("Protection"),
    ProtectionPercent("Protection Percent"),
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
