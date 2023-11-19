package Scenes;

import Characters.Cato;
import Characters.Character;
import Characters.Rue;
import InteractableObjects.Consumables.Berry;
import InteractableObjects.Consumables.Water;
import InteractableObjects.Weapons.BowAndArrow;
import InteractableObjects.Weapons.Dagger;
import InteractableObjects.Enviornment.Mountain;
import InteractableObjects.Enviornment.Tree;
import InteractableObjects.InteractableObject;
import InteractableObjects.Weapons.Slingshot;
import InteractableObjects.Weapons.Sword;

import java.util.HashMap;

public class NutMountain extends Scene {
    public NutMountain() {
        super(
                "Nut Mountain",
                "You are in the Nut Mountain Area. There are Mountains everywhere.",
                2,
                new HashMap<InteractableObject, Position>() {{
                    put(new Mountain(), new Position(1, 0));
                    put(new Mountain(), new Position(0, 1));
                    put(new Slingshot(), new Position(0, 0));
                    put(new Water(), new Position(0, 0));
                }},
                new HashMap<Character, Position>() {{
                    put(new Cato(), new Position(1, 1));
                }});

    }
}
