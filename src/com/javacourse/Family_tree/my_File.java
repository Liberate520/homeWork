package com.javacourse.Family_tree;

import java.io.IOException;
import java.util.Scanner;

public interface my_File {
    Scanner file() throws IOException;
    String[] read();
    void write(Person human) throws IOException;
}
