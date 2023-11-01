package InteractableObjects.Weapons.Attacks;

import Characters.Character;
import Characters.MainCharacter;
import Scenes.Position;

import java.util.Map;

public class MeleeAttack implements AttackBehaviour {

    private final int damage;
    private final int range;

    public MeleeAttack(int damage, int range) {
        this.damage = damage;
        this.range = range;
    }

    @Override
    public void attack(Character sender) {
        var scene = sender.getCurrentScene();
        var position = sender.getPosition();

        for (Map.Entry<Character, Position> entry : scene.getCharacters().entrySet()) {
            var character = entry.getKey();
            var characterPosition = entry.getValue();

            // can't attack yourself
            if (character == sender)
                continue;

            if (characterPosition.isInContact(position, range)) {
                character.takeDamage(damage);
                // only do prints for main character
                if (!(sender instanceof MainCharacter)) {
                    Singletons.UI.getInstance().print("You hit", character.getName(), "for", damage, "damage");
                }
            }
        }
    }

}
