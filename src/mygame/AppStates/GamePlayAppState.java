/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mygame.AppStates;

import com.jme3.app.Application;
import com.jme3.app.SimpleApplication;
import com.jme3.app.state.AbstractAppState;
import com.jme3.app.state.AppStateManager;
import com.jme3.asset.AssetManager;
import com.jme3.collision.CollisionResults;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.FastMath;
import com.jme3.math.Ray;
import com.jme3.math.Vector3f;
import com.jme3.renderer.Camera;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.shape.Box;
import java.util.ArrayList;
import java.util.List;
import mygame.BoxUtil;
import mygame.Creeps.CreepControl;
import mygame.Towers.TowerControl;
import mygame.Towers.TowerUtil;

/**
 *
 * @author mohamed.bendery
 */
public class GamePlayAppState extends AbstractAppState {
    
    //general app state info
    private SimpleApplication app;
    private Camera cam;
    private Node rootNode;
    private AssetManager assetManager;
    private Ray ray = new Ray();
    private static Box mesh = new Box(Vector3f.ZERO, 1, 1, 1);
    private List<Geometry> towers;
    private List<Geometry> creeps;
    private int creepsNumberInGame = 40;
    //utils
    BoxUtil boxUtil = new BoxUtil();
    //player state data
    private int level;
    private int score;
    private int health;
    private int budget;
    private boolean lastGameWon;
    
    
    @Override
    public void update(float tpf) {
        //check if player has lost
        if(health <= 0){
            this.lastGameWon = false;
            //detach gameplayappstate object and end game
            
        }else if(health > 0 && this.creeps.isEmpty()){
            // player has won
            this.lastGameWon = true;
            //detach gameplayappstate object and end game
        }
        //else continue game
    }
    
    @Override
    public void cleanup() {}
    
    @Override
    public void initialize(AppStateManager stateManager, Application app) {
        super.initialize(stateManager, app);
        this.app = (SimpleApplication) app;
        this.cam = this.app.getCamera();
        this.rootNode = this.app.getRootNode();
        this.assetManager = this.app.getAssetManager();
        
        createTowers();
    }
    
    public void createTowers(){
        //create right tower
        Geometry rightTowerGeometry = boxUtil.createBox(5, 1, 1, "Tower "+1 , 0.25f , new Vector3f(5,5,0), ColorRGBA.Yellow, assetManager);
        rightTowerGeometry.addControl(new TowerControl(this));
        rightTowerGeometry.setUserData("index", 1);
        rightTowerGeometry.setUserData("chargesNumber", 10);
        rightTowerGeometry.setUserData("name", "Tower "+1);
        this.rootNode.attachChild(rightTowerGeometry);
        
        //create left tower
        Geometry leftTowerGeometry = boxUtil.createBox(5, 1, 1, "Tower "+2, 0.25f , new Vector3f(-8,5,0), ColorRGBA.Orange, assetManager);
        leftTowerGeometry.addControl(new TowerControl(this));
        leftTowerGeometry.setUserData("index", 2);
        leftTowerGeometry.setUserData("chargesNumber", 10);
        leftTowerGeometry.setUserData("name", "Tower "+2);
        this.rootNode.attachChild(leftTowerGeometry);
        
        towers = new ArrayList<>();
        towers.add(rightTowerGeometry);
        towers.add(leftTowerGeometry);
        
        
        //create creeps (must gradually spawn new creeps)
        this.creeps = new ArrayList<>();
        for(int i = 0; i < this.creepsNumberInGame; i++){
            //random locations on x,y coordinates. fixed on y-axis point(-30)
            Vector3f location = new Vector3f(FastMath.nextRandomInt(-30, 0),-30 ,FastMath.nextRandomInt(-30, 0));
            Geometry creep = this.boxUtil.createBox(1, 1, 1, "Creep", 0.25f, location, ColorRGBA.Blue, assetManager);
            creep.addControl(new CreepControl(this));
            creep.setUserData("index", i);
            creep.setUserData("health", 10);
            this.rootNode.attachChild(creep);
            this.creeps.add(creep);
        }

    }
    
    public List<Geometry> getTowers(){
        if(towers == null){
            return new ArrayList<Geometry>();
        }else{
            return this.towers;
        }
    }
    
    public void setHealth(int health){
        this.health = health;
    }
    
    public int getHealth(){
        return this.health;
    }
    
    public void setBudget(int budget){
        this.budget = budget;
    }
    
    public int getBudget(){
        return this.budget;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public boolean isLastGameWon() {
        return lastGameWon;
    }

    public void setLastGameWon(boolean lastGameWon) {
        this.lastGameWon = lastGameWon;
    }
    
    

    
}
