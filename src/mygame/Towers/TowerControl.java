/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mygame.Towers;

import com.jme3.renderer.RenderManager;
import com.jme3.renderer.ViewPort;
import com.jme3.scene.control.AbstractControl;
import java.util.ArrayList;
import java.util.List;
import mygame.AppStates.GamePlayAppState;
import mygame.Charges.Charges;

/**
 *
 * @author mohamed.bendery
 */
public class TowerControl extends AbstractControl{
    
    //for accessing the user state
    private GamePlayAppState gamePlayAppState;
    //creep's data
    private int index;
    private int chargesNumber = 10;
    private List<Charges> charges;
    private List<Integer> reachables;
    private String name;
    
    public TowerControl(GamePlayAppState gamePlayAppState){
        this.gamePlayAppState = gamePlayAppState;
        
        //initialize 10 charges
        this.charges = new ArrayList();
        for(int i=0; i< this.chargesNumber; i++){
            Charges charge = new Charges(5, 10);
            this.charges.add(charge);
        }
    }
    
    @Override
    protected void controlUpdate(float f) {
        //control distance to nearest creep
        
        //if dis. is near, collect into reachables
        
        //if reachables are not empty, fire charges
        
    }

    @Override
    protected void controlRender(RenderManager rm, ViewPort vp) {
        
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getChargesNumber() {
        return chargesNumber;
    }

    public void setChargesNumber(int chargesNumber) {
        this.chargesNumber = chargesNumber;
    }

    public List<Charges> getCharges() {
        return charges;
    }

    public void setCharges(List<Charges> charges) {
        this.charges = charges;
    }

    public List<Integer> getReachables() {
        return reachables;
    }

    public void setReachables(List<Integer> reachables) {
        this.reachables = reachables;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
    
}
