package bubbleSort;

public class ChoiceSort {
	//选择排序思路为:先找出数组中最小的数，然后判断最小数是不是在最前面，若不是，交换二者的位置
	public static int[] sort(int[] array) {
		for (int i = 0; i < array.length-1; i++) {
			int min = i;
			for (int j = i+1; j < array.length; j++) {
				if (array[j] < array[min]) {
					min = j;
				}
			}
			if (min != i) {
				int temp = array[i];
				array[i] = array[min];
				array[min] = temp;
			}

			System.out.println("第" +(i+1) +"轮排序结果为:");
			display(array);
		}
		return array;
	}
	
	public static void display(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + "  ");
		}
		System.out.println();
	}
	
	public static void main (String[] args) {
		int[] array = new int[] {9,8,7,5,6};
		System.out.println("排序前数组为:");
		display(array);
		System.out.println("----------");
		array = sort(array);
		System.out.println("----------");
		System.out.println("最后数组为:");
		display(array);
		
	}

}
