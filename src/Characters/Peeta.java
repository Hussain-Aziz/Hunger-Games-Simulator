package Characters;

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
                }});
    }

    @Override
    public void interact() {
        UI.getInstance().print("Hello, I'm Peeta Mellark. Stay away from me");
    }
}
