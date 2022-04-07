class Person{
    String name;
    char sex;
    int age;
    Person(String name,char sex,int age){
        this.name = name;
        this.sex = sex;
        this.age = age;
    }
    void setDate(String name,char sex,int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }
    String getDate() {
        String date = " name: " + name + " sex: " + sex + " age: " + age;
        return date;
    }
}
class Student extends Person{
    long sID;int classNO;
    Student(String name,char sex,int age,long sID,int classNO){
        super(name,sex,age);
        this.sID = sID;
        this.classNO = classNO;
    }
    void setDate(String name,char sex,int age,long sID,int classNO){
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.sID = sID;
        this.classNO = classNO;
    }
    String getDate() {
        String date = " name: " + name + " sex: " + sex + " age: " + age;
        date += '\n' + " sID: " + sID +" classNO: " + classNO;
        return date;
    }
}

public class Test {
    public static void main(String []args) {
        Student people = new Student("lsh",'m',19,1302009,1302);
        String date = people.getDate();
        System.out.print(date);
    }
}
