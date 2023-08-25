package com.javacourse.view;

import java.io.IOException;

public interface View {
    void start() throws IOException;
    void printAnswer(String answer);
    
}
