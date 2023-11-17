package Characters.MainCharacterCommands;

import Characters.Katniss;
import InteractableObjects.InteractableObject;
import Singletons.UI;

public class Inventory implements CharacterCommand {
    private final Katniss katniss;

    public Inventory(Katniss katniss) {
        this.katniss = katniss;
    }
    @Override
    public void execute(String[] args) {
        katniss.printInventory();
    }

    @Override
    public String[] getAliases() {
        return new String[]{"inventory", "inv"};
    }

    @Override
    public String getDescription() {
        return "Prints all inventory items";
    }
}
