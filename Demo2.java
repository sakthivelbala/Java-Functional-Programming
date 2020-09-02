import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class Demo2 {

    public static void main(String args[]){
        Predicate<Integer> evenFilterPredicate = x->x%2==0;
        Function<Integer,Integer> squareMapper = x->x*x;
        Consumer<Integer> sysOutConsumer = System.out::println;

        BinaryOperator<Integer> sumBinaryOperator = (x,y)->x+y;
        UnaryOperator<Integer> into3=(x)->3*x;

        Supplier<Integer> randomSupplier=()->2;

        System.out.println(List.of(1,2,3,4,5,6).stream()
            .filter(evenFilterPredicate)
            .map(squareMapper)
            .reduce(0,sumBinaryOperator));
            // .forEach(sysOutConsumer);


        List<Integer> squaredNumbers=squareNumbers(List.of(1,2,3,4,5,6),x->x*x);
        System.out.println(squaredNumbers);
        System.out.println(randomSupplier.get());
        System.out.println(into3.apply(4));
    }

    private static List<Integer> squareNumbers(List<Integer> numbers, Function<Integer,Integer> function) {
        return numbers.stream()
            .map(function)
            .collect(Collectors.toList());
    }
    
}