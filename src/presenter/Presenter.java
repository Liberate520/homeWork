package presenter;

import cmdui.IView;
import cmdui.commands.ICmdAdd;
import cmdui.commands.ICmdGet;
import cmdui.commands.ICmdUpdate;
import familytree.service.IFamilyTreeService;

// Все методы в этом классе private, т.к. это обработчики событий, которые генерирует View.
// Они передаются в представление в виде функциональных интерфейсов и никогда не вызываются напрямую.
public class Presenter {
    private IView view;
    private IFamilyTreeService service;

    public Presenter(IView view, IFamilyTreeService service) {
        this.view = view;
        this.service = service;
        setCmdHandlers();
    }

    private void setCmdHandlers() {
        view.setCmdGetHandler(this::cmdGetHandler);
        view.setCmdAddHandler(this::cmdAddHandler);
        view.setCmdUpdateHandler(this::cmdUpdateHandler);
    }
    
    private void cmdGetHandler(ICmdGet cmdGet) {
        view.setPrintOut(service.getMembers(cmdGet.getSortMode(), cmdGet.getId(), cmdGet.getName()));
    }

    private void cmdAddHandler(ICmdAdd cmdAdd) {
        view.setPrintOut(service.addMember(cmdAdd.getName(), cmdAdd.getSex(), cmdAdd.getBirthDay(), cmdAdd.getParents()));
    }

    private void cmdUpdateHandler(ICmdUpdate cmdUpdate) {
        view.setPrintOut(service.updateMember(cmdUpdate.getId(), cmdUpdate.getName(), cmdUpdate.getDeathDay()));
    }
}
