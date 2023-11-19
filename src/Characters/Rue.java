package Characters;

import InteractableObjects.Consumables.Berry;
import InteractableObjects.Consumables.Fish;
import InteractableObjects.Weapons.Slingshot;
import InteractableObjects.InteractableObject;
import Singletons.UI;

import java.util.ArrayList;

public class Rue extends NPC {
    public Rue() {
        super("Rue Barnette",
                2,
                new ArrayList<InteractableObject>() {{
                    add(new Slingshot());
                    add(new Fish());
                    add(new Berry());
                    add(new Berry());
                }});
    }

    @Override
    public void talk() {
        UI.getInstance().print("Hello, I'm Peeta Mellark. Stay away from me");
    }
}
