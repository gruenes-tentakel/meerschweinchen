public class Meerschweinchen {
    
    // Attribute
    private String name;
    private boolean satt;
    private boolean munter;
    private boolean fröhlich;
    
    // Constructor
    public Meerschweinchen(String _name) {
        name = _name;
        satt = true;
        munter = true;
        fröhlich = true;
        sag("Hallo, ich bin es das Meerschweinchen " + name + "!");
    }
    
    // Methoden
    public String nameDesMeerschweinchens() {
        return name;
    }
    
    public void status() {
        if (satt) {
            sag("Ich bin satt. 😊");
        }
        else {
            sag("Ich bin hungrig. Gib mir bitte was zu fressen. 🥕");
        }
        if (munter) {
            sag("Ich bin munter! 🙂");
        }
        else {
            sag("Ich bin soo müde. Jetzt würde ich mich gerne ausruhen! 😴");
        }
        if (fröhlich) {
            sag("Ich bin fröhlich! 😁");
        }
        else {
            sag("Ich bin ärgerlich auf dich! *Grummel, grummel* 😠");
        }
    }
    
    public void sag(String _text) {
        System.out.println(name + " sagt: " + _text);
    }
    
    public void friss() {
        System.out.println(name + " bekommt eine Gurkenscheibe angeboten.");
        if (!satt) {
            System.out.println(name + " frisst.");
            satt = true;
            sag ("Mhhh...das war lecker. Jetzt bin ich satt!");
        }
        else {
            sag("Nein danke, ich bin schon satt!");
        }
    }
   
    public void renn() {
        System.out.println(name + ", renn los!");
        rennintern();
    }   
    
    protected void rennintern() {
        if (munter && satt && fröhlich) {
            System.out.println(name + " rennt los. Die Ohren wehen im Wind!");
            munter = false;
            satt = false;
        }
        else {
            System.out.println("Ich will jetzt nicht rennen.");
        }
    }

    public void mussrennen() {
       System.out.println(name + ", renn los!");
       sag("Ich will jetzt nicht rennen.");
       System.out.println(name + ", SUDO renn los!");
       System.out.println(name + " rennt langsam los, doch bleibt nach 30cm stehen. Die Energie des Meerschweinchens ist jetzt negativ und es ist jetzt ärgerlich auf dich.");
       fröhlich = false;
       satt = false;
       munter = false;
    }
    
    public void erbsenflocke() {
        System.out.println(name + " bekommt eine Erbsenflocke.");
        sag ("Mhhh...lecker! Ich liebe Erbsenflocken! Jetzt bin ich fröhlich!");
        fröhlich = true;
    }
    
    public void jage(Meerschweinchen _wen) {
        System.out.println(name + ", jage " + _wen.nameDesMeerschweinchens() + "!");
        fröhlich = true;
        if (satt && munter) {
            System.out.println(name + " macht sich bereit um " + _wen.nameDesMeerschweinchens() + " zu jagen!");
            rennintern();
            _wen.sag ("Hilfe! Ich werde von " + name + " angegriffen!");
            _wen.rennintern();
        }
        else {
            sag ("Nö, ich bin gerade zu schlapp zum jagen.");
        }
    }
    
    public void schlaf() {
       System.out.println(name + ", ruhst du dich mal aus?");
       if (!munter) {
            System.out.println(name + " schläft.");
            munter = true;
            sag("Jetzt bin ich wieder munter und fühle mich fit und frisch!");
       }  
       else {
          sag("Ich bin doch noch gar nicht müde!");
       }
    }
}    