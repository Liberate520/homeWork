package com.britenight.MVP.Presenter;

import java.util.Map;
import java.util.function.Function;

public interface Fabric<E> {
    E create(Function<Map<String, String>, Map<String,String>> prompt);
}
