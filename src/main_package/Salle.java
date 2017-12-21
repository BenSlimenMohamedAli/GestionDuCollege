package main_package;

public class Salle {
    private int num_salle;
    private int capacité;
    private String type_salle;

    public Salle(int num_salle, int capacité, String type_salle) {
        this.num_salle = num_salle;
        this.capacité = capacité;
        this.type_salle = type_salle;
    }

    // Setters et getters

    public int getNum_salle() {
        return num_salle;
    }

    public void setNum_salle(int num_salle) {
        this.num_salle = num_salle;
    }

    public int getCapacité() {
        return capacité;
    }

    public void setCapacité(int capacité) {
        this.capacité = capacité;
    }

    public String getType_salle() {
        return type_salle;
    }

    public void setType_salle(String type_salle) {
        this.type_salle = type_salle;
    }
}
