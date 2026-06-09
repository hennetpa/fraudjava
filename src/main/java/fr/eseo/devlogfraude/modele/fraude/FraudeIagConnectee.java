package fr.eseo.devlogfraude.modele.fraude;

import java.time.LocalDate;

/**
 * Représente une fraude de type IAG Connectée.
 * Cas particulier d'une fraude IAG avec un accès réseau,
 * précisant en plus l'adresse IP utilisée lors de la fraude.
 *
 * @author DevLogFraude
 * @version 1.0
 */
public class FraudeIagConnectee extends FraudeIag {

    /** Adresse IP utilisée lors de la fraude */
    private String adresseIP;

    // -------------------------------------------------------------------------
    // Constructeurs
    // -------------------------------------------------------------------------

    /**
     * Constructeur par défaut.
     */
    public FraudeIagConnectee() {
        super();
        this.adresseIP = "";
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
     * @param adresseIP      adresse IP utilisée
     */
    public FraudeIagConnectee(int idApprenant, String nom, String prenom, String cursus,
                               LocalDate dateRevelation, String description,
                               String nomService, String adresseIP) {
        super(idApprenant, nom, prenom, cursus, dateRevelation, description, nomService);
        this.adresseIP = adresseIP;
    }

    // -------------------------------------------------------------------------
    // Getters et Setters
    // -------------------------------------------------------------------------

    /**
     * Retourne l'adresse IP utilisée.
     *
     * @return l'adresse IP
     */
    public String getAdresseIP() {
        return adresseIP;
    }

    /**
     * Définit l'adresse IP utilisée.
     *
     * @param adresseIP l'adresse IP
     */
    public void setAdresseIP(String adresseIP) {
        this.adresseIP = adresseIP;
    }

    // -------------------------------------------------------------------------
    // Méthodes
    // -------------------------------------------------------------------------

    /**
     * Retourne le type de fraude.
     *
     * @return "IAG Connectée"
     */
    @Override
    public String getTypeFraude() {
        return "IAG Connectée";
    }

    /**
     * Retourne une représentation textuelle de la fraude IAG Connectée.
     *
     * @return la représentation textuelle
     */
    @Override
    public String toString() {
        return "FraudeIagConnectee{"
                + super.toString()
                + ", adresseIP='" + adresseIP + '\''
                + '}';
    }
}
