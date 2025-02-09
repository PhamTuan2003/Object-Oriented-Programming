Một hệ thống máy tính thường có nhiều Process và Thread đang hoạt động .
Đúng ngay cả khi các hệ thống chỉ có một lõi thực thi
Thời gian xử lý cho một lõi được chia sẻ giữa các Process và Thread qua một tính năng của hệ điều hành được gọi là Time Slicing

Tiến trình (Process) là gì ?
Tiến trình là một thể hiện của một chương trình đang chạy trong hệ thống. Mỗi tiến trình sở hữu một con trỏ lệnh, tập các thanh ghi và các biến thể riêng.Để hoàn thành công việc , tiến trình cần sử dụng các tài nguyên như CPU , bộ nhớ, .....

Để phân biệt giữa tiến trình và chương trình, chúng ta cần hiểu rằng một chương trình là một thực thể tĩnh, nó chỉ chứa các chỉ thị điều khiển máy tính để thực hiện một tác vụ cụ thể. Khi được thực thi, chương trình trở thành một tiến trình.

Một tiến trình có thể sở hữu nhiều luồng (threads) để thực hiện các tác vụ đồng thời. Tiến trình và luồng là hai khái niệm quan trọng liên quan đến đa nhiệm và đa luồng trong lập trình.


### **Cấu trúc của Process**

1. **Code Section (Text Section):** Chứa mã chương trình.
2. **Data Section:** Lưu các biến toàn cục đã được khởi tạo hoặc chưa khởi tạo.
3. **Heap:** Phần bộ nhớ động dành cho cấp phát và giải phóng dữ liệu khi chương trình chạy.
4. **Stack:** Lưu các lời gọi hàm, biến cục bộ, và con trỏ quay lại.
5. **Registers:** Bộ nhớ nhanh lưu trữ trạng thái hiện tại của tiến trình.


### **Mô hình trạng thái của Process**

Process có thể trải qua nhiều trạng thái khác nhau:

1. **New (Mới):** Process vừa được tạo, đang chờ cấp phát tài nguyên.
2. **Ready (Sẵn sàng):** Process đã có tài nguyên, chờ CPU để thực thi.
3. **Running (Đang chạy):** Process đang thực thi trên CPU.
4. **Waiting (Chờ đợi):** Process tạm dừng, chờ một sự kiện (ví dụ: I/O).
5. **Terminated (Kết thúc):** Process hoàn thành hoặc bị dừng.

### **Process Context**

**Process Context** là tập hợp các thông tin cần thiết để tiếp tục thực thi một tiến trình. Nó bao gồm:

- **Program Counter (PC):** Địa chỉ lệnh tiếp theo cần thực thi.
- **CPU Registers:** Trạng thái của các thanh ghi.
- **Memory Management Information:** Thông tin phân bổ bộ nhớ.
- **I/O Status Information:** Trạng thái thiết bị I/O.


### **Context Switch là gì?**

**Context Switch (chuyển ngữ cảnh)** xảy ra khi CPU chuyển từ thực thi một tiến trình sang tiến trình khác. Trong quá trình này:

- Hệ điều hành lưu lại **Process Context** của tiến trình hiện tại.
- Khôi phục **Process Context** của tiến trình mới.

**Khi nào xảy ra Context Switch?**

1. Khi có **multitasking** (đa nhiệm).
2. Khi một tiến trình chuyển sang trạng thái chờ.
3. Khi ưu tiên của một tiến trình khác cao hơn.