package view.commands;

import view.Console;

public class getList {
  private Console console;

  public getList(Console console) {
        this.console = console;
    }

  public String getDescription() {
    return "Получить список людей";
  }

  public void execute() {
    console.getHumanList();
  }
}
