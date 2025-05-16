class Student {
    public static int count = 0;
    private int id;
    private String name;

    void setId(int id){
        this.id = id;
    }

    void setName(String name){
        this.name = name;
    }

    int getId(){
        return this.id;
    }

    String getName(){
        return this.name;
    }

    Student(){
        count++;
    }

    static void getCount(){
        System.out.println("Total number of students: "+(count));
    }
}

class Test {
    public static void main(String[] args) {
        Student s1 = new Student();
        Student s2 = new Student();
        Student s3 = new Student();
        Student s4 = new Student();
        Student s5 = new Student();

        System.out.println(Student.count);
        Student.getCount();
    }
}