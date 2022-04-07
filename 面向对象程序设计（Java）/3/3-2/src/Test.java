abstract class Person{
    String name;
    char sex;
    int age;
    abstract void setDate(String name,char sex,int age);
    abstract String getDetail();
}

class Student extends Person{
    int sID;
    String speciality;
    Student(String name,char sex,int age,int sID,String speciality){
        setDate(name,sex,age);
        this.sID = sID;
        this.speciality = speciality;
    }
    void setDate(String name,char sex,int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }
    String getDetail() {
        String date = " name: " + name + " sex: " + sex + " age: " + age;
        date += '\n' + " sID: " + sID +" speciality: " + speciality;
        return date;
    }

}

class Teacher extends Person{
    int tID;
    String department;
    Teacher(String name,char sex,int age,int tID,String department){
        setDate(name,sex,age);
        this.tID = tID;
        this.department = department;
    }
    void setDate(String name,char sex,int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }
    String getDetail() {
        String date = " name: " + name + " sex: " + sex + " age: " + age;
        date += '\n' + " tID: " + tID +" department: " + department;
        return date;
    }

}

public class Test {
    public static void main(String []args) {
        Student people = new Student("lsh",'m',19,130209,"software");
        String date = people.getDetail();
        System.out.print(date);
    }
}
