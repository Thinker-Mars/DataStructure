package array;

public class MyArray {
	private int elems;//数组有效长度
	private int[] array;//定义的int数组
	private int length;//数组长度
	
	//无参的构造函数
	public MyArray() {
		elems = 0;
		length = 20;
		array = new int[length];
	}
	//有参数长度的构造函数
	public MyArray(int length) {
		elems = 0;
		this.length = length;
		array = new int[length];
	}
	//获取数组长度
	public int getSize() {
		return elems;
	}
	//遍历显示数组
	public void display() {
		for (int i = 0; i < elems; i++) {
			System.out.print(array[i]+ " ");
		}
	}
	//添加元素
	public boolean add(int value) {
		if (elems == length) {
			return false;
		}
		else {
			array[elems] = value;
			elems++;
			return true;
		}
	}
	//根据下标查找value
	public int get(int i) {
		if (i <0 || i > elems) {
			System.out.print("下标越界!");
		}
		return array[i];
	}
	//根据查找的元素返回下标
	public int find(int value) {
		int i;
		//这里循环时使用上面定义的i来遍历，这样就只用定义一个变量，很巧
		for (i = 0; i < elems; i++) {
			if (array[i] == value) {
				break;
			}
		}
		//若i=elems，则说明数组中没有找到该值,因为只有这样才会出现i=elems，在数组内存在查询值的情况下，i最大只到elems-1
		if (i == elems) {
			return -1;
		}
		
		return i;
		
	}
	//根据value删除数组中的值
	public boolean delete(int value) {
		int index = find(value);
		if (index == -1) {
			return false;
		}
		else {
			if (index == elems-1) {
				elems--;
			}
			else {
				for (int k = index; k < elems-1; k++) {
					array[k] = array[k+1];
				}
				elems--;
			}
			return true;
		}
	}
	//修改数据
	public boolean modify(int oldValue, int newValue) {
		int index = find(oldValue);
		if (index == -1) {
			System.out.println("数据不存在");
			return false;
		}
		else {
			array[index] = newValue;
			return true;
		}
		
	}

}
