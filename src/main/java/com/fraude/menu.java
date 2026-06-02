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
                System.out.printf("Veuillez entrer un nombre entre %d et %d.\n", min, max);
            }
        } catch (NumberFormatException e) {
            System.out.println("Saisie invalide. Veuillez entrer un nombre.");
        }

        }
    }

