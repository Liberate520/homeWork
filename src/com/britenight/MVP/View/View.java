package com.britenight.MVP.View;

import java.util.Map;

public interface View {
    void start();
    void print(String text);
    Map<String, String> prompt(Map<String, String> idTitle);
}
