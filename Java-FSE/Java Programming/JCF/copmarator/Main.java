import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class IntegerArrayComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        if (o1.intValue() > o2.intValue()) {
            return -1;
        } else if (o1.intValue() < o2.intValue()) {
            return 1;
        } else {
            return 0;
        }
    }
}

class StringArrayComparator implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        if (o1.length() > o2.length()) {
            return 1;
        } else if (o1.length() < o2.length()) {
            return -1;
        } else {
            return 0;
        }
    }
}

// Student objects sorting
class Student {
    private String name;
    private int id;
    private double GPA;
    private int Semester;

    Student(int id, double GPA, int Semester, String name) {
        this.name = name;
        this.id = id;
        this.GPA = GPA;
        this.Semester = Semester;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public double getGPA() {
        return GPA;
    }

    public int getSemester() {
        return Semester;
    }
}

class Test {
    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>();

        list1.add(7);
        list1.add(19);
        list1.add(14);
        list1.add(1);
        list1.add(11);
        list1.add(9);
        list1.add(3);
        list1.add(4);

        // System.out.println("Before sorting the integer array is: "+list1);

        list1.sort(new IntegerArrayComparator());

        // System.out.println(list1);

        List<String> lStrings = new ArrayList<>();

        lStrings.add("mew");
        lStrings.add("articuno");
        lStrings.add("aken");
        lStrings.add("ball");
        lStrings.add("cat");
        lStrings.add("pokemon");
        lStrings.add("raichu");
        lStrings.add("squartle");
        lStrings.add("bulbasaur");

        // System.out.println("Before sorting the string array is: "+lStrings);

        // lStrings.sort(new StringArrayComparator());

        // System.out.println(lStrings);

        // * Sorting Using Lambda Expression
        list1.sort((a, b) -> a - b);

        // System.out.println("After sorting the Integer array is: "+list1);

        lStrings.sort((a, b) -> b.length() - a.length());

        // System.out.println("After sorting the String array is: "+lStrings);

        // * Sorting Objects
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, 3.27, 2, "Alice"));
        students.add(new Student(2, 4.00, 3, "Bob"));
        students.add(new Student(3, 2.58, 1, "Charlie"));
        students.add(new Student(4, 3.91, 4, "David"));
        students.add(new Student(5, 3.13, 2, "Eve"));
        students.add(new Student(6, 2.45, 1, "Frank"));
        students.add(new Student(7, 3.76, 3, "Grace"));
        students.add(new Student(8, 2.45, 2, "Heidi"));
        students.add(new Student(9, 3.68, 4, "Ivan"));
        students.add(new Student(10, 2.22, 1, "Judy"));

        for (Student s : students) {
            System.out.println("ID: " + s.getId() + ", Name: " + s.getName() + ", GPA: " + s.getGPA() + ", Semester: "
                    + s.getSemester());
        }

        System.out.println("\n");

        students.sort((s1, s2) -> (int) s2.getGPA() - (int) s1.getGPA());

        for (Student s : students) {
            System.out.println("ID: " + s.getId() + ", Name: " + s.getName() + ", GPA: " + s.getGPA() + ", Semester: "
                    + s.getSemester());
        }

        System.out.println("\n");

        // * Creating comparator using function reference
        Comparator<Student> comparator = Comparator.comparing(Student::getGPA);

        students.sort(comparator);

        for (Student s : students) {
            System.out.println("ID: " + s.getId() + ", Name: " + s.getName() + ", GPA: " + s.getGPA() + ", Semester: "
                    + s.getSemester());
        }
    }
}

