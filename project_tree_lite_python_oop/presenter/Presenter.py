class Presenter:
    def __init__(self, view, service):
        self.service = service
        view.setPresenter(self)

    def setCommandFromView(self, command, text, index):
        self.service.communicator(command, text, index)

    def getPrintList(self):
        return self.service.getAListPrintHuman()
