package com.github.ldoud.modassist.constants;

public enum Character {
    AskokaTano("Ahsoka Tano"),
    BiggsDarklighter("Biggs Darklighter"),
    BobaFett("Boba Fett"),
    CadBane("Cad Bane"),
    CaptainHanSolo("Captain Han Solo"),
    CommanderLukeSkywalker("Commander Luke Skywalker"),
    CloneWarsChewbacca("Clone Wars Chewbacca"),
    DarthMaul("Darth Maul"),
    DarthSion("Darth Sion"),
    DeathTrooper("Death Trooper"),
    EmperorPalpatine("Emperor Palpatine"),
    FirstOrderTIEPilot("First Order TIE Pilot"),
    GeneralKenobi("General Kenobi"),
    GrandAdmiralThrawn("Grand Admiral Thrawn"),
    GrandMoffTarkin("Grand Moff Tarkin"),
    GrandMasterYoda("Grand Master Yoda"),
    HothRebelScout("Hoth Rebel Scout"),
    JediConsular("Jedi Consular"),
    JynErso("Jyn Erso"),
    K2SO("K-2SO"),
    Magmatrooper("Magmatrooper"),
    OldDaka("Old Daka"),
    PrincessLeia("Princess Leia"),
    ResistancePilot("Resistance Pilot"),
    ResistanceTrooper("Resistance Trooper"),
    RoyalGuard("Royal Guard"),
    SabineWren("Sabine Wren"),
    Shoretrooper("Shoretrooper"),
    SithAssassin("Sith Assassin"),
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
