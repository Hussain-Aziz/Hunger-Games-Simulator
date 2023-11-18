package Characters.CharacterStates;

import Characters.NPC;

public interface CharacterState {
    void prev(NPC npc);
    void next(NPC npc);
}
