package InteractableObjects.Weapons.Attacks;

import Characters.Character;
import Characters.MainCharacter;
import MessageArchitecture.Message;
import Scenes.Position;

import java.util.Map;

public class MeleeAttack implements AttackBehaviour {
    private final int damage;

    public MeleeAttack(int damage) {
        this.damage = damage;
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

            if (characterPosition.isInContact(position, 1)) {
                character.takeDamage(damage);
                sender.publishMessage(new Message(sender, "damage", damage + " damage to " + character.getName()));

                // required to return because we may edit the hashmap which throw exception if we try to continue looping
                // so a patch fix to just not loop anymore
                // anyways theres never more than 1 character in a scene so it's fine
                return;
            }
        }
    }

}
