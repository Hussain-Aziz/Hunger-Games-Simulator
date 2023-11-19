package Characters;

import InteractableObjects.Consumables.Berry;
import InteractableObjects.Consumables.Fish;
import InteractableObjects.InteractableObject;
import InteractableObjects.Weapons.Sword;
import Singletons.UI;

import java.util.ArrayList;

public class Effie extends NPC {
    public Effie() {
        super("Effie Trinket",
                2,
                new ArrayList<InteractableObject>() {{
                    add(new Sword());
                    add(new Fish());
                    add(new Berry());
                    add(new Berry());
                }});
    }

    @Override
    public void talk() {
        UI.getInstance().print("I'm Effie Trinket and I'm here to help you on your journey!");
    }
}
