package fr.eseo.devlogfraude.menu;

import fr.eseo.devlogfraude.gestion.GestionFormulaires;
import fr.eseo.devlogfraude.modele.*;
import fr.eseo.devlogfraude.modele.fraude.*;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Classe Menu : interface utilisateur textuelle de l'application.
 * Présente un menu principal numéroté et guide l'utilisateur
 * dans toutes les actions disponibles.
 *
 * @author DevLogFraude
 * @version 1.0
 */
public class Menu {

    /** Scanner pour la lecture des saisies utilisateur */
    private Scanner scanner;

    /** Gestionnaire de formulaires */
    private GestionFormulaires gestionFormulaires;

    // -------------------------------------------------------------------------
    // Constructeurs
    // -------------------------------------------------------------------------

    /**
     * Constructeur par défaut.
     */
    public Menu() {
        this.scanner = new Scanner(System.in);
        this.gestionFormulaires = new GestionFormulaires();
    }

    /**
     * Constructeur initialisant le scanner et le gestionnaire.
     *
     * @param scanner            le scanner d'entrée
     * @param gestionFormulaires le gestionnaire de formulaires
     */
    public Menu(Scanner scanner, GestionFormulaires gestionFormulaires) {
        this.scanner = scanner;
        this.gestionFormulaires = gestionFormulaires;
    }

    // -------------------------------------------------------------------------
    // Getters et Setters
    // -------------------------------------------------------------------------

    /**
     * Retourne le scanner utilisé.
     *
     * @return le scanner
     */
    public Scanner getScanner() {
        return scanner;
    }

    /**
     * Définit le scanner.
     *
     * @param scanner le scanner
     */
    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    /**
     * Retourne le gestionnaire de formulaires.
     *
     * @return le gestionnaire de formulaires
     */
    public GestionFormulaires getGestionFormulaires() {
        return gestionFormulaires;
    }

    /**
     * Définit le gestionnaire de formulaires.
     *
     * @param gestionFormulaires le gestionnaire de formulaires
     */
    public void setGestionFormulaires(GestionFormulaires gestionFormulaires) {
        this.gestionFormulaires = gestionFormulaires;
    }

    // -------------------------------------------------------------------------
    // Méthodes d'affichage du menu
    // -------------------------------------------------------------------------

    /**
     * Affiche le menu principal et exécute la boucle principale de l'application.
     */
    public void afficherMenuPrincipal() {
        boolean continuer = true;

        while (continuer) {
            System.out.println();
            System.out.println("     DevLogFraude - Menu Principal  ");
            System.out.println("  1. Ajouter un formulaire            ");
            System.out.println("  2. Retirer un formulaire            ");
            System.out.println("  3. Lister les formulaires           ");
            System.out.println("  4. Rechercher par étudiant (ID)     ");
            System.out.println("  5. Rechercher par épreuve (ECUE)    ");
            System.out.println("  6. Quitter                          ");
            System.out.print("Votre choix : ");

            int choix = lireChoix(1, 6);

            switch (choix) {
                case 1 -> ajouterFormulaire();
                case 2 -> retirerFormulaire();
                case 3 -> listerFormulaires();
                case 4 -> rechercherParEtudiant();
                case 5 -> rechercherParEpreuve();
                case 6 -> {
                    System.out.println("Au revoir !");
                    continuer = false;
                }
                default -> System.out.println("[Erreur] Choix invalide.");
            }
        }
    }

    /**
     * Lit un entier saisi par l'utilisateur compris entre min et max inclus.
     * En cas de saisie invalide, affiche un message d'erreur et redemande.
     *
     * @param min valeur minimale acceptée
     * @param max valeur maximale acceptée
     * @return l'entier saisi compris entre min et max
     */
    public int lireChoix(int min, int max) {
        while (true) {
            try {
                String ligne = scanner.nextLine().trim();
                int valeur = Integer.parseInt(ligne);
                if (valeur >= min && valeur <= max) {
                    return valeur;
                }
                System.out.printf("[Erreur] Veuillez saisir un entier entre %d et %d : ", min, max);
            } catch (NumberFormatException e) {
                System.out.printf("[Erreur] Saisie invalide. Veuillez saisir un entier entre %d et %d : ",
                        min, max);
            }
        }
    }

    // -------------------------------------------------------------------------
    // Actions du menu
    // -------------------------------------------------------------------------

