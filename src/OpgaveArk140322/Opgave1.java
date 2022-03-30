package OpgaveArk140322;

public class Opgave1 {

    public static void main(String[] args) {

        //Opg. 23.2.1
        /*
        Se opg. 23.2.2
        Kompleksiteten af "insertion sort", er O(n^2)
         */

        //Opg. 23.2.2
        int[] n = {45, 11, 50, 59, 60, 2, 4, 7, 10};
        /*
        Første element bliver gemt i en variable >11<
        Step 1: {45, >11<, 50, 59, 60, 2, 4, 7, 10}
        Derefter bliver elementet erstattet med forrige element
        hvis det forrige element er af lavere værdi end første element
        Step 2: {45, >45<, 50, 59, 60, 2, 4, 7, 10}
        Dernæst vil >11< blive sat ind på den forrige plads
        Step 3: {>11<, 45, 50, 59, 60, 2, 4, 7, 10}
        Sådan vil pladserne blive tjekket og rykket og til sidst
        være i sorteret orden
        */

        //Opg. 23.2
        /*
        Hvis listen allerede er sorteret, så vil formlen for
        sammenligning være n-1. n er længden på arrayet
         */

        //Opg. 23.3.1
        /*
        Tids kompleksiteten af "insertion sort", er O(n^2)
        Det første index i arrayet bliver sammenlignet med de
        andre index pladser i arrayet, og er betingelsen i det
        inderstes loop's if udtryk sandt, så vil den index plads
        vi sammenligner med, blive gemt i en variable for at undgå
        at den bliver overskrevet. Derefter kan de to index pladser
        byttes rundt på. Se eksempel

        int temp;
        for (int i = 0; i < n.length; i++) {
            for (int j = 1; j < n.length; j++) {
                if (n[i] > n[j]){
                   temp = n[i];
                   n[i] = n[j];
                   n[j] = temp;
                }
            }
        }
        */

        //Opg. 23.3.2
        /*
        Se opg. 23.3.1
        */

        //Opg. 23.3.3
        /*
        Hvis listen allerede er sorteret, så vil formlen for
        sammenligning være n-1. n er længden på arrayet
         */

        //Opg. 23.4.1
        int[] p = {45, 11, 50, 59, 60, 2, 4, 7, 10};
        /*
        Kompleksiteten af "Merge sort", er O(nLogn).
        "Merge sort" fungere således at en funktion får et array ind
        og det array bliver delt halvt op. Det vil give to arrays og
        de to arrays vil så blive delt op igen indtil, det er
        enkelt stående elementer. Derefter vil de enkelt
        stående blive sendt til en anden funktion, som sammenligner
        dem og sætter dem i sorteret orden. Til sidst vil det
        give det originale array i sorteret orden.
        Et array vil blive delt helt op før det andet vil blive
        delt op.
         */

        //Opg. 23.4.2
        int[] k = {15, 11, 50, 29, 80, 1, 5, 9, 19};
        mergeSort(k);
        for (int i = 0; i < k.length; i++)
            System.out.print(k[i] + " ");

        //Opg. 23.4.3
        /*
        // Merge sort the first half
        int[] firstHalf = new int[list.length / 2 + 1];
        System.arraycopy(list, 0, firstHalf, 0, list.length / 2 + 1);
        mergeSort(firstHalf);

        // Merge sort the second half
        int secondHalfLength = list.length - list.length / 2 - 1;
        int[] secondHalf = new int[secondHalfLength];
        System.arraycopy(list, list.length / 2 + 1,
        secondHalf, 0, secondHalfLength);
        mergeSort(secondHalf);

        SVAR: Hvis der nu blev givet en liste med en størrelse
        på 2, så ville firstHalf arrayet udgøre hele listen fordi
        der er blevet plusset med +1.
         */

        //Opg. 23.5.1 - Describe how quick sort works. What is the time complexity for a quick sort?
        /*
        Tids kompleksiteten for "Quick sort" er O(n^2) i værste
        tilfælde og gennemsnitligt er det O(n Log(n)).

         */

        //Opg. 23.5.2 - Why is quick sort more space efficient than merge sort?
        /*
        "Quick sort" gør ikke brug af hjælpe arrays, hvilket gør
        denne algoritme mere effekt i forhold til RAM-brug.
         */
    }

    public static void mergeSort(int[] list) {
        if (list.length > 1) {
            // Merge sort the first half
            int[] firstHalf = new int[list.length / 2];
            System.arraycopy(list, 0, firstHalf, 0, list.length / 2);
            mergeSort(firstHalf);

            // Merge sort the second half
            int secondHalfLength = list.length - list.length / 2;
            int[] secondHalf = new int[secondHalfLength];
            System.arraycopy(list, list.length / 2,
                    secondHalf, 0, secondHalfLength);
            mergeSort(secondHalf);

            // Merge firstHalf with secondHalf into list
            merge(firstHalf, secondHalf, list);
        }
    }

    public static void merge(int[] firstHalf, int[] secondHalf, int[] temp) {
        int current1 = 0; // Current index in firstHalf
        int current2 = 0; // Current index in secondHalf
        int current3 = 0; // Current index in temp

        while (current1 < firstHalf.length && current2 < secondHalf.length) {
            if (firstHalf[current1] < secondHalf[current2])
                temp[current3++] = firstHalf[current1++];
            else
                temp[current3++] = secondHalf[current2++];
        }

        while (current1 < firstHalf.length)
            temp[current3++] = firstHalf[current1++];

        while (current2 < secondHalf.length)
            temp[current3++] = secondHalf[current2++];
    }
}
