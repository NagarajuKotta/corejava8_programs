import java.util.*;
import java.util.stream.Collectors;

public class ListToMap {

    static class Employee{

         private int empId;
         private String empName;
         private int salary;
         private String company;

        @Override
        public String toString() {
            return "Employee{" +
                    "empId=" + empId +
                    ", empName='" + empName + '\'' +
                    ", salary=" + salary +
                    ", company='" + company + '\'' +
                    '}';
        }

        Employee(int empId, String empName, int salary, String compamy){
             this.empId = empId;
             this.empName = empName;
             this.salary = salary;
             this.company = compamy;
         }

        public int getEmpId() {
            return empId;
        }

        public String getEmpName() {
            return empName;
        }

        public int getSalary() {
            return salary;
        }

        public String getCompany() {
            return company;
        }
    }

     public static void main(String[] args){
         Employee emp2 = new Employee(2,"kn", 1234, "ibm");
         Employee emp1 = new Employee(1,"kn1", 123, "ibm");
         Employee emp4 = new Employee(4,"kn4", 1234, "ibm");
         Employee emp3 = new Employee(3,"kn3", 12034, "ibm");
         Employee emp5 = new Employee(5,"kn5", 12345, "ibm");

         List<Employee> employeeList = new ArrayList<>();
         employeeList.add(emp1);
         employeeList.add(emp2);
         employeeList.add(emp3);
         employeeList.add(emp4);
         employeeList.add(emp5);
        // Convert List to Map
         Map<Integer, Employee> employeeMap = employeeList.stream().collect(Collectors.toMap(Employee::getEmpId, emp->emp));
         System.out.println("Employee : "+employeeMap);

         // Sorting in reverse order without duplicate allows
         List<Employee> sortList = employeeList.stream().sorted(Comparator.comparingInt(Employee::getSalary).reversed()).distinct().collect(Collectors.toList());
        System.out.println("Sorted List: "+sortList);
        System.out.println("Second highest salary: "+sortList.get(1));

        // Grouping based on salary

         Map<Integer, List<Employee>> salaryGroup = employeeList.stream().collect(Collectors.groupingBy(Employee::getSalary));
         System.out.println("Group By Salary :: "+salaryGroup);

         LinkedHashMap<Integer, List<Employee>> sortedGroup = salaryGroup.entrySet().stream()
                 .sorted(Map.Entry.<Integer, List<Employee>>comparingByKey(Comparator.reverseOrder()))
                 .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (n,o)->o, LinkedHashMap::new));
         System.out.println("Sorted :"+sortedGroup);

     }
}
