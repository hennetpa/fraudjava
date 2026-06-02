public class Etudiant extends Formulaire {
    private int idApprenant;
    private String nom;
    private String prenom;
    private String cursus;

    public Etudiant(int idApprenant, String nom, String prenom, String cursus) {
        this.idApprenant = idApprenant;
        this.nom = nom;
        this.prenom = prenom;
         if (cursus.equals("E3e") || cursus.equals("E3a") || cursus.equals("E1") || cursus.equals("E2") || cursus.equals("E4") || cursus.equals("E5")) {
        this.cursus = cursus;
    }
    }

    public int getIdApprenant() {
        return idApprenant;
    }

    public void setIdApprenant(int idApprenant) {
        this.idApprenant = idApprenant;
    }
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getCursus() {
        return cursus;
    }

    public void setCursus(String cursus) {
        this.cursus = cursus;
    }

}
