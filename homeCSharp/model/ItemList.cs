namespace GeekBrains;
using System.Collections;

public class ItemList {
    private List<Item> list;

    public ItemList(){
        this.list = new List<Item>();
        // тестовые ребята
        // Вася
        Human vasya = new Human();
        vasya.setId(11); 
        vasya.setName("Василий");
        vasya.setAge(40);
        list.Add(vasya);

        // Марина
        Human marina = new Human();
        marina.setId(22); 
        marina.setName("Марина");
        marina.setAge(50);
        list.Add(marina);

        // Петя
        Human petya = new Human();
        petya.setId(33); 
        petya.setName("Петр");
        petya.setAge(10);
        list.Add(petya);

        // Петя сын Васи
        Relationship vasyapetya = new Relationship(2,33);
        vasya.setRelationship(vasyapetya);
    }

    public Item get(int index){
        return this.list[index];
    }

    public int size(){
        return this.list.Count();
    }

    public String itemListToString(){
        String result = "";
        for (int i = 0; i < this.list.Count(); i++){
            result = result + list[i].itemToString() + "\n";
        }
        return result;
    }

    public String addHuman(String name, int age){
        Item itemToAdd = new Human(list, name, age);
        this.list.Add(itemToAdd);
        return "добавлен: " + itemToAdd.itemToString();
    }

    public String removeItem(int idForMenu){
        for (int i = 0; i < list.Count(); i++){
            if (list[i].getId() == idForMenu){
                Item removedItem = list[i];
                list.Remove(list[i]);
                return "удален: " + removedItem.itemToString();
            } 
        }
        return "Совпадений нет";
    }      

    public String printChildrens(int idForMenu){
        foreach (Item item in list){
            if (item.getId() == idForMenu){
                return "Дети: " + item.childrensToString();
            }
        }
        return "Совпадений нет";
    }

    public String addReletionToItem(int idForMenu, int reletionId, int reletionToitemId ){
        foreach (Item item in list){
            if (item.getId() == idForMenu){
                Relationship relationship = new Relationship(reletionId, reletionToitemId);
                item.setRelationship(relationship);
                return "связь добавлена";
            }
        }
        return "Совпадений нет";
    }
}
