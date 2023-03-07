from project_tree_lite_python_oop.model.Human import Human


class AddHuman:
    def addHuman(self, name, tree):
        tree.getBigFamily().append(Human(name))
