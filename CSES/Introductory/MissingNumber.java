
import java.util.Scanner;

public class MissingNumber {
    public static void main(String[] args){
        AddMethod();
    }
    public static void AddMethod(){
        Scanner scan = new Scanner(System.in);
        long s = 0;
        long number = scan.nextInt();
        long missing_num = ((number * (number + 1))/2);
        for(int i = 1; i <= number - 1; i++) {
            long num = scan.nextLong();
            s += num;
        }
        System.out.println(missing_num-s);
    }
}
