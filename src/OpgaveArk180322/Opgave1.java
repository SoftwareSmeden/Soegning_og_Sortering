package OpgaveArk180322;

import java.util.ArrayList;

public class Opgave1 {

    public static void main(String[] args) {

        /*
        1.	Lav et program, hvor der i main erklæres et string array og der indsættes 10 strenge i arrayet. Programmer nu heapsort sorteringsalgoritmen, så den kan sortere arrays af strenge.
            Test sorteringsalgoritmen med det oprettede array af strenge.
         */

        String[] arrStr = {"Casper","Bent","Dennis","Aron","Erik","Gert","Hans","Frank"};
        String[] tal = {"1","2","4","5","3","6","9","8","7"};

        heapSort(arrStr, arrStr.length);
        for (int i = 0; i < arrStr.length; i++) {
            System.out.println(arrStr[i]);
        }

        heapSort(tal, tal.length);
        for (int i = 0; i < tal.length; i++) {
            System.out.println(tal[i]);
        }
    }

    public static void heapSort(String[] arrStr, int length){
        Heap heap = new Heap();
        for (int i = 0; i < length; i++) {
            heap.add(arrStr[i]);
        }
        for (int i = arrStr.length - 1; i >= 0; i--) {
            arrStr[i] = heap.remove();
        }
    }


    //Inner class 1:
    private static class Heap implements Comparable<Heap>{
        private ArrayList<String> list = new ArrayList<>();

        public Heap(){
        }

        public void add(String arrStr){
            list.add(arrStr);
            int currentIndex = list.size()-1;
            while (currentIndex > 0){
                int parentIndex = (currentIndex - 1) / 2;
                if (list.get(currentIndex).compareTo(list.get(parentIndex)) > 0){
                    String temp = list.get(currentIndex);
                    list.set(currentIndex, list.get(parentIndex));
                    list.set(parentIndex,temp);
                }else
                    break; //Break when the tree is a heap

                currentIndex = parentIndex;
            }
        }

        public String remove(){
            if (list.size() == 0) return null;

            String removeStr = list.get(0);
            list.set(0, list.get(list.size() - 1));
            list.remove(list.size() - 1);

            int currentIndex = 0;
            while (currentIndex < list.size()){
                int leftChildIndex = 2 * currentIndex + 1;
                int rightChildIndex = 2 * currentIndex + 2;

                if (leftChildIndex >= list.size()) break; //Break beacuse tree is a heap
                int maxIndex = leftChildIndex;
                if (rightChildIndex < list.size()) {
                    if (list.get(maxIndex).compareTo(list.get(rightChildIndex)) < 0){
                        maxIndex = rightChildIndex;
                    }
                }

                if (list.get(currentIndex).compareTo(list.get(maxIndex)) < 0){
                    String temp = list.get(maxIndex);
                    list.set(maxIndex, list.get(currentIndex));
                    list.set(currentIndex,temp);
                    currentIndex = maxIndex;
                }else
                    break; //Break when the tree is a heap
            }
            return removeStr;
        }


        @Override
        public int compareTo(Heap o) {
            return 0;
        }
    }
}
