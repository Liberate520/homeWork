package com.familytree;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class Utility {
    public static void writeTextToFile(Path path, List<String> lines) throws IOException {
        if (path.toFile().length() == 0) {
            for (String line : lines) {
                Files.writeString(path, line, StandardCharsets.UTF_8, StandardOpenOption.APPEND);
            }
        }
    }

    public static Person getPersonFromBFS(List<Person> pathToPerson) {
        return pathToPerson.get(pathToPerson.size() - 1);
    }

    public static int getShortestPathFromBFS(List<Person> pathToPerson) {
        return pathToPerson.size() - 1;
    }
}
