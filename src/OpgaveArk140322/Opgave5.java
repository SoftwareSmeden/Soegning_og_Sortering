package OpgaveArk140322;

import java.util.*;

public class Opgave5 {

    public static void main(String[] args) {
        ArrayList<Student> student = new ArrayList<>();
        student.add(new Student(11,"Aron",22));
        student.add(new Student(33,"Gurli",34));
        student.add(new Student(22,"Bente",45));
        student.add(new Student(88,"John",11));
        student.add(new Student(44,"Per",15));
        student.add(new Student(66,"Arne",25));
        student.add(new Student(99,"Thor",19));
        student.add(new Student(55,"Hans",44));
        student.add(new Student(77,"Pia",78));
        student.add(new Student(100,"Nikolai",38));

        System.out.println("Sorting student by name:");
        Collections.sort(student,new NameComparator());
        for (Student st : student) {
            System.out.printf("%-3d %-8s %d\n",st.stdNumb,st.fnavn,st.alder);
        }

        System.out.println("\nSorting students by age:");
        Collections.sort(student,new AgeComparator());
        for (Student st : student) {
            System.out.printf("%-3d %-8s %d\n",st.stdNumb,st.fnavn,st.alder);
        }

        System.out.println("\nSorting string arraylist by names");
        ArrayList<String> list = new ArrayList<>(Arrays.asList("Hans",
                "Aron","John","Pia","Malene","June","Nikolaj","Peter","Gert","Christian","Dennis"));
        Collections.sort(list, new NameComp());
        for (String str : list) {
            System.out.printf("%s\n",str);
        }
    }

    //Inner class 1:
    private static class Student{
        int stdNumb;
        String fnavn;
        int alder;

        Student(int rollno,String name,int alder){
            this.stdNumb =rollno;
            this.fnavn =name;
            this.alder = alder;
        }
    }

    //Inner class 2:
    private static class NameComparator implements Comparator<Student> {
        public int compare(Student s1,Student s2){
            return s1.fnavn.compareTo(s2.fnavn);
        }
    }

    //Inner class 3:
    private static class AgeComparator implements Comparator<Student>{
        public int compare(Student s1,Student s2){
            if(s1.alder == s2.alder)
                return 0;
            else if(s1.alder > s2.alder)
                return 1;
            else
                return -1;
        }
    }

    //Inner class 4:
    private static class NameComp implements Comparator<String>{
        @Override
        public int compare(String s1, String s2) {
            return s1.compareTo(s2);
        }
    }
}
