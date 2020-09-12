import java.util.Scanner;

public class Repitions {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String string = scan.next();
        int string_max = 1;
        int max = 1;
        char letter_before = ' ';
        for(char letter : string.toCharArray()){
            if(letter_before == letter){
                max += 1;
                if(max > string_max){
                    string_max = max;
                }
            }
            else {
                max = 1;
                letter_before = letter;
            }
        }
        System.out.println(string_max);


    }
}
