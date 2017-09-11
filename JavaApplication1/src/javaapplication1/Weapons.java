/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

/**
 *
 * @author bigmanlaptop
 */
public class Weapons {
    
    int damage;
    String damageType;
    String weaponType;
    String name;
    public Weapons()
    {
        damage =1;
        damageType = "versitile";
        weaponType = "shortSword";
        name = "";
    }
    
    public Weapons(int damage, String damageType, String weaponType, String name)
    {
        this.damage = damage;
        this.damageType = damageType;
        this.weaponType = weaponType;
        this.name = name;
    }
    
    public int getDamage()
    {
        return damage;
    }
    
    public void setDamage(int damage)
    {
        this.damage = damage;
    }
    
    public String getDamageType()
    {
        return damageType;
    }
    
    public void setDamageType(String damageType)
    {
        this.damageType = damageType;
    }
    
    public String weaponType()
    {
        return weaponType;
    }
    
    public void setWeaponType(String weaponType)
    {
        this.weaponType = weaponType;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setName( String name)
    {
        this.name = name;
    }
}
