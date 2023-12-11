package FamilyTree.FamilyTree.Presenter;


import FamilyTree.FamilyTree.Model.Person.Gender;
import FamilyTree.FamilyTree.Model.Person.Person;
import FamilyTree.FamilyTree.Model.Service.Service;
import FamilyTree.FamilyTree.Model.Utils.StorageTree;
import FamilyTree.FamilyTree.View.View;

import java.util.ArrayList;

    public class Presenter {
        private View view;
        private Service service;

        public Presenter(View view) {
            this.view = view;
            service = new Service(new StorageTree<Person>());
        }

        public boolean addPerson(String name, Gender gender, String birthDate, String deathDate){
            service.addPerson(name, gender, birthDate,deathDate);
            return true;
        }

        public boolean setParent(int personId, int parentId){
            if (service.checkId(personId) & service.checkId(parentId)){
                service.setParent(personId,parentId);
                return true;
            }
            return false;
        }

        public boolean setSpouse(int personId, int spouseId){
            if (service.checkId(personId) & service.checkId(spouseId)){
                service.setSpouse(personId,spouseId);
                return true;
            }
            return false;
        }


        public void treeInfo(){
            view.printAnswer(service.getFamilyInfo());
        }

        public ArrayList<String> treeSortedByAge(){
            return service.listSortByAge();
        }

        public ArrayList<String> treeSortedByChildren(){
            return service.listSortByChildren();
        }

        public boolean restoreTree(String filePath){
            return service.restoreTree(filePath);
        }

        public boolean saveTree(String fileName){
            return service.saveTree(fileName);
        }


    }

