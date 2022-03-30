package OpgaveArk140322;

public class Opgave4 {

    public static void main(String[] args) {
        Person[] persons = new Person[6];
        persons[0] = new Person(11,"Jon","Hansen",10.3);
        persons[1] = new Person(22,"Mette","Pan",7.4);
        persons[2] = new Person(33,"Aron","Prut",12.0);
        persons[3] = new Person(44,"Bente","Pedersen",4.8);
        persons[4] = new Person(55,"Louise","Nielsen",11.1);
        persons[5] = new Person(66,"Per","Fisker",7.4);

        //BubbleSort:
        System.out.println("BubbleSort:");
        for (int i = 0; i < persons.length; i++) {
            System.out.printf("%-8s %-10s - Stdnr: %-8d - Gennemsnitskarakter: %.1f \n",
                    bubbleSort(persons, persons.length)[i].fNavn,
                    bubbleSort(persons, persons.length)[i].eNavn,
                    bubbleSort(persons, persons.length)[i].stdnr,
                    bubbleSort(persons, persons.length)[i].gennemsnitsKar);
        }

        //InsertionSort:
        System.out.println("\nInsertionSort:");
        for (int i = 0; i < persons.length; i++) {
            System.out.printf("%-8s %-10s - Stdnr: %-8d - Gennemsnitskarakter: %.1f \n",
                    insertionSort(persons, persons.length)[i].fNavn,
                    insertionSort(persons, persons.length)[i].eNavn,
                    insertionSort(persons, persons.length)[i].stdnr,
                    insertionSort(persons, persons.length)[i].gennemsnitsKar);
        }

        //MergeSort:
        System.out.println("\nMergeSort:");
        for (int i = 0; i < persons.length; i++) {
            System.out.printf("%-8s %-10s - Stdnr: %-8d - Gennemsnitskarakter: %.1f \n",
                    mergeSort(persons)[i].fNavn,
                    mergeSort(persons)[i].eNavn,
                    mergeSort(persons)[i].stdnr,
                    mergeSort(persons)[i].gennemsnitsKar);
        }

        //QuickSort:
        System.out.println("\nQuickSort:");
        for (int i = 0; i < persons.length; i++) {
            System.out.printf("%-8s %-10s - Stdnr: %-8d - Gennemsnitskarakter: %.1f \n",
                    quickSort(persons,0,persons.length-1)[i].fNavn,
                    quickSort(persons,0,persons.length-1)[i].eNavn,
                    quickSort(persons,0,persons.length-1)[i].stdnr,
                    quickSort(persons,0,persons.length-1)[i].gennemsnitsKar);
        }

        //SelectionSort:
        System.out.println("\nSelectionSort:");
        for (int i = 0; i < persons.length; i++) {
            System.out.printf("%-8s %-10s - Stdnr: %-8d - Gennemsnitskarakter: %.1f \n",
                    selectionSort(persons, persons.length)[i].fNavn,
                    selectionSort(persons, persons.length)[i].eNavn,
                    selectionSort(persons, persons.length)[i].stdnr,
                    selectionSort(persons, persons.length)[i].gennemsnitsKar);
        }
    }

    //Inner class:
    private static class Person {
        int stdnr;
        String fNavn;
        String eNavn;
        double gennemsnitsKar;
        public Person(int stdnr, String fNavn, String eNavn, double gennemsnitsKar) {
            this.stdnr = stdnr;
            this.fNavn = fNavn;
            this.eNavn = eNavn;
            this.gennemsnitsKar = gennemsnitsKar;
        }
        @Override
        public String toString() {
            return fNavn +" "+ eNavn +
                    " Stdnr: " + stdnr +
                    " Gennemsnitskarakter: " + gennemsnitsKar;
        }
    }

    public static Person[] bubbleSort(Person[] arrPersons, int length){
        Person temp;
        for (int i = 0; i < length-1; i++) {
            for (int j = i+1; j < length; j++) {
                if (arrPersons[i].fNavn.compareToIgnoreCase(arrPersons[j].fNavn) > 0){
                    temp = arrPersons[i];
                    arrPersons[i] = arrPersons[j];
                    arrPersons[j] = temp;
                }
            }
        }
        return arrPersons;
    }

