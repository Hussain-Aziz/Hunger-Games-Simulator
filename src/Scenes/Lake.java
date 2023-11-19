package Scenes;

import Characters.Character;
import InteractableObjects.Weapons.Dagger;
import InteractableObjects.Enviornment.Tree;
import InteractableObjects.InteractableObject;
import InteractableObjects.Consumables.Fish;

import java.util.HashMap;

public class Lake extends Scene {
    public Lake() {
        super(
                "Lake",
                "You are in the Lake. There are fish everywhere.",
                4,
                new HashMap<InteractableObject, Position>() {{
                    put(new Fish(), new Position(0, 0));//what TODO with position? allscenes
                }},
                new HashMap<Character, Position>() {{
                }});
    }
}
