Tính đóng gói là che giấu thông tin và hành vi bên trong đối tượng , chỉ tiết lộ những gì cần thiết và quy định cách truy cập thông qua các phương thức công khai. 

Tại sao cần tính đóng gói?

Tính đóng gói giúp bảo vệ dữ liệu và tránh truy cập trực tiếp đến các thuộc tính của đối tượng từ bên ngoài.Điều này có ích trong việc quản lý và bảo vệ dữ liệu , đồng thời cho phép kiểm soát cách các thành phần khác nhau tương tác đối tượng đó.

Ví dụ với Java:

Một lớp đại diện cho một người trong java , sử dụng tính đóng gói để bảo vệ thông tin các nhân như tên và tuổi của người đó.


![[donggoi.png]]

- Thuộc tính name và age được khai báo là private, nghĩa là chúng không thể truy cập trực tiếp từ bên ngoài lớp Person. Để lấy hoặc thay đổi giá trị của chúng, chúng ta sử dụng các phương thức khai getName, getAge và setAge.

- Thông tin cá nhân của người được che giấu bên trong lớp Person và bạn chỉ có thể truy cập thông qua các phương thức công khai.Điề này giúp đảm bảo rằng dữ liệu của người không bị sửa đổi hoặc truy cập một cách không kiểm soát.


***Note:  Kiểm soát quyền truy cập (Access Control)***
***Xác định rằng chỉ có thể truy cập hoặc thay đổi thuộc tính dưới những điều kiện cụ thể.***
 ví dụ: 
 ![[Screenshot 2024-09-23 215326.png]]   ![[Screenshot 2024-09-23 215338.png]]   
 - **Thuộc tính private**: Các thuộc tính `accountNumber` và `balance` được khai báo là `private`, vì vậy chúng không thể bị truy cập trực tiếp từ bên ngoài.
    
- **Các phương thức getter**: Các phương thức `getAccountNumber()` và `getBalance()` cho phép truy cập số tài khoản và số dư một cách an toàn.
    
- **Phương thức setter với kiểm tra điều kiện**: Phương thức `deposit(double amount)` chỉ cho phép gửi tiền nếu số tiền gửi lớn hơn 0. Tương tự, phương thức `withdraw(double amount)` chỉ cho phép rút tiền khi số tiền hợp lệ (không lớn hơn số dư và phải lớn hơn 0).

