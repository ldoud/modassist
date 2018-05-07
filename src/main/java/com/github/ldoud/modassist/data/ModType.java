package com.github.ldoud.modassist.data;

public enum ModType {
    Transmitter("Transmitter", "Square", "transmitter"),
    Receiver("Receiver","Arrow", "receiver"),
    Processor("Processor","Diamond", "processor"),
    HoloArray("Holo-Array", "Triangle", "holoArray"),
    DataBus("Data-Bus", "Circle", "dataBus"),
    Multiplexer("Multiplexer", "Cross", "multiplexer");

    private String name;
    private String shape;
    private String planningVariableName;

    ModType(String name, String shape, String planningVariableName) {
        this.name = name;
        this.shape = shape;
        this.planningVariableName = planningVariableName;
    }

    @Override
    public String toString() {
        return name;
    }

    public String getPlanningVariableName() {
        return planningVariableName;
    }
}
