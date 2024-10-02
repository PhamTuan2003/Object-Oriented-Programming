package passby;

public class EmployeeDemoClass {

    static class Employee {
        private String name;
        private Float salary;

        public Employee() {
        }

        public Employee(String name, Float salary) {
            this.name = name;
            this.salary = salary;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Float getSalary() {
            return salary;
        }

        public void setSalary(Float salary) {
            this.salary = salary;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "name='" + name + '\'' +
                    ", salary=" + salary +
                    '}';
        }
    }

    public static void main(String[] args) {
        Employee employee = new Employee("Huy", 5_500_000F);
        payRaise(employee);
        System.out.println(employee);
    }

    public static void payRaise(Employee employee) {
//        employee.setSalary(10_000_000F);
        employee = new Employee("Hung", 10_000_000F);
    }
}
