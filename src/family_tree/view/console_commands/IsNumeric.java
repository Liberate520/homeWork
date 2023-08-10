package family_tree.view.console_commands;

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
