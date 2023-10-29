package Scenes;

import Characters.Character;
import InteractableObjects.Weapons.Dagger;
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
                }},
                new HashMap<Character, Position>() {{
                }});
    }
}
