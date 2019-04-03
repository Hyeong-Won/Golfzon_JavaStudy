package com.pl.mcu;

import com.pl.exception.InvalidDataException;

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

    public MCUVillain(String name, int health, int power) throws InvalidDataException {
        super(name, health, power);
        // TODO Auto-generated constructor stub
    }

}
