**1.Auto Cast (tự động ép kiểu):**

*Auto cast, hay còn gọi là implicit casting, là quá trình java tự động chuyển đổi dữ liệu nhỏ hơn hoặc tương thích sang kiểu dữ liệu lớn hơn  mà không cần can thiệp thủ công.*

**Điều kiện:**
- Chỉ áp dụng cho các kiểu dữ liệu tương thích và chuyển từ nhỏ hơn sang kiểu lớn hơn.
- Không có nguy cơ mất dữ liệu khi chuyển đổi.

- int value = 100;
- long num = value; // Tự động ép kiểu từ int sang long

- Các kiểu tự động ép kiểu :
- byte -> short -> int -> long -> float -> double
- char -> int 

- float f = 10; // tự động ép kiểu từ int sang float
- double d = f; // tự động ép kiểu từ float sang double

2. Manual Cast (Ep kiểu thủ công)
Manual cast, hay còn gọi là explicit casting là quá trình can thiệp thủ công để chuyển đổi kiểu dữ liệu từ một kiểu lớn hơn sang kiểu nhỏ hơn hoặc giữa các kiểu không hoàn toàn tương thích.

Điều kiện:
- Cần khi chuyển từ kiểu lớn hơn sang kiểu nhỏ hơn
- Cần khi chuyển đổi giữa các kieerur dữ liệu không hoàn toàn tương thích;
- Có thể gây mất dữ liệu hoặc lỗi runtime.

Ví dụ về Manual Cast:

long num = 10000000000000;
int value = (int) num; // Ep kiểu thủ công từ long sang int
(Note: *Sẽ mất dữ liệu , do giá trị long quá lớn so với int*)

- Khi ép kiểu giữa các lớp đối tượng, cần đảm bảo rằng hai lớp đó có quan hệ kế thừa hoặc là cùng một hệ thống kiểu dữ liệu, Nếu không, sẽ xảy ra lỗi ClassCastException tại runtime.
Test 1:
1. Object obj = "Hello";
2. String str = (String) obj; // Ep kiểu thủ công từ Object sang string, hợp lệ
Test 2:
3. Object objNum = 100;
4. String strNum = (String) objNum; // Lỗi runtimeClassCastException