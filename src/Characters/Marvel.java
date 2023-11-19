package Characters;

import InteractableObjects.Consumables.Berry;
import InteractableObjects.Consumables.Fish;
import InteractableObjects.InteractableObject;
import InteractableObjects.Weapons.Spear;
import Singletons.UI;

import java.util.ArrayList;

public class Marvel extends NPC {
    public Marvel() {
        super("Marvel",
                2,
                new ArrayList<InteractableObject>() {{
                    add(new Spear());
                    add(new Fish());
                    add(new Berry());
                    add(new Berry());
                }});
    }

    @Override
    public void talk() {
        UI.getInstance().print("I'm Marvel and I'm here to help you on your journey if you want us to be partners");
    }
}
