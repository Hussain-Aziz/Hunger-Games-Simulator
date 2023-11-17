package Scenes;

import Characters.Character;
import InteractableObjects.Weapons.Dagger;
import InteractableObjects.Enviornment.Tree;
import InteractableObjects.InteractableObject;

import java.util.HashMap;

public class Forest extends Scene {
    public Forest() {
        super(
                "Forest",
                "You are in the forest. There are trees everywhere.",
                4,
                new HashMap<InteractableObject, Position>() {{
                	
                    put(new Dagger(), new Position(0, 0));
                   //put(new Environment("Forest", "Forest description"), new Position(3,3));
//                    put(new Tree("Forest", "Forest description"), new Position(2,3));
//                    put(new Tree("Forest", "Forest description"), new Position(3,2));
                }},
                new HashMap<Character, Position>() {{
                }});
    
    }
    public Tree getEnv() {
    	
    	for (InteractableObject currentObject: interactableObjects.keySet())
    	{
    		if (currentObject instanceof Tree)
    		{
    			return (Tree)currentObject;
    		}
    	}
    	
    	return null;
    	
    }
}
