package Characters.CharacterStates;

import Characters.NPC;
import Singletons.UI;

public class Give implements CharacterState {
    public Give(NPC npc) {
        String itemName = npc.giveItem();
        if (itemName != null) {
            UI.getInstance().print("Pick a " + itemName + "  if you want ");
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

    public static final String name = "Giving";
}
