## Quá trình Autoboxing

Autoboxing hay Boxing là quá trình chuyển dữ liệu từ kiểu tham trị sang kiểu tham chiếu. Quá trình boxing một biến kiểu tham trị sẽ khởi tạo một đối tượng trong vùng nhớ Heap và copy giá trị của biến tham trị vào đối tượng mới này. Và quá trình boxing được thực hiện nhờ quá trình chuyển đổi ngầm định.



![[Screenshot 2024-09-26 215520.png]]
## Quá trình **Unboxing**

**Unboxing** là quá trình ngược lại với Boxing, tức là đưa từ kiểu tham chiếu ra kiểu tham trị. Quá trình này sẽ được thực hiện một cách tường minh. Gồm có 2 bước :

–  Bước 1 : Kiểm tra chắc chắn rằng đối tượng đã được boxing đúng kiểu giá trị đưa ra.

– Bước 2 : Copy giá trị sang biến dữ liệu kiểu tham trị.

![[Screenshot 2024-09-26 215540.png]]