    /**
     * Gère l'ajout d'un formulaire en trois étapes :
     * sélection de l'épreuve, saisie des étudiants, enregistrement des fraudes.
     */
    private void ajouterFormulaire() {
        System.out.println("\n--- Ajout d'un formulaire ---");

        // Étape 1 : sélection de l'épreuve
        List<Epreuve> epreuves = gestionFormulaires.listerEpreuves();
        if (epreuves.isEmpty()) {
            System.out.println("[Erreur] Aucune épreuve disponible.");
            return;
        }

        System.out.println("Épreuves disponibles :");
        for (int i = 0; i < epreuves.size(); i++) {
            System.out.printf("  %d. %s - %s (%s)%n",
                    i + 1,
                    epreuves.get(i).getEcue(),
                    epreuves.get(i).getDate(),
                    epreuves.get(i).getModalite());
        }
        System.out.print("Sélectionnez une épreuve (numéro) : ");
        int indexEpreuve = lireChoix(1, epreuves.size()) - 1;
        Epreuve epreuve = epreuves.get(indexEpreuve);

        // Étape 2 : saisie des étudiants
        List<Etudiant> etudiants = new ArrayList<>();
        boolean ajouterEtudiant = true;
        while (ajouterEtudiant) {
            System.out.println("\n  -- Saisie d'un étudiant --");
            Etudiant etudiant = saisirEtudiant();
            etudiants.add(etudiant);
            System.out.print("  Ajouter un autre étudiant ? (1=Oui, 0=Non) : ");
            ajouterEtudiant = lireChoix(0, 1) == 1;
        }

        // Étape 3 : enregistrement des fraudes
        Formulaire formulaire = new Formulaire(epreuve, etudiants, new ArrayList<>());
        boolean ajouterFraude = true;
        while (ajouterFraude) {
            System.out.println("\n  -- Saisie d'une fraude --");
            Fraude fraude = saisirFraude();
            if (fraude != null) {
                formulaire.ajouterFraude(fraude);
            }
            System.out.print("  Ajouter une autre fraude ? (1=Oui, 0=Non) : ");
            ajouterFraude = lireChoix(0, 1) == 1;
        }

        gestionFormulaires.creationFormulaire(formulaire);
        System.out.println("[OK] Formulaire n°" + formulaire.getId() + " créé avec succès.");
    }

    /**
     * Gère le retrait d'un formulaire par son identifiant.
     */
    private void retirerFormulaire() {
        System.out.println("\n--- Retrait d'un formulaire ---");
        listerFormulaires();

        System.out.print("Identifiant du formulaire à retirer : ");
        try {
            int id = Integer.parseInt(scanner.nextLine().trim());
            boolean retire = gestionFormulaires.retirerFormulaire(id);
            if (retire) {
                System.out.println("[OK] Formulaire n°" + id + " retiré.");
            } else {
                System.out.println("[Erreur] Identifiant inconnu : " + id);
            }
        } catch (NumberFormatException e) {
            System.out.println("[Erreur] Saisie invalide.");
        }
    }

    /**
     * Affiche la liste de tous les formulaires enregistrés.
     */
    private void listerFormulaires() {
        System.out.println("\n--- Liste des formulaires ---");
        List<Formulaire> liste = gestionFormulaires.listerFormulaires();
        if (liste.isEmpty()) {
            System.out.println("(aucun formulaire enregistré)");
        } else {
            liste.forEach(f -> System.out.printf(
                    "  #%-3d | ECUE: %-10s | Créé: %s | Étudiants: %d | Fraudes: %d%n",
                    f.getId(),
                    f.getEpreuve() != null ? f.getEpreuve().getEcue() : "N/A",
                    f.getDateCreation(),
                    f.getEtudiants().size(),
                    f.getFraudes().size()));
        }
    }

    /**
     * Recherche les formulaires impliquant un étudiant par son identifiant.
     */
    private void rechercherParEtudiant() {
        System.out.println("\n--- Recherche par étudiant ---");
        System.out.print("Numéro apprenant : ");
        try {
            int id = Integer.parseInt(scanner.nextLine().trim());
            List<Formulaire> resultats = gestionFormulaires.rechercherParEtudiant(id);
            afficherResultatsFormulaires(resultats);
        } catch (NumberFormatException e) {
            System.out.println("[Erreur] Saisie invalide.");
        }
    }

    /**
     * Recherche les formulaires concernant une épreuve par son code ECUE.
     */
    private void rechercherParEpreuve() {
        System.out.println("\n--- Recherche par épreuve ---");
        System.out.print("Code ECUE : ");
        String ecue = scanner.nextLine().trim();
        List<Formulaire> resultats = gestionFormulaires.rechercherParEpreuve(ecue);
        afficherResultatsFormulaires(resultats);
    }

