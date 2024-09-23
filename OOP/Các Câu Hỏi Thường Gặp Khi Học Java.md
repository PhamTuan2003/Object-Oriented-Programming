
1. Super Class có 1 method để access modifier là protected thì Sub Class override lại method đấy có để public được không?
- Có thể ghi đề một phương thức là protected trong lớp cha(superclass) và thay đổi access modifier thành public trong lớp con(subclass)
- Lý do là vì khi override một phương thức có thể mở rộng phạm vi truy cập (protected -> public), nhưng không thể thu hẹp phạm vi truy cập(protected -> private).Để các phương thức trong lớp con có thể truy cập ở cùng hoặc phạm vi rộng hơn lớp cha.

Bước 1: Tạo lớp cha có phương thức là prootected:

![[Screenshot 2024-09-18 233235 1.png]]

Bước 2: Lớp con ghi đè phương thức lớp cha và giảm phạm vi truy cập protected->private
(Sẽ gây ra lỗi error)

![[Screenshot 2024-09-18 233334.png]]

Bước3: Lớp con ghi đè phương thức lớp cha và tăng phạm vi truy cập từ protected -> public

![[Screenshot 2024-09-18 233312.png]]

3. Super Class có 1 method throws IllegalArgumentException, Sub Class  override lại có throws được Exception k
- Nếu phương thức trong superclass throws một checked exception thì phương thức override trong subclass chỉ được phép:
	+Ném cùng ngoại lệ đó.
	+Ném một ngoại lệ con của ngoại lệ đã khai báo trong superclass
	+Có thể không ném ngoại lệ gì cả.

- Phương thức trong supperclass throws một unchecked exception(như IllegalArgumentException ), thì phương thức override có thể:
    +Ném bất kỳ unchecked exception nào (bao gồm cả `IllegalArgumentException` hoặc các unchecked exception khác).
    +Không thể ném checked exception mà không khai báo trong phương thức cha.

Một số checked exception hay dùng
- `IOException`
- `SQLException`
- `FileNotFoundException`
- `ClassNotFoundException`
*Thường xảy ra trong các tình huống có thể dự đoán được trong runtime.(hay sử lý bằng try-catch or throws)*
Một số unchecked exception 
- `RuntimeException`
- `NullPointerException`
- `ArrayIndexOutOfBoundsException`
- `IllegalArgumentException`
*Thường xảy ra trong trường hợp không dự đoán được (VD : truy cập phần tử ngoài giới hạn của mảng)*
![[Screenshot 2024-09-18 234658.png]]
1. Sub Class override lại được public static method ở Super Class được k
Không thể orerride được vì phương thức tĩnh static method không tuân theo cơ chế ghi đè :
+Static thuộc về class, không phải đối tượng và không thể bị override.
*Nhưng có thể định nghĩa lại phương thức khai báo là static bằng cách tạo một phương thức tĩnh mới cùng tên và kiểu tham số.*

2. Tại sao cần encapsulation


3. Mutable, Immutable, Shadow Copy, Deep Copy

Mutable(có thể thay đổi)
- Có thể thay đổi trạng thái của nó sau khi khởi tạo
- Vidu: StringBuilder, ArrayList, HashMap là mutable và có thể thay đổi nội dung của chúng mà không cần tạo ra đối tượng mới
![[Screenshot 2024-09-20 104931 1.png]]
- Immutable(Không thể thay đổi)
- Đối tượng **immutable** không thể thay đổi sau khi đã được khởi tạo. Mọi thao tác thay đổi trên nó sẽ tạo ra đối tượng mới.
- ![[Screenshot 2024-09-20 105110.png]]

Shallow Coppy (Sao chép nông)
-  **Shallow copy** tạo ra một bản sao của đối tượng, nhưng các đối tượng con bên trong chỉ được sao chép tham chiếu, không sao chép nội dung thực sự.
- Điều này có nghĩa là nếu bạn thay đổi dữ liệu bên trong đối tượng con, cả bản gốc và bản sao sẽ bị ảnh hưởng.

![[Screenshot 2024-09-20 105316.png]]
Deep Copy (Sao chép sâu)
- **Deep copy** sao chép toàn bộ đối tượng và các đối tượng con của nó. Điều này đảm bảo rằng bản sao hoàn toàn độc lập với bản gốc.
- Khi bạn thay đổi dữ liệu trong bản sao, dữ liệu của bản gốc không bị ảnh hưởng.

![[Screenshot 2024-09-20 105623.png]]
![[Screenshot 2024-09-20 105653.png]]

3. Integer a = null; int b = 1; a == b trả giá trị gì ?
Biểu thức a == b sẽ gây ra lỗi NullPoiterException trong java
Vì Interger a == null; nghĩa là biến a đang trỏ tới giá trị null
	int b = 1 là biến kiểu nguyên thủy (primitive), không thể null.
	Khi biểu thức a == b được thực hiện, java sẽ tự động unbox đối tượng a từ kiểu Integer sang kiểu int  để so sánh với biến b.Tuy nhiên vì a là null việc unbox sẽ dẫn tới NullPoiterException do không thể unbox giá trị null thành kiểu int.
	
4. Có 2 interface A và B đều có method default giống nhau, nếu class C implements cả A và B thì C lấy method default nào?
		Nó sẽ vẫn Override được nhưng nó sẽ không biết phải chọn phương thức nào ?
		Phải dùng từ khóa super() để gọi đến thằng cha của nó và xác định xem cần sử dụng phương thức của A hay B.
	- ![[Screenshot 2024-09-20 111016.png]]