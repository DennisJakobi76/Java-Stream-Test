package streamexamples;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ReductionOperationsWithReduce {

    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
                new Employee("David", 3000, Employee.Sex.MALE),
                new Employee("Marry", 2500, Employee.Sex.FEMALE),
                new Employee("Clark", 3500, Employee.Sex.MALE),
                new Employee("Andy", 4500, Employee.Sex.MALE),
                new Employee("Sara", 2000, Employee.Sex.FEMALE)
        );
        Optional<Employee> topEarner = employees.stream().reduce((emp1, emp2) -> emp1.getSalary() > emp2.getSalary() ? emp1 : emp2);
        {
            topEarner.ifPresent(emp -> System.out.println("Top Earner: " + emp.getName() + " with salary " + emp.getSalary()));

        }

        int totalSalary = employees.stream()
                .map(Employee::getSalary)
                .reduce(0, Integer::sum);
        System.out.println("Total Salary Expense: " + totalSalary);

        String concatenatedNames = employees.stream()
                .map(Employee::getName)
                .reduce("", (name1, name2) -> name1 + " " + name2);
        System.out.println("Employees: " + concatenatedNames);

        /*
        List<Integer> nums = Arrays.asList(1,2,3,4,5);

        Optional<Integer> sum = nums.stream()
                .reduce(Integer::sum);

        sum.ifPresent(s -> System.out.println("Sum: " + s));

        int sumWithInitialValue = nums.stream()
                .reduce(0,Integer::sum);

        System.out.println("Sum: " + sumWithInitialValue);

        int elementProduct = nums.stream()
                .reduce(1,(a,b) -> a * b);

        System.out.println("Product: " + elementProduct);

        Optional<Integer> max = nums.stream().reduce((a,b) -> a > b ? a : b);
        max.ifPresent(m -> System.out.println("Max: " + m));

        Optional<Integer> min = nums.stream().reduce((a,b) -> a < b ? a : b);
        min.ifPresent(mi -> System.out.println("Min: " + mi));

         */

    }
}
