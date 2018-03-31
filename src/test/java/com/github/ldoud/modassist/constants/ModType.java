package com.github.ldoud.modassist.constants;

public enum ModType {
    Transmitter("Transmitter", "Square"),
    Receiver("Receiver","Arrow"),
    Processor("Processor","Diamond"),
    HoloArray("Holo-Array", "Triangle"),
    DataBus("Data-Bus", "Circle"),
    Multiplexer("Multiplexer", "Cross");

    private String name;
    private String shape;

    ModType(String name, String shape) {
        this.name = name;
        this.shape = shape;
    }

    @Override
    public String toString() {
        return name;
    }
}
