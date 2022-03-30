package OpgaveArk140322;

import java.util.Arrays;

public class Opgave3 {

    public static void main(String[] args) {

        String[] strSorted = {"Arne","Bent","Camilla","Dennis","Erik","Frank","Georgia","Hans","Irene","Jacob"};
        String[] strMessy = {"Gert","Paul","Aron","Bente","Ziska","Ove","Christian","Kevin","Dorte","Finn"};

        //LinearSearch:
        System.out.println((linearSearch(strMessy, strMessy.length, "Ziska")) >= 0 ?
                "Found the name at index: "+(linearSearch(strMessy, strMessy.length, "Christian")) : "Couldn't find the name");

        //BinarySearch:
        Arrays.sort(strMessy);
        int findIndex1 = binarySearch(strSorted,"Camilla");
        int findIndex2 = binarySearch(strMessy,"Aron");
        System.out.println("BinarySearch - Element: "+ strSorted[findIndex1] + " " + "Index: "+ findIndex1);
        System.out.println("BinarySearch - Element: "+ strMessy[findIndex2] + " " + "Index: "+ findIndex2);
    }

    public static int linearSearch(String[] arrStr, int length, String find){
        for (int i = 0; i < length; i++) {
            if (find.equalsIgnoreCase(arrStr[i])) return i;
        }
        return -1;
    }

    public static int binarySearch(String[] arrStr, String find){
        int min = 0;
        int max = arrStr.length-1;
        int mid;
        while (max >= min){
            mid = (min+max)/2;
            if (find.compareToIgnoreCase(arrStr[mid]) < 0){
                max = mid - 1;
            }else if (find.equalsIgnoreCase(arrStr[mid])){
                return mid;
            }else{
                min = mid + 1;
            }
        }
        return -1;
    }
}
