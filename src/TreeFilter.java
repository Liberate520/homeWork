package src;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

public class TreeFilter<T extends It> {

    public List<T> filter(List<T> filteringLst, String filterStr, Function<T, String> property, FilterType filterType) {
        List<T> result = new ArrayList<>();
        if (!filteringLst.isEmpty()) {
            if (filterStr.isEmpty()) {
                result.addAll(filteringLst);
            } else {
                Dates day = new Dates();
                for (T h : filteringLst) {
                    switch (filterType) {
                        case STRING -> {
                            if (Objects.equals(property.apply(h), filterStr)) {
                                result.add(h);
                            }
                        }
                        case DATE_FROM -> {
                            if (day.datesCompare(filterStr, property.apply(h))) {
                                result.add(h);
                            }
                        }
                        case DATE_TO -> {
                            if (day.datesCompare(property.apply(h), filterStr)) {
                                result.add(h);
                            }
                        }
                    }
                }
            }
        }
        return result;
    }
}
