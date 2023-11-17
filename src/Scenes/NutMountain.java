package Scenes;

import Characters.Character;
import InteractableObjects.Weapons.Dagger;
import InteractableObjects.Enviornment.Mountain;
import InteractableObjects.Enviornment.Tree;
import InteractableObjects.InteractableObject;

import java.util.HashMap;

public class NutMountain extends Scene {
    public NutMountain() {
        super(
                "Nut Mountain",
                "You are in the Nut Mountain Area. There are Mountains everywhere.",
                4,
                new HashMap<InteractableObject, Position>() {{
                	
                    //put(new Dagger(), new Position(0, 0));
                	// TODO add other interactable objects like what ?
                }},
                new HashMap<Character, Position>() {{
                }});
    
    }
//    public Mountain getEnv() {
//    	
//    	for (InteractableObject currentObject: interactableObjects.keySet())
//    	{
//    		if (currentObject instanceof Mountain)
//    		{
//    			return (Mountain)currentObject;
//    		}
//    	}
//    	
//    	return null;
//    	
//    }

	@Override
	public Tree getEnv() {
		// TODO Auto-generated method stub
		return null;
	}
}
