package Characters.CharacterStates;

import Characters.NPC;
import Singletons.UI;

public class Talk implements CharacterState {

    @Override
    public void prev(NPC npc) {
        npc.setState(new Dormant());
    }

    @Override
    public void next(NPC npc) {
        npc.setState(new Attack());
    }

    @Override
    public void executeStateAction(NPC npc) {
        npc.interact();
        String itemName = npc.giveItem();
        if (itemName != null) {
            UI.getInstance().print("Take this " + itemName);
        }
    }
}
