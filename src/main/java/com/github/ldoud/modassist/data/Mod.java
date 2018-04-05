package com.github.ldoud.modassist.data;

public class Mod {

    private String character;
    private int dots;
    private int level;
    private String setName;
    private ModType type;


    public void setType(ModType type) {
        this.type = type;
    }

    public ModType getType() {
        return type;
    }
}
