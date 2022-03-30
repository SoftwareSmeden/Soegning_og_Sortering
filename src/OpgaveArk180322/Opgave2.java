package OpgaveArk180322;

public class Opgave2 {

    public static void main(String[] args) {

        /*
        2.	Programmer en funktion, som modtager et array af strenge og et ord der søges på. Funktionen skal returnere om ordet findes i arrayet.
         */

        String[] arrStr = {"Casper","Bent","Dennis","Aron","Erik","Gert","Hans","Frank"};
        System.out.println(wordSearch(arrStr,arrStr.length,"Erik") >= 0 ?
                "Fandt ordet på index: "+wordSearch(arrStr,arrStr.length,"Erik") :
                "Ordet findes ikke i arrayet");
    }

    public static int wordSearch(String[] arrStr,int length, String find){
        for (int i = 0; i < length; i++) {
            if (find.equalsIgnoreCase(arrStr[i])) return i;
        }
        return -1;
    }
}
