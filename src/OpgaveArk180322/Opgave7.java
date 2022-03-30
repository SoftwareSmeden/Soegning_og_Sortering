package OpgaveArk180322;

public class Opgave7 {

    public static void main(String[] args) {

        /*
        7.	Programmer en funktion, som kan tælle hvor mange gange hvert ord i arrayet i opgave 5 forekommer.
            Funktionen skal modtage et array af strenge og et ord der søges på. Funktionen skal returnere hvor mange gange ordet findes i arrayet.
         */

        String[] arrStr = {"Per","Aron","Mads","Daniel","Julie","Maj","Kirsten","Gurli","Mette","Per","Per","Johnny","Julie","Mads"};
        String findWord = "Per";

        //Count how many times on specific word appears in the array
        System.out.println(countWord(arrStr, arrStr.length, findWord) > 0 ? "Found the name "+findWord+" "+ countWord(arrStr, arrStr.length, "Per")+" times" : "Couldn't find the word!");

        //Count how many times each word in the array appears
        for (int i = 0; i < arrStr.length; i++) {
            if (countEveryWordInTheArray(arrStr)[i] > 0){
                System.out.printf("Name: %-8s Appears: %d times.\n", arrStr[i], countEveryWordInTheArray(arrStr)[i]);
            }
        }
    }

    public static int countWord(String[] arrStr, int length, String findWord){
        int countWord = 0;
        for (int i = 0; i < length; i++) {
            if (arrStr[i].equalsIgnoreCase(findWord)){
                countWord++;
            }
        }
        return countWord;
    }

    public static int[] countEveryWordInTheArray(String[] arrStr){
        String[] temp = new String[arrStr.length];
        System.arraycopy(arrStr,0, temp,0,arrStr.length);
        int[] countEveryWord = new int[arrStr.length];
        for (int i = 0; i < temp.length; i++) {
            if (!temp[i].isEmpty()) {
                int count = 1;
                for (int j = i+1; j < temp.length; j++) {
                    if (temp[i].equalsIgnoreCase(temp[j])) {
                        count++;
                        temp[j] = "";
                    }
                }
                countEveryWord[i] = count;
            }
        }
        return countEveryWord;
    }
}
