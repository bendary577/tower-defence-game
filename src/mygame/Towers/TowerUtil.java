/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mygame.Towers;

import com.jme3.collision.CollisionResults;
import com.jme3.input.InputManager;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Ray;
import com.jme3.math.Vector2f;
import com.jme3.math.Vector3f;
import com.jme3.renderer.Camera;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import java.util.List;

/**
 *
 * @author mohamed.bendery
 */
public class TowerUtil {
    
    private final InputManager inputManager;
    private final Camera cam;
    private final Node rootNode;
        
    public TowerUtil( Node rootNode, InputManager inputManager, Camera cam){
        this.inputManager = inputManager;
        this.cam = cam;
        this.rootNode = rootNode;
    }
    
    public int selectTower(List<Geometry> towers){
        Geometry selectedGeometry;
        CollisionResults results = new CollisionResults();
        Vector2f click2d = this.inputManager.getCursorPosition(); //get cutsor mouse 2d position
        Vector3f clicked3d = this.cam.getWorldCoordinates(new Vector2f(click2d.getX(), click2d.getY()), 0f); //method to convert these (x,y) coordinates into (x,y,z)
        //subtract one point from another is the way to know the direction
        Vector3f dir = this.cam.getWorldCoordinates(new Vector2f(click2d.getX(), click2d.getY()), 1f).subtractLocal(clicked3d); //get direction of aiming from point of clicking
        Ray ray = new Ray(clicked3d, dir);
        rootNode.collideWith(ray, results);
        if (results.size() > 0) {
            // check if selection is of tower control
            selectedGeometry = results.getClosestCollision().getGeometry();
            if(true){
                selectedGeometry.getMaterial().setColor("Color", ColorRGBA.Green);
                for (int i = 0; i < towers.size(); i++) {
                    if(!towers.get(i).equals(selectedGeometry)){
                        towers.get(i).getMaterial().setColor("Color", ColorRGBA.Yellow);
                    }
                }
//                System.out.println(" selecting tower " + selectedGeometry.getUserData("index"));
                return selectedGeometry.getUserData("index");
            }else{
                // the geometry selected is not a tower
                return -1;
            }
        }else{
            System.out.println("you've selected nothing");
            return -1;
        }
    }
}
