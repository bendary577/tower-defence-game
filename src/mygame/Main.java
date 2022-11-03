package mygame;

import com.jme3.app.SimpleApplication;
import com.jme3.input.InputManager;
import com.jme3.input.KeyInput;
import com.jme3.input.MouseInput;
import com.jme3.input.controls.ActionListener;
import com.jme3.input.controls.KeyTrigger;
import com.jme3.input.controls.MouseButtonTrigger;
import com.jme3.input.controls.Trigger;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.renderer.RenderManager;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;
import com.jme3.system.AppSettings;
import java.util.List;
import mygame.AppStates.GamePlayAppState;
import mygame.Charges.Charges;
import mygame.Towers.TowerControl;
import mygame.Towers.TowerUtil;

/**
 * This is the Main Class of your Game. You should only do initialization here.
 * Move your Logic into AppStates or Controls
 * @author normenhansen
 */
public class Main extends SimpleApplication {

    private GamePlayAppState gamePlayAppState;
    private final static Trigger TRIGGER_SELECT = new MouseButtonTrigger(MouseInput.BUTTON_LEFT);
    private final static Trigger TRIGGER_CHARGE = new KeyTrigger(KeyInput.KEY_SPACE);
    private final static String MAPPING_SELECT = "Select";
    private final static String MAPPING_CHARGE = "Charge";
    TowerUtil towerUtil;
    private int selected = -1;

        
    public static void main(String[] args) {
        
        Main app = new Main();
        
        //configure app settings
        AppSettings settings = new AppSettings(true); 
        settings.setTitle("Tower Defense Game");
        settings.useInput();
        app.setShowSettings(false);
        app.setDisplayFps(false);
        app.setDisplayStatView(false);
                
        //register input events in ipnut manager (associates actions with triggers)
        InputManager inputManager = app.getInputManager();
        
        app.start();
    }

    @Override
    public void simpleInitApp() {

        //visible mouse cursor
        flyCam.setDragToRotate(true);
        inputManager.setCursorVisible(true); 

        //init tower util class to select towers
        towerUtil = new TowerUtil(rootNode, inputManager, cam);
        
        inputManager.addMapping(MAPPING_SELECT, TRIGGER_SELECT);
        inputManager.addMapping(MAPPING_CHARGE, TRIGGER_CHARGE);
        
        gamePlayAppState = new GamePlayAppState();
        gamePlayAppState.initialize(stateManager, this);
        
        //game action for pressing left mouse button
        ActionListener SelectActionListener = (String name, boolean isPressed, float tpf) -> {
            if (name.equals(MAPPING_SELECT) && !isPressed) {
                //choose selected tower
                List<Geometry> towers = gamePlayAppState.getTowers();
                if(!towers.isEmpty()){
                    selected = towerUtil.selectTower(towers);
                }
            }
        };
        
         //game action for pressing left mouse button
        ActionListener ChargeActionListener = (String name, boolean isPressed, float tpf) -> {
//            System.out.println("**********************************************");
//            if (name.equals(MAPPING_CHARGE) && !isPressed) {
//                if(selected == -1){
//                    System.out.println("please select a tower to charge");
//                }else{
//                    System.out.println("charging tower...");
//                    if(gamePlayAppState.getBudget() != 0){
//                        TowerControl control = rootNode.getChild("Tower "+ selected).getControl(TowerControl.class);
//                        System.out.println("initial charges " + control.getCharges().size());
//                        control.getCharges().add(new Charges(5, 10));
//                        control.setChargesNumber(control.getChargesNumber()+1);
//                        System.out.println("final charges " + control.getCharges().size());
//                        
//                        System.out.println("name is " + control.getSpatial().getName());
//                    }
//                }
//            }
        };
        
        inputManager.addListener(SelectActionListener, new String[]{MAPPING_SELECT});
        inputManager.addListener(ChargeActionListener, new String[]{MAPPING_CHARGE});
    }

    @Override
    public void simpleUpdate(float tpf) {
        //TODO: add update code
    }

    @Override
    public void simpleRender(RenderManager rm) {
        //TODO: add render code
    }
}
