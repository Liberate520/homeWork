package org.example;

import java.util.HashMap;
import java.util.ArrayList;

public class Menu {
        private HashMap<Integer,String> buttons;
        //------------------------------------------------------------------------------------------------------------------

        public HashMap<Integer, String> getButtons() {
            return buttons;
        }
        public void setButtons(HashMap<Integer,String> buttons) {
            this.buttons = buttons;
        }

        public void outputOfMenuButtons(HashMap<Integer,String> b){ // Выводит на экран Menu
            for (int i = 1; i < b.size() + 1; i++) {
                System.out.printf("%d - %s%n", i, b.get(i));
            }
        }

        public void outputOfMessages(HashMap<Integer,String> b, ArrayList<Integer> keys){
            for (Integer key : keys) {
                System.out.printf("%s%n", b.get(key));
            }
        }

        public static void clear(){
            for (int i = 0; i < 50; i++) {
                System.out.println(" ");
            }
        }
        //------------------------------------------------------------------------------------------------------------------


}


