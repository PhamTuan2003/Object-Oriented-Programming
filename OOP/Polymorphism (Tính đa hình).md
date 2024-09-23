- Nó cho phép thực hiện cùng một hành động trên các đối tượng khác nhau mà không cần quan tâm đến loại đối tượng cụ thể.

- Tại sao cần tính đa hình?

- Tính đa hình giúp tạo ra mã nguồn linh hoạt và dễ bảo trì .Nó cho phép các phương thức chung mà có thể được sử dụng trên nhiều lớp khác nhau, giúp giảm sự lặp lại mã và tạo ra mã nguồn dễ mở rộng.


**Các loại đa hình trong OOP** 
1. Tính đa hình được chia thành hai loại chính:
2. Đa hình lúc biên dịch (Compile-time polymorphism) hay còn gọi là đa hình tĩnh:
3. Đây là kiểu đa hình mà quyết định phương thức nào sẽ được gọi được thực hiện trong thời gian biên dịch.
4. Ví dụ: 
5. Nạp chồng phương thức (method overloading) và nạp chồng toán tử (Operator overloading).

6. Đa hình lúc runtime (Runtime polymorphism) hay còn gọi là đa hình động:
7. Đây là kiểu đa hình mà quyết định phương thức nào sẽ được gọi được thực hiện trong thời gian chạy.
8. Ví dụ phổ biến của đa hình động là **ghi đè phương thức (method overriding)**.


**Đa hình lúc biên dịch (Compile-time polymorphism)**

#### Nạp chồng phương thức (Method Overloading)

**Nạp chồng phương thức** là khi một lớp có nhiều phương thức cùng tên nhưng khác nhau về số lượng hoặc kiểu dữ liệu của các tham số. Trình biên dịch sẽ quyết định phương thức nào cần được gọi dựa trên danh sách tham số.

![[Screenshot 2024-09-23 231812.png]]


- Cùng một phương thức `add()` nhưng với các danh sách tham số khác nhau (số lượng và kiểu dữ liệu), giúp ta có thể thực hiện nhiều thao tác cộng khác nhau mà không cần đặt các tên phương thức khác biệt.
    
- Trình biên dịch quyết định phương thức nào sẽ được gọi dựa trên các tham số truyền vào.

Khi lớp con kế thừa lớp cha và tạo một phương thức cùng tên nhưng với số lượng tham số khác nhau, đó là một ví dụ của **nạp chồng phương thức (method overloading)**, chứ không phải là **ghi đè phương thức (method overriding)**. Hành vi này được gọi là **đa hình lúc biên dịch (compile-time polymorphism)**, bởi vì việc quyết định phương thức nào sẽ được gọi dựa trên số lượng và kiểu tham số truyền vào, và quá trình này xảy ra tại thời gian biên dịch (compile-time).

### Ý nghĩa của việc thay đổi số lượng tham số:

- **Phương thức mới trong lớp con**: Khi lớp con tạo một phương thức cùng tên nhưng có số lượng tham số khác với phương thức trong lớp cha, nó không ghi đè (override) phương thức đó. Thay vào đó, nó tạo ra một **phương thức nạp chồng (overloaded method)**.
- **Đối với nạp chồng phương thức**, cả hai phương thức (của lớp cha và lớp con) có thể cùng tồn tại mà không có xung đột. Khi gọi phương thức, trình biên dịch sẽ quyết định dựa trên tham số truyền vào, phương thức nào sẽ được gọi.


![[Screenshot 2024-09-23 232539.png]]


**Đa hình lúc runtime (Runtime polymorphism)**

#### Ghi đè phương thức (Method Overriding)

**Ghi đè phương thức** là khi một phương thức của lớp con có cùng chữ ký (tên và danh sách tham số) với một phương thức của lớp cha, nhưng lớp con có thể định nghĩa lại phương thức đó để thực hiện hành vi khác biệt. Việc lựa chọn phương thức nào sẽ được gọi được quyết định trong thời gian chạy (runtime).

![[Screenshot 2024-09-23 232932.png]]

- Cả hai lớp `Dog` và `Cat` đều ghi đè phương thức `makeSound()` của lớp cha `Animal`.
    
- Trong thời gian chạy, đối tượng thuộc lớp `Dog` sẽ thực thi phương thức `makeSound()` của lớp `Dog`, đối tượng thuộc lớp `Cat` sẽ thực thi phương thức của lớp `Cat`.
    
- **Polymorphism** ở đây là khả năng các đối tượng `Dog` và `Cat` đều có thể được sử dụng như kiểu `Animal`, nhưng phương thức thực sự được gọi sẽ phụ thuộc vào kiểu đối tượng cụ thể trong thời gian chạy.

*Lợi ích :*
- *Tính linh hoạt : Tính đa hình cho phép sử dụng cùng một phương thức hoặc tên phương thức cho các đối tượng khác nhau mà không cần phải viết mã lặp lại.*

- ***Dễ bảo trì**: Thay vì phải viết nhiều phương thức cho từng loại đối tượng khác nhau, có thể viết chung một phương thức, điều này giúp dễ bảo trì và nâng cấp mã nguồn.*
    
- ***Tính mở rộng (Extensibility)**: Có thể mở rộng thêm các lớp mới mà không cần phải thay đổi các đoạn mã hiện có, miễn là lớp mới tuân theo cùng một giao diện hoặc kế thừa từ lớp cha chung.*