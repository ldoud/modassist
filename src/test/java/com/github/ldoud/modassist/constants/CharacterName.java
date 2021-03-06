package com.github.ldoud.modassist.constants;

public enum CharacterName {
    AskokaTano("Ahsoka Tano"),
    AsajjVentress("Asajj Ventress"),
    BB8("BB-8"),
    BiggsDarklighter("Biggs Darklighter"),
    BobaFett("Boba Fett"),
    CadBane("Cad Bane"),
    CaptainHanSolo("Captain Han Solo"),
    CommanderLukeSkywalker("Commander Luke Skywalker"),
    CloneWarsChewbacca("Clone Wars Chewbacca"),
    DarthMaul("Darth Maul"),
    DarthSion("Darth Sion"),
    DarthVader("Darth Vader"),
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
    HanSolo("Han Solo"),
    HothRebelScout("Hoth Rebel Scout"),
    JediConsular("Jedi Consular"),
    JynErso("Jyn Erso"),
    K2SO("K-2SO"),
    KyloRen("Kylo Ren"),
    Magmatrooper("Magmatrooper"),
    OldDaka("Old Daka"),
    PoeDameron("Poe Dameron"),
    PrincessLeia("Princess Leia"),
    R2D2("R2-D2"),
    ResistancePilot("Resistance Pilot"),
    ResistanceTrooper("Resistance Trooper"),
    RoyalGuard("Royal Guard"),
    SabineWren("Sabine Wren"),
    ScarifRebelPathfinder("Scarif Rebel Pathfinder"),
    Shoretrooper("Shoretrooper"),
    Snowtrooper("Snowtrooper"),
    SithAssassin("Sith Assassin"),
    StormtrooperHan("Stormtrooper Han"),
    TieFighterPilot("TIE Fighter Pilot"),
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
