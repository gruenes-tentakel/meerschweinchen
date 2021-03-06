import java.util.*;

public class User {
    static ArrayList<Meerschweinchen> meeries;
    
    private static Meerschweinchen findeMeerie(String name) {
        for (Meerschweinchen m : meeries) {
            if (m.nameDesMeerschweinchens().toLowerCase().equals(name)) {
                return m;
            }
        }
        return null;
    }
    
    public static void main(String[] args) {
        meeries = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        boolean ersterDurchlauf = true;
        
        while (true) {
            
            if (ersterDurchlauf) {
                System.out.print("\nBitte gib einen Befehl ein, wenn du keine weiteren Befehle eingeben möchtest schreibe \"Ende\", wenn du Hilfe benötigst schreibe \"Hilfe\": ");
                ersterDurchlauf = false;
            }   
            else {
                System.out.print( "\nBitte gib einen Befehl ein: ");
            }
            
            String befehl = in.nextLine();
            System.out.println ("");
            
            if (befehl.toLowerCase().equals("ende")) {
                break;
            }
            else if (befehl.toLowerCase().equals("hilfe")) {
                System.out.println("Meerschweinchen Simulator 1.0 by Charly:");
                System.out.println("Zuerst musst du ein Meerschweinchen erstellen. Dazu schreibst du den Namen des Meerschweinchens und danach \"erstellen\".");
                System.out.println("Du kannst auch ein faules Meerschweinchen erstellen, das am Anfang müde ist und dem du erst eine Erbsenflocke geben musst, damit es rennt.");
                System.out.println("Dazu musst du nach erstellen noch ein Leerzeichen und dann \"faul\" schreiben!");
                System.out.println("Das Meerschweinchen hat drei Energie-Punkt am Anfang, außer es ist ein faules Meerschweinchen, dann hat es am Anfang keine Energie-Punkte");
                System.out.println("Als erstes gibst du den Namen des Meerschweinchens ein, das einen bestimmten Befehl ausführen soll.");
                System.out.println("Danach schreibst du ein Leerzeichen und gibst den Befehl ein.");
                System.out.println("Hier findest du die Befehle, die du eingeben kannst, um ein Meerschweinchen zu steuern:");
                System.out.println("- Erbsenflocke -> Das Meerschweinchen frisst eine Erbsenflocke und wird fröhlich.");
                System.out.println("- Friss        -> Das Meerschweinchen frisst, wenn es hunger hat und seine Energiepunkte sind wieder auf drei aufgeladen.");
                System.out.println("- Renn         -> Das Meerschweinchen rennt, wenn es munter und fröhlich ist, wird müde und verliert einen Energie-Punkt.");
                System.out.println("- Mussrennen   -> Du zwingst das Meerschweinchen dazu, zu rennen, es wird ärgerlich auf dich und verliert alle Energie-Punkte.");
                System.out.println("- Schlaf       -> Das Meerschweinchen schläft, falls es müde sein sollte und wird wieder munter.");
                System.out.println("- Jage (wen)   -> Das Meerschweinchen jagt ein anderes Meerschweinchen. Ein Beispiel zum eintippen: tobi jage mila");
                System.out.println("- Status       -> Das Meerschweinchen sagt dir, wie es ihm geht.");
                System.out.println("Zum Beispiel kann man eingeben: \"Tobi Erbsenflocke\". Das Meerschweinchen Tobi würde in diesem Fall eine Erbsenflocke essen und fröhlich sein.");
                System.out.println("Du musst auch nicht auf Groß- und Kleinschreibung achten.");
                System.out.println("Wenn du Hilfe benötigst, kannst du \"Hilfe\" schreiben und wenn du die Eingabe beenden möchtest, kannst du \"Ende\" schreiben.");
                
            }
            else {
               
                String[] teile = befehl.split(" ");
                
                if (teile.length == 2) {
                    String name = teile[0];
                    String tat = teile[1].toLowerCase();
                    Meerschweinchen m = findeMeerie(name.toLowerCase());
                    if (m != null) {
                        if(tat.equals("erbsenflocke")) {
                            m.erbsenflocke();
                        }
                        else if(tat.equals("friss")) {
                            m.friss();
                        }
                        else if(tat.equals("renn")) {
                            m.renn();
                        }
                        else if(tat.equals("mussrennen")) {
                            m.mussrennen();
                        }
                        else if(tat.equals("schlaf")) {
                            m.schlaf();
                        }
                        else if(tat.equals("status")) {
                            m.status();
                        }
                        else{
                            System.out.println("Es tut mir leid, diesen Befehl kenne ich nicht, falls du Hilfe benötigst, schreibe \"Hilfe\".");
                        }
                    }
                    else {
                        if (tat.equals("erstellen")) {
                            meeries.add(new Meerschweinchen(name));
                        }
                        else {
                            System.out.println("Es tut mir leid, dieses Meerschweinchen kenne ich nicht, falls du Hilfe benötigst, schreibe \"Hilfe\".");
                        }
                    }
                }  
                else if (teile.length ==3) {
                    String tat = teile[1].toLowerCase();
                    if (tat.equals("erstellen")) {
                        String art = teile[2].toLowerCase();
                        if (art.equals("faul")) {
                            String name = teile[0];
                            meeries.add(new FaulesMeerschweinchen(name));
                        }
                        else {
                            System.out.println("Es tut mir leid, das kann ich nicht machen. Du kannst ein normales Meerschweinchen oder ein faules Meerschweinchen erstellen.");
                        }
                    }
                    else if (tat.equals("jage")) {
                        String name = teile[0].toLowerCase();                    
                        String opfer = teile[2].toLowerCase();
                        Meerschweinchen m = findeMeerie(name);
                        Meerschweinchen o = findeMeerie(opfer);
                        if (m != null && o != null) {
                            if (m != o) {
                                m.jage(o);
                            }
                            else {
                                System.out.println ("Hier musst du zwei verschiedene Meerschweinchen angeben!");  
                            }
                        }
                        else {
                            System.out.println ("Es tut mir leid, mindestens eins dieser Meerschweinchen kenne ich nicht, falls du Hilfe benötigst, schreibe \"Hilfe\"."); 
                        }
                    }                                                            
                    else {
                        System.out.println("Es tut mir leid, diesen Befehl kenne ich nicht, falls du Hilfe benötigst, schreibe \"Hilfe\".");                                             
                    }
                }
            }
        }
    }
}