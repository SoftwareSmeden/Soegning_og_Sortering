package OpgaveArk140322;

import java.util.ArrayList;

public class Opgave2 {

    private static ArrayList<String> list = new ArrayList<>();

    public static void main(String[] args) {

        String[] strMessy = {"Gert","Paul","Aron","Bente","Ziska","Ove","Christian","Kevin","Dorte","Finn"};

        //BubbleSort:
        for (int i = 0; i < strMessy.length; i++) {
            //BubbleSort:
                //System.out.println(bubbleSort(strMessy, strMessy.length)[i]);
            //HeapSort:
                //System.out.println(heapSort(strMessy,strMessy.length)[i]);
            //InsertionSort:
                //System.out.println(insertionSort(strMessy,strMessy.length)[i]);
            //MergeSort:
                //System.out.println(mergeSort(strMessy)[i]);
            //QuickSort:
                //System.out.println(quickSort(strMessy,0,strMessy.length-1)[i]);
            //SelectionSort:
                //System.out.println(selectionSort(strMessy, strMessy.length)[i]);
        }
    }

    public static String[] bubbleSort(String[] arrStr, int length){
        String temp;
        for (int i = 0; i < length-1; i++) {
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

    public static String[] heapSort(String[] arrStr, int length){
        for (int i = 0; i < length; i++) {
            add(arrStr[i]);
        }
        for (int i = arrStr.length - 1; i >= 0; i--) {
            arrStr[i] = remove();
        }
        return arrStr;
    }

    public static void add(String arrStr){
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

    public static String remove(){
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

    public static String[] insertionSort(String[] arrStr, int length){
        for (int i = 1; i < length; i++) {
            String currentEle = arrStr[i];
            int j;
            for (j = i - 1; j >= 0 && (currentEle.compareToIgnoreCase(arrStr[j]) < 0); j--) {
                //System.out.println("I:"+i+" J:"+j+" Comp: "+currentEle.compareToIgnoreCase(arrStr[j]));
                arrStr[j + 1] = arrStr[j];
            }
            arrStr[j + 1] = currentEle;
        }
        return arrStr;
    }

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

    public static String[] quickSort(String[] arrStr, int first, int last){
        if (last > first){
            int pivotIndex = partition(arrStr,first,last);
            quickSort(arrStr, first, pivotIndex - 1);
            quickSort(arrStr, pivotIndex + 1, last);
        }
        return arrStr;
    }

    private static int partition(String[] arrStr, int first, int last){
        String pivot = arrStr[first];   //First Element
        int low = first + 1;            //Index for forward search
        int high = last;                //Index for backward search

        while (high > low){
            //Search forward from left
            while (low <= high && arrStr[low].compareToIgnoreCase(pivot) <= 0) low++;
            //Search backward from right
            while (low <= high && arrStr[high].compareToIgnoreCase(pivot) > 0) high--;
            //Swap two elements in the array
            if (high > low){
                String temp = arrStr[high];
                arrStr[high] = arrStr[low];
                arrStr[low] = temp;
            }
        }
        while ((high > first) && (arrStr[high].compareToIgnoreCase(pivot) >= 0)) high--;
        //Swap pivot with arrStr[High]
        if (pivot.compareToIgnoreCase(arrStr[high]) > 0){
            arrStr[first] = arrStr[high];
            arrStr[high] = pivot;
            return high;
        }else
            return first;
    }

    public static String[] selectionSort(String[] arrStr, int length){
        for (int i = 0; i < length; i++) {
            String currentMin = arrStr[i];
            int currentMinIndex = i;
            for (int j = i + 1; j < length; j++) {
                if (currentMin.compareToIgnoreCase(arrStr[j]) > 0){
                    currentMin = arrStr[j];
                    currentMinIndex = j;
                }
            }
            //Swaps arrStr elements
            if (currentMinIndex != i){
                arrStr[currentMinIndex] = arrStr[i];
                arrStr[i] = currentMin;
            }
        }
        return arrStr;
    }
}
