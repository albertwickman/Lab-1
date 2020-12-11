package src;

import java.util.ArrayList;

public class TurboModel {

    private final ArrayList<Turbo> turbos = new ArrayList<>();

    public void setTurboOn() {
        for (Turbo t : turbos) {
            t.setTurboOn();
        }
    }

    public void setTurboOff() {
        for (Turbo t : turbos) {
            t.setTurboOff();
        }
    }

    public ArrayList<Turbo> getTurbos() { return turbos; }
    public void addTurbo(Turbo turbo) { this.turbos.add(turbo); }
}
