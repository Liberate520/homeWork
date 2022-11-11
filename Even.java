public class Even {

	public static void main(String arr[]) {

		int num[] = {3,2,4,7,10,6,5};

		int n=num.length-1;

		for(int i=0;i<=num.length-1;i++) {

			if(num[i] % 2!=0) {

				System.out.println(num[i]);

			}

		}

	}



}