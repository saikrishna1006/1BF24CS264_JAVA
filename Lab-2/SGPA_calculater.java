import java.util.Scanner;

class Subject {
    int grade;
    int subjectmarks;
    int credits;
}

class Student {
    int totalpoints = 0, totalcredits = 0;
    String USN, Name;
    Subject[] subjects;
    double SGPA;

    Student() {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter student's name:");
        Name = s.nextLine();

        System.out.println("Enter student's USN:");
        USN = s.nextLine();

        System.out.println("Enter number of subjects:");
        int n = s.nextInt();
        subjects = new Subject[n];

        for (int i = 0; i < n; i++) {
            subjects[i] = new Subject();
            System.out.println("Enter subject " + (i + 1) + " marks:");
            subjects[i].subjectmarks = s.nextInt();

            System.out.println("Enter subject " + (i + 1) + " credits:");
            subjects[i].credits = s.nextInt();

            if (subjects[i].subjectmarks >= 90)
                subjects[i].grade = 10;
            else if (subjects[i].subjectmarks >= 80)
                subjects[i].grade = 9;
            else if (subjects[i].subjectmarks >= 70)
                subjects[i].grade = 8;
            else if (subjects[i].subjectmarks >= 60)
                subjects[i].grade = 7;
            else if (subjects[i].subjectmarks >= 50)
                subjects[i].grade = 6;
            else
                subjects[i].grade = 0;
        }
    }

    void GPA() {
        for (Subject sub : subjects) {
            totalcredits += sub.credits;
            totalpoints += sub.grade * sub.credits;
        }
        SGPA = (double) totalpoints / totalcredits;
        System.out.println("SGPA: " + SGPA);
    }
}

public class SGPA_calculater {
    public static void main(String[] args) {
        Student s = new Student();
        s.GPA();
    }
}