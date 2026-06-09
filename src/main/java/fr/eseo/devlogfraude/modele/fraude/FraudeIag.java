package fr.eseo.devlogfraude.modele.fraude;

import java.time.LocalDate;

/**
 * Représente une fraude de type IAG (Intelligence Artificielle Générative).
 * Ce type de fraude correspond à l'utilisation non déclarée d'un service
 * d'intelligence artificielle générative lors d'une épreuve.
 *
 * @author DevLogFraude
 * @version 1.0
 */
public class FraudeIag extends Fraude {

    /** Nom du service d'IA générative utilisé */
    private String nomService;

    // -------------------------------------------------------------------------
    // Constructeurs
    // -------------------------------------------------------------------------

    /**
     * Constructeur par défaut.
     */
    public FraudeIag() {
        super();
        this.nomService = "";
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
     * @param nomService     nom du service IAG utilisé
     */
    public FraudeIag(int idApprenant, String nom, String prenom, String cursus,
                     LocalDate dateRevelation, String description, String nomService) {
        super(idApprenant, nom, prenom, cursus, dateRevelation, description);
        this.nomService = nomService;
    }

    // -------------------------------------------------------------------------
    // Getters et Setters
    // -------------------------------------------------------------------------

    /**
     * Retourne le nom du service IAG utilisé.
     *
     * @return le nom du service
     */
    public String getNomService() {
        return nomService;
    }

    /**
     * Définit le nom du service IAG utilisé.
     *
     * @param nomService le nom du service
     */
    public void setNomService(String nomService) {
        this.nomService = nomService;
    }

    // -------------------------------------------------------------------------
    // Méthodes
    // -------------------------------------------------------------------------

    /**
     * Retourne le type de fraude.
     *
     * @return "IAG"
     */
    @Override
    public String getTypeFraude() {
        return "IAG";
    }

    /**
     * Retourne une représentation textuelle de la fraude IAG.
     *
     * @return la représentation textuelle
     */
    @Override
    public String toString() {
        return "FraudeIag{"
                + super.toString()
                + ", nomService='" + nomService + '\''
                + '}';
    }
}
