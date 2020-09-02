import java.util.Comparator;
import java.util.List;

public class Demo1 {
    public static void main(String args[]){
        int sum = sumOfNumers(List.of(7,1,2,3,4,4,5,5,6,6));
        System.out.println(sum);
    }

    private static int sumOfNumers(List<Integer> numbers) {
        numbers.stream()
            .distinct()
            .sorted(Comparator.reverseOrder())
            .forEach(System.out::println);

        return numbers.stream()
            .distinct()
            .reduce(0,Integer::sum);
    }
    
}