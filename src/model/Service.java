package model;

import java.io.IOException;
import model.Comparator.IdComparator;
import model.Comparator.NameComparator;
import model.Comparator.SortByLastName;
import model.Comparator.SortById;
import model.FamilyTree.FamilyTree;
import model.FamilyTree.FindHuman;
import model.FamilyTree.AddIntoTree.AddPerson;
import model.FamilyTree.AddIntoTree.FillHuman;
import model.FamilyTree.AddIntoTree.FillOthers;
import model.Iterator.HumanIterator;
import model.Persons.Human;
import model.Persons.Others;
import model.Persons.Person;
import model.fileWork.Format.SaveDoc.InterfaceSave;
import model.fileWork.Format.SaveDoc.SaveBinFormat;
import model.fileWork.Format.SaveDoc.SaveDocFormat;
import model.fileWork.Format.SaveDoc.SaveMdFormat;
import model.fileWork.Format.SaveDoc.SaveTextFormat;
import model.fileWork.Format.ReadDoc.ReadBin;
import model.fileWork.Format.ReadDoc.ReadDoc;
import model.fileWork.Format.ReadDoc.ReadTxt;
import model.fileWork.Format.ReadDoc.ReadMd;
import model.fileWork.Format.ReadDoc.interfaceRead;


public class Service<T extends Person>
{
private FamilyTree<T> familyTree; 
private Person person;
private Human human;
private Others others;
// private InterfaceSave interfaceSave;
// private interfaceRead interfaceRead;
private FindHuman findHuman;
private AddPerson addPerson;
private NameComparator nameComparator;
private SortById sortById;
private SortByLastName sortByLastName;
private HumanIterator humanIterator;
private IdComparator idComparator;
private SaveBinFormat saveBinFormat;
private SaveTextFormat saveTextFormat;
private SaveDocFormat saveDocFormat;
private SaveMdFormat saveMdFormat;
private ReadBin readBin;
private ReadTxt readTxt;
private ReadDoc readDoc;
private ReadMd readMd;


    public Service(FamilyTree familyTree, 
        SaveBinFormat saveBinFormat, SaveTextFormat saveTextFormat,
        SaveDocFormat saveDocFormat,SaveMdFormat saveMdFormat,
        SortById sortById, SortByLastName sortByLastName,
         FindHuman findHuman, AddPerson addPerson)
    {
        this.familyTree = familyTree;
        this.addPerson = addPerson;
        this.sortById = sortById;
        this.sortByLastName = sortByLastName;
        this.saveBinFormat = saveBinFormat;
        this.saveTextFormat = saveTextFormat;
        this.saveDocFormat = saveDocFormat;
        this.saveMdFormat = saveMdFormat;
    }

        public void addPerson() // добавление персон в список дерева
        {
            AddPerson addPerson1 = new AddPerson();
            FillHuman fillHuman1 = new FillHuman();
            // addPerson1.addPerson(fillHuman1.fillByHuman());
            System.out.println("Печать дерева с Human: " + addPerson1.addPerson(fillHuman1.fillByHuman()));
        }

        public void addHuman() // добавление в дерево людей и вывод на экран
        {
            AddPerson addPerson2 = new AddPerson();
            FillHuman fillHuman2 = new FillHuman();
           
            // addPerson1.addPerson(fillHuman1.fillByHuman());
            System.out.println("Печать дерева с Human: " + addPerson2.addPerson(fillHuman2.fillByHuman()));
        }

        public void addOthers()  // добавление в дерево других
        {
            // addOthers.FillByOthers();
            AddPerson addPerson5 = new AddPerson();
            FillOthers fillOthers5 = new FillOthers<>();
           
            // addPerson1.addPerson(fillHuman1.fillByHuman());
            System.out.println("Печать дерева с Others: " + addPerson5.addPerson(fillOthers5.fillOthers()));
        }

        public void FindHuman() // поиск людей в дереве по имени и фамилии
        {
            AddPerson addPerson3 = new AddPerson();
            FillHuman fillHuman3 = new FillHuman();
            FamilyTree familyTree3 = new FamilyTree();
            familyTree3 = addPerson3.addPerson(fillHuman3.fillByHuman());
            FindHuman findHuman = new FindHuman();
            findHuman.findHuman(familyTree3);
        }

        public  void SaveBinFormat() throws IOException, ClassNotFoundException  
        {
            AddPerson addPerson = new AddPerson();
            FillHuman fillHuman = new FillHuman();
            InterfaceSave interfaceSave = new SaveBinFormat(); // сериализация дерева в бинарный формат
            interfaceSave.write(addPerson.addPerson(fillHuman.fillByHuman()));    
        }

        public  void SaveTxtFormat() throws IOException, ClassNotFoundException
        {
            AddPerson addPerson = new AddPerson();
            FillHuman fillHuman = new FillHuman();
            InterfaceSave interfaceSave = new SaveTextFormat();
            interfaceSave.write(addPerson.addPerson(fillHuman.fillByHuman()));   
        }

        public  void SaveDocFormat() throws IOException, ClassNotFoundException
        {   
            AddPerson addPerson = new AddPerson();
            FillHuman fillHuman = new FillHuman();
            InterfaceSave interfaceSave = new SaveDocFormat();
            interfaceSave.write(addPerson.addPerson(fillHuman.fillByHuman()));    
        }

        public  void SaveMdFormat() throws IOException, ClassNotFoundException
        {
            AddPerson addPerson = new AddPerson();
            FillHuman fillHuman = new FillHuman();
            InterfaceSave interfaceSave = new SaveMdFormat();
            interfaceSave.write(addPerson.addPerson(fillHuman.fillByHuman()));    
        }

        public  void ReadBin() throws IOException, ClassNotFoundException
        {
            interfaceRead interfaceread = new ReadBin();
            interfaceread.read(familyTree);    
        }

        public  void ReadTxt() throws IOException, ClassNotFoundException
        {
            interfaceRead interfaceread = new ReadTxt<>();
            interfaceread.read(familyTree);    
        }

        public  void ReadMd() throws IOException, ClassNotFoundException
        {
            interfaceRead interfaceread = new ReadMd<>();
            interfaceread.read(familyTree);    
        }

        public  void ReadDoc() throws IOException, ClassNotFoundException
        {
            interfaceRead interfaceread = new ReadDoc<>();
            interfaceread.read(familyTree);    
        }
        public void NameComparator() // сравнивает двух персон
        {
            nameComparator.compare(person, person);
        }
        
        public void SortById() // сортировка по id
        {
            FamilyTree familyTree1 = new FamilyTree();
            AddPerson addPerson = new AddPerson();
            FillHuman fillHuman = new FillHuman();
            familyTree1 = addPerson.addPerson(fillHuman.fillByHuman());
            sortById.sortBy(familyTree1); // передаём заполненное дерево и сортируем по убыванию id
            System.out.println("Список, отсортированный по id: " + familyTree1);
        }

        public void SortByLastName() // сортировка по имени
        {
            FamilyTree familyTree2 = new FamilyTree();
            AddPerson addPerson = new AddPerson();
            FillHuman fillHuman = new FillHuman();
            familyTree2 = addPerson.addPerson(fillHuman.fillByHuman());
            sortByLastName.sortByLastName(familyTree2);
            System.out.println("Список, отсортированный по имени: " + familyTree2);
        }

}