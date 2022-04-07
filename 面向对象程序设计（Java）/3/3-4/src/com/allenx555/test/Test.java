package com.allenx555.test;

class Student implements Person{
    String name; char sex; long birthday;
    long sID; String speciality;
    void init(long sID, String speciality){
        this.sID = sID;
        this.speciality = speciality;
    }
    String getInit() {
        return String.valueOf(sID)+' '+speciality;
    }
    public void setDate(String name, char sex, long birthday) {
        this.name = name;
        this.sex = sex;
        this.birthday = birthday;
    }
    public String getData() {
        return name+' '+sex+' '+birthday;
    }
}


public class Test {
    public static void main(String[] args) {
        Student a = new Student();
        a.setDate("lsh", 'm', 19990921);
        a.init(130209, "software");
        System.out.println(a.getData());
        System.out.println(a.getInit());

    }
}
