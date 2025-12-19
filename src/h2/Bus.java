package h2;
import java.util.ArrayList;

public class Bus {
    public ArrayList<Passenger> passengers;

    public Bus() {
        this.passengers = new ArrayList<>();
    }

    public void enterBus(Passenger p) {
        passengers.add(p);
    }

    private void exitBus() {
        for (int i = passengers.size() - 1; i >= 0; i--) {
            Passenger p = passengers.get(i);
            if (p.visited == p.planned) {
                passengers.remove(i);
            }
        }
    }
    public void nextStop(Passenger[] boarding) {
        for(Passenger p : passengers) {
            p.visited++;
        }
        exitBus();
        for(Passenger p : boarding) {
            enterBus(p);
        }
    }
    public void nextStop() {
        for (Passenger p : passengers) {
            p.visited++;
        }
        exitBus();
    }
    public ArrayList<Passenger> findPassengersWithoutTickets() {
        ArrayList<Passenger> removed = new ArrayList<>();
        for (int i = passengers.size() - 1; i >= 0; i--) {
            Passenger p = passengers.get(i);
            if(p.ticket == false) {
                passengers.remove(i);
                removed.add(0,p);

            }
        }
        return removed;
    }
    public void transferPassengers(Bus otherBus, String[] passengerNames) {
        ArrayList<Passenger> umstieg = new ArrayList<>();
        for(Passenger p : this.passengers) {
            for (String name : passengerNames) {
                if(p.name.equals(name)) {
                    umstieg.add(p);
                    break;
                }
            }
        }
        this.passengers.removeAll(umstieg);
        for(Passenger p : umstieg) {
            otherBus.enterBus(p);
        }
    }
}
