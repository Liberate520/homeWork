public class Exception {
    public static int[] differenceArr(int[] Arr1, int[] Arr2){
        if (Arr1.length!=Arr2.length) {
            throw new RuntimeException("Длины массивов не совпадают!");
        }
        int[] Arr3 = new int[Arr1.length];
        for(int i = 0; i<Arr1.length; i++){
            Arr3[i] = Arr1[i] - Arr2[i];
            }

        return Arr3;
    }

    public static void printArr(int[] Arr) {
        if (Arr.length == 0){
            throw new RuntimeException("Массив пустой!");
        }

        for(int i = 0; i<Arr.length; i++ ){
            System.out.print(Arr[i] + ",");
        }

        System.out.println();
    }

    public static void printArr1(double[] Arr) {
        if (Arr.length == 0){
            throw new RuntimeException("Массив пустой!");
        }

        for(int i = 0; i<Arr.length; i++ ){
            System.out.print(Arr[i] + ",");
        }

        System.out.println();
    }

    public static double[] divisionArr(int[] Arr1, int[] Arr2){
        if (Arr1.length!=Arr2.length) {
            throw new RuntimeException("Длины массивов не совпадают!");
        }
        double[] Arr3 = new double[Arr1.length];
        for(int i = 0; i<Arr1.length; i++){
            if(Arr2[i] == 0){
                throw new RuntimeException("На ноль делить нельзя!");
            }
            Arr3[i] = Arr1[i]/Arr2[i];
        }

        return Arr3;

    }



    public static void main(String[] args){
        int[] myArr = {1,2,3,4,5,};
        int[] myArr1 = {5,8,2,1,6,};
        int[] myArr2 = differenceArr(myArr, myArr1);
        printArr(myArr2);
//        int[] Arr45 = {};
//        printArr(Arr45);
        double[] myArr3 = divisionArr(myArr,myArr1);
        printArr1(myArr3);

    }
}
