package fr.eseo.devlogfraude.modele.fraude;

import java.time.LocalDate;

/**
 * Classe abstraite représentant une fraude constatée lors d'une épreuve.
 * Une fraude est caractérisée par une date de relevé, une description
 * et un contenu. Les sous-classes définissent le type précis de fraude.
 *
 * @author DevLogFraude
 * @version 1.0
 */
public abstract class Fraude {

    /** Identifiant de l'apprenant impliqué */
    private int idApprenant;

    /** Nom de l'étudiant */
    private String nom;

    /** Prénom de l'étudiant */
    private String prenom;

    /** Cursus de l'étudiant */
    private String cursus;

    /** Date à laquelle la fraude a été relevée */
    private LocalDate dateRevelation;

    /** Description textuelle de la fraude */
    private String description;

    // -------------------------------------------------------------------------
    // Constructeurs
    // -------------------------------------------------------------------------

    /**
     * Constructeur par défaut.
     */
    public Fraude() {
        this.idApprenant = 0;
        this.nom = "";
        this.prenom = "";
        this.cursus = "";
        this.dateRevelation = LocalDate.now();
        this.description = "";
    }

    /**
     * Constructeur initialisant l'ensemble des attributs communs.
     *
     * @param idApprenant    identifiant de l'apprenant
     * @param nom            nom de l'étudiant
     * @param prenom         prénom de l'étudiant
     * @param cursus         cursus de l'étudiant
     * @param dateRevelation date à laquelle la fraude a été révélée
     * @param description    description de la fraude
     */
    public Fraude(int idApprenant, String nom, String prenom, String cursus,
                  LocalDate dateRevelation, String description) {
        this.idApprenant = idApprenant;
        this.nom = nom;
        this.prenom = prenom;
        this.cursus = cursus;
        this.dateRevelation = dateRevelation;
        this.description = description;
    }

    // -------------------------------------------------------------------------
    // Méthode abstraite
    // -------------------------------------------------------------------------

    /**
     * Retourne le type de fraude sous forme de chaîne.
     *
     * @return le type de fraude
     */
    public abstract String getTypeFraude();

    // -------------------------------------------------------------------------
    // Getters et Setters
    // -------------------------------------------------------------------------

    /**
     * Retourne l'identifiant de l'apprenant.
     *
     * @return l'identifiant apprenant
     */
    public int getIdApprenant() {
        return idApprenant;
    }

    /**
     * Définit l'identifiant de l'apprenant.
     *
     * @param idApprenant l'identifiant apprenant
     */
    public void setIdApprenant(int idApprenant) {
        this.idApprenant = idApprenant;
    }

    /**
     * Retourne le nom de l'étudiant.
     *
     * @return le nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * Définit le nom de l'étudiant.
     *
     * @param nom le nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Retourne le prénom de l'étudiant.
     *
     * @return le prénom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * Définit le prénom de l'étudiant.
     *
     * @param prenom le prénom
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * Retourne le cursus de l'étudiant.
     *
     * @return le cursus
     */
    public String getCursus() {
        return cursus;
    }

    /**
     * Définit le cursus de l'étudiant.
     *
     * @param cursus le cursus
     */
    public void setCursus(String cursus) {
        this.cursus = cursus;
    }

    /**
     * Retourne la date de révélation de la fraude.
     *
     * @return la date de révélation
     */
    public LocalDate getDateRevelation() {
        return dateRevelation;
    }

    /**
     * Définit la date de révélation de la fraude.
     *
     * @param dateRevelation la date de révélation
     */
    public void setDateRevelation(LocalDate dateRevelation) {
        this.dateRevelation = dateRevelation;
    }

    /**
     * Retourne la description de la fraude.
     *
     * @return la description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Définit la description de la fraude.
     *
     * @param description la description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    // -------------------------------------------------------------------------
    // Méthodes
    // -------------------------------------------------------------------------

    /**
     * Retourne une représentation textuelle de la fraude.
     *
     * @return la représentation textuelle
     */
    @Override
    public String toString() {
        return "Fraude{"
                + "type=" + getTypeFraude()
                + ", idApprenant=" + idApprenant
                + ", nom='" + nom + '\''
                + ", prenom='" + prenom + '\''
                + ", cursus='" + cursus + '\''
                + ", dateRevelation=" + dateRevelation
                + ", description='" + description + '\''
                + '}';
    }
}
