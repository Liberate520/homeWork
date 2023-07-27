
import java.util.HashMap;
import java.util.Map;

public class task1 {

    public static StringBuilder getCondition(Map<String, String> params) {
        StringBuilder result = new StringBuilder();
        for (Map.Entry<String, String> pair : params.entrySet()) {
            if (pair.getValue() != null) {
                if (result.toString().equals("")) {
                    result.append(pair.getKey() + " = '" + pair.getValue() + "'");
                } else {
                    result.append(" and " + pair.getKey() + " = '" + pair.getValue() + "'");
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Map<String, String> params = new HashMap<String, String>();
        params.put("name", "Ivanov");
        params.put("country", "Ukraine");
        params.put("city", "Kiev");
        params.put("age", null);
        System.out.println(getCondition(params));
    }
}