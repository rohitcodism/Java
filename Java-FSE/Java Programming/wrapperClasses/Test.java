class Student {
    int id;
}
class Test{
    public static void main(String[] args) {
        Student student = new Student();
        student.id = 1;
        fun(student);
        System.out.println(" Student id: "+student.id);
    }

    private static void fun(Student a){
        Student student = new Student();
        student.id=2;
        a=student;
    }
}