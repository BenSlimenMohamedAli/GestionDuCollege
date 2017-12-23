package main_package;

import java.sql.Time;

public class Séance {
    private int num_séance;
    private Time heure_séance;
    private String jour_séance;
    private int num_niveau;
    private int num_classe;
    private int cin_ens;
    private String type_cours;
    private int num_salle;

    // Constructeur

    public Séance(int num_séance,Time heure_séance, String jour_séance, int num_niveau, int num_classe, int cin_ens, String type_cours, int num_salle) {
        this.num_séance = num_séance;
        this.heure_séance = heure_séance;
        this.jour_séance = jour_séance;
        this.num_niveau = num_niveau;
        this.num_classe = num_classe;
        this.cin_ens = cin_ens;
        this.type_cours = type_cours;
        this.num_salle = num_salle;
    }

    // Setters et getters

    public int getNum_séance() {
        return num_séance;
    }

    public Time getHeure_séance() {
        return heure_séance;
    }

    public void setHeure_séance(Time heure_séance) {
        this.heure_séance = heure_séance;
    }

    public String getJour_séance() {
        return jour_séance;
    }

    public void setJour_séance(String jour_séance) {
        this.jour_séance = jour_séance;
    }

    public int getNum_niveau() {
        return num_niveau;
    }

    public void setNum_niveau(int num_niveau) {
        this.num_niveau = num_niveau;
    }

    public int getNum_classe() {
        return num_classe;
    }

    public void setNum_classe(int num_classe) {
        this.num_classe = num_classe;
    }

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

    public int getNum_salle() {
        return num_salle;
    }

    public void setNum_salle(int num_salle) {
        this.num_salle = num_salle;
    }
}
