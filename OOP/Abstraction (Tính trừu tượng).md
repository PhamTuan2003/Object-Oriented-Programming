Tại sao cần tính trừu tượng?
Tính trừu tượng giúp tạo ra mã nguồn dễ bảo trì dễ mở rộng .Nó cho phép tạo các lớp trừu tượng và định nghĩa các giao diện để đảm bảo rằng các đối tượng sẽ tuân thủ một số quy tắc và chuẩn cố định.

Tập trung vào những gì một đối tượng làm, mà không cần quan tâm đến cách mà nó thực hiện những công việc đó, là ẩn đi những chi tiết cụ thể và chỉ hiển thị các tính năng cần thiết cho người dùng.

Cộng dụng của tính trừu tượng
1. **Giam độ phức tạp:** Bằng cách ẩn đi các chi tiết không cần thiết, tính trừu tượng giúp giảm độ phức tạp hệ thống. Người dùng chỉ cần biết cách sử dụng đối tượng mà không cần hiểu cách hoạt động bên trong.
2. **Tăng tính linh hoạt**: Các chi tiết cài đặt có thể thay đổi mà không ảnh hưởng đến cách mà người dùng tương tác với đối tượng. Điều này giúp dễ dàng nâng cấp và bảo trì mã nguồn.
Có hai cách chính để thực hiện tính trừu tượng trong OOP:

1. **Lớp trừu tượng (Abstract Class)**: Đây là lớp không thể được khởi tạo, chỉ được sử dụng làm lớp cha cho các lớp khác. Lớp trừu tượng có thể chứa cả phương thức trừu tượng (phương thức không có phần thân) và phương thức bình thường (có phần thân).
    
2. **Interface**: Đây là một kiểu trừu tượng hoàn toàn, nơi chỉ định nghĩa các phương thức mà không có phần thân. Các lớp thực hiện interface phải cung cấp cài đặt cho tất cả các phương thức trong interface đó.


