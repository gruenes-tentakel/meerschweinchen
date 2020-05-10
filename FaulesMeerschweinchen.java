public class FaulesMeerschweinchen extends Meerschweinchen {
    private boolean erbsenflocke;
    public FaulesMeerschweinchen(String _name) {
        super (_name);
        munter = false;
        erbsenflocke= false;
    }
    
    protected void begrüßung() {
        sag("Hallo, ich bin es das faule Meerschweinchen " + name + "!");
    }
    
    protected void rennintern() {
        if (munter && satt && fröhlich && erbsenflocke) {
            System.out.println(name + " rennt los. Die Ohren wehen im Wind!");
            munter = false;
            satt = false;
            erbsenflocke = false;
        }
        else if (!erbsenflocke) {
            sag("NÖ! Ich renne erst, wenn du mir eine Erbsenflocke gegeben hast.");
        }
        
        else {
            sag("Ich will jetzt nicht rennen.");
        }
    }
    
    public void erbsenflocke() {
        System.out.println(name + " bekommt eine Erbsenflocke.");
        sag ("Mhhh...lecker! Ich liebe Erbsenflocken! Jetzt bin ich fröhlich!");
        fröhlich = true;
        erbsenflocke = true;
    }
}