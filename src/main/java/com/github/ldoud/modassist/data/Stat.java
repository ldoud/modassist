package com.github.ldoud.modassist.data;

public class Stat {
    public enum Type{PRIMARY, SECONDARY};

    private StatName name;
    private Type type;
    private double value;

    public StatName getName() {
        return name;
    }

    public void setName(StatName name) {
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
