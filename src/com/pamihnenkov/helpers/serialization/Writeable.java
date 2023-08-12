package com.pamihnenkov.helpers.serialization;

import java.io.Serializable;

public interface Writeable {
    void save(Serializable serializable);
    Object load();
}
