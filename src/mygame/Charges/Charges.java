/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mygame.Charges;

/**
 *
 * @author mohamed.bendery
 */
public class Charges {
    
    private int damageValue;
    private int remainingBulletsNumber;
    
    public Charges(int damageValue, int remainingBulletsNumber){
        this.damageValue = damageValue;
        this.remainingBulletsNumber = remainingBulletsNumber; 
    }
    
    public void setDamageValue(int damageValue){
        this.damageValue = damageValue;
    }
    
    public int getDamageValue(){
        return this.damageValue;
    }
    
    public void setRemainingBulletsNumber(int remainingBulletsNumber){
        this.remainingBulletsNumber = remainingBulletsNumber;
    }
    
    public int getRemainingBulletsNumber(){
        return this.remainingBulletsNumber;
    }
    
    
    
}
