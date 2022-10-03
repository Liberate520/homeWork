import java.util.Collections;

public class Task2 {

    public static void main(String [] args){
        int[] myarray = new int[10];
        int[] myarray1 = new int [10];
        int i = 0;
        while (i < myarray.length) {
            int n = (int)(Math.random() * 2);
            myarray[i] = n;
            i += 1;
            
        }
        int j = 0;
        while (j < myarray.length) {
            System.out.println(myarray[j]);
            j +=1;
            
        }
        System.out.println("----------------------------------------");
        int z = 0;
        int sum = 0;
        int y = 0;
         while (z < myarray.length) {
             sum = sum + myarray[z];
             if (z == (myarray.length - 1) & sum > 0){
                myarray1[y]= sum;
                y +=1;
                sum = 0;
            }
             else if (myarray[z] == 0){
                myarray1[y]= sum;
                sum = 0;
                y++;
                
             }
             
            z ++;
            
         }

        int jj = 0;
        while (jj < myarray1.length) {
            System.out.println(myarray1[jj]);
            jj +=1;
        }

        System.out.println("----------------------------------------");
        
        int max = 0;
        for(int zz = 0; zz < myarray1.length; zz++) {
            if (myarray1[zz] >= max) {
                max = myarray1[zz];
                
                                                
            }
                               
        }
        System.out.println(max);

        

    }
    
}
