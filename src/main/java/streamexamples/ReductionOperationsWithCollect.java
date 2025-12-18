package streamexamples;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ReductionOperationsWithCollect {

    public static void main(String[] args) {
    /*
        List<String> names = Arrays.asList("David", "Marry", "Clark", "Andy", "Sara", "Marry");
        List<String> collectedNames = names.stream()
                .filter(n -> n.length() > 4)
                .collect(Collectors.toList());

        System.out.println("Names with more than 4 characters: " + collectedNames);

        Set<String> collectedNamesSet = names.stream()
                .filter(n -> n.length() > 4)
                .collect(Collectors.toSet());

        System.out.println("Names with more than 4 characters in a set: " + collectedNamesSet);

        String joinedNames = names.stream()
                .collect(Collectors.joining(", ", "[", "]"));

        System.out.println("Joined Names: " + joinedNames);

        Map<Integer, List<String>> groupedByLength = names.stream()
                .collect(Collectors.groupingBy(n -> n.length()));

        System.out.println("Names grouped by length: " + groupedByLength);

       Map<Boolean,List<String>> partitionedByLength = names.stream()
                .collect(Collectors.partitioningBy(n -> n.length() > 4));

        System.out.println("Names partitioned by length > 4: " + partitionedByLength);

        LinkedList<String> linkedListNames = names.stream()
                .filter(n -> n.length() > 4)
                .collect(Collectors.toCollection(LinkedList::new));

        System.out.println("Names with more than 4 characters in a LinkedList: " + linkedListNames);
    */
        List<Employee> employees = Arrays.asList(
                new Employee("David", 3000, Employee.Sex.MALE),
                new Employee("Marry", 2500, Employee.Sex.FEMALE),
                new Employee("Clark", 3500, Employee.Sex.MALE),
                new Employee("Andy", 4500, Employee.Sex.MALE),
                new Employee("Sara", 2000, Employee.Sex.FEMALE)
        );
        /*
        Map<Employee.Sex, Integer> totalSalaryByGender = employees.stream()
                .collect(Collectors.groupingBy(Employee::getGender,
                        Collectors.summingInt(Employee::getSalary)));

        System.out.println("Total salary by gender: " + totalSalaryByGender);

        SalaryCollector salaryCollector = employees.stream()
                .map(Employee::getSalary)
                .collect(
                        SalaryCollector::new,
                        SalaryCollector::accept,
                        SalaryCollector::combine
                );

        System.out.println("Total Salary: " + salaryCollector.getTotal());
        */

        Map<Employee.Sex, SalaryCollector> totalSalaryByGenderWithCustomCollector = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getGender,
                        Collectors.mapping(Employee::getSalary,
                                Collector.of(
                                        SalaryCollector::new,
                                        SalaryCollector::accept,
                                        (salary1, salary2) -> {
                                                salary1.combine(salary2);
                                                return salary1;
                                        }
                                )
                        )
                ));


        totalSalaryByGenderWithCustomCollector.forEach((g,s) -> {
            System.out.println("Gender: " + g + ", Total Salary: " + s.getTotal() + ", Count: " + s.getCount());
        });
    }
}
