import java.util.Scanner;

public class WeirdAlgo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long number = scan.nextLong();
        System.out.print(number + " ");
        while(number != 1){
            if(number%2 == 0){
                number /= 2;

            }
            else{
                number = number * 3 + 1;
            }
            System.out.print(number + " ");
        }
    }
    public static void bruh(){
        System.out.println("Bruh");
    }
}
