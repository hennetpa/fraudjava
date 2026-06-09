package fr.eseo.devlogfraude.modele;

import fr.eseo.devlogfraude.modele.fraude.Fraude;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Représente un formulaire de fraude, document central du système.
 * Un formulaire relie une épreuve, un ou plusieurs étudiants impliqués
 * et une ou plusieurs fraudes constatées.
 * Son identifiant est généré automatiquement à la création.
 *
 * @author DevLogFraude
 * @version 1.0
 */
public class Formulaire {

    /** Compteur statique pour la génération automatique d'identifiants */
    private static int compteurId = 1;

    /** Identifiant unique du formulaire */
    private int id;

    /** Date de création du formulaire */
    private LocalDate dateCreation;

    /** Date de dernière modification du formulaire */
    private LocalDate dateModification;

    /** Épreuve associée au formulaire */
    private Epreuve epreuve;

    /** Liste des étudiants impliqués */
    private List<Etudiant> etudiants;

    /** Liste des fraudes constatées */
    private List<Fraude> fraudes;

    // -------------------------------------------------------------------------
    // Constructeurs
    // -------------------------------------------------------------------------

    /**
     * Constructeur par défaut.
     * L'identifiant est généré automatiquement.
     */
    public Formulaire() {
        this.id = compteurId++;
        this.dateCreation = LocalDate.now();
        this.dateModification = LocalDate.now();
        this.epreuve = null;
        this.etudiants = new ArrayList<>();
        this.fraudes = new ArrayList<>();
    }

    /**
     * Constructeur initialisant l'ensemble des attributs.
     * L'identifiant est généré automatiquement.
     *
     * @param epreuve   épreuve concernée
     * @param etudiants liste des étudiants impliqués
     * @param fraudes   liste des fraudes constatées
     */
    public Formulaire(Epreuve epreuve, List<Etudiant> etudiants, List<Fraude> fraudes) {
        this.id = compteurId++;
        this.dateCreation = LocalDate.now();
        this.dateModification = LocalDate.now();
        this.epreuve = epreuve;
        this.etudiants = etudiants != null ? new ArrayList<>(etudiants) : new ArrayList<>();
        this.fraudes = fraudes != null ? new ArrayList<>(fraudes) : new ArrayList<>();
    }

    // -------------------------------------------------------------------------
    // Getters et Setters
    // -------------------------------------------------------------------------

    /**
     * Retourne l'identifiant du formulaire.
     *
     * @return l'identifiant
     */
    public int getId() {
        return id;
    }

    /**
     * Définit l'identifiant du formulaire.
     *
     * @param id l'identifiant
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Retourne la date de création du formulaire.
     *
     * @return la date de création
     */
    public LocalDate getDateCreation() {
        return dateCreation;
    }

    /**
     * Définit la date de création du formulaire.
     *
     * @param dateCreation la date de création
     */
    public void setDateCreation(LocalDate dateCreation) {
        this.dateCreation = dateCreation;
    }

    /**
     * Retourne la date de dernière modification.
     *
     * @return la date de modification
     */
    public LocalDate getDateModification() {
        return dateModification;
    }

    /**
     * Définit la date de dernière modification.
     *
     * @param dateModification la date de modification
     */
    public void setDateModification(LocalDate dateModification) {
        this.dateModification = dateModification;
    }

    /**
     * Retourne l'épreuve associée au formulaire.
     *
     * @return l'épreuve
     */
    public Epreuve getEpreuve() {
        return epreuve;
    }

    /**
     * Définit l'épreuve associée au formulaire.
     *
     * @param epreuve l'épreuve
     */
    public void setEpreuve(Epreuve epreuve) {
        this.epreuve = epreuve;
    }

    /**
     * Retourne la liste des étudiants impliqués.
     *
     * @return la liste des étudiants
     */
    public List<Etudiant> getEtudiants() {
        return etudiants;
    }

    /**
     * Définit la liste des étudiants impliqués.
     *
     * @param etudiants la liste des étudiants
     */
    public void setEtudiants(List<Etudiant> etudiants) {
        this.etudiants = etudiants;
    }

    /**
     * Retourne la liste des fraudes constatées.
     *
     * @return la liste des fraudes
     */
    public List<Fraude> getFraudes() {
        return fraudes;
    }

    /**
     * Définit la liste des fraudes constatées.
     *
     * @param fraudes la liste des fraudes
     */
    public void setFraudes(List<Fraude> fraudes) {
        this.fraudes = fraudes;
    }

    // -------------------------------------------------------------------------
    // Méthodes
    // -------------------------------------------------------------------------

    /**
     * Ajoute un étudiant au formulaire et met à jour la date de modification.
     *
     * @param etudiant l'étudiant à ajouter
     */
    public void ajouterEtudiant(Etudiant etudiant) {
        if (etudiant != null && !etudiants.contains(etudiant)) {
            etudiants.add(etudiant);
            this.dateModification = LocalDate.now();
        }
    }

    /**
     * Ajoute une fraude au formulaire et met à jour la date de modification.
     *
     * @param fraude la fraude à ajouter
     */
    public void ajouterFraude(Fraude fraude) {
        if (fraude != null) {
            fraudes.add(fraude);
            this.dateModification = LocalDate.now();
        }
    }

    /**
     * Réinitialise le compteur d'identifiants (utile pour les tests).
     */
    public static void reinitialiserCompteur() {
        compteurId = 1;
    }

    /**
     * Retourne le compteur actuel d'identifiants.
     *
     * @return le compteur
     */
    public static int getCompteurId() {
        return compteurId;
    }

    /**
     * Retourne une représentation textuelle du formulaire.
     *
     * @return la représentation textuelle
     */
    @Override
    public String toString() {
        return "Formulaire{"
                + "id=" + id
                + ", dateCreation=" + dateCreation
                + ", dateModification=" + dateModification
                + ", epreuve=" + (epreuve != null ? epreuve.getEcue() : "N/A")
                + ", nbEtudiants=" + etudiants.size()
                + ", nbFraudes=" + fraudes.size()
                + '}';
    }
}
