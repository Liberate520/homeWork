package presenter;

import service.Service;
import view.Console;
import view.View;

public class Presenter {
    View view =new Console();
    Service service = new Service();

    public Presenter(View view, Service service) {
        this.view = view;
        this.service = service;
    }
    public void addMember(String name,String FatherName,String MatherName)
    {
        if (service.addMember(name,FatherName,MatherName)) {
            view.print(service.find(name) + "  успешно добавлен");
        }
        else view.print("Добавление не  удалось");
    }
public String getName(String name)
{
    return service.find(name).getName();
}
public String getInfo()
{
    return service.getInfo();
}
public void getChildren(String nameFather)
{
    view.print(service.getChildren(nameFather));
}
public void findMember(String name)
{
  if(service.find(name)!=null)
  {
      view.print(service.find(name).getInfo());
  }
  else view.print("Такой человек не найден");
}
public void save(String fileName)
{
    if(service.save("family.txt"))
    {
        view.print("Семья сохранена успешно");
    }
    else view.print("Запись не удалась");
}
    public void load(String fileName)
    {
        if(service.load("family.txt"))
        {
            view.print("Семья загружена успешно\n");
        }
        else view.print("Загрузка не удалась\n");
    }
}

