package Scenes;

import Characters.Character;
import Characters.Peeta;
import Characters.Rue;
import InteractableObjects.Consumables.Berry;
import InteractableObjects.Consumables.Fish;
import InteractableObjects.Weapons.Dagger;
import InteractableObjects.Enviornment.Tree;
import InteractableObjects.InteractableObject;
import InteractableObjects.Weapons.Slingshot;
import InteractableObjects.Weapons.Sword;

import java.util.HashMap;

public class Forest extends Scene {
    public Forest() {
        super(
                "Forest",
                "You are in the forest. There are trees everywhere.",
                2,
                new HashMap<InteractableObject, Position>() {{
                    put(new Tree(), new Position(1, 0));
                    put(new Tree(), new Position(0, 1));
                    put(new Sword(), new Position(0, 0));
                    put(new Berry(), new Position(0, 0));
                }},
                new HashMap<Character, Position>() {{
                    put(new Rue(), new Position(1, 1));
                }});
    }
}
