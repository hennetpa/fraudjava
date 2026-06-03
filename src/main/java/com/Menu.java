import java.util.*;
import fr.eseo.devlogfraude.gestion.GestionFormulaires;

public class Menu {
    /** Scanner pour la lecture des saisies utilisateur */
    private Scanner scanner;

    /** Gestionnaire de formulaires */
    private GestionFormulaires gestionFormulaires;
}
    public Menu() {
        this.scanner = new Scanner(System.in);
        this.gestionFormulaires = new GestionFormulaires();
    }
    public void afficherMenuPrincipal() {
        boolean continuer = true;
        while (continuer) {
            System.out.println("\n--- Menu Principal ---");
            System.out.println("1. Ajouter un formulaire de fraude");
            System.out.println("2. Retirer un formulaire");
            System.out.println("3. Lister les formulaires");
            System.out.println("4. Quitter");
            System.out.print("Choisissez une option (1-4) : ");
//scanf
            int choix = lireChoix(1, 4);
            switch (choix) {
                case 1:
                    ajouterFormulaire();
                    break;
                case 2:
                    retirerFormulaire();
                    break;
                case 3:
                    listerFormulaires();
                    break;
                case 4:
                    continuer = false;
                    System.out.println("Au revoir !");
                    break;
            }
        }

    }
public int lireChoix(int min, int max) {
    while (true) {
        try {
            int choix = Integer.parseInt(scanner.nextLine());
            if (choix >= min && choix <= max) {
                return choix;
            } else {
                System.out.printf("Veuillez entrer un chiffre entre %d et %d.\n", min, max);
            }
        } catch (NumberFormatException e) {
            System.out.println("Saisie invalide. Veuillez entrer un chiffre.");
        }

        }
    }

private void ajouterFormulaire() {
    // Étape 1: Sélection de l'épreuve
    System.out.println("\n--- Ajout d'un formulaire ---");
    System.out.print("Nom de l'épreuve : ");
    String nomEpreuve = scanner.nextLine();
    System.out.print("Date de l'épreuve : ");
    String dateEpreuve = scanner.nextLine();
    System.out.print("Durée de l'épreuve : ");
    String dureeEpreuve = scanner.nextLine();
    System.out.print("Nom de l'ECUE de l'épreuve : ");
    String ecueEpreuve = scanner.nextLine();
    System.out.print("Modalite de l'épreuve : ");
    String modaliteEpreuve = scanner.nextLine();
    Epreuve epreuve = new.Epreuve(nomEpreuve,dateEpreuve,dureeEpreuve,ecueEpreuve,modaliteEpreuve);

    // Étape 2: Saisie des étudiants
    List<Etudiant> etudiants = new ArrayList<>();
    while (true) {
        System.out.println("\nAjouter un étudiant (ou 'fin' pour terminer) :");
        System.out.print("Nom : ");
        String nom = scanner.nextLine();
        if (nom.equalsIgnoreCase("fin")) break;

        System.out.print("Prénom : ");
        String prenom = scanner.nextLine();
        System.out.print("Numéro apprenant : ");
        String numero = scanner.nextLine();
        System.out.print("Cursus : ");
        String cursus = scanner.nextLine();

        etudiants.add(new Etudiant(nom, prenom, numero, cursus));
    }

    // Étape 3: Saisie des fraudes
        }
        System.out.println("\n--- Menu Principal ---");
        System.out.println("1. Fraud Calculatrice");
        System.out.println("2. Fraud IAG");
        System.out.println("3. Fraud IAGconnecter");
        System.out.println("4. Fraud Papier");
        System.out.print("Choisissez une option (1-4) : ");
//scanf
        int choix = menu.lireChoix(1, 4);
        switch (choix) {
            case 1:
                fraud.ajouterFraudCalculatrice();
                break;
            case 2:
                fraud.ajouterFraudIag();
                break;
            case 3:
                fraud.ajouterFraudIagConnecter();
                break;
            case 4:
                fraud.ajouterFraudPapier();
                break;
            }
         Formulaire.setId(lenght(<Formulaire>+1))

        // Ajouter d'autres attributs selon le type


    // Enregistrement du formulaire
    Formulaire formulaire = new Formulaire(epreuve, etudiants, fraudes );
    gestionFormulaires.ajouterFormulaire(formulaire);
    System.out.println("Formulaire ajouté avec succès ! ID : " + formulaire.getId());
}

private void retirerFormulaire() {
    listerFormulaires();
    if (gestionFormulaires.getTousLesFormulaires().isEmpty()) {
        System.out.println("Aucun formulaire à retirer.");
        return;
    }
    System.out.print("Entrez l'ID du formulaire à retirer : ");
    String id = scanner.nextLine();
    if (gestionFormulaires.retirerFormulaire(id)) {
        System.out.println("Formulaire retiré avec succès.");
    } else {
        System.out.println("ID inconnu. Aucun formulaire retiré.");
    }
}

private void listerFormulaires() {
    List<Formulaire> formulaires = gestionFormulaires.getTousLesFormulaires();
    if (formulaires.isEmpty()) {
        System.out.println("Aucun formulaire enregistré.");
        return;
    }
    System.out.println("\n--- Liste des formulaires ---");
    for (Formulaire f : formulaires) {
        System.out.println(f);
        System.out.println("-----------------------------");
    }
}
}