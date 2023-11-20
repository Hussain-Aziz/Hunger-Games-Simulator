package Characters.CharacterStates;

import Characters.NPC;

public class Talk implements CharacterState {
    public Talk(NPC npc) {
        npc.talk();
    }
    @Override
    public void prev(NPC npc) {
        npc.setState(Attack.name);
    }

    @Override
    public void next(NPC npc) {
        npc.setState(Give.name);
    }

    @Override
    public String toString() {
        return name;
    }

    public static final String name = "Talking";
}
