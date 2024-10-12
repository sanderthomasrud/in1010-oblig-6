import java.util.Scanner;

public class Oblig6 {
    public static void main(String[] args) {

        String filnavn = args[0];

        Labyrint lab1 = new Labyrint(filnavn);

        kommandoLokke(lab1);

    }

    public static void kommandoLokke(Labyrint lab) {
        Scanner sc = new Scanner(System.in);

        System.out.println("\nSkriv inn koordinater <rad> <kolonne> ('-1' for aa avslutte)");

        String input = sc.nextLine();

        while (!input.equals("-1")) {
            String[] pos = input.split(" ");

            lab.finnUtveiFra(Integer.parseInt(pos[0]), Integer.parseInt(pos[1]));

            System.out.println("\nSkriv inn nye koordinater (-1 for aa avslutte)");

            input = sc.nextLine();
        }

        return;
    }

}
