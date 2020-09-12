import java.util.Scanner;

public class Permutations {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int length = scan.nextInt();
        int[] array = new int[length];
        int number = 1;
        for(int i = 0; i < length; i += 2){
            array[i] = number;
            number++;
        }
        for(int i = 1; i < length; i += 2) {
            array[i] = number;
            number++;
        }
        for(int i : array){
            System.out.println(i + " ");
        }
    }
}
