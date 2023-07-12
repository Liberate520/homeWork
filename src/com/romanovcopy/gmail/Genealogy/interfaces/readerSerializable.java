package com.romanovcopy.gmail.Genealogy.interfaces;

import java.io.Serializable;

public interface readerSerializable<T> extends Serializable{
    T read();
}
