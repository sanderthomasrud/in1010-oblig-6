public class Aapning extends HvitRute {
    
    public Aapning(int rad, int kolonne) {
        super(rad, kolonne);
    }


    @Override
    public String toString() {
        return ".";
    }

    public void finn(Rute fra) {
        // System.out.println("Aapninger:\n");
        System.out.println("(" + rad + ", " + kolonne + ")");
        return;
    }
}
