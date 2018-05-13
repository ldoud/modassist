package com.github.ldoud.modassist.sets;

import com.github.ldoud.modassist.data.Mod;

import java.util.Comparator;

public class ModSpeedComparator implements Comparator<Mod> {

    @Override
    public int compare(Mod m1, Mod m2) {
        int speedOfMod1 = m1 != null ? m1.getSpeed() : 0;
        int speedOfMod2 = m2 != null ? m2.getSpeed() : 0;

        return speedOfMod2 - speedOfMod1;
    }
}
