public class HvitRute extends Rute {

    public HvitRute(int rad, int kolonne) {
        super(rad, kolonne);
    }
    
    @Override
    public String toString() {
        return ".";
    }

    public void finn(Rute fra) {
        if (fra == null){
            nord.finn(this);
            oest.finn(this);
            vest.finn(this);
            soer.finn(this);
        }
        else {
            if (nord != null && nord != fra){
                nord.finn(this); 
            }
            if (oest != null && oest != fra){
                oest.finn(this);
            }
            if (soer != null && soer != fra){
                soer.finn(this);
            }
            if (vest != null && vest != fra){
                vest.finn(this);
            }
        }
        return;
    }
}
