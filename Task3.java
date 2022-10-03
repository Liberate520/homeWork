public class Task3 {
    public static void main(String[] args) {
        int[] nums = new int[4];
        nums[0] = 3;
        nums[1] = 2;
        nums[2] = 2;
        nums[3] = 3;
        
        int val = 3;
        int col = 0;
         for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                col ++;
                
            }
            

            
         }
         System.out.println(col);

        nums[0] = 2;
        nums[1] = 2;
        nums[2] = 2;
        nums[3] = 2;

         for (int j = nums.length - 1; j < nums.length; j--) {
            if (col > 0) {
                nums[j] = val;
                col --;
                        
            }
                            
            }
            for (int ii = 0; ii < nums.length; ii++) {
                System.out.println(nums[ii]);
                
            }
        
         }
        
    }
    

