package tree.handlers;

import tree.interfaces.Handler;
import tree.interfaces.Saveable;

public abstract class FileHandler implements Handler {
    private Saveable object;

    public FileHandler(Saveable object) {
        this.object = object;
    }

}
