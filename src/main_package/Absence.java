package main_package;


import java.sql.Date;

public class Absence {
    private Date date_dabsence;
    private int num_inscri;
    private int num_séance;

    // Constructeur

    public Absence(Date date_dabsence, int num_inscri, int num_séance) {
        this.date_dabsence = date_dabsence;
        this.num_inscri = num_inscri;
        this.num_séance = num_séance;
    }

    // getters et setters

    public Date getDate_dabsence() {
        return date_dabsence;
    }

    public void setDate_dabsence(Date date_dabsence) {
        this.date_dabsence = date_dabsence;
    }

    public int getNum_inscri() {
        return num_inscri;
    }

    public void setNum_inscri(int num_inscri) {
        this.num_inscri = num_inscri;
    }

    public int getNum_séance() {
        return num_séance;
    }

    public void setNum_séance(int num_séance) {
        this.num_séance = num_séance;
    }
}
