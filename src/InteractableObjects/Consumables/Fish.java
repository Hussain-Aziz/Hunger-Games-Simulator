package InteractableObjects.Consumables;

import InteractableObjects.Consumables.ConsumableBehaviours.Heal;
import Singletons.UI;

public class Fish extends Consumable {
    public Fish() {
        super("Fish", "A fish. It looks delicious");
    }

    protected void throwWrapping() {
        UI.getInstance().print("You throw the fish bones on the ground");
    }

    protected void consumeObject(){
        UI.getInstance().print("You eat the fish");
    }

    protected void openWrapping() {
        UI.getInstance().print("You remove the fish outer scales");
    }
}
