package Scenes;

import Characters.Character;
import Characters.Peeta;
import InteractableObjects.Consumables.Fish;
import InteractableObjects.Weapons.Dagger;
import InteractableObjects.Enviornment.Tree;
import InteractableObjects.InteractableObject;

import java.util.HashMap;

public class Cornucopia extends Scene {
    public Cornucopia() {
        super(
                "Cornucopia",
                "You are at the Cornucopia. There are weapons and supplies everywhere.",
                2,
                new HashMap<InteractableObject, Position>() {{
                    put(new Dagger(), new Position(0, 0));
                    put(new Fish(), new Position(0, 0));
                    put(new Tree(), new Position(0, 1));

                   // put(new LargePotion, new Position(0,1))          			ADDING THE CONSUMABLE TO THE MAP(CORNUCOPIA)
                }},
                new HashMap<Character, Position>() {{
                    put(new Peeta(), new Position(1, 0));
                }});
    }

	@Override
	public Tree getEnv() {
		// TODO Auto-generated method stub
		return null;
	}
}