    /**
    // -------------------------------------------------------------------------
    // Méthodes de saisie
    // -------------------------------------------------------------------------

    /**
     * Guide la saisie d'un étudiant et retourne l'objet créé.
     *
     * @return l'étudiant saisi
     */
    private Etudiant saisirEtudiant() {
        System.out.print("    Nom : ");
        String nom = scanner.nextLine().trim();

        System.out.print("    Prénom : ");
        String prenom = scanner.nextLine().trim();

        int idApprenant = 0;
        while (idApprenant <= 0) {
            System.out.print("    Numéro apprenant : ");
            try {
                idApprenant = Integer.parseInt(scanner.nextLine().trim());
                if (idApprenant <= 0) System.out.println("    [Erreur] Le numéro doit être positif.");
            } catch (NumberFormatException e) {
                System.out.println("    [Erreur] Saisie invalide.");
            }
        }

        Cursus cursus = null;
        while (cursus == null) {
            System.out.print("    Cursus (E1/E2/E3e/E3a/E4/E5) : ");
            String saisie = scanner.nextLine().trim();
            cursus = Cursus.fromLibelle(saisie);
            if (cursus == null) System.out.println("    [Erreur] Cursus invalide.");
        }

        return new Etudiant(idApprenant, nom, prenom, cursus);
    }

    /**
     * Guide la saisie d'une fraude et retourne l'objet créé.
     *
     * @return la fraude saisie, ou null en cas d'erreur
     */
    private Fraude saisirFraude() {
        System.out.println("    Type de fraude :");
        System.out.println("      1. IAG");
        System.out.println("      2. IAG Connectée");
        System.out.println("      3. Papier");
        System.out.println("      4. Calculatrice");
        System.out.print("    Choix : ");
        int type = lireChoix(1, 4);

        System.out.print("    Numéro apprenant concerné : ");
        int idApprenant;
        try {
            idApprenant = Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("    [Erreur] Saisie invalide.");
            return null;
        }

        System.out.print("    Nom : ");
        String nom = scanner.nextLine().trim();
        System.out.print("    Prénom : ");
        String prenom = scanner.nextLine().trim();
        System.out.print("    Cursus : ");
        String cursus = scanner.nextLine().trim();
        System.out.print("    Description : ");
        String description = scanner.nextLine().trim();

        LocalDate dateRevelation = LocalDate.now();

        return switch (type) {
            case 1 -> {
                System.out.print("    Nom du service IAG : ");
                String nomService = scanner.nextLine().trim();
                yield new FraudeIag(idApprenant, nom, prenom, cursus,
                        dateRevelation, description, nomService);
            }
            case 2 -> {
                System.out.print("    Nom du service IAG : ");
                String nomService = scanner.nextLine().trim();
                System.out.print("    Adresse IP : ");
                String ip = scanner.nextLine().trim();
                yield new FraudeIagConnectee(idApprenant, nom, prenom, cursus,
                        dateRevelation, description, nomService, ip);
            }
            case 3 -> {
                double dim = 0.0;
                while (dim <= 0) {
                    System.out.print("    Dimensions (cm²) : ");
                    try {
                        dim = Double.parseDouble(scanner.nextLine().trim());
                        if (dim <= 0) System.out.println("    [Erreur] Valeur positive requise.");
                    } catch (NumberFormatException e) {
                        System.out.println("    [Erreur] Saisie invalide.");
                    }
                }
                System.out.print("    État plié ? (1=Oui, 0=Non) : ");
                boolean plie = lireChoix(0, 1) == 1;
                yield new FraudePapier(idApprenant, nom, prenom, cursus,
                        dateRevelation, description, dim, plie);
            }
            case 4 -> {
                System.out.print("    Marque de la calculatrice : ");
                String marque = scanner.nextLine().trim();
                System.out.print("    Programme stocké : ");
                String programme = scanner.nextLine().trim();
                yield new FraudeCalculatrice(idApprenant, nom, prenom, cursus,
                        dateRevelation, description, marque, programme);
            }
            default -> null;
        };
    }

    // -------------------------------------------------------------------------
    // Méthodes d'affichage utilitaires
    // -------------------------------------------------------------------------

    /**
     * Affiche une liste de formulaires dans le terminal.
     *
     * @param formulaires la liste à afficher
     */
    private void afficherResultatsFormulaires(List<Formulaire> formulaires) {
        if (formulaires.isEmpty()) {
            System.out.println("  Aucun résultat.");
        } else {
            System.out.println("  " + formulaires.size() + " résultat(s) :");
            formulaires.forEach(f -> System.out.printf(
                    "    #%-3d | ECUE: %-10s | Créé: %s | Fraudes: %d%n",
                    f.getId(),
                    f.getEpreuve() != null ? f.getEpreuve().getEcue() : "N/A",
                    f.getDateCreation(),
                    f.getFraudes().size()));
        }
    }

    /**
     * Affiche une liste d'étudiants dans le terminal.
     *
     * @param etudiants la liste à afficher
     */
    private void afficherResultatsEtudiants(List<Etudiant> etudiants) {
        if (etudiants.isEmpty()) {
            System.out.println("  Aucun résultat.");
        } else {
            System.out.println("  " + etudiants.size() + " résultat(s) :");
            etudiants.forEach(e -> System.out.printf(
                    "    ID: %-6d | %s %s | Cursus: %s%n",
                    e.getIdApprenant(), e.getNom(), e.getPrenom(), e.getCursus()));
        }
    }
}
