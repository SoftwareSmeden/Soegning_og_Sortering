package OpgaveArk140322;

import java.util.*;

public class Opgave6 {

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

        Collections.sort(student);
        for (Student stud : student) {
            System.out.printf("%-5d %-8s %d\n",stud.stdnr,stud.fnavn,stud.alder);
        }
    }

    //Inner class 1:
    private static class Student implements Comparable<Student>{
        int stdnr;
        String fnavn;
        int alder;

        public Student(int stdnr, String fnavn, int alder) {
            this.stdnr = stdnr;
            this.fnavn = fnavn;
            this.alder = alder;
        }

        public int compareTo(Student stud) {
            if (stdnr == stud.stdnr) return 0;
            else if (stdnr > stud.stdnr) return 1;
            else return -1;
        }
    }
}
