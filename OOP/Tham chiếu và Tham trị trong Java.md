
**1: Tham trị (Pass by value)**

- Khi bạn truyền một giá trị nguyên thủy vào một phương thức , java sẽ sao chép giá trị của biến và truyền bản sao đó vào phương , Java sẽ sao chép giá trị của biến truyền và truyền bản sao đó vào phương thức. Điều này có nghĩa là mọi thay đổi đối với giá trị trong phương thức sẽ không ảnh hưởng đến biến ban đầu .

public class Main{
	public static void main(String[] args){
			int x = 5;
			changeValue(x);
			System.out.println(x); // Kết quả sẽ là 5
	}
	public static void changeValue(int num){
		    num = 10;  // Thay đổi chỉ xảy ra trên biến cục bộ "num"
	}
}

**2: Tham chiếu (Pass by Reference):**

- Trong java tất cả các đối tượng (objects) đều được truyền theo tham chiếu, nhưng cơ chế thực sự vẫn là pass-by-value của tham chiếu. Điều này có nghĩa là java sao chép giá trị của biến tham chiếu (địa chỉ đối tượng) và truyền bản sao đo vào phương thức .
- Do đó, nếu bạn thay đổi các thuộc tính của đối tượng thông qua tham chiếu , đối tượng ban đầu cũng sẽ thay đổi.

- Tuy nhiên , nếu bạn thay đổi giá trị của biến tham chiếu (chuyển nó trỏ tới một đối tượng khác), điều này sẽ không ảnh hưởng đến biến ba đầu.

class Dog{
	String name;
}

public class Main{
		public static void main(String[] args){
			Dog myDog = new Dog();
			myDog.name = "Rex";
			System.out.println(myDog.name); // Kết quả sẽ là "Fido"
		}

		public static void changeDogName(Dog dog){
				dog.name = "Fido";
				 // Thay đổi thuộc tính của đối tượng ban đầu
		}
}

Ví dụ tham trị trong java:

public class Main {
    public static void main(String[] args) {
        int x = 10;               // Khởi tạo biến x với giá trị 10
        System.out.println("Trước khi gọi hàm: x = " + x);
        
        changeValue(x); 
        // Gọi phương thức và truyền biến x vào
        
        System.out.println("Sau khi gọi hàm: x = " +x);  
        // Kết quả vẫn là 10
    }
    public static void changeValue(int number) {
        number = 20;              
        // Thay đổi giá trị của tham số number
        System.out.println("Trong hàm changeValue: number = " + number);
    }
}
- Ở đây, biến `x` là một kiểu dữ liệu nguyên thủy (`int`), và khi nó được truyền vào phương thức `changeValue`, Java thực hiện cơ chế **pass by value** (tham trị). Điều này có nghĩa là một **bản sao** của giá trị của `x` được truyền vào phương thức, chứ không phải chính bản thân `x`.
- Trong phương thức `changeValue`, biến `number` (đã nhận giá trị sao chép từ `x`) được thay đổi thành 20. Tuy nhiên, điều này **không ảnh hưởng** đến giá trị gốc của `x` trong phương thức `main`.

- Trước khi gọi hàm: x = 10
- Trong hàm changeValue: number = 20
- Sau khi gọi hàm: x = 10
