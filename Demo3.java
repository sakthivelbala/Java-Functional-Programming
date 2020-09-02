import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Course{
    private String name;
    private String category;
    private int reviewScore;
    private int noOfStudents;

    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getReviewScore() {
        return reviewScore;
    }

    public void setReviewScore(int reviewScore) {
        this.reviewScore = reviewScore;
    }

    public int getNoOfStudents() {
        return noOfStudents;
    }

    public void setNoOfStudents(int noOfStudents) {
        this.noOfStudents = noOfStudents;
    }

    public Course(String name, String category, int reviewScore, int noOfStudents) {
        this.name = name;
        this.category = category;
        this.reviewScore = reviewScore;
        this.noOfStudents = noOfStudents;
    }

    @Override
    public String toString() {
        return "Course [category=" + category + ", name=" + name + ", noOfStudents=" + noOfStudents + ", reviewScore="
                + reviewScore + "]\n";
    }
    
}

public class Demo3 {

    public static void main(String args[]) {
        List<Course> courses=List.of(new Course("java", "programing", 10, 2000),
            new Course("c", "programing", 10, 425),
            new Course("c++", "programing", 8, 2000),
            new Course("python", "dummy", 7, 567),
            new Course("js", "dummy", 4, 2000)
        );
        System.out.println(
            courses.stream().allMatch(course->course.getReviewScore()>3)
        );
        System.out.println(
            courses.stream().noneMatch(course->course.getReviewScore()<4)
        );
        System.out.println(
            courses.stream().anyMatch(course->course.getReviewScore()==9)
        );
        System.out.println(
            courses.stream().sorted(
                Comparator.comparing(Course::getNoOfStudents)
                    .reversed()).   
                collect(Collectors.toList())
        );
        System.out.println(
            courses.stream().sorted(
                Comparator.comparing(Course::getNoOfStudents)
                    .thenComparing(Course::getReviewScore)
                    .reversed())
                .limit(3)
                .skip(1). 
                collect(Collectors.toList())
        );

        System.out.println(
            courses.stream()
                .takeWhile(course->course.getReviewScore()>8).   
                collect(Collectors.toList())
        );
        System.out.println(
            courses.stream()
                .dropWhile(course->course.getReviewScore()>8). 
                findAny().orElse(
                    new Course("js", "dummy", 4, 2000)
                )
                // collect(Collectors.toList())
        );

        System.out.println(
            courses.stream()
                .collect(Collectors.groupingBy(Course::getCategory))
        );
        System.out.println(
            courses.stream()
                .collect(Collectors.groupingBy(Course::getCategory,
                    Collectors.counting())
                    )
        );

        System.out.println(
            courses.stream()
                .collect(Collectors.groupingBy(Course::getCategory,
                    Collectors.maxBy(
                        Comparator.comparing(Course::getReviewScore)
                    ))
                    )
        );

        System.out.println(
            IntStream.range(1, 2).sum()
        );
        System.out.println(
            IntStream.rangeClosed(1, 2).sum()
        );
        System.out.println(
            IntStream.iterate(1,e->e<10, e->e+2).peek(System.out::println).sum()
        );
        System.out.println(
            courses.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", "))
        );
        System.out.println(
            courses.stream()
                .map(course->course.getName().split(""))
                .flatMap(Arrays::stream)
                .collect(Collectors.toList())
        );
        System.out.println(
            courses.stream()
                .flatMap(
                    course->courses.stream()
                        .map(course2->List.of(course.getName(),course2.getName()))
                ).collect(
                    Collectors.toList()
                )
        );
        System.out.println(
            courses.stream()
                .flatMap(
                    course->courses.stream()
                        .filter(course2->course.getName().length()==course2.getName().length())
                        .map(course2->List.of(course.getName(),course2.getName()))
                ).filter(
                    list-> !list.get(0).equals(list.get(1))
                ).collect(
                    Collectors.toList()
                )
        );

        /**
         * 
         * 
         * min
         * max
         * find first
         * findany
         * sum
         * average
         * count
         * 
         * replaceAll
         * removeIf
         * 
         */
        
    }
    
}