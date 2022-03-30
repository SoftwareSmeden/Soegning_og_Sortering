package OpgaveArk180322;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Opgave8 {

    public static void main(String[] args) throws FileNotFoundException {

        /*
        8.	Lav nu det samme som i opgave 5 og 6, men nu skal teksten ikke fra start ligge i en streng i main, men den skal ligge i en tekstfil.
         */

        PrintWriter textFile = new PrintWriter("ReadFromTextFile.txt");
        textFile.write("Næstved er en gammel by");
        textFile.close();

        File file = new File("ReadFromTextFile.txt");
        Scanner read = new Scanner(file);
        String text = read.nextLine();
        read.close();
        for (String st : text.split(" ")) {
            System.out.println(st);
        }

        System.out.println("Sorted: ");
        for (int i = 0; i < text.split(" ").length; i++) {
            System.out.println(bubbleSort(text.split(" "))[i]);
        }
    }

    //BubbleSort:
    public static String[] bubbleSort(String[] arrStr){
        String temp;
        for (int i = 0; i < arrStr.length; i++) {
            for (int j = i+1; j < arrStr.length; j++) {
                if (arrStr[i].compareToIgnoreCase(arrStr[j]) > 0){
                    temp = arrStr[i];
                    arrStr[i] = arrStr[j];
                    arrStr[j] = temp;
                }
            }
        }
        return arrStr;
    }
}


