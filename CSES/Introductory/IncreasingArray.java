import java.util.Scanner;

public class IncreasingArray {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int index = scan.nextInt();
        long num_of_turns = 0;
        long[] array = new long[index];
        long prev_number = array[0];

        for (int i = 0; i < index; i++) {
            if(i == 0){
                long number = scan.nextInt();
                array[0] = number;
                prev_number = number;
            }
            else {
                long number = scan.nextInt();
                if(number >= prev_number){
                    prev_number = number;
                }
                else{
                    num_of_turns += prev_number - number;
                    array[i] = prev_number;
                }
            }
        }
        System.out.println(num_of_turns);
    }
}
