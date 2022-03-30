package OpgaveArk180322;

import java.util.ArrayList;

public class Opgave3 {

    public static void main(String[] args) {

        /*
        3.	Opret en klasse person, med egenskaber stdnr, fnavn, enavn, gennemsnitkar.
            Opret et array i main, som kan indeholde person-objekter. Tilret nu heapsort  sorteringsalgoritmen, så den kan sortere på stdnr eller fnavn, eller enavn eller gennemsnitskar.
            Test sorteringsalgoritmen med det oprettede array af personer.
         */

        Person[] pers = new Person[6];
        pers[0] = new Person(11,"Torben","Hansen",5.5);
        pers[1] = new Person(22,"John","Nielsen",2.3);
        pers[2] = new Person(44,"Mette","Pedersen",10.4);
        pers[3] = new Person(33,"Aron","Andersen",12.0);
        pers[4] = new Person(55,"Bente","Ziegler",7.8);
        pers[5] = new Person(99,"Hans","Iversen",8.8);

        heapSort(pers, pers.length);
        for (int i = 0; i < pers.length; i++) {
            System.out.printf("%-8s %-10s Stdnr: %-5d Gnskar: %.1f\n",
                    pers[i].fnavn,pers[i].enavn,pers[i].stdnr,pers[i].gennemsnitskar);
        }
    }

    //Inner class 1:
    private static class Person{
        int stdnr;
        String fnavn;
        String enavn;
        double gennemsnitskar;

        public Person(int stdnr, String fnavn, String enavn, double gennemsnitskar) {
            this.stdnr = stdnr;
            this.fnavn = fnavn;
            this.enavn = enavn;
            this.gennemsnitskar = gennemsnitskar;
        }

        @Override
        public String toString() {
            return fnavn +" "+ enavn +
                    " Stdnr: " + stdnr +
                    " Gennemsnitskarakter: " + gennemsnitskar;
        }
    }

    //Inner class 2:
    public static void heapSort(Person[] persArr, int length){
        Heap2 heap2 = new Heap2();
        for (int i = 0; i < length; i++) {
            heap2.add(persArr[i]);
        }
        for (int i = persArr.length - 1; i >= 0; i--) {
            persArr[i] = heap2.remove();
        }
    }

    //Inner class 1:
    private static class Heap2 <H extends Comparable<Heap2>> {
        private ArrayList<Person> list = new ArrayList<>();

        public Heap2() {
        }

        public void add(Person person) {
            list.add(person);
            int currentIndex = list.size() - 1;
            while (currentIndex > 0) {
                int parentIndex = (currentIndex - 1) / 2;
                if (list.get(currentIndex).fnavn.compareTo(list.get(parentIndex).fnavn) > 0) {
                    Person temp = list.get(currentIndex);
                    list.set(currentIndex, list.get(parentIndex));
                    list.set(parentIndex, temp);
                } else
                    break; //Break when the tree is a heap

                currentIndex = parentIndex;
            }
        }

        public Person remove() {
            if (list.size() == 0) return null;

            Person removeStr = list.get(0);
            list.set(0, list.get(list.size() - 1));
            list.remove(list.size() - 1);

            int currentIndex = 0;
            while (currentIndex < list.size()) {
                int leftChildIndex = 2 * currentIndex + 1;
                int rightChildIndex = 2 * currentIndex + 2;

                if (leftChildIndex >= list.size()) break; //Break beacuse tree is a heap
                int maxIndex = leftChildIndex;
                if (rightChildIndex < list.size()) {
                    if (list.get(maxIndex).fnavn.compareTo(list.get(rightChildIndex).fnavn) < 0) {
                        maxIndex = rightChildIndex;
                    }
                }

                if (list.get(currentIndex).fnavn.compareTo(list.get(maxIndex).fnavn) < 0) {
                    Person temp = list.get(maxIndex);
                    list.set(maxIndex, list.get(currentIndex));
                    list.set(currentIndex, temp);
                    currentIndex = maxIndex;
                } else
                    break; //Break when the tree is a heap
            }
            return removeStr;
        }
    }
}
