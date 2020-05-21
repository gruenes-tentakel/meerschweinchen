public class Meerschweinchen {
    
    // Attribute
    protected String name;
    protected boolean munter;
    protected boolean fröhlich;
    protected int energie;
    
    // Constructor
    public Meerschweinchen(String _name) {
        name = _name;
        munter = true;
        fröhlich = true;
        energie = 3;
        begrüßung();
    }
    
    // Methoden
    
    protected void begrüßung() {
        sag("Hallo, ich bin es das Meerschweinchen " + name + "!");
    }
    
    public String nameDesMeerschweinchens() {
        return name;
    }
    
    public void status() {
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
        if (energie == 3) {
            sag("Ich bin voll Energie geladen und satt!");
        }
        else if (energie == 2 || energie == 1) {
            sag("Joaaa...ich hab noch ein bisschen Energie und hab auch schon etwas hunger!");
        }
        else {
            sag("Ich habe keine Energie mehr..., gib mir etwas zu fressen!");
        }
    }
    
    public void sag(String _text) {
        System.out.println("🐹 " + name + " sagt: " + _text);
    }
    
    public void friss() {
        System.out.println(name + " bekommt ein Möhrchen angeboten.");
        if (energie != 3) {
            System.out.println(name + " frisst.");
            energie = 3;
            sag ("Mhhh...das war lecker. Jetzt bin ich satt und habe wieder Energie!");
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
        if (munter && energie>0 && fröhlich) {
            System.out.println(name + " rennt los. Die Ohren wehen im Wind!");
            munter = false;
            energie = energie-1;
        }
        else {
            sag("Ich will jetzt nicht rennen.");
        }
    }

    public void mussrennen() {
        System.out.println(name + ", renn los!");
        sag("Ich will jetzt nicht rennen.");
        System.out.println(name + ", SUDO renn los!");
        System.out.println(name + " rennt langsam los, doch bleibt nach 30cm stehen. Das Meerschweinchen ist jetzt ärgerlich auf dich und hat keine Energie mehr.");
        fröhlich = false;
        munter = false;
        energie = 0;
    }
    
    public void erbsenflocke() {
        System.out.println(name + " bekommt eine Erbsenflocke.");
        sag ("Mhhh...lecker! Ich liebe Erbsenflocken! Jetzt bin ich fröhlich!");
        fröhlich = true;
        
    }
    
    public void jage(Meerschweinchen _wen) {
        System.out.println(name + ", jage " + _wen.nameDesMeerschweinchens() + "!");
        if (energie>0 && munter) {
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
