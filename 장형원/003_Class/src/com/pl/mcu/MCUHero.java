package com.pl.mcu;

public class MCUHero extends MCUCharacter implements MCUAvengers{

    @Override
    public void specialAbility() {
        this.power += 10; 
        System.out.println(toString());
    }

    @Override
    public void uniform() {
        System.out.println(this.name + " 유니폼 장착");
    }

    public MCUHero() {
        super();
        // TODO Auto-generated constructor stub
        uniform();
    }

    public MCUHero(String name, int health, int power) {
        super(name, health, power);
        // TODO Auto-generated constructor stub
        uniform();
    }
    
    
}
