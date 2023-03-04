package src;

import java.util.List;

public class Statistics {

    public String getStatistics(It human, List<It> children) {
        StringBuilder result = new StringBuilder();
        result.append("---------------------------\n");
        result.append("ФИО: ").append(human.getLastName()).append(" ").append(human.getFirstName()).append(" ");
        result.append(human.getPatronymic()).append("\n");
        result.append("Родился ").append(human.getDateOfBorn()).append(" г. в ").append(human.getPlaceOfBirth());
        result.append("\n");
        if (!human.isAlive()) {
            result.append("Умер ").append(human.getDateOfDeath()).append(" г\n");
            result.append("Прожил ").append(human.getAge()).append(" полных лет\n");
        }
        if (!human.getChildren().isEmpty()) {
            result.append("Имеет ").append(human.getChildren().size()).append(" детей и ").append(children.size()
                    - human.getChildren().size()).append(" внуков с правнуками\n");
            result.append("Дети:\n");
            for (It h : human.getChildren()) {
                result.append("└───   ").append(h.getShortName()).append(" - ID: ").append(h.getId()).append("\n");
            }
        }
        result.append("Родители:");
        if (human.getFather() != null || human.getMother() != null) {
            if (human.getFather() != null) {
                result.append("\n└───   ").append("Отец: ").append(human.getFather());
            }
            if (human.getMother() != null) {
                result.append("\n└───   ").append("Мать: ").append(human.getMother());
            }
        } else {
            result.append("\nИнформация о родителях отсутствует!\n");
        }
        return result.toString();
    }
}
