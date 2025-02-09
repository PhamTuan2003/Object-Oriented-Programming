[[List]][[Linked List]][[Vector]][[Queue]]

| Title    | Description                                                                                                                                                                                                                                                     |
| -------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| Iterable | Định nghĩa: Iterable là một interface trong Java nằm trong gói java.lang. Nó đại diện cho một tập hợp các đối tượng mà bạn có thể duyệt qua. Một lớp triển khai interface Iterable cần cung cấp một phương thức iterator(), trả về một đối tượng kiểu Iterator. |
|          | **Phương thức**:<br><br>- `iterator()`: Trả về một đối tượng `Iterator` để duyệt qua các phần tử trong tập hợp.                                                                                                                                                 |
|          |                                                                                                                                                                                                                                                                 |
```java
public class ExExample{
	public static void main(String[] args){
		 ArrayList<String> list = new ArrayList<>();
		 list.add("a");
		 list.add("b");
		 list.add("c");

// ArrayList implements Iterable, so we can use iterator() 
    Iterator<String> iterator = list.iterator(); 
    while (iterator.hasNext()) {           
        System.out.println(iterator.next()); 
        } 
      }	
	}
}
```


| Iterator | Iterator là một interface trong Java, nằm trong gói java.util. Nó cung cấp các phương thức cơ bản để duyệt qua các phần tử trong một tập hợp.                                                                                                              |
| -------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
|          | - **Phương thức**:<br>    - `boolean hasNext()`: Kiểm tra xem còn phần tử nào để duyệt qua không.<br>    - `E next()`: Trả về phần tử kế tiếp trong tập hợp.<br>    - `void remove()`: Xóa phần tử hiện tại khỏi tập hợp (không bắt buộc phải triển khai). |
```java
public static void main(String[] args) {  
    List<String> list = new ArrayList<>();  
    list.add("A");  
    list.add("B");  
    list.add("C");  
  
    Iterator<String> iterator = list.iterator();  
    while (iterator.hasNext()) {  
        String element = iterator.next();  
        System.out.println(element);  
  
        if(element.equals("A")){  
            iterator.remove();  
        }  
    }  
    System.out.println("list: " + list);  
}
```


|     | Cơ chế hoạt động:                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             |
| --- | ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
|     | *hasNext():*<br>Return *true* if the iteration has more elements. (In other words, return *true* if next would return an element rather than throwing an exception)<br>*Returns: true if the iteration has more elements.*<br>`Nó trả về true nếu trình lặp có nhiều phần tử hơn, nếu không nó trả về false.`<br><br>`E next();`<br>Return the next element in the iteration<br>Throws: `NoSuchElementException` if the iteration has no more elements<br><br>`Nó trả về phần tử và di chuyển con trỏ đến phần tử tiếp theo.` |

| Collection Interface | `Giao diện Collection là giao diện được triển khai bởi tất cả các lớp trong khung bộ sưu tập. Nó khai báo các phương thức mà mọi bộ sưu tập sẽ có. Nói cách khác, chúng ta có thể nói rằng giao diện Collection xây dựng nền tảng mà khung bộ sưu tập phụ thuộc vào.` |
| -------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| List Interface       | Giao diện danh sách là giao diện con của giao diện thu thập. Nó ức chế một cấu trúc dữ liệu loại danh sách trong đó chúng ta có thể lưu trữ bộ sưu tập các đối tượng được đặt hàng. Nó có thể có các giá trị trùng lặp.                                               |
|                      |                                                                                                                                                                                                                                                                       |
