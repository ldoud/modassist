package com.github.ldoud.modassist.data;

public enum StatName {
    Accuracy("Accuracy", -1),
    CriticalAvoidance("Critical Avoidance", -1),
    CriticalChance("Critical Chance", 15, 2),
    CriticalDamage("Critical Damage", -1, 4),
    Defense("Defense", 10, 2),
    DefensePercent("Defense Percent", 11),
    Health("Health", 16, 2),
    HealthPercent("Health Percent", 17),
    Offense("Offense", 8, 4),
    OffensePercent("Offense Percent", 9),
    Potency("Potency", 12, 2),
    Protection("Protection", 13),
    ProtectionPercent("Protection Percent", 14),
    Speed("Speed", 7, 4),
    Tenacity("Tenacity", 18, 2);


    private String name;
    private int csvColumnIndexForSecondary;
    private int numberOfModsInSet = 0;

    StatName(String name, int csvColumnIndexForSecondary) {
        this(name, csvColumnIndexForSecondary, 0);
    }

    StatName(String name, int csvColumnIndexForSecondary, int numberOfModsInSet) {
        this.name = name;
        this.csvColumnIndexForSecondary = csvColumnIndexForSecondary;
        this.numberOfModsInSet = numberOfModsInSet;
    }

    @Override
    public String toString() {
        return name;
    }

    public int getColumnIndexForSecondary() {
        return csvColumnIndexForSecondary;
    }

    public boolean isStatUsedForModSet() {
        return numberOfModsInSet > 0;
    }

    public int getNumberOfModsInSet() {
        return numberOfModsInSet;
    }
}
