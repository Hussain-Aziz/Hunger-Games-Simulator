package InteractableObjects;

import Scenes.Position;

/**
 * An interface for objects that can hold other objects
 */
public interface InteractableObjectOwner {
    /**
     * Adds an object to an owner
     */
    boolean take(InteractableObject object, Position position);

    /**
     * Removes an object from an owner
     */
    void drop(InteractableObject object);
}
