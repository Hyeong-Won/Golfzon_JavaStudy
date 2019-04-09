package com.pl.mcu;

public class MCUVillain extends MCUCharacter{

    @Override
    public void specialAbility() {
        this.health += 200;
        this.power  += 5;
        System.out.println(toString());
    }

    public MCUVillain() {
        super();
        // TODO Auto-generated constructor stub
    }

    public MCUVillain(String name, int health, int power) {
        super(name, health, power);
        // TODO Auto-generated constructor stub
    }

}
