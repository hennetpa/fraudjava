package fr.eseo.devlogfraude.modele.fraude;

import java.time.LocalDate;

/**
 * Représente une fraude de type Calculatrice.
 * Correspond à l'utilisation non autorisée d'une calculatrice
 * lors d'une épreuve. Précise la marque et le programme stocké.
 *
 * @author DevLogFraude
 * @version 1.0
 */
public class FraudeCalculatrice extends Fraude {

    /** Marque de la calculatrice utilisée */
    private String marque;

    /** Programme stocké dans la calculatrice */
    private String programme;

    // -------------------------------------------------------------------------
    // Constructeurs
    // -------------------------------------------------------------------------

    /**
     * Constructeur par défaut.
     */
    public FraudeCalculatrice() {
        super();
        this.marque = "";
        this.programme = "";
    }

    /**
     * Constructeur initialisant l'ensemble des attributs.
     *
     * @param idApprenant    identifiant de l'apprenant
     * @param nom            nom de l'étudiant
     * @param prenom         prénom de l'étudiant
     * @param cursus         cursus de l'étudiant
     * @param dateRevelation date de révélation
     * @param description    description de la fraude
     * @param marque         marque de la calculatrice
     * @param programme      programme stocké dans la calculatrice
     */
    public FraudeCalculatrice(int idApprenant, String nom, String prenom, String cursus,
                               LocalDate dateRevelation, String description,
                               String marque, String programme) {
        super(idApprenant, nom, prenom, cursus, dateRevelation, description);
        this.marque = marque;
        this.programme = programme;
    }

    // -------------------------------------------------------------------------
    // Getters et Setters
    // -------------------------------------------------------------------------

    /**
     * Retourne la marque de la calculatrice.
     *
     * @return la marque
     */
    public String getMarque() {
        return marque;
    }

    /**
     * Définit la marque de la calculatrice.
     *
     * @param marque la marque
     */
    public void setMarque(String marque) {
        this.marque = marque;
    }

    /**
     * Retourne le programme stocké dans la calculatrice.
     *
     * @return le programme
     */
    public String getProgramme() {
        return programme;
    }

    /**
     * Définit le programme stocké dans la calculatrice.
     *
     * @param programme le programme
     */
    public void setProgramme(String programme) {
        this.programme = programme;
    }

    // -------------------------------------------------------------------------
    // Méthodes
    // -------------------------------------------------------------------------

    /**
     * Retourne le type de fraude.
     *
     * @return "Calculatrice"
     */
    @Override
    public String getTypeFraude() {
        return "Calculatrice";
    }

    /**
     * Retourne une représentation textuelle de la fraude Calculatrice.
     *
     * @return la représentation textuelle
     */
    @Override
    public String toString() {
        return "FraudeCalculatrice{"
                + super.toString()
                + ", marque='" + marque + '\''
                + ", programme='" + programme + '\''
                + '}';
    }
}
