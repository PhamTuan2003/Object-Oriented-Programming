[[Boxing và Unboxing]][[Auto cast and Manual cast]]
**Ví dụ về sử dụng Wrapper class:**
- int a = 5 ; // Kiểu nguyên thủy
- Integer aObj = Integer.valueOf(a): // Gói kiểu nguyên thủy thành đối tượng
- int b = aObj.intValue();// Lấy giá trị nguyên thủy từ đối tượng 

Tại sao cần sử dụng Wrapper class ?

1. Collections: Các kiểu nguyên thủy không thể được sử dụng trực tiếp trong các cấu trúc dữ liệu như ArrayList, HashMap,....
Do đó cần phải sử dụng Wrapper class.
1. ArrayList<Integer> number = new ArrayList<>();
   2. numbers.add(5);

II: Chuyển đổi kiểu dữ liệu:Wrapper class cung cấp các phương thức tiện lợi để chuyển đổi giữa kiểu dữ liệu nguyên thuỷ và chuỗi (string), như `Integer.parseInt()`.

III:**Tính năng Autoboxing và Unboxing**: Java hỗ trợ tự động chuyển đổi giữa các kiểu nguyên thuỷ và các Wrapper class. Điều này giúp đơn giản hóa mã nguồn.

- Autoboxing: Tự động chuyển đổi từ kiểu nguyên thuỷ thành đối tượng.
- Unboxing: Tự động chuyển đổi từ đối tượng thành kiểu nguyên thuỷ.

Integer aObj = 5; // autoboxing (tự động chuyển từ int sang Integer)
int a = aObj; // unboxing (tự động chuyển từ Integer sang int)

![[Screenshot 2024-09-26 214511.png]]