package h1;

import java.util.ArrayList;

public class H1_main {
    public static void main(String[] args) {
        PrioListe liste = new PrioListe();
        liste.addPatient(new Patient("JAA",1));
        liste.addPatient(new Patient("JAA2",10));
        liste.addPatient(new Patient("JAA3",5));

        System.out.println(liste.getNextPatient().name);
        System.out.println(liste.getNextPatient().name);
        System.out.println(liste.getNextPatient().name);

    }
}
