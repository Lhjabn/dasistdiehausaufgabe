package h1;

import java.util.ArrayList;

public class PrioListe {
    public ArrayList<Patient> myList = new ArrayList<>();

    public void addPatient(Patient p){
        if(myList.isEmpty()) {
            myList.add(p);
            return;
        }
        boolean drinne = false;
        for (int i = 0; i < myList.size(); i++) {
            if(p.prio < myList.get(i).prio) {
                myList.add(i, p);
                drinne = true;
                break;
            }

        }
        if(drinne == false) {
            myList.add(p);
        }
    }
    public Patient getNextPatient(){
        if(myList.isEmpty()) {
            return null;
        }
        Patient p = myList.get(0);
        myList.remove(0);
        return p;
    }
    public int getPosition(Patient p) {
        return myList.indexOf(p);
    }
}

