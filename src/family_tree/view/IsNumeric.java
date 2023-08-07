package family_tree.view;

public class IsNumeric {
    public boolean checkNum(String str) {
        // Проверка на число
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
