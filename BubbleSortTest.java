class BubbleSortTest{
	public static void main(String[] args){
		int[] arr = {5, 7, 3, 9, 4, 8};
		print(arr);
		bubbleSort(arr);
		print(arr);
/*		for(int i = 1 ; i < arr.length; i++){
			for(int  j = 0; j < arr.length - i; j++){
				if(arr[j] > arr[j+1]){
					int tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
				}
			}
		}

		for(int i = 0; i < arr.length; i++){
			System.out.print(arr[i]);
		}
		System.out.println(); */
	}

	private static void bubbleSort(int[] arr){
		bubbleSort(arr, arr.length -1);
	}
	private static void bubbleSort(int[] arr, int last){
		if(last > 0){
			for(int i = 1; i <= last; i++){
				if(arr[i-1]> arr[i]){
					swap(arr, i -1, i);
				}
			}
			bubbleSort(arr, last -1);
		}
	}
	private static void swap(int[] arr, int preI, int i){
		int  temp = arr[preI];
		arr[preI] = arr[i];
		arr[i] = temp;
	}
	private static void print(int[] arr){
		for(int i = 0 ; i < arr.length; i++){
			System.out.print(arr[i]);
		}
		System.out.println();
	}
}
