import java.util.ArrayList;
import java.util.List;

class Student {
    String name;
    int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class DeleteStudents {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("John", 20));
        students.add(new Student("Sarah", 22));
        students.add(new Student("Mike", 25));
        students.add(new Student("Sam", 23));
        students.add(new Student("Kate", 21));

        System.out.println("Original list of students:");
        System.out.println(students);

        students.removeIf(student -> student.name.startsWith("S"));

        System.out.println("List of students after deleting those whose name starts with 'S':");
        System.out.println(students);
    }
}