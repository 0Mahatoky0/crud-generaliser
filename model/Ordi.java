package model;

public class Ordi {
    
    private int id;
    private String marque;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getMarque() {
        return marque;
    }
    public void setMarque(String marque) {
        this.marque = marque;
    }

    @Override
    public String toString() {
        return this.id  + "  " + this.marque;
    }
}
