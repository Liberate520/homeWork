import java.util.List;

public class Laptop {
    int id;
    String model;
    String operatingSystem;
    String processor;
    String memorySize;
    String storageCapacity;
    String color;
    String display;
    String weight;
    String batteryLife;
    String graphics;
    int productionYear;

    public Laptop( int id, String model, String operatingSystem, String processor, String memorySize, String storageCapacity, String color, String display, String weight, String batteryLife, String graphics, int productionYear) {
        this.id = id;
        this.model = model;
        this.operatingSystem = operatingSystem ;
        this.processor = processor;
        this.memorySize = memorySize;
        this.storageCapacity = storageCapacity;
        this.color = color;
        this.display = display;
        this.weight = weight;
        this.batteryLife = batteryLife;
        this.graphics = graphics;
        this.productionYear = productionYear;

    }

    @Override
    public String toString() {
        return "Laptop{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", operatingSystem='" + operatingSystem + '\'' +
                ", processor=" + processor + '\'' +
                ", memorySize=" + memorySize + '\'' +
                ", storageCapacity=" + storageCapacity + '\'' +
                ", color=" + color + '\'' +
                ", display=" + display + '\'' +
                ", weight=" + weight + '\'' +
                ", batteryLife=" + batteryLife + '\'' +
                ", graphics=" + graphics + '\'' +
                ", productionYear=" + productionYear + 
                '}';
    }
    
     @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 61 * hash + (this.model != null ? this.model.hashCode() : 0);
        hash = 61 * hash + (this.operatingSystem != null ? this.operatingSystem.hashCode() : 0);
        hash = 61 * hash + (this.processor != null ? this.processor.hashCode() : 0);
        hash = 61 * hash + (this.memorySize != null ? this.memorySize.hashCode() : 0);
        hash = 61 * hash + (this.storageCapacity != null ? this.storageCapacity.hashCode() : 0);
        hash = 61 * hash + (this.color != null ? this.color.hashCode() : 0);
        hash = 61 * hash + (this.display != null ? this.display.hashCode() : 0);
        hash = 61 * hash + (this.weight != null ? this.weight.hashCode() : 0);
        hash = 61 * hash + (this.batteryLife != null ? this.batteryLife.hashCode() : 0);
        hash = 61 * hash + (this.graphics != null ? this.graphics.hashCode() : 0);
        hash = 61 * hash + (this.productionYear != null ? this.productionYear.hashCode() : 0);
        return hash;
    }
        
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    public long getId() {
        return id;
    }
    public String getmodel() {
        return model;
    }
    public String getoperatingSystem() {
        return operatingSystem;
    }
    public String getprocessor() {
        return processor;
    }
    public String getmemorySize() {
        return memorySize;
    }
    public String storageCapacity() {
        return storageCapacity;
    }
    public String getcolor() {
        return color;
    }
    public String getdisplay() {
        return display;
    }
    public String getweight() {
        return weight;
    }
    public String getbatteryLife() {
        return batteryLife;
    }
    public String getgraphics() {
        return graphics;
    }
    public String getproductionYear() {
        return productionYear;
    }
}


    public class InputMenu 
{
    public void choise() 
    {
	System.out.println("1) Add record\n2) Get record 2\n3) Update record\n4) Remove record ");
	System.out.print("Selection: ");
    }
    
