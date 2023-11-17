package Characters.CharacterStates;

import Characters.NPC;
import Singletons.UI;

public class Talk implements CharacterState {
    public Talk(NPC npc) {
        npc.interact();
    }
    @Override
    public void prev(NPC npc) {
        npc.setState(new Attack(npc));
    }

    @Override
    public void next(NPC npc) {
        npc.setState(new Give(npc));
    }
}
