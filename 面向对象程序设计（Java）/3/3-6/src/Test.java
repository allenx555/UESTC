class Student{
    int studentNumber;
    Student(int n){
        studentNumber = n;
    }
}

class Teacher{
    int teacherNumber;
    Teacher(int n){
        teacherNumber = n;
    }
}

class Course{
    int courseNumber;
    String[] name;
    Course(int n){
        courseNumber = n;
    }
}

class Grade{
    int n;
    int studentNumber;
    int teacherNumber;
    int courseNumber;
    Grade(int n,int a,int b,int c){
        this.n = n;
        Student gradeStudent = new Student(a);
        this.studentNumber = gradeStudent.studentNumber;
        Teacher gradeTeacher = new Teacher(b);
        this.teacherNumber = gradeTeacher.teacherNumber;
        Course gradeCourse = new Course(c);
        this.courseNumber = gradeCourse.courseNumber;
    }
}

public class Test{
    public static void main(String []args) {
        Grade grade1 = new Grade(100,1,2,3);
        System.out.println("grade1.studentNumber:\t"+grade1.studentNumber);
        System.out.println("grade1.teacherNumber:\t"+grade1.teacherNumber);
        System.out.println("grade1.courseNumber:\t"+grade1.courseNumber);
        System.out.println("grade1.grade:\t"+grade1.n);
    }
}