    public static Person[] insertionSort(Person[] arrPersons, int length){
        for (int i = 1; i < length; i++) {
            Person currentEle = arrPersons[i];
            int j;
            for (j = i - 1; j >= 0 && (currentEle.fNavn.compareToIgnoreCase(arrPersons[j].fNavn) < 0); j--) {
                //System.out.println("I:"+i+" J:"+j+" Comp: "+currentEle.fNavn.compareToIgnoreCase(arrPersons[j].fNavn));
                arrPersons[j + 1] = arrPersons[j];
            }
            arrPersons[j + 1] = currentEle;
        }
        return arrPersons;
    }

    public static int linearSearch(Person[] arrPersons, int length, String findNavn){
        for (int i = 0; i < length; i++) {
            if (findNavn.equalsIgnoreCase(arrPersons[i].fNavn)) return i;
        }
        return -1;
    }

    public static Person[] mergeSort(Person[] arrPersons){
        if (arrPersons.length > 1){
            Person[] firstHalf = new Person[arrPersons.length/2];
            System.arraycopy(arrPersons,0,firstHalf,0,arrPersons.length/2);
            mergeSort(firstHalf);

            int secondLen = arrPersons.length-arrPersons.length/2;
            Person[] secondHalf = new Person[secondLen];
            System.arraycopy(arrPersons,arrPersons.length/2,secondHalf,0,secondLen);
            mergeSort(secondHalf);

            merge(firstHalf,secondHalf,arrPersons);
        }
        return arrPersons;
    }

    private static void merge(Person[] firstHalf, Person[] secondHalf, Person[] tempArr){
        int firstHalfIndex = 0;
        int secondHalfIndex = 0;
        int tempIndex = 0;
        while ((firstHalfIndex < firstHalf.length) && (secondHalfIndex < secondHalf.length)){
            if (firstHalf[firstHalfIndex].fNavn.compareToIgnoreCase(secondHalf[secondHalfIndex].fNavn) < 0){
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

    public static Person[] quickSort(Person[] arrPerons, int first, int last){
        if (last > first){
            int pivotIndex = partition(arrPerons,first,last);
            quickSort(arrPerons, first, pivotIndex - 1);
            quickSort(arrPerons, pivotIndex + 1, last);
        }
        return arrPerons;
    }

    private static int partition(Person[] arrPersons, int first, int last){
        Person pivot = arrPersons[first];   //First Element
        int low = first + 1;                //Index for forward search
        int high = last;                    //Index for backward search

        while (high > low){
            //Search forward from left
            while (low <= high && arrPersons[low].fNavn.compareToIgnoreCase(pivot.fNavn) <= 0) low++;
            //Search backward from right
            while (low <= high && arrPersons[high].fNavn.compareToIgnoreCase(pivot.fNavn) > 0) high--;
            //Swap two elements in the array
            if (high > low){
                Person temp = arrPersons[high];
                arrPersons[high] = arrPersons[low];
                arrPersons[low] = temp;
            }
        }
        while ((high > first) && (arrPersons[high].fNavn.compareToIgnoreCase(pivot.fNavn) >= 0)) high--;
        //Swap pivot with arrPersons[High]
        if (pivot.fNavn.compareToIgnoreCase(arrPersons[high].fNavn) > 0){
            arrPersons[first] = arrPersons[high];
            arrPersons[high] = pivot;
            return high;
        }else
            return first;
    }

    public static Person[] selectionSort(Person[] arrPersons, int length){
        for (int i = 0; i < length; i++) {
            Person currentMin = arrPersons[i];
            int currentMinIndex = i;
            for (int j = i + 1; j < length; j++) {
                if (currentMin.fNavn.compareToIgnoreCase(arrPersons[j].fNavn) > 0){
                    currentMin = arrPersons[j];
                    currentMinIndex = j;
                }
            }
            //Swaps arrPersons elements
            if (currentMinIndex != i){
                arrPersons[currentMinIndex] = arrPersons[i];
                arrPersons[i] = currentMin;
            }
        }
        return arrPersons;
    }
}
