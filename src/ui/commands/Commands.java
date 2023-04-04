package Seminar6.src.ui.commands;

import Seminar6.src.ui.ConsoleUi;


public abstract class Commands {
   protected ConsoleUi consoleUi;

   public Commands(ConsoleUi cU) {
      this.consoleUi = cU;
   }

   public abstract void execute();

}
