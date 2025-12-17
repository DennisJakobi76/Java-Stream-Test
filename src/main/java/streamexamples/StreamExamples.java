package streamexamples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StreamExamples {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,4,10,3,6,1,15,4,9,16,5);
        numbers.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n+1)
                .sorted()
                .distinct()
                .forEach(System.out::println);

        // Terminal Operation Methods -> do not return a Stream
        // Intermediate Operation Methods -> returns a Stream

        List<String> animals = new ArrayList<>();
        animals.add("Cat");
        animals.add("Dog");
        animals.add("Cow");
    }
}
