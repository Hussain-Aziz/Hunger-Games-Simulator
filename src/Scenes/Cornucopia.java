package Scenes;

import Characters.Character;
import Characters.Peeta;
import InteractableObjects.Weapons.Dagger;
import InteractableObjects.Environment;
import InteractableObjects.InteractableObject;

import java.util.HashMap;

public class Cornucopia extends Scene {
    public Cornucopia() {
        super(
                "Cornucopia",
                "You are at the Cornucopia. There are weapons and supplies everywhere.",
                4,
                new HashMap<InteractableObject, Position>() {{
                    put(new Dagger(), new Position(0, 0));
                    
                   // put(new LargePotion, new Position(0,1))          			ADDING THE CONSUMABLE TO THE MAP(CORNUCOPIA)
                }},
                new HashMap<Character, Position>() {{
                    put(new Peeta(), new Position(0, 0));
                }});
    }

	@Override
	public Environment getEnv() {
		// TODO Auto-generated method stub
		return null;
	}
}
