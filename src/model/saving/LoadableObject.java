package model.saving;

import java.io.IOException;

public interface LoadableObject {
    Object loadObjectFrom(String path) throws IOException, ClassNotFoundException;
}
