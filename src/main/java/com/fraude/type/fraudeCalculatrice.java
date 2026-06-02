package main.java.com.fraude.type;

public class fraudeCalculatrice {
    private String marque;
    private String programme;

    public fraudeCalculatrice(String marque, String programme) {
        this.marque = marque;
        this.programme = programme;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public void setProgramme(String programme) {
        this.programme = programme;
    }

    public String getMarque() {
        return marque;
    }

    public String getProgramme() {
        return programme;
    }


}
