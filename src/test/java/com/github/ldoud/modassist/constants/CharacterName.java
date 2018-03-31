package com.github.ldoud.modassist.constants;

public enum CharacterName {
    AskokaTano("Ahsoka Tano"),
    AsajjVentress("Asajj Ventress"),
    BiggsDarklighter("Biggs Darklighter"),
    BobaFett("Boba Fett"),
    CadBane("Cad Bane"),
    CaptainHanSolo("Captain Han Solo"),
    CommanderLukeSkywalker("Commander Luke Skywalker"),
    CloneWarsChewbacca("Clone Wars Chewbacca"),
    DarthMaul("Darth Maul"),
    DarthSion("Darth Sion"),
    DeathTrooper("Death Trooper"),
    DirectorKrennic("Director Krennic"),
    EmperorPalpatine("Emperor Palpatine"),
    EwokElder("Ewok Elder"),
    FirstOrderStormtrooper("First Order Stormtrooper"),
    FirstOrderTIEPilot("First Order TIE Pilot"),
    GeneralKenobi("General Kenobi"),
    GeneralVeers("General Veers"),
    GrandAdmiralThrawn("Grand Admiral Thrawn"),
    GrandMoffTarkin("Grand Moff Tarkin"),
    GrandMasterYoda("Grand Master Yoda"),
    HothRebelScout("Hoth Rebel Scout"),
    JediConsular("Jedi Consular"),
    JynErso("Jyn Erso"),
    K2SO("K-2SO"),
    KyloRen("Kylo Ren"),
    Magmatrooper("Magmatrooper"),
    OldDaka("Old Daka"),
    PrincessLeia("Princess Leia"),
    ResistancePilot("Resistance Pilot"),
    ResistanceTrooper("Resistance Trooper"),
    RoyalGuard("Royal Guard"),
    SabineWren("Sabine Wren"),
    Shoretrooper("Shoretrooper"),
    SithAssassin("Sith Assassin"),
    StormtrooperHan("Stormtrooper Han"),
    WedgeAntilles("Wedge Antilles"),
    ZamWesell("Zam Wesell");


    private String name;

    CharacterName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
