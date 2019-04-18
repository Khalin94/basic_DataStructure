class InsertionSortTest1{
	public static void main(String[] args){
		int[] arr = {60, 40, 70, 50, 100, 20};
		int j;
		for(int i = 1; i < arr.length; i++){
			int key = arr[i];
			for(j = i-1; j >= 0; j--){
				if(arr[j] <= key){
					break;
				}
				arr[j+1] = arr[j];
			}
			arr[j+1] = key;
		}

		for(int i = 0 ; i < arr.length; i++){
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}

