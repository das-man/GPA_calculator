import java.util.HashMap;
import java.util.Scanner;

public class gpa {
    double res = 0;
    int subjcount = 0;
    HashMap<String, Double> gpaMap = new HashMap<String, Double>();
    Scanner s = new Scanner(System.in);

    // transfer grade into GPA
    public double transfer(String gpa) {
        // more user-friendly
        gpa = gpa.toUpperCase();

        switch (gpa) {
            case "A":
                return 4;
            case "A-":
                return 3.7;
            case "B+":
                return 3.3;
            case "B":
                return 3;
            case "B-":
                return 2.7;
            case "C+":
                return 2.3;
            case "C":
                return 2;
            case "D+":
                return 1.3;
            case "D":
                return 1;
            case "D-":
                return 0.7;
            case "F":
                return 0;
            default:
                return -1;
        }
    }

    public void start() {
        System.out.println("===============================================");
        System.out.println("Welcome to gpa calculator");
        System.out.println("enter -1 if you want to exit the programme");

        // enter subjects loop
        while (true) {
            System.out.println("Subject Name:");
            String subj = s.nextLine();

            if (subj.equals("-1") ){
                cal();
                return;
            }

            System.out.println("Subject GPA:");
            String gpa = s.nextLine();
            double gpaFin = transfer(gpa);

            if (gpa.equals("-1")) {
                cal();
                return;
            }

            if (gpaFin == -1) {
                // typo
                System.out.println("Invalid gpa, try again.");
            } else {
                subjcount++;
                // record in hashmap
                gpaMap.put(subj, gpaFin);
            }
        }
    }

    public void cal() {
        System.out.println("===============================================");

        for (String subj : gpaMap.keySet()) {
            // print all subjects
            System.out.println(subj + ": " + gpaMap.get(subj));

            // sum up all subjects
            res += gpaMap.get(subj);
        }

        // result
        res = res / subjcount;

        if (gpaMap.size() == 0) {
            System.out.println("Are you joking LOL");
        } else {
            System.out.println("\nYour final GPA: " + res);
        }
    }

    public static void main(String[] args) {
        new gpa().start();
    }
}