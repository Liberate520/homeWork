package model;

import java.io.IOException;
import model.*;
import model.Comparator.IdComparator;
import model.Comparator.NameComparator;
import model.Comparator.SortByLastName;
import model.Comparator.SortId;
import model.FamilyTree.FamilyTree;
import model.FamilyTree.FindHuman;
import model.FamilyTree.AddIntoTree.AddHuman;
import model.FamilyTree.AddIntoTree.AddOthers;
import model.FamilyTree.AddIntoTree.AddPerson;
import model.Iterator.HumanIterator;
import model.Persons.Human;
import model.Persons.Others;
import model.Persons.Person;
import model.fileWork.FileHandlerSave;
import model.fileWork.Format.SaveDoc.InterfaceSave;
import model.fileWork.Format.SaveDoc.SaveBinFormat;
import model.fileWork.Format.SaveDoc.SaveDocFormat;
import model.fileWork.Format.SaveDoc.SaveMdFormat;
import model.fileWork.Format.SaveDoc.SaveTextFormat;
import model.fileWork.FileHandlerRead;
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
private FileHandlerSave fileHandlerSave;
private FileHandlerRead fileHandlerRead;
private InterfaceSave interfaceSave;
private interfaceRead interfaceRead;
private FindHuman findHuman;
private AddPerson addPerson;
private AddHuman addHuman;
private AddOthers addOthers;
private NameComparator nameComparator;
private SortId sortId;
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


    public Service(FamilyTree familyTree, AddHuman addHuman, 
        SaveBinFormat saveBinFormat, SaveTextFormat saveTextFormat,
        SaveDocFormat saveDocFormat,
        SortId sortId, SortByLastName sortByLastName, FindHuman findHuman, AddPerson addPerson)
    {
         this.familyTree = familyTree;
        // this.person = person;
        // this.human = human;
        // this.others = others;
        // this.fileHandlerSave = fileHandlerSave;
        // this.fileHandlerRead = fileHandlerRead;
        // this.interfaceSave = interfaceSave;
        // this.interfaceRead = interfaceRead;
        this.findHuman = findHuman;
        this.addPerson = addPerson;
         this.addHuman = addHuman;
        // this.addOthers = addOthers;
        // this.nameComparator = nameComparator;
         this.sortId = sortId;
         this.sortByLastName = sortByLastName;
        // this.humanIterator = humanIterator;
        // this.idComparator = idComparator;
        this.saveBinFormat = saveBinFormat;
        this.saveTextFormat = saveTextFormat;
        this.saveDocFormat = saveDocFormat;
        this.saveMdFormat = saveMdFormat;
    }

    

        public void addPerson() // добавление персон в список дерева
        {
            addPerson.addPerson(person, familyTree);
        }

        public void addHuman() // добавление в дерево людей и вывод на экран
        {
            // addHuman.FillByHuman();
            System.out.println("Печать дерева с Human: " + addHuman.FillByHuman());
        }

        public void addOthers()  // добавление в дерево других
        {
            addOthers.FillByOthers();
        }

        public void FindHuman() // поиск людей в дереве по имени и фамилии
        {
            findHuman.findHuman(human, familyTree);
        }

        public  void SaveBinFormat() throws IOException, ClassNotFoundException  
        {
            InterfaceSave interfaceSave = new SaveBinFormat(); // сериализация дерева в бинарный формат
            interfaceSave.write(addHuman.FillByHuman());    
        }

        public  void SaveTxtFormat() throws IOException, ClassNotFoundException
        {
            InterfaceSave interfaceSave = new SaveTextFormat();
            interfaceSave.write(addHuman.FillByHuman());   
        }

        public  void SaveDocFormat() throws IOException, ClassNotFoundException
        {
            InterfaceSave interfaceSave = new SaveDocFormat();
            interfaceSave.write(addHuman.FillByHuman());    
        }

        public  void SaveMdFormat() throws IOException, ClassNotFoundException
        {
            InterfaceSave interfaceSave = new SaveMdFormat();
            interfaceSave.write(addHuman.FillByHuman());    
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
        
        public void SortId() // сортировка по id
        {
            sortId.SortId(familyTree);
        }

        public void SortByLastName() // сортировка по имени
        {
            sortByLastName.sortByLastName(person);
        }

}