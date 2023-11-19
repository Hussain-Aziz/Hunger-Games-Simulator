package InteractableObjects.Consumables;

import InteractableObjects.Consumables.ConsumableBehaviours.Heal;
import Singletons.UI;

public class Water extends Consumable {
    public Water() {
        super("Water", "Water. helps heal and quench your player's thirst ");
    }

    protected void throwWrapping() {
        UI.getInstance().print("You throw the bottle on the ground");
    }

    protected void consumeObject(){
        UI.getInstance().print("You drink the water");
    }

    protected void openWrapping() {
        UI.getInstance().print("You open the water bottle");
    }
}
