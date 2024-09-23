**Tại sao cần tính kế thừa  ?**

- Tính kế thừa giúp tái sử dụng mã nguồn và tạo ra các cấu trúc phân cấp cho các lớp. Cho phép xây dựng các lớp mới trên cơ sở của các lớp đã có.
- (Lớp con có thể tái sử dụng các thành phần của lớp cha, đồn thời mở rộng và thêm các chức năng riêng mà không cần viết lại toàn bộ code)

- Tính tái sử dụng(Resusability) : Lớp con có thể sử dụng lại tất cả các thuộc tính và phương thức mà lớp cha đã định nghĩa mà không cần viết lại mã.

- Tính mở rộng(Extensibility): Lớp con có thể mở rộng chức năng của lớp cha bằng cách thêm các phương thức và thuộc tính mới hoặc ghi đè (override) các phương thức của lớp cha.

- Tính phân cấp (Hierarchical structure): Kế thừa giúp xây dựng cấu trúc phân cấp trong hệ thống, giúp quản lý và tổ chức các lớp theo dạng cây kế thừa rõ ràng.

- Tính đa hình (Polymorphism): Lớp con có thể thay đổi hoặc ghi đè (override) các phương thức của lớp cha để có hành vi khác nhau, nhưng vẫn giữ cùng tên và kiểu dữ liệu của phương thức đó.

Lớp con sẽ kế thừa những gì từ lớp cha?

1. Thuộc tính: Lớp con sẽ kế thừa các thuộc tính public và protected từ lớp cha.Tuy nhiên thì các thuộc tính private sẽ không được kế thừa trực tiếp nhưng có thể truy cập thông qua các phương thức getter và setter .
2. Phương thức(method): Lớp con kế thừa tất cả phương thức public và protected từ lớp cha. Lớp con cũng có thể ghi đè (override) các phương thức này nếu cần thay đổi hành vi.
3. Constructor: Lớp con không kế thừa constructor từ lớp cha nhưng có thể gọi constructor của lớp thông quan từ khóa super() để khởi tạo các thuộc tính từ lớp cha.

![[Screenshot 2024-09-23 223159.png]]    

![[Screenshot 2024-09-23 223211.png]]


