import java.util.List;

public class Demo{
    public static void main(String args[]){
        printListOfNumbers(List.of(1,2,3,4,5,6));
        printListOfStrings(List.of("something","something else","more","thing","else","where"));
        printListOfStringsMoreThanFour(List.of("something","something else","more","thing","else","where"));
    }

    /**
     * 
     * 
     * please put words in (@code words)
     * 
     * @param words
     */
    private static void printListOfStringsMoreThanFour(List<String> words) {
        words.stream()
            .filter(word->word.length()>4)
            .map(word->word.length())
            .forEach(System.out::println);
    }

    private static void printListOfStrings(List<String> words) {
        words.stream()
            .filter(word->word.contains("else"))
            .forEach(System.out::println);
    }

    private static void printListOfNumbers(List<Integer> numbers) {
        numbers.stream()
            .filter(x->x%2!=0)
            .map(x->x*x)
            .forEach(System.out::println);
    }
}