public class home2 {
    // Дан массив двоичных чисел, например [1,1,0,1,1,1], вывести максимальное количество подряд идущих 1
    public static void main (String args[]){
        int[] arr;
        arr = new int[] { 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1 };
		int j=1;
        int max=0;
		for (int i =1; i<arr.length;i++){
			if (arr[i] == arr[i-1]) j++;
            else j=1;
            if (max < j) max = j;  
		}
		System.out.println("Максимальное количество подряд идущих 1 = "+max);					
	}
}
