package net.mrliuli.generics.bounds;

/**
 * Created by leon on 2017/12/7.
 */

import java.util.List;

/**
 * 更多层次
 */

interface SuperPower{}
interface XRayVision extends SuperPower{
    void seeThroughWalls();
}
interface SuperHearing extends SuperPower{
    void hearSubtleNoise();
}
interface SuperSmell extends SuperPower{
    void trackBySmell();
}

class SuperHero<POWER extends SuperPower>{
    POWER power;
    SuperHero(POWER power){ this.power = power; }
    POWER getPower() { return power; }
}

class SuperSleuth<POWER extends XRayVision> extends SuperHero<POWER> {
    SuperSleuth(POWER power) { super(power); }
    void see() { power.seeThroughWalls(); }
}

class CanineHero<POWER extends SuperHearing & SuperSmell> extends SuperHero<POWER>{
    CanineHero(POWER power) { super(power); }
    void hear() { power.hearSubtleNoise(); }
    void smell() { power.trackBySmell(); }
}
class SuperHearSmell implements SuperHearing, SuperSmell {
    public void hearSubtleNoise() {}
    public void trackBySmell() {}
}

class DogBoy extends CanineHero<SuperHearSmell> {
    DogBoy() { super(new SuperHearSmell()); }
}

public class EpicBattle {
    // Bounds in generic methods:
    static <POWER extends SuperHearing> void useSuperHearing(SuperHero<POWER> hero){
        hero.getPower().hearSubtleNoise();
    }

    static <POWER extends SuperHearing & SuperSmell> void superFind(SuperHero<POWER> hero){
        hero.getPower().hearSubtleNoise();
        hero.getPower().trackBySmell();
    }

    public static void main(String[] args){
        DogBoy dogBoy = new DogBoy();
        useSuperHearing(dogBoy);
        superFind(dogBoy);
        // You can do this:
        List<? extends SuperHearing> audioBoys;
        // But you can't do this:
        // List<? extends SuperHearing & SuperSmell> dogBoy;
    }
}
