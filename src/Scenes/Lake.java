package Scenes;

import Characters.Cato;
import Characters.Character;
import Characters.Effie;
import InteractableObjects.Consumables.Fish;
import InteractableObjects.Consumables.Water;
import InteractableObjects.Weapons.BowAndArrow;
import InteractableObjects.Enviornment.*;
import InteractableObjects.InteractableObject;

import java.util.HashMap;

public class Lake extends Scene {
    public Lake() {
        super(
                "Lake",
                "You are in the Lake. There are fish everywhere.",
                2,
                new HashMap<InteractableObject, Position>() {{
                    put(new Pond(), new Position(1, 0));
                    put(new Pond(), new Position(0, 1));
                    put(new BowAndArrow(), new Position(0, 0));
                    put(new Water(), new Position(0, 0));
                    put(new Fish(), new Position(0, 0));
                }},
                new HashMap<Character, Position>() {{
                    put(new Effie(), new Position(1, 1));
                }});
    }
}
