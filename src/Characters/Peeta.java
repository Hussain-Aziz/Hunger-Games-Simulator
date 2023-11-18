package Characters;

import InteractableObjects.Consumables.Berry;
import InteractableObjects.Weapons.Dagger;
import InteractableObjects.InteractableObject;
import Singletons.UI;

import java.util.ArrayList;

public class Peeta extends NPC {
    public Peeta() {
        super("Peeta Mellark",
                2,
                new ArrayList<InteractableObject>() {{
                    add(new Dagger());
                    add(new Berry());
                    add(new Berry());
                    add(new Berry());
                }});
    }

    @Override
    public void talk() {
        UI.getInstance().print("Hello, I'm Peeta Mellark. Stay away from me");
    }
}
