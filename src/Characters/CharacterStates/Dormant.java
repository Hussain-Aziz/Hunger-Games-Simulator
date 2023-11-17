package Characters.CharacterStates;

import Characters.NPC;

public class Dormant implements CharacterState {

    @Override
    public void prev(NPC npc) {
        npc.setState(new Talk());
    }

    @Override
    public void next(NPC npc) {
        npc.setState(new Talk());
    }

    @Override
    public void executeStateAction(NPC npc) {
        // pass
    }
}
