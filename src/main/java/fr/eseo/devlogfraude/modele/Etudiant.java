package fr.eseo.devlogfraude.modele;

/**
 * Représente un étudiant dans le système de gestion des fraudes.
 * Un étudiant est identifié de manière unique par son numéro apprenant.
 *
 * @author DevLogFraude
 * @version 1.0
 */
public class Etudiant {

    /** Identifiant unique de l'apprenant */
    private int idApprenant;

    /** Nom de l'étudiant */
    private String nom;

    /** Prénom de l'étudiant */
    private String prenom;

    /** Cursus de l'étudiant */
    private Cursus cursus;

    // -------------------------------------------------------------------------
    // Constructeurs
    // -------------------------------------------------------------------------

    /**
     * Constructeur par défaut.
     */
    public Etudiant() {
        this.idApprenant = 0;
        this.nom = "";
        this.prenom = "";
        this.cursus = Cursus.E1;
    }

    /**
     * Constructeur initialisant l'ensemble des attributs.
     *
     * @param idApprenant identifiant unique de l'apprenant
     * @param nom         nom de l'étudiant
     * @param prenom      prénom de l'étudiant
     * @param cursus      cursus de l'étudiant
     */
    public Etudiant(int idApprenant, String nom, String prenom, Cursus cursus) {
        this.idApprenant = idApprenant;
        this.nom = nom;
        this.prenom = prenom;
        this.cursus = cursus;
    }

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
    public Cursus getCursus() {
        return cursus;
    }

    /**
     * Définit le cursus de l'étudiant.
     *
     * @param cursus le cursus
     */
    public void setCursus(Cursus cursus) {
        this.cursus = cursus;
    }

    // -------------------------------------------------------------------------
    // Méthodes
    // -------------------------------------------------------------------------

    /**
     * Vérifie l'égalité entre deux étudiants sur la base de leur identifiant.
     *
     * @param obj l'objet à comparer
     * @return true si les étudiants ont le même identifiant
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Etudiant)) return false;
        Etudiant other = (Etudiant) obj;
        return this.idApprenant == other.idApprenant;
    }

    /**
     * Retourne le hashCode basé sur l'identifiant apprenant.
     *
     * @return le hashCode
     */
    @Override
    public int hashCode() {
        return Integer.hashCode(idApprenant);
    }

    /**
     * Retourne une représentation textuelle de l'étudiant.
     *
     * @return la représentation textuelle
     */
    @Override
    public String toString() {
        return "Etudiant{"
                + "idApprenant=" + idApprenant
                + ", nom='" + nom + '\''
                + ", prenom='" + prenom + '\''
                + ", cursus=" + cursus
                + '}';
    }
}
