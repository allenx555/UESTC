class MyDate{
    int year,month,day;
    MyDate(){
        year = 2018;
        month = 12;
        day = 14;
    }
    MyDate(int year,int month,int day){
        this.year = year;
        this.month = month;
        this.day = day;
    }
    void print() {
        System.out.println("The date is "+year+"/"+month+"/"+day);
    }
}

public class Test {
    public static void main(String []args) {
        MyDate birthday = new MyDate(2018,12,14);
        birthday.print();
    }
}
