package main_package;


public class Enseignement {
    private int cin_ens;
    private String type_cours;

    // Constructor

    public Enseignement(int cin_ens, String type_cours) {
        this.cin_ens = cin_ens;
        this.type_cours = type_cours;
    }

    // Getters et setters

    public int getCin_ens() {
        return cin_ens;
    }

    public void setCin_ens(int cin_ens) {
        this.cin_ens = cin_ens;
    }

    public String getType_cours() {
        return type_cours;
    }

    public void setType_cours(String type_cours) {
        this.type_cours = type_cours;
    }
}
