package com.github.ldoud.modassist.data;

public enum ModStat {
    Accuracy("Accuracy", -1),
    CriticalAvoidance("Critical Avoidance", -1),
    CriticalChance("Critical Chance", 15),
    CriticalDamage("Critical Damage", -1),
    Defense("Defense", 10),
    DefensePercent("Defense Percent", 11),
    Health("Health", 16),
    HealthPercent("Health Percent", 17),
    Offense("Offense", 8),
    OffensePercent("Offense Percent", 9),
    Potency("Potency", 12),
    Protection("Protection", 13),
    ProtectionPercent("Protection Percent", 14),
    Speed("Speed", 7),
    Tenacity("Tenacity", 18);


    private String name;
    private int csvColumnIndexForSecondary;

    ModStat(String name, int index) {
        this.name = name;
        csvColumnIndexForSecondary = index;
    }

    @Override
    public String toString() {
        return name;
    }

    public int getColumnIndexForSecondary() {
        return csvColumnIndexForSecondary;
    }
}
