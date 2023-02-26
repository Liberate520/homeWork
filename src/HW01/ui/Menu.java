package HW01.ui;

import HW01.ui.commands.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


    public class Menu {
        private List<Option> commands;
        private Console console;

        public Menu(Console console) {
            this.console = console;
            commands = new ArrayList<>();
            commands.add(new ErrorInput(console));
            commands.add(new TestTree(console));
            commands.add(new LoadData(console));
            commands.add(new SaveData(console));
            commands.add(new AddPerson(console));
            commands.add(new UpdatePerson(console));
            commands.add(new PersonEnvironment(console));
            commands.add(new SearchPerson(console));
            commands.add(new PrintTree(console));
            commands.add(new SortByName(console));
            commands.add(new SortByBitrhDate(console));
            commands.add(new Exit(console));
        }
        void execute(int num) throws IOException, ClassNotFoundException {
            Option option = commands.get(num);
            option.execute();
        }
        public String printMenu(){
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("\n");
            for (int i = 1; i < commands.size(); i++) {
                stringBuilder.append(i);
                stringBuilder.append(": ");
                stringBuilder.append(commands.get(i).description());
                stringBuilder.append("\n");
            }
            return stringBuilder.toString();
        }

        public Integer getMenuRowsValue (){
            return commands.size();
        }
    }



