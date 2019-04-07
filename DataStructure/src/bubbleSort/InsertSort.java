package bubbleSort;

public class InsertSort {
	//插入排序思路为: 从第二个数开始，依次与这个数前面的数进行比较，如果比前面的数小，那么就交换二者的数值，当比前面的数大而且前面的数在第一个位置时，停止比较
	public static int[] sort(int[] array) {
		int j;
		for (int i = 1; i < array.length; i++) {
			
			j = i;
			int temp = array[i];
			while(j > 0 && temp < array[j-1]) {
				array[j] = array[j-1];
				j--;
			}
			array[j] = temp;
			
		}
		return array;
	}
	
	public static void display(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + "  ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		
		int[] array = new int[] {9,8,7,5,6};
		System.out.println("排序前数组为:");
		display(array);
		array = sort(array);
		System.out.println("最后数组为:");
		display(array);

	}

}
