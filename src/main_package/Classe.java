package main_package;

public class Classe {
    private int num_classe;
    private int num_niveau;

    // constructor

    public Classe(int num_classe, int num_niveau) {
        this.num_classe = num_classe;
        this.num_niveau = num_niveau;
    }

    // Getters et setters

    public int getNum_classe() {
        return num_classe;
    }

    public void setNum_classe(int num_classe) {
        this.num_classe = num_classe;
    }

    public int getNum_niveau() {
        return num_niveau;
    }

    public void setNum_niveau(int num_niveau) {
        this.num_niveau = num_niveau;
    }
}
