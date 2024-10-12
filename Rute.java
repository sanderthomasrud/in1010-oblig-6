abstract class Rute {
    protected int rad;
    protected int kolonne;
    protected Labyrint lab;

    protected Rute nord = null;
    protected Rute soer = null;
    protected Rute oest = null;
    protected Rute vest = null;

    public Rute(int rad, int kolonne) {
        this.rad = rad;
        this.kolonne = kolonne;
    }

    public void leggTilLab(Labyrint lab) {
        this.lab = lab;
    }

    public void leggTilNord(Rute nord) {
        this.nord = nord;
    }

    public void leggTilSoer(Rute soer) {
        this.soer = soer;
    }

    public void leggTilOest(Rute oest) {
        this.oest = oest;
    }

    public void leggTilVest(Rute vest) {
        this.vest = vest;
    }

    public void sjekkNabo() {
        if (nord == null) {
            System.out.println("null");
        } else { System.out.println(nord.toString()); }
        if (oest == null) {
            System.out.println("null");
        } else { System.out.println(oest.toString()); }
        if (soer == null) {
            System.out.println("null");
        } else { System.out.println(soer.toString()); }
        if (vest == null) {
            System.out.println("null");
        } else { System.out.println(vest.toString()); }
    }

    abstract void finn(Rute fra);

}

