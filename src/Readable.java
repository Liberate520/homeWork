package src;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public interface Readable {
    Object loadFile(@NotNull String path) throws IOException, ClassNotFoundException;
}
