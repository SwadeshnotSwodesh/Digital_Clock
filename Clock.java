 import java.util.Scanner;

class Time {
    Scanner scan = new Scanner(System.in);
    int hrs, min, sec, err = 0, choice;

    public void displayAM(int hrs, int min, int sec) throws InterruptedException {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("\n=========TIME=========");
        System.out.printf(" %02d:%02d:%02d AM%n", hrs, min, sec);
        System.out.println("======================\n");
        sec++;
        Thread.sleep(1000);
        if (sec > 59) {
            sec = 0;
            min++;
        }
        if (min > 59) {
            min = 0;
            hrs++;
        }
        if (hrs > 12) {
            hrs = 1;
            displayPM(hrs, min, sec);
        } else {
            displayAM(hrs, min, sec);
        }
    }

    public void displayPM(int hrs, int min, int sec) throws InterruptedException {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("\n=========TIME=========");
        System.out.printf(" %02d:%02d:%02d PM%n", hrs, min, sec);
        System.out.println("======================\n");
        sec++;
        Thread.sleep(1000);
        if (sec > 59) {
            sec = 0;
            min++;
        }
        if (min > 59) {
            min = 0;
            hrs++;
        }
        if (hrs > 12) {
            hrs = 1;
            displayAM(hrs, min, sec);
        } else {
            displayPM(hrs, min, sec);
        }
    }

    public void get() {
        while (err == 0) {
            System.out.println("Enter number of hours first:");
            hrs = scan.nextInt();
            System.out.println("Enter number of minutes:");
            min = scan.nextInt();
            System.out.println("Enter number of seconds:");
            sec = scan.nextInt();
            if (hrs < 13 && min < 60 && sec < 60) {
                err++;
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        }
        System.out.println("");
        System.out.println("Enter 1 for AM / 2 for PM:");
        choice = scan.nextInt();
        switch (choice) {
            case 1:
                try {
                    displayAM(hrs, min, sec);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            case 2:
                try {
                    displayPM(hrs, min, sec);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            default:
                System.out.println("Invalid option...");
        }
    }
}

public class Clock {
    public static void main(String[] args) {
        Time t = new Time();
        t.get();
    }
}
