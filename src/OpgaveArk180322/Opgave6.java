package OpgaveArk180322;

public class Opgave6 {

    public static void main(String[] args) {

        /*
        6.	Lav et program, hvor der i main oprettes en String, der indeholder en tekst.
            Benyt split funktionen til at lægge indholdet af strengen over i et array, hvor der på hver plads i arrayet nu ligger et ord.
            Anvend nu de forskellige sorteringsalgoritmer til at sortere ordene i arrayet.
         */

        String splitMe = "Torben";
        for (int i = 0; i < splitMe.length(); i++) {
            System.out.println("BubbleSort: "+bubbleSort(splitMe.split(""),splitMe.length())[i]);
        }

        for (int i = 0; i < splitMe.length(); i++) {
            System.out.println("MergeSort: "+mergeSort(splitMe.split(""))[i]);
        }

    }

    //BubbleSort:
    public static String[] bubbleSort(String[] arrStr, int length){
        String temp;
        for (int i = 0; i < length; i++) {
            for (int j = i+1; j < length; j++) {
                if (arrStr[i].compareToIgnoreCase(arrStr[j]) > 0){
                    temp = arrStr[i];
                    arrStr[i] = arrStr[j];
                    arrStr[j] = temp;
                }
            }
        }
        return arrStr;
    }

    //MergeSort:
    public static String[] mergeSort(String[] arrStr){
        if (arrStr.length > 1){
            String[] firstHalf = new String[arrStr.length/2];
            System.arraycopy(arrStr,0,firstHalf,0,arrStr.length/2);
            mergeSort(firstHalf);

            int secondLen = arrStr.length-arrStr.length/2;
            String[] secondHalf = new String[secondLen];
            System.arraycopy(arrStr,arrStr.length/2,secondHalf,0,secondLen);
            mergeSort(secondHalf);

            merge(firstHalf,secondHalf,arrStr);
        }
        return arrStr;
    }

    private static void merge(String[] firstHalf, String[] secondHalf, String[] tempArr){
        int firstHalfIndex = 0;
        int secondHalfIndex = 0;
        int tempIndex = 0;
        while ((firstHalfIndex < firstHalf.length) && (secondHalfIndex < secondHalf.length)){
            if (firstHalf[firstHalfIndex].compareToIgnoreCase(secondHalf[secondHalfIndex]) < 0){
                tempArr[tempIndex++] = firstHalf[firstHalfIndex++];
            }else{
                tempArr[tempIndex++] = secondHalf[secondHalfIndex++];
            }
        }
        while (firstHalfIndex < firstHalf.length){
            tempArr[tempIndex++] = firstHalf[firstHalfIndex++];
        }
        while (secondHalfIndex < secondHalf.length){
            tempArr[tempIndex++] = secondHalf[secondHalfIndex++];
        }
    }
}
