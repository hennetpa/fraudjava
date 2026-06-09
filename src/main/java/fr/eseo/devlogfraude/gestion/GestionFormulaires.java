package fr.eseo.devlogfraude.gestion;

import fr.eseo.devlogfraude.modele.Epreuve;
import fr.eseo.devlogfraude.modele.Etudiant;
import fr.eseo.devlogfraude.modele.Formulaire;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Classe de gestion des formulaires de fraude.
 * Assure la création, la suppression, la recherche et la liste
 * de l'ensemble des formulaires du système.
 *
 * @author DevLogFraude
 * @version 1.0
 */
public class GestionFormulaires {

    /** Liste de tous les formulaires enregistrés */
    private List<Formulaire> formulaires;

    /** Liste de toutes les épreuves disponibles */
    private List<Epreuve> epreuves;

    // -------------------------------------------------------------------------
    // Constructeurs
    // -------------------------------------------------------------------------

    /**
     * Constructeur par défaut.
     */
    public GestionFormulaires() {
        this.formulaires = new ArrayList<>();
        this.epreuves = new ArrayList<>();
    }

    /**
     * Constructeur initialisant les listes de formulaires et d'épreuves.
     *
     * @param formulaires liste de formulaires initiale
     * @param epreuves    liste d'épreuves disponibles
     */
    public GestionFormulaires(List<Formulaire> formulaires, List<Epreuve> epreuves) {
        this.formulaires = formulaires != null ? new ArrayList<>(formulaires) : new ArrayList<>();
        this.epreuves = epreuves != null ? new ArrayList<>(epreuves) : new ArrayList<>();
    }

    // -------------------------------------------------------------------------
    // Getters et Setters
    // -------------------------------------------------------------------------

    /**
     * Retourne la liste de tous les formulaires.
     *
     * @return la liste des formulaires
     */
    public List<Formulaire> getFormulaires() {
        return formulaires;
    }

    /**
     * Définit la liste des formulaires.
     *
     * @param formulaires la liste des formulaires
     */
    public void setFormulaires(List<Formulaire> formulaires) {
        this.formulaires = formulaires;
    }

    /**
     * Retourne la liste des épreuves disponibles.
     *
     * @return la liste des épreuves
     */
    public List<Epreuve> getEpreuves() {
        return epreuves;
    }

    /**
     * Définit la liste des épreuves disponibles.
     *
     * @param epreuves la liste des épreuves
     */
    public void setEpreuves(List<Epreuve> epreuves) {
        this.epreuves = epreuves;
    }

    // -------------------------------------------------------------------------
    // Méthodes de gestion des formulaires
    // -------------------------------------------------------------------------

    /**
     * Crée et enregistre un nouveau formulaire.
     *
     * @param formulaire le formulaire à enregistrer
     */
    public void creationFormulaire(Formulaire formulaire) {
        if (formulaire != null) {
            formulaires.add(formulaire);
        }
    }

    /**
     * Retire un formulaire du système par son identifiant.
     *
     * @param id l'identifiant du formulaire à retirer
     * @return true si le formulaire a été retiré, false si non trouvé
     */
    public boolean retirerFormulaire(int id) {
        return formulaires.removeIf(f -> f.getId() == id);
    }

    /**
     * Retourne la liste de tous les formulaires (affichage).
     *
     * @return la liste des formulaires
     */
    public List<Formulaire> listerFormulaires() {
        return new ArrayList<>(formulaires);
    }

    /**
     * Recherche un formulaire par son identifiant.
     *
     * @param id l'identifiant recherché
     * @return le formulaire correspondant ou null si non trouvé
     */
    public Formulaire rechercherParId(int id) {
        return formulaires.stream()
                .filter(f -> f.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // -------------------------------------------------------------------------
    // Méthodes de recherche
    // -------------------------------------------------------------------------

    /**
     * Recherche tous les formulaires impliquant un étudiant donné.
     *
     * @param idApprenant l'identifiant de l'apprenant
     * @return la liste des formulaires impliquant cet étudiant
     */
    public List<Formulaire> rechercherParEtudiant(int idApprenant) {
        return formulaires.stream()
                .filter(f -> f.getEtudiants().stream()
                        .anyMatch(e -> e.getIdApprenant() == idApprenant))
                .collect(Collectors.toList());
    }

    /**
     * Recherche tous les formulaires concernant une épreuve donnée.
     *
     * @param ecue le code ECUE de l'épreuve
     * @return la liste des formulaires concernant cette épreuve
     */
    public List<Formulaire> rechercherParEpreuve(String ecue) {
        return formulaires.stream()
                .filter(f -> f.getEpreuve() != null
                        && f.getEpreuve().getEcue().equalsIgnoreCase(ecue))
                .collect(Collectors.toList());
    }

    /**
     * Retourne la liste de toutes les épreuves disponibles.
     *
     * @return la liste des épreuves
     */
    public List<Epreuve> listerEpreuves() {
        return new ArrayList<>(epreuves);
    }

    /**
     * Ajoute une épreuve à la liste des épreuves disponibles.
     *
     * @param epreuve l'épreuve à ajouter
     */
    public void ajouterEpreuve(Epreuve epreuve) {
        if (epreuve != null) {
            epreuves.add(epreuve);
        }
    }
}
