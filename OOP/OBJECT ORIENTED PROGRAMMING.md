**Các loại access modifier:**
[[Cast Type (ÉP KIỂU)]] [[Phân biệt CLASS VÀ OBJECT]][[Constructor in java]][[STATIC AND FINAL]][[INTERFACE IN JAVA]][[Phân biệt Orverviding and Orverloading]]
**public:**
Thành phần được đánh dấu là public có thể được truy cập từ bất kỳ đâu trong chương trình, bao gồm (class con, class bên ngoài).

*! Mức độ truy cập rộng nhất.*

**private:**
	- Thành phần được đánh dấu là private chỉ có thể được truy cập bên trong lớp chứa nó

*! Mức truy cập hạn chế.*

**protected:**
	Cho phép các lớp con truy cập vào các thành phần protected của lớp cha.
Lớp con có thể mở rộng các thành phần protected của lớp cha.(Hữu ích khi tạo các lớp con có tính kế thừa từ lớp cha mà không cần viết lại code)
Không cho phép truy cập từ các lớp không cùng package và không phải là con.

**default:**
	- Default access chỉ cho phép truy cập trong cùng một package và không thể sử dụng để cho phép truy cập từ các gói khác.
- Default method trong interface cung cấp một cách để thêm các phương thước vào interface mà không phá vỡ các lớp hiện có triển khai interface đó.

- ! Khi khai báo một method trong interface là default thì khi một class implement không cần phải triển khai method này.