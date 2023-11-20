package Characters.CharacterStates;

import Characters.NPC;
import InteractableObjects.InteractableObject;
import InteractableObjects.Weapons.Weapon;
import Singletons.UI;

public class Attack implements CharacterState {

    public Attack(NPC npc) {
        for (InteractableObject object : npc.getInventory()) {
            if (object instanceof Weapon) {
                UI.getInstance().print(npc.getName(), ": I will attack you with", object.getName());
                ((Weapon) object).attack(npc);
            }
        }
    }

    @Override
    public void prev(NPC npc) {
        npc.setState(Talk.name);
    }

    @Override
    public void next(NPC npc) {
        npc.setState(Attack.name);
    }

    @Override
    public String toString() {
        return name;
    }

    public static final String name = "Attacking";
}
