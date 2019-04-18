class MergeSortTest{
	public static void main(String[] args){
/*		int[] arrA = {23,45, 50, 55, 60};
		int[] arrB = {90, 85, 75, 40};
		int[] arrC = new int[9];
		int done = 0;
		int iA = 0;
		int iB = arrB.length - 1;
		int iC = 0;

		while(true){
			if(arrA[iA] < arrB[iB]){
				arrC[iC] = arrA[iA];
				iA++;
				iC++;
				if(iA > arrA.length -1){
					if(done == 0){
						arrA[arrA.length-1] = 999999;
						iA = arrA.length - 1;
						done = 1;
					}else{
						break;
					}
				}
			}else{
				arrC[iC] = arrB[iB];
				iB--;
				iC++;
				if(iB < 0){
					if(done == 0){
						arrB[0] = 999999;
						iB = 0;
						done = 1;
					}else{
						break;
					}
				}
			} 
		}
		for(int i = 0; i < arrC.length; i++){
			System.out.print(arrC[i] + " ");
		}
		System.out.println(); */
		int[] arr = {6,4,8,9,3,2};
		for(int i : arr){
			System.out.print(i + " ");
		}
		System.out.println();

		mergeSort(arr);

		for(int i : arr){
			System.out.print(i + " ");
		}
		System.out.println();
	}

	private static void mergeSort(int[] arr){
		int[] tmp = new int[arr.length];
		mergeSort(arr, tmp, 0, arr.length-1);
	}

	private static void mergeSort(int[] arr, int[] tmp, int start, int end){
		if(start < end){
			int mid = (start + end) / 2;
			mergeSort(arr, tmp, start, mid);
			mergeSort(arr, tmp, mid + 1, end);
			merge(arr, tmp, start, mid, end);
		}
	}
	private static void merge(int[] arr, int[] tmp, int start, int mid, int end){
		for(int i = start ; i <= end; i++){
				tmp[i] = arr[i];
		}
		int part1 = start;
		int part2 = mid +1;
		int index = start;
		while(part1 <= mid && part2 <= end){
			if(tmp[part1] <= tmp[part2]){
				arr[index] = tmp[part1];
				part1++;
			}else{
				arr[index] = tmp[part2];
				part2++;
			}
			index++;
		}
		for(int i = 0; i <= mid - part1; i ++){
			arr[index + i] = tmp[part1 + i];
		}
	}
}

