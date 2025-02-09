
# JVM:
JVM (Java Virtual Machine) là một máy trừu tượng. Nó được gọi là máy ảo vì nó không tồn tại vật lý. Nó là một đặc tả cung cấp môi trường thời gian chạy trong đó Java bytecode có thể được thực thi. Nó cũng có thể chạy các chương trình được viết bằng các ngôn ngữ khác và được biên dịch thành Java bytecode.

JVM có sẵn cho nhiều nền tảng phần cứng và phần mềm. JVM, JRE và JDK phụ thuộc vào nền tảng vì cấu hình của mỗi [hệ điều hành](https://www.javatpoint.com/os-tutorial) khác nhau. Tuy nhiên, Java không phụ thuộc vào nền tảng. Có ba khái niệm về JVM: _đặc tả_ , _triển khai_ và _thể hiện_ .

JVM thực hiện các nhiệm vụ chính sau:

- Tải mã
- Xác minh mã
- Thực thi mã
- Cung cấp môi trường thời gian chạy
### JRE

JRE là từ viết tắt của Java Runtime Environment. Nó cũng được viết là Java RTE. Java Runtime Environment là một bộ công cụ phần mềm được sử dụng để phát triển các ứng dụng Java. Nó được sử dụng để cung cấp môi trường thời gian chạy. Nó là triển khai của JVM. Nó tồn tại vật lý. Nó chứa một bộ thư viện + các tệp khác mà JVM sử dụng khi chạy.

Việc triển khai JVM cũng được nhiều công ty khác ngoài Sun Micro Systems tích cực triển khai.

### JDK

JDK là từ viết tắt của Java Development Kit. Java Development Kit (JDK) là một môi trường phát triển phần mềm được sử dụng để phát triển các ứng dụng và [applet](https://www.javatpoint.com/java-applet) Java . Nó tồn tại vật lý. Nó chứa JRE + các công cụ phát triển.

JDK là phiên bản triển khai của một trong các nền tảng Java dưới đây do Oracle Corporation phát hành:

- Nền tảng Java phiên bản chuẩn
- Nền tảng Java phiên bản doanh nghiệp
- Nền tảng Java Micro Edition

JDK chứa một Máy ảo Java (JVM) riêng và một số tài nguyên khác như trình thông dịch/trình tải (java), trình biên dịch (javac), trình lưu trữ (jar), trình tạo tài liệu (Javadoc), v.v. để hoàn thiện quá trình phát triển Ứng dụng Java.