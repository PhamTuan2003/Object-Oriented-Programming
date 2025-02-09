
| Title | Description                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         |
| ----- | ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| Queue | Giao diện Queue có trong gói [java.util và mở rộng](https://www.geeksforgeeks.org/java-util-package-java/) [giao diện Collection](https://www.geeksforgeeks.org/collections-in-java-2/) được sử dụng để giữ các phần tử sắp được xử lý theo thứ tự FIFO (First In First Out). Đây là danh sách các đối tượng được sắp xếp với mục đích sử dụng giới hạn ở việc chèn các phần tử vào cuối danh sách và xóa các phần tử khỏi đầu danh sách, (tức là, nó tuân theo nguyên tắc FIFO hoặc First-In-First-Out.                                                                            |
|       | `Các phương thức chính trong Queue: boolean add(E e): Thêm phần tử vào hàng đợi. Ném ngoại lệ nếu hàng đợi đầy. boolean offer(E e): Thêm phần tử vào hàng đợi, trả về false nếu hàng đợi đầy.`<br>`E remove(): Xóa và trả về phần tử đầu tiên trong hàng đợi. Ném ngoại lệ nếu hàng đợi trống.` <br>`E poll(): Xóa và trả về phần tử đầu tiên trong hàng đợi. Trả về null nếu hàng đợi trống.` <br>`E element(): Trả về phần tử đầu tiên mà không xoá nó. Ném ngoại lệ nếu hàng đợi trống.`<br>`E peek(): Trả về phần tử đầu tiên mà không xoá nó. Trả về null nếu hàng đợi trống.` |
|       |                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     |
```java
import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();

        // add elements to the queue
        queue.add("apple");
        queue.add("banana");
        queue.add("cherry");

        // print the queue
        System.out.println("Queue: " + queue);

        // remove the element at the front of the queue
        String front = queue.remove();
        System.out.println("Removed element: " + front);

        // print the updated queue
        System.out.println("Queue after removal: " + queue);

        // add another element to the queue
        queue.add("date");

        // peek at the element at the front of the queue
        String peeked = queue.peek();
        System.out.println("Peeked element: " + peeked);

        // print the updated queue
        System.out.println("Queue after peek: " + queue);
    }
}

```
```java
// OUTPUT
Queue: [apple, banana, cherry]
Removed element: apple
Queue after removal: [banana, cherry]
Peeked element: banana
Queue after peek: [banana, cherry, date]
```


| PriorityQueue | `PriorityQueue` là một loại hàng đợi ưu tiên (priority queue), nơi mà phần tử có độ ưu tiên cao hơn sẽ được xử lý trước, thay vì theo thứ tự FIFO.<br><br>- **Đặc điểm**:<br>    - Sử dụng **min-heap** để duy trì thứ tự phần tử.<br>    - Các phần tử trong `PriorityQueue` phải có khả năng so sánh được (`Comparable` interface) hoặc phải cung cấp một comparator.<br>    - Không hỗ trợ chèn `null`.<br>    - Phần tử nhỏ nhất luôn nằm ở đầu hàng đợi. |
| ------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
```java
Queue<Integer> pq = new PriorityQueue<>();
pq.add(5);
pq.add(10);
pq.add(1);
System.out.println(pq.poll());  // Kết quả là 1 (phần tử nhỏ nhất)

```

| Deque (Double Ended Queue) | `Deque` là hàng đợi hai đầu, cho phép thêm hoặc xóa phần tử từ cả hai đầu của hàng đợi. `Deque` là viết tắt của "double-ended queue".<br><br>- **Đặc điểm**:<br>    - Hỗ trợ các phương thức để thêm/xóa từ cả hai phía (đầu và cuối hàng đợi).<br>    - Làm việc như một hàng đợi thông thường hoặc như một ngăn xếp (stack).<br>- **Các phương thức quan trọng**:<br>    - `void addFirst(E e)`: Thêm phần tử vào đầu hàng đợi.<br>    - `void addLast(E e)`: Thêm phần tử vào cuối hàng đợi.<br>    - `E removeFirst()`: Xóa và trả về phần tử đầu tiên.<br>    - `E removeLast()`: Xóa và trả về phần tử cuối cùng.<br>    - `E peekFirst()`, `E peekLast()`: Lấy phần tử từ đầu/cuối mà không xoá. |
| -------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `ArrayDeque`               | `ArrayDeque` là một triển khai của `Deque` sử dụng mảng động, có thể làm việc như cả một hàng đợi lẫn ngăn xếp.<br><br>- **Đặc điểm**:<br>    - Không có giới hạn về kích thước.<br>    - Nhanh hơn `LinkedList` khi sử dụng như một `Deque`.<br>    - Không hỗ trợ chèn `null`.<br>    - Hiệu năng tốt hơn khi cần thêm/xóa từ cả hai đầu của danh sách.                                                                                                                                                                                                                                                                                                                                               |
```java
Deque<String> deque = new ArrayDeque<>();
deque.addFirst("A");
deque.addLast("B");
System.out.println(deque.removeFirst());  // Kết quả là "A"

```

| So sánh giữa các loại Queue                                 |                                                                                                                                                                                                                           |                                                                                                                                                                                                                         |                                                                                                                                                                                                                                                 |
| ----------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| Loại Queue                                                  | Đặc điểm                                                                                                                                                                                                                  | Cấu trúc lưu trữ                                                                                                                                                                                                        | Sắp xếp                                                                                                                                                                                                                                         |
| Queue                                                       | `Hàng đợi thông thường, FIFO`                                                                                                                                                                                             | *Mảng/Linked List*                                                                                                                                                                                                      | Không ưu tiên                                                                                                                                                                                                                                   |
| PriorityQueue                                               | `Hàng đợi ưu tiên, phần tử ưu tiên cao hơn`                                                                                                                                                                               | *Min-Heap*                                                                                                                                                                                                              | Có sắp xếp                                                                                                                                                                                                                                      |
| Deque                                                       | `Hàng đợi hai đầu, thêm/xóa từ cả hai đầu`                                                                                                                                                                                | *Mảng/Linked List*                                                                                                                                                                                                      | Không sắp xếp                                                                                                                                                                                                                                   |
| ArrayDeque                                                  | `Triển khai của Deque, nhanh hơn LinkedList`                                                                                                                                                                              | *Mảng động*                                                                                                                                                                                                             | Không sắp xếp                                                                                                                                                                                                                                   |
| *Ưu điểm của việc sử dụng Giao diện hàng đợi trong Java*    |                                                                                                                                                                                                                           |                                                                                                                                                                                                                         |                                                                                                                                                                                                                                                 |
|                                                             | - **Bảo toàn thứ tự**<br>    <br>    : Giao diện Queue cung cấp một cách để lưu trữ và truy xuất các phần tử theo thứ tự cụ thể, theo nguyên tắc vào trước ra trước (FIFO).                                               | - **Tính linh hoạt**<br>    <br>    : Giao diện Queue là một kiểu con của giao diện Collection, nghĩa là nó có thể được sử dụng với nhiều cấu trúc dữ liệu và thuật toán khác nhau, tùy thuộc vào yêu cầu của ứng dụng. | - **An toàn luồng**<br>    <br>    : Một số triển khai của giao diện Queue, chẳng hạn như lớp java.util.concurrent.ConcurrentLinkedQueue, an toàn cho luồng, nghĩa là chúng có thể được nhiều luồng truy cập cùng lúc mà không gây ra xung đột. |
|                                                             |                                                                                                                                                                                                                           |                                                                                                                                                                                                                         | - **Hiệu suất**<br>    <br>    : Giao diện Queue cung cấp các triển khai hiệu quả để thêm, xóa và kiểm tra các phần tử, khiến nó trở thành một công cụ hữu ích để quản lý bộ sưu tập các phần tử trong các ứng dụng quan trọng về hiệu suất.    |
| *Nhược điểm của việc sử dụng Giao diện hàng đợi trong Java* |                                                                                                                                                                                                                           |                                                                                                                                                                                                                         |                                                                                                                                                                                                                                                 |
|                                                             | - **Chức năng hạn chế:**<br>    <br>    Giao diện Queue được thiết kế riêng để quản lý các bộ sưu tập phần tử theo thứ tự cụ thể, nghĩa là nó có thể không phù hợp với các thuật toán hoặc cấu trúc dữ liệu phức tạp hơn. | - **Hạn chế về kích thước:**<br>    <br>    Một số triển khai của giao diện Queue, chẳng hạn như lớp ArrayDeque, có kích thước cố định, nghĩa là chúng không thể phát triển vượt quá số lượng phần tử nhất định.        | - **Sử dụng bộ nhớ:**<br>    <br>    Tùy thuộc vào cách triển khai, giao diện Queue có thể yêu cầu nhiều bộ nhớ hơn các cấu trúc dữ liệu khác, đặc biệt nếu cần lưu trữ thông tin bổ sung về thứ tự các phần tử.                                |
|                                                             |                                                                                                                                                                                                                           |                                                                                                                                                                                                                         | - **Độ phức tạp**<br>    <br>    : Giao diện Queue có thể khó sử dụng và khó hiểu đối với những lập trình viên mới vào nghề, đặc biệt là nếu họ không quen với các nguyên tắc về cấu trúc dữ liệu và thuật toán.                                |
