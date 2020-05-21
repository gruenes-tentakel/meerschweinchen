public class FaulesMeerschweinchen extends Meerschweinchen {
    private boolean erbsenflocke;
    public FaulesMeerschweinchen(String _name) {
        super (_name);
        munter = false;
        erbsenflocke= false;
        energie = 0;
    }
    
    protected void begrüßung() {
        sag("Hallo, ich bin es das faule Meerschweinchen " + name + "!");
    }
    
    protected void rennintern() {
        if (munter && energie>0 && fröhlich && erbsenflocke) {
            System.out.println(name + " rennt los. Die Ohren wehen im Wind!");
            munter = false;
            energie = energie-1;
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
    
    public void jage(Meerschweinchen _wen) {
        System.out.println(name + ", jage " + _wen.nameDesMeerschweinchens() + "!");
        fröhlich = true;
        if (energie>0 && munter && erbsenflocke == true) {
            System.out.println(name + " macht sich bereit um " + _wen.nameDesMeerschweinchens() + " zu jagen!");
            rennintern();
            _wen.sag ("Hilfe! Ich werde von " + name + " angegriffen!");
            _wen.rennintern();
        }
        else {
            sag ("Nö, ich bin gerade zu schlapp zum jagen.");
        }
    }
}