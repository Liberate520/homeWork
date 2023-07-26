package FamilyTree.View.Check;

import java.lang.reflect.Method;

public class ChooseEnum {

    public static void choose(Class enumClass){
        Method valuesMethod;

        try {

            valuesMethod = enumClass.getMethod("values");
            Enum [] enumValues = (Enum  []) valuesMethod.invoke(null);

            System.out.println("Введите "  + enumClass.getSimpleName() + " строго из предложенных вариантов :");
            for (Enum value : enumValues) {
                System.out.println(value);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
