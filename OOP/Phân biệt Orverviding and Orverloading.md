- **Orverriding(Ghi đè)** :

- Xảy ra khi một lớp con kế thừa và định nghĩa lại một phương thức của lớp cha.Khi đó phương thức của lớp con sẽ ghi đè lên phương thức của lớp cha.

- **Orverloading(Nạp chồng):**

- Xảy ra khi một lớp có nhiều phương thức cùng tên nhưng khác nhau về kiểu hoặc số lượng tham tham số.


*Orverloading và Polymorphism (compile-time)*

*Khi nạp chồng phương thức, trình biên dịch sẽ xác định phiên bản nào của phương thức thức cần được gọi dựa trên kiểu và số lượng tham số*

*Orverriding và  Polymorphism (runtime)*

*Khi một phương thức bị ghi đè trong lớp con quyết định về việc sử dụng phiên bản của lớp nào sẽ được đưa ra trong quá trình thực thi (runtime).Điều này cho phép các đối tượng thuộc các lớp con khác nhau phản ứng khác nhau đối với cùng một phương thức, dựa trên kiểu đối tượng thực tế tại runtime*