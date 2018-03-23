package com.github.ldoud.modassist.xsl;

public enum Character {
    AskokaTano("Ahsoka Tano"),
    BiggsDarklighter("Biggs Darklighter"),
    BobaFett("Boba Fett"),
    CadBane("Cad Bane"),
    CaptainHanSolo("Captain Han Solo"),
    DarthMaul("Darth Maul"),
    DarthSion("Darth Sion"),
    EmperorPalpatine("Emperor Palpatine"),
    FirstOrderTIEPilot("First Order TIE Pilot"),
    GrandMoffTarkin("Grand Moff Tarkin"),
    HothRebelScout("Hoth Rebel Scout"),
    JediConsular("Jedi Consular"),
    JynErso("Jyn Erso"),
    Magmatrooper("Magmatrooper"),
    PrincessLeia("Princess Leia"),
    ResistancePilot("Resistance Pilot"),
    ResistanceTrooper("Resistance Trooper"),
    SabineWren("Sabine Wren"),
    Shoretrooper("Shoretrooper"),
    WedgeAntilles("Wedge Antilles");


    private String name;

    Character(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
