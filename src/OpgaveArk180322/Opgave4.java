package OpgaveArk180322;

import java.util.*;

public class Opgave4 {

    public static void main(String[] args) {
        Person[] pers = new Person[6];
        pers[0] = new Person(11,"Torben","Hansen",5.5);
        pers[1] = new Person(22,"John","Nielsen",2.3);
        pers[2] = new Person(44,"Mette","Pedersen",10.4);
        pers[3] = new Person(33,"Aron","Andersen",12.0);
        pers[4] = new Person(55,"Bente","Ziegler",7.8);
        pers[5] = new Person(99,"Hans","Iversen",8.8);
        List<Person> list = new ArrayList<>(Arrays.asList(pers));

        CompareNames cn = new CompareNames();
        Collections.sort(list,cn);
        for (int i = 0; i < list.size(); i++) {
            System.out.println("Sorted by names: "+ list.get(i).fnavn +" "+ list.get(i).enavn);
        }

        CompareKar ck = new CompareKar();
        Collections.sort(list,ck);
        for (int i = 0; i < list.size(); i++) {
            System.out.println("Sorted by gennemsnitskar: "+list.get(i).fnavn +" "+ list.get(i).gennemsnitskar);
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
    private static class CompareNames implements Comparator<Person> {
        @Override
        public int compare(Person s1, Person s2){
            return s1.fnavn.compareTo(s2.fnavn);
        }

    }
    //Inner class 3:
    private static class CompareKar implements Comparator<Person> {
        public int compare(Person s1, Person s2){
            if (s1.gennemsnitskar == s2.gennemsnitskar) return 0;
            else if (s1.gennemsnitskar > s2.gennemsnitskar) return 1;
            return -1;
        }
    }
}
