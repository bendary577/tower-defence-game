/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mygame.Creeps;

import com.jme3.math.Vector3f;
import com.jme3.renderer.RenderManager;
import com.jme3.renderer.ViewPort;
import com.jme3.scene.control.AbstractControl;
import mygame.AppStates.GamePlayAppState;

/**
 *
 * @author mohamed.bendery
 */
public class CreepControl extends AbstractControl {

    //for accessing the user state
    private GamePlayAppState gamePlayAppState;
    //creep's data
    private int index;
    private int health = 10;
    
    public CreepControl(GamePlayAppState gamePlayAppState){
        this.gamePlayAppState = gamePlayAppState;
    }
    
    @Override
    protected void controlUpdate(float f) {
        if(this.health > 0){
            System.out.print("moving ...");
            //if creep z-coordinates reaches tower z-coordinates, subtract 1 life from player
//            this.gamePlayAppState.setHealth(this.gamePlayAppState.getHealth()-1);
            //else move forward
            spatial.move(new Vector3f(0,1,0));
        }else if(this.health <= 0){
            //else increase player budget
            this.gamePlayAppState.setBudget(this.gamePlayAppState.getBudget()+1);
            //detatch itself
        }
        
    }

    @Override
    protected void controlRender(RenderManager rm, ViewPort vp) {
   
    }
    
}
