package InteractableObjects;

import Scenes.Position;

/**
 * An interface for objects that can hold other objects
 */
public interface InteractableObjectOwner {
    /**
     * Adds an object to an owner
     */
    public boolean take(InteractableObject object, Position position);

    /**
     * Removes an object from an owner
     */
    public void drop(InteractableObject object);
}
