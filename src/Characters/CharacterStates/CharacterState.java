package Characters.CharacterStates;

import Characters.NPC;

public interface CharacterState {
    public void prev(NPC npc);
    public void next(NPC npc);
    public void executeStateAction(NPC npc);
}
