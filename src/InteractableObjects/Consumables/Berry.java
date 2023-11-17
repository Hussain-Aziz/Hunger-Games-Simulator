package InteractableObjects.Consumables;

import InteractableObjects.Consumables.ConsumableBehaviours.*;
import Singletons.UI;

public class Berry extends Consumable {
    public Berry() {
        super("berry", "A berry. It looks poisonous", new Damage());
    }
    protected void throwWrapping() {
        UI.getInstance().print("You spit out the berry");
    }

    protected void consumeObject(){
        UI.getInstance().print("You eat the berry");
    }

    protected void openWrapping() {
        UI.getInstance().print("You suspiciously put the berry in your mouth");
    }
}
