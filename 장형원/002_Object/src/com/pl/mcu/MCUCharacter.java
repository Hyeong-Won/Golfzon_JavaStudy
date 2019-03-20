package com.pl.mcu;

public class MCUCharacter {
    private String name;
    private int    health;
    private int    power;
    
    public MCUCharacter() {
        
    }
    
    public MCUCharacter(String name, int health, int power) {
        this.name   = name;
        this.health = health;
        this.power  = power;
        
        System.out.println(toString());
    }
    
    public void attack(MCUCharacter mcuCharacter) {
        if(mcuCharacter.health <= this.power) {
            System.out.println(this.name + "이(가) " + mcuCharacter.name + "에게 " + mcuCharacter.health + "만큼의 데미지를 입혔습니다.");
            mcuCharacter.health = 0;
            
        } else {
            System.out.println(this.name + "이(가) " + mcuCharacter.name + "에게 " + this.power + "만큼의 데미지를 입혔습니다.");
            mcuCharacter.health = mcuCharacter.health - this.power;    
        }
        
        System.out.println(mcuCharacter.name +"의 남은 생명 : " + mcuCharacter.health);
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getHeath() {
        return health;
    }
    public void setHeath(int health) {
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
    
    @Override
    protected void finalize() throws Throwable {
        // TODO Auto-generated method stub
        super.finalize();
        
        if(this.health == 0) {
            System.out.println(this.name + " 사망ㅠㅠ");
        }
        
    }
}
