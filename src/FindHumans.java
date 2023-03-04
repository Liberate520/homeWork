package src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.function.Function;

public class FindHumans<T extends It> {

    public List<T> findHumans(
            List<T> family,
//            String gender,
//            String firstName,
//            String patronymic,
//            String lastName,
//            String dateOfBornFrom,
//            String dateOfBornTo,
//            String dateOfDeathFrom,
//            String dateOfDeathTo,
//            String placeOfBirth
            HashMap<String, String> hashMap
    ) {
        List<T> result = new ArrayList<>();
        TreeFilter<T> tr = new TreeFilter<>();
        String gender = hashMap.get("gender");
        String firstName = hashMap.get("firstName");
        String patronymic = hashMap.get("patronymic");
        String lastName = hashMap.get("lastName");
        String dateOfBornFrom = hashMap.get("dateOfBornFrom");
        String dateOfBornTo = hashMap.get("dateOfBornTo");
        String dateOfDeathFrom = hashMap.get("dateOfDeathFrom");
        String dateOfDeathTo = hashMap.get("dateOfDeathTo");
        String placeOfBirth = hashMap.get("placeOfBirth");

        List<Function<T, String>> filters = Arrays.asList(
                T::getGender,
                T::getFirstName,
                T::getPatronymic,
                T::getLastName,
                T::getPlaceOfBirth,
                T::getDateOfBorn,
                T::getDateOfDeath,
                T::getDateOfBorn,
                T::getDateOfDeath
        );
        List<String> values = Arrays.asList(
                gender,
                firstName,
                patronymic,
                lastName,
                placeOfBirth,
                dateOfBornFrom,
                dateOfDeathFrom,
                dateOfBornTo,
                dateOfDeathTo
        );
        List<FilterType> types = Arrays.asList(
                FilterType.STRING,
                FilterType.STRING,
                FilterType.STRING,
                FilterType.STRING,
                FilterType.STRING,
                FilterType.DATE_FROM,
                FilterType.DATE_FROM,
                FilterType.DATE_TO,
                FilterType.DATE_TO
        );

        for (int i = 0; i < filters.size(); i++) {
            if (i == 0) {
                result.addAll(family);
            }
            result.retainAll(tr.filter(result, values.get(i), filters.get(i), types.get(i)));
        }
        return result;
    }


}
