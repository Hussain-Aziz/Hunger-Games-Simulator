package Characters.CharacterStates;

import Characters.NPC;

public class Dormant implements CharacterState {
    @Override
    public void prev(NPC npc) {
        npc.setState(Talk.name);
    }
    @Override
    public void next(NPC npc) {
        npc.setState(Talk.name);
    }
    @Override
    public String toString() {
        return name;
    }
    public static final String name = "Dormant";
}
