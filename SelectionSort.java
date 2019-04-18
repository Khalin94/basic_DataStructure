class SelectionSort{
	public static void main(String[] args){
/*		int[] arr = {5, 2, 6, 7, 1, 3};
		for(int i =0; i < arr.length; i++){
			for(int j = i+1; j  < arr.length; j++){
				if(arr[i] > arr[j]){
					int tmp = arr[i];
					arr[i] = arr[j];
					arr[j] = tmp;
				}
			}

			System.out.print(arr[i]);
		}
		System.out.println();

		for(int i = 0 ; i < arr.length; i++){
			System.out.print(arr[i]);
		}
		System.out.println(); */ 
		int[] arr = {5, 3, 8, 2, 9};
		print(arr);
		selSort(arr);
		print(arr);
	}

	private static void selSort(int[] arr){
		selSort(arr, 0);
	}
	private static void selSort(int[] arr, int start){
		if(start < arr.length-1){
			int min_index = start;
			for(int i = start; i < arr.length; i++){
				if(arr[i] < arr[min_index]){
					min_index = i;
				}
			}
			swap(arr, start, min_index);
			selSort(arr, start+1);
		}
	}
	private static void swap(int[] arr, int start, int min_index){
		int temp = arr[start];
		arr[start] = arr[min_index];
		arr[min_index] = temp;
	}

	private static void print(int[] arr){
		for(int i = 0 ; i < arr.length; i++){
			System.out.print(arr[i]);
		}
		System.out.println();
	}

}
