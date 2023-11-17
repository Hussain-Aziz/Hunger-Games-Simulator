package Characters.CharacterStates;

import Characters.NPC;
import InteractableObjects.InteractableObject;
import InteractableObjects.Weapons.Weapon;
import Singletons.UI;

public class Attack implements CharacterState {

    public Attack(NPC npc) {
        for (InteractableObject object : npc.getInventory()) {
            if (object instanceof Weapon) {
                UI.getInstance().print("I will attack you with ", object.getName());
                ((Weapon) object).attack(npc);
            }
        }
    }

    @Override
    public void prev(NPC npc) {
        npc.setState(new Talk(npc));
    }

    @Override
    public void next(NPC npc) {
        npc.setState(new Attack(npc));
    }
}
