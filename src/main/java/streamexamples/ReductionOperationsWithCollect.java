package streamexamples;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ReductionOperationsWithCollect {

    public static void main(String[] args) {

        List<String> names = Arrays.asList("David", "Marry", "Clark", "Andy", "Sara", "Marry");
        List<String> collectedNames = names.stream()
                .filter(n -> n.length() > 4)
                .collect(Collectors.toList());

        System.out.println("Names with more than 4 characters: " + collectedNames);

        Set<String> collectedNamesSet = names.stream()
                .filter(n -> n.length() > 4)
                .collect(Collectors.toSet());

        System.out.println("Names with more than 4 characters in a set: " + collectedNamesSet);
    }
}
