package bubbleSort;

public class BubbleSort {
	//最大的数在最右边，外层循环控制循环次数，任意大小的数组最大需要length-1次循环即可排好顺序
	//内层循环用来交换两个数值，定义的flag若为true，则说明已经排好顺序，则跳出外层循环
	public static int[] sort(int[] array) {
		for (int i = 1; i < array.length; i++) {
			boolean flag = true;
			for (int j = 0; j < array.length-i; j++) {
				if (array[j] > array[j+1]) {
					int temp;
					temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
					flag = false;
				}
			}
			if (flag) {
				break;
			}
			System.out.println("第" + i+ "轮循环结果为:");
			display(array);
		}
		return array;
	}
	
	public static void display(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + "--");
		}
		System.out.println("");
	} 

	public static void main(String[] args) {
		int[] testArray = new int[] {9,8,7,6,5};
		System.out.println("原始数组为:");
		display(testArray);
		System.out.println("-----------------");
		testArray = sort(testArray);
		System.out.println("-----------------");
		System.out.println("最后数组为:");
		display(testArray);
		

	}

}
