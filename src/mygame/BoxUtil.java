/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mygame;

import com.jme3.asset.AssetManager;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;

/**
 *
 * @author mohamed.bendery
 */
public class BoxUtil {
    
    public Geometry createBox(int x, int y, int z, String name, float scale, Vector3f location, ColorRGBA color, AssetManager assetManager){ 
        Box box = new Box(location, x,y,z);
        Geometry geometry = new Geometry(name, box);
        geometry.scale(scale);
        Material towerMat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md"); 
        towerMat.setColor("Color", color);
        geometry.setMaterial(towerMat);
        return geometry;
    }
    
}
