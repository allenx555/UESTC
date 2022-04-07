import java.io.*;
import java.util.Scanner;

public class ReWrite {
    public static void main(String[] args) {
        PrintStream out;
        try {
            out = new PrintStream(new File("D:\\UESTC\\面向对象程序设计（Java）\\4\\4-3\\test.txt"));
            Scanner sc = new Scanner(System.in);
            String test = sc.nextLine();
            out.print(test);
            System.setOut(out);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
