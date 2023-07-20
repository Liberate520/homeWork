package org.genealogy.view;

import java.io.IOException;

public interface View {
    void printAnswer(String text);
    void start() throws IOException, ClassNotFoundException;
}
