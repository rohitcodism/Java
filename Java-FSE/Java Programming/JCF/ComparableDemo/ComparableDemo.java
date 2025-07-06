import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Student implements Comparable<Student>{
    private double GPA;
    private String name;

    Student(String n, double g){
        this.name = n;
        this.GPA = g;
    }

    public double getGPA() {
        return GPA;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Student o) {
        return Double.compare(o.getGPA(), this.getGPA());
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "', GPA=" + GPA + "}\n";
    }
}

public class ComparableDemo {

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        students.add(new Student("Alice", 4.5));
        students.add(new Student("Bob", 3.8));
        students.add(new Student("Charlie", 4.2));
        students.add(new Student("Diana", 3.5));
        students.add(new Student("Caroline", 3.5));
        students.add(new Student("Eve", 4.7));
        students.add(new Student("Frank", 3.9));
        students.add(new Student("Grace", 4.0));

        System.out.println(students);

        //students.sort(null);

        //System.out.println(students);

        // * Sorting by custom order
        System.out.println("Sorting just according to GPA: ");
        students.sort(Comparator.comparing(Student::getGPA));
        students.forEach(System.out::println);

        // * Comparator chaining
        System.out.println("Sorting according to GPA and then Name: ");
        students.sort(Comparator.comparing(Student::getGPA).thenComparing(Student::getName));
        students.forEach(System.out::println);
    }
}