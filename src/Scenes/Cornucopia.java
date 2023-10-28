package Scenes;

import Characters.Character;
import Characters.Peeta;
import InteractableObjects.Dagger;
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
                }},
                new HashMap<Character, Position>() {{
                    put(new Peeta(), new Position(0, 0));
                }});
    }
}
