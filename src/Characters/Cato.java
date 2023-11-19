package Characters;

import InteractableObjects.Consumables.Berry;
import InteractableObjects.Consumables.Fish;
import InteractableObjects.Weapons.Dagger;
import InteractableObjects.Weapons.Sword;
import InteractableObjects.InteractableObject;
import Singletons.UI;

import java.util.ArrayList;

public class Cato extends NPC {
    public Cato() {
        super("Cato Hadley",
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
        UI.getInstance().print("I'm Cato Hadley and I'm coming for you");
    }
}
