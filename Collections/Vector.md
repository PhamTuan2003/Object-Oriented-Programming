
| Title  | Description                                                                                                                                                                                                                                                                                                                                     |
| ------ | ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| Vector | `Vector triển khai một mảng động có nghĩa là nó có thể tăng hoặc giảm tùy theo yêu cầu. Giống như một mảng, nó chứa các thành phần có thể được truy cập bằng cách sử dụng chỉ số nguyên.`                                                                                                                                                       |
|        | `Chúng rất giống với ArrayList nhưng vector được đồng bộ hoá và có một số phương thức cũ mã không còn sử dụng. Nó cũng duy trì thứ tự chèn như arrayList. Tuy nhiên nó hiếm khi được sử dụng trong môi trường không có luồng vì nó được đồng bộ hoá và do đó nó có hiệu suất kém trong việc thêm, tìm kiếm, xoá và cập nhật các phần tử của nó` |
|        | `Iterator được trả về bởi lớp Vector là fail-fast. Trong trường hợp sửa đổi đồng thời, nó sẽ fail và ném ra ConcurrentModificationException.`                                                                                                                                                                                                   |
```java
// Java Program to Demonstrate Working of Vector
// Via Creating and Using It
// Importing required classes
import java.io.*;
import java.util.*;

// Main class
class GFG {

    // Main driver method
    public static void main(String[] args)
    {
        // Size of the Vector
        int n = 5;

        // Declaring the Vector with
        // initial size n
        Vector<Integer> v = new Vector<Integer>(n);

        // Appending new elements at
        // the end of the vector
        for (int i = 1; i <= n; i++)
            v.add(i);

        // Printing elements
        System.out.println(v);

        // Remove element at index 3
        v.remove(3);

        // Displaying the vector
        // after deletion
        System.out.println(v);

        // iterating over vector elements
        // using for loop
        for (int i = 0; i < v.size(); i++)

            // Printing elements one by one
            System.out.print(v.get(i) + " ");
    }
}

```


| Ưu điểm của việc sử dụng Vector trong Java         | *- Đồng bộ hóa: Như đã đề cập trước đó, Vector được đồng bộ hóa, giúp sử dụng an toàn trong môi trường đa luồng.*<br>*- Kích thước động: Kích thước của Vector có thể tăng hoặc giảm một cách linh hoạt khi các phần tử được thêm vào hoặc xóa đi, do đó bạn không cần phải lo lắng về việc thiết lập kích thước ban đầu phù hợp với tất cả các phần tử.*<br>*- Hỗ trợ cũ: Vector là một phần của Java kể từ khi thành lập và vẫn được hỗ trợ, do đó, đây là lựa chọn tốt nếu bạn cần làm việc với mã Java cũ hơn sử dụng Vector.* |
| -------------------------------------------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `Nhược điểm của việc sử dụng Vector trong Java`    | `- Hiệu suất: Việc đồng bộ hóa trong Vector có thể dẫn đến hiệu suất chậm hơn so với các lớp bộ sưu tập khác, chẳng hạn như ArrayList.<br>- Mã cũ: Mặc dù Vector vẫn được hỗ trợ, nhưng mã Java mới hơn thường được viết bằng các lớp bộ sưu tập hiện đại hơn, do đó có thể khó tìm ví dụ và hỗ trợ cho Vector hơn.<br>- Chi phí không cần thiết: Nếu bạn không cần tính năng đồng bộ hóa của Vector, việc sử dụng nó sẽ làm tăng thêm chi phí không cần thiết cho mã của bạn.`                                                    |
| **Sự khác biệt đáng kể giữa ArrayList và Vector:** |                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    |
| `Đồng bộ hoá:`                                     | `Được đồng bộ hoá nghĩa là chỉ một luồng tại một thời điểm có thể truy cập mã, trong khi arrayList không đồng bộ hoá nghĩa là nhiều luồng có thể làm việc trên ArrayList cùng một lúc, Ví dụ nếu một luồng đang thực hiện thao tác xoá trong môi trường đa luồng.Nếu nhiều luồng truy cập ArrayList đồng thời thì chúng ta phải đồng bộ hoá khối mã sửa đổi danh sách về mặt cấu trúc hoặc cho phép sửa đổi phần tử đơn giản`                                                                                                      |
| - **Hiệu suất:**                                   | `ArrayList nhanh hơn. Vì nó không được đồng bộ hóa, trong khi các hoạt động vector có hiệu suất chậm hơn vì chúng được đồng bộ hóa (an toàn cho luồng), nếu một luồng hoạt động trên một vector, nó đã có được khóa trên đó, buộc bất kỳ luồng nào khác muốn hoạt động trên đó phải đợi cho đến khi khóa được giải phóng.`                                                                                                                                                                                                         |
| Data Growth                                        | `Đều tăng và giảm một cách động ArrayList và Vector để duy trì việc sử dụng lưu trữ tối ưu – nhưng cách chúng thay đổi kích thước là khác nhau. ArrayList tăng 50% kích thước mảng hiện tại nếu số lượng phần tử vượt quá khả năng của nó, trong khi vector tăng 100% – về cơ bản là tăng gấp đôi kích thước mảng hiện tại. `                                                                                                                                                                                                      |
