package Scenes;

import Characters.Character;
import Characters.Peeta;
import InteractableObjects.Consumables.*;
import InteractableObjects.Enviornment.Tree;
import InteractableObjects.InteractableObject;
import InteractableObjects.Weapons.*;

import java.util.HashMap;

public class Cornucopia extends Scene {
    public Cornucopia() {
        super(
                "Cornucopia",
                "You are at the Cornucopia. There are weapons and supplies everywhere.",
                2,
                new HashMap<InteractableObject, Position>() {{
                    put(new Dagger(), new Position(0, 0));
                    put(new Fish(), new Position(0, 1));
                    put(new Slingshot(), new Position(0, 1));
                    put(new Berry(), new Position(0, 1));
                }},
                new HashMap<Character, Position>() {{
                    put(new Peeta(), new Position(0, 1));
                }});
    }
}
