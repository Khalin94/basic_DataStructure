class QuickSortTest{
	public static void main(String[] args){
		int[] arr = {50, 20, 58, 59, 32, 19, 67};
		for(int i : arr){
			System.out.print(i + " ");
		}
		System.out.println();

		quickSort(arr, 0, arr.length - 1);
		for(int i : arr){
			System.out.print(i + " ");
		}
		System.out.println();
	}
	private static void quickSort(int[] arr, int l, int r){
		if(l > r){
			return;
		}
		int pivot = arr[l];
		int i = l +1;
		int j = r;
		int tmp;

		while(true){
			while(pivot > arr[i] && i < r){
				i++;
			}
			while(pivot < arr[j] && j > l){
				j--;
			}
			if(i >= j){
				break;
			}
			tmp = arr[i];
			arr[i] = arr[j];
			arr[j] = tmp;
		}

		tmp = arr[j];
		arr[j] = arr[l];
		arr[l] = tmp;

		quickSort(arr, l, j-1);
		quickSort(arr, i+1, r);
	}

}
