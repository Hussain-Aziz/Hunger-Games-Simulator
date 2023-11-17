package Characters.CharacterStates;

import Characters.NPC;

public class Attack implements CharacterState {

    @Override
    public void prev(NPC npc) {
        npc.setState(new Talk());
    }

    @Override
    public void next(NPC npc) {
        npc.setState(new Dormant());
    }

    @Override
    public void executeStateAction(NPC npc) {
        // TODO: implement attack
    }
}
