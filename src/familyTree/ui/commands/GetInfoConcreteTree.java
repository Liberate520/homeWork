package familyTree.ui.commands;

import familyTree.ui.View;

public class GetInfoConcreteTree implements Command{
        private View view;
        public GetInfoConcreteTree(View view) {
            this.view = view;
        }
        @Override
        public String getDescription() {
            return "Полная информация по конкретному древу";
        }

        @Override
        public void execute() {
            view.getInfoConcreteTree();
        }
}