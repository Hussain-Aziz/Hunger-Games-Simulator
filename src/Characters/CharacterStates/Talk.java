package Characters.CharacterStates;

import Characters.NPC;

public class Talk implements CharacterState {
    public Talk(NPC npc) {
        npc.talk();
    }
    @Override
    public void prev(NPC npc) {
        npc.setState(new Attack(npc));
    }

    @Override
    public void next(NPC npc) {
        npc.setState(new Give(npc));
    }

    @Override
    public String toString() {
        return "Talking";
    }
}
