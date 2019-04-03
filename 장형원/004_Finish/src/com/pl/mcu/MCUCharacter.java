package com.pl.mcu;

import com.pl.exception.*;

public abstract class MCUCharacter{
    protected String name;
    protected int    health;
    protected int    power;
    
    public abstract void specialAbility();
    
    public void attack(MCUCharacter mcuCharacter) {
        if(mcuCharacter.health <= this.power) {
            System.out.print(this.name + "이(가) " + mcuCharacter.name + "에게 " + mcuCharacter.health + "만큼의 데미지를 입혔습니다. ");
            mcuCharacter.health = 0;
            
        } else {
            System.out.print(this.name + "이(가) " + mcuCharacter.name + "에게 " + this.power + "만큼의 데미지를 입혔습니다. ");
            mcuCharacter.health = mcuCharacter.health - this.power;    
        }
        
        System.out.println(mcuCharacter.name +"의 남은 생명 : " + mcuCharacter.health);
    }

    public void fight() {
        
    }
    
    public MCUCharacter() {
        super();
    }

    public MCUCharacter(String name, int health, int power) throws InvalidDataException{
        super();
        this.name = name;
        this.health = health;
        this.power = power;
        
        if(health >= 100000 || power >= 1000) {
            throw new InvalidDataException(name + "의 능력치가 너무나도 터무니 없습니다.");
        }
        
        System.out.println(toString());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    @Override
    public String toString() {
        return "MCUCharacter [name=" + name + ", health=" + health + ", power=" + power + "]";
    }
    
    
}
