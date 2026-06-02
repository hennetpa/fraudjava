import java.sql.Date;

public class Formulaire implements Epreuve, Etudiant, Fraude {
    private int ID;
    private Date dateCreation;
    private Date dateModification;


    public Formulaire(int ID, Date dateCreation, Date dateModification) {
        this.ID = ID;
        this.dateCreation = dateCreation;
        this.dateModification = dateModification;
        }

    public int getId() {
        return ID;
    }

    public void setId(int id) {
        this.ID = id;
    }
    
    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }
    
    public Date getDateModification() {
        return dateModification;
    }

    public void setDateModification(Date dateModification) {
        this.dateModification = dateModification;
    }

    public void ficheEtudiante() {
    }

    public void ficheFraude() {
    }

    public void enregistrementFormulaire() {
    }

    public void retirerFormulaire(){

    }
    public void listerFormulaire(){

    }
}
