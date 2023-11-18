package Characters.MainCharacterCommands;

import Characters.Katniss;
import Characters.NPC;
import Singletons.UI;

public class Interact implements CharacterCommand {
    private final Katniss katniss;

    public Interact(Katniss katniss) {
        this.katniss = katniss;
    }
    @Override
    public void execute(String[] args) {
        if (args.length == 1) {
            UI.getInstance().print("I can't interact with nothing");
            return;
        }
        var npc = katniss.getCurrentScene().getNearbyNPC(katniss);

        if (npc != null) {

            boolean equals = true;

            var npcName = npc.getName().toLowerCase().split(" ");

            for (int i = 1; i < args.length && i < npcName.length + 1; i++) {
                if (!args[i].toLowerCase().equals(npcName[i - 1])) {
                    equals = false;
                }
            }

            if (equals) {
                katniss.interactWithNPC(npc);
                return;
            }
        }

        UI.getInstance().print("I can't interact with that");
    }

    @Override
    public String[] getAliases() {
        return new String[]{"interact", "talk", "speak", "converse"};
    }

    @Override
    public String getDescription() {
        return "Interact with an NPC (args: npc name)";
    }
}
