package InteractableObjects.Consumables;

import InteractableObjects.Consumables.ConsumableBehaviours.Heal;
import Singletons.UI;

public class CarePack extends Consumable {
    public CarePack() {
        super("carepack", "A care package. It heals you");
    }

    protected void throwWrapping() {
        UI.getInstance().print("You throw the care package wrapping on the ground");
    }

    protected void consumeObject(){
        UI.getInstance().print("You use the care package");
    }

    protected void openWrapping() {
        UI.getInstance().print("You tear open the care package wrapping");
    }
}