    public Main() {
    Scanner in = new Scanner ( System.in );

    choise();
    switch ( in.nextInt() ) {
        
	{
	    case 1:
	    class Catalogue {
    private Map<Long, Record> records = new HashMap<Long, Record>();
    private long nextId;
    private long getNextId() {
        if (nextId < Long.MAX_VALUE && !records.containsKey(nextId))
            return nextId++;
        nextId = 0;
        while (nextId < Long.MAX_VALUE) {
            if (!records.containsKey(nextId))
                return nextId;
            ++nextId;
        }
        throw new RangeException((short)111, "No more IDs availiable");
        
    public Record addRecord(String model, String operatingSystem, String processor, String memorySize, String storageCapacity, String color, String display, String weight, String batteryLife, String graphics, int productionYear) 
        throws CloneNotSupportedException {
        long recordId = getNextId();
        Record record = new Record(recordId, model, operatingSystem, processor, memorySize, storageCapacity, color, display, weight, batteryLife, graphics, productionYear);
        records.put(recordId, record);
        return (Record)record.clone();
        }System.out.println ("");
	    break;
  
	    case 2:
        System.out.println ("Chouse characteristic");
	    new choise2();
        break; 

	    case 3:
    public Record updateRecord(long id, String 1phone, String 2phone, String name, String address)
        throws CloneNotSupportedException {
        Record record = new Record(id, 1phone, 2phone, name, address);
        records.put(id, record);
        return getRecord(id);
    }
	    break;
	    
	    case 4:
    public void removeRecord(long id) {
        records.remove(id);
	    break;
	    
	    default:
	    System.err.println ( "Unrecognized option" );
	    break;
	}
    }
         }public void choise2() 
        {
        System.out.println("1) id \n2) model \n3) operatingSystem \n4) processor \n5) memorySize \n6) storageCapacity \n7 color \n8 display \n9 weight \n10 batteryLife \n11 graphics \n12 productionYear");
        System.out.print("Selection: ");
        }
        public Main() {
            Scanner in = new Scanner ( System.in );
        
            choise2();
            switch ( in.nextInt() ) {
                case 1:
                public Record getRecord(long id) throws CloneNotSupportedException {
                    if (records.containsKey(id))
                        return (Record)records.get(id).clone();
                    return null;
                }
                break;
              case 2:
              public Record getRecord(model) throws CloneNotSupportedException {
                if (records.containsKey(model))
                    return (Record)records.get(model).clone();
                return null;
            }
                break;
              case 3:
              public Record getRecord(operatingSystem) throws CloneNotSupportedException {
                if (records.containsKey(operatingSystem))
                    return (Record)records.get(operatingSystem).clone();
                return null;
            }
                break;  
                case 4:
                public Record getRecord(processor) throws CloneNotSupportedException {
                  if (records.containsKey(processor))
                      return (Record)records.get(processor).clone();
                  return null;
              }
                break
                case 5:
                public Record getRecord(memorySize) throws CloneNotSupportedException {
                  if (records.containsKey(memorySize))
                      return (Record)records.get(memorySize).clone();
                  return null;
              }
                break
                case 6:
                public Record getRecord(storageCapacity) throws CloneNotSupportedException {
                  if (records.containsKey(storageCapacity))
                    return (Record)records.get(storageCapacity).clone();
                  return null;
              }
                break
                case 7:
                public Record getRecord(color) throws CloneNotSupportedException {
                  if (records.containsKey(color))
                   return (Record)records.get(color).clone();
                  return null;
              }
                break
                case 8:
                public Record getRecord(display) throws CloneNotSupportedException {
                  if (records.containsKey(display))
                   return (Record)records.get(display).clone();
                  return null;
              }
                break
                case 9:
                public Record getRecord(weight) throws CloneNotSupportedException {
                  if (records.containsKey(weight))
                   return (Record)records.get(weight).clone();
                  return null;
              }
                break
                case 10:
                public Record getRecord(batteryLife) throws CloneNotSupportedException {
                  if (records.containsKey(batteryLife))
                   return (Record)records.get(batteryLife).clone();
                  return null;
              }
                break
                case 11:
                public Record getRecord(graphics) throws CloneNotSupportedException {
                  if (records.containsKey(graphics))
                   return (Record)records.get(graphics).clone();
                  return null;
              }
                break
                case 12:
                public Record getRecord(productionYear) throws CloneNotSupportedException {
                  if (records.containsKey(productionYear))
                   return (Record)records.get(productionYear).clone();
                  return null;
              }
                break          
              default:
                System.err.println ( "Unrecognized option" );
                break;
            }
          }
	    
    }
}public class Tutorial0001 {
    public static void main(String[] args) throws CloneNotSupportedException {
        AddressBook addressBook = new AddressBook();
        addressBook.addRecord("1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1" );
        addressBook.addRecord("2", "2", "2", "2", "2", "2", "2", "2", "2", "2", "2", "2" );
        addressBook.addRecord("3", "3", "3", "3", "3", "3", "3", "3", "3", "3", "3", "3" );
    }
}

    }
}