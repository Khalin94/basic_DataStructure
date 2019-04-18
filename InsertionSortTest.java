class InsertionSortTest{
	public static void main(String[] args){
		int[] arr = {6, 3, 8, 9, 1, 4};
		int j;
		int key;
		for(int i = 1; i < arr.length; i++){
			key = arr[i];
			for(j = i -1; j >= 0; j--){
				if(arr[j] <= key){
					break;
				}
				arr[j+1] = arr[j];
			}
			arr[j+1] = key;
		}
		for(int i = 0 ; i < arr.length; i++){
			System.out.print(arr[i]);
		}
		System.out.println();
	}
}

