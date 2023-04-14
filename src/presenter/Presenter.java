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
    public boolean addMember(String name,String FatherName,String MatherName)
    {
        return service.addMember(name,FatherName,MatherName);
    }
public String getName(String name)
{
    return service.find(name).getName();
}
public String getInfo()
{
    return service.getInfo();
}
}
