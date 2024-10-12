import java.io.File;
import java.util.Scanner;

public class Labyrint {
    protected Rute[][] lab;
    protected int antRad;
    protected int antKol;

    public Labyrint(String filnavn) {
        File fil = new File(filnavn);
        Scanner sc = null;

        try {
            sc = new Scanner(fil);
        } catch (Exception e) {
            e.printStackTrace();
        }

        this.antRad = sc.nextInt();
        this.antKol = sc.nextInt();
        Rute[][] lab = new Rute[antRad][antKol];

        String linje;

        sc.nextLine();

        for (int rad = 0; rad < antRad; rad++) {
            linje = sc.nextLine();

            String[] biter = linje.split("");

            for (int kol = 0; kol < biter.length; kol++) {
                if (biter[kol].equals(".")) {
                    if (rad == 0 || rad == antRad-1 || kol == 0 || kol == antKol-1) {
                        lab[rad][kol] = new Aapning(rad, kol);
                    }
                    else {
                        lab[rad][kol] = new HvitRute(rad, kol);
                    }
                }
                else if (biter[kol].equals("#")) {
                    lab[rad][kol] = new SvartRute(rad, kol);
                }
            }

        }

        this.lab = lab;

        giNaboer();
        giLab();

        System.out.println("Slik ser labyrinten ut:\n");
        System.out.println(this);
    }

    public Rute hentRute(int y, int x) {
        return lab[y][x];
    }

    public String toString() {
        String utskrift = "";

        for (int y = 0; y < antRad ; y++) {
            utskrift += "\n";
            for (int x = 0; x < antKol; x++) {
                utskrift += lab[y][x];
            }
        }

        return utskrift;
    }

    public void giNaboer() {

        for (int rad = 0; rad < antRad; rad++) {
            for (int kol = 0; kol < antKol; kol++) {
                if (rad > 0) {
                    lab[rad][kol].leggTilNord(lab[rad-1][kol]);
                }
                if (rad < antRad - 1) {
                    lab[rad][kol].leggTilSoer(lab[rad+1][kol]);
                }
                if (kol > 0) {
                    lab[rad][kol].leggTilVest(lab[rad][kol-1]);
                }
                if (kol < antKol - 1) {
                    lab[rad][kol].leggTilOest(lab[rad][kol+1]);
                }
            }
        }
    }

    public void giLab() {
        for (Rute[] rad : lab) {
            for (Rute kol : rad) {
                kol.leggTilLab(this);
            }
        }
    }

    public void finnUtveiFra(int rad, int kol) {
        Rute start = lab[rad][kol];

        if (start instanceof SvartRute) {
            System.out.println("Kan ikke starte fra svart rute");
            return;
        }

        start.finn(null);
    }

    public void skrivUtAapninger() {
        for (Rute[] rad : lab) {
            for (Rute kol : rad) {
                if (kol instanceof Aapning) {
                    System.out.println("(" + kol.rad + ", " + kol.kolonne + ")");
                }
            }
        }
    }

}