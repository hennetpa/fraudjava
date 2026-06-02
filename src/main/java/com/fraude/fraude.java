package main.java.com.fraude;

public class fraude {
    private int idApprenant;
    private String nom;
    private String prenom;
    private String Cursus;
    private String DateRevelation;
    private String description;

    public fraude(int idApprenant, String nom, String prenom, String Cursus, String DateRevelation, String description) {
        this.idApprenant = idApprenant;
        this.nom = nom;
        this.prenom = prenom;
        if (Cursus.equals("E3e") || Cursus.equals("E3a") || Cursus.equals("E1") || Cursus.equals("E2") || Cursus.equals("E4") || Cursus.equals("E5")) {
            this.Cursus = Cursus;
        }
        else {
            System.out.println("Erreur se Cursus n'existe pas");
        }

        this.DateRevelation = DateRevelation;
        this.description = description;

    }

    public void setIdApprenant(int idApprenant) {
        this.idApprenant = idApprenant;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setCursus(String cursus) {
        Cursus = cursus;
    }

    public void setDateRevelation(String dateRevelation) {
        DateRevelation = dateRevelation;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getIdApprenant() {
        return idApprenant;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getCursus() {
        return Cursus;
    }

    public String getDateRevelation() {
        return DateRevelation;
    }

    public String getDescription() {
        return description;
    }


}
