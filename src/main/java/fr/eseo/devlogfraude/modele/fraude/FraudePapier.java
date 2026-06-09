package fr.eseo.devlogfraude.modele.fraude;

import java.time.LocalDate;

/**
 * Représente une fraude de type Papier.
 * Correspond à un document physique non autorisé lors d'une épreuve.
 * Précise les dimensions du document et son état plié ou non.
 *
 * @author DevLogFraude
 * @version 1.0
 */
public class FraudePapier extends Fraude {

    /** Dimensions du document en cm (ex : "10.5x7.0") */
    private double dimensions;

    /** Indique si le document était plié */
    private boolean etatPlie;

    // -------------------------------------------------------------------------
    // Constructeurs
    // -------------------------------------------------------------------------

    /**
     * Constructeur par défaut.
     */
    public FraudePapier() {
        super();
        this.dimensions = 0.0;
        this.etatPlie = false;
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
     * @param dimensions     dimensions du document (en cm²)
     * @param etatPlie       true si le document était plié
     */
    public FraudePapier(int idApprenant, String nom, String prenom, String cursus,
                        LocalDate dateRevelation, String description,
                        double dimensions, boolean etatPlie) {
        super(idApprenant, nom, prenom, cursus, dateRevelation, description);
        this.dimensions = dimensions;
        this.etatPlie = etatPlie;
    }

    // -------------------------------------------------------------------------
    // Getters et Setters
    // -------------------------------------------------------------------------

    /**
     * Retourne les dimensions du document.
     *
     * @return les dimensions en cm²
     */
    public double getDimensions() {
        return dimensions;
    }

    /**
     * Définit les dimensions du document.
     *
     * @param dimensions les dimensions en cm²
     */
    public void setDimensions(double dimensions) {
        this.dimensions = dimensions;
    }

    /**
     * Indique si le document était plié.
     *
     * @return true si le document était plié
     */
    public boolean isEtatPlie() {
        return etatPlie;
    }

    /**
     * Définit l'état plié du document.
     *
     * @param etatPlie true si le document était plié
     */
    public void setEtatPlie(boolean etatPlie) {
        this.etatPlie = etatPlie;
    }

    // -------------------------------------------------------------------------
    // Méthodes
    // -------------------------------------------------------------------------

    /**
     * Retourne le type de fraude.
     *
     * @return "Papier"
     */
    @Override
    public String getTypeFraude() {
        return "Papier";
    }

    /**
     * Retourne une représentation textuelle de la fraude Papier.
     *
     * @return la représentation textuelle
     */
    @Override
    public String toString() {
        return "FraudePapier{"
                + super.toString()
                + ", dimensions=" + dimensions
                + ", etatPlie=" + etatPlie
                + '}';
    }
}
