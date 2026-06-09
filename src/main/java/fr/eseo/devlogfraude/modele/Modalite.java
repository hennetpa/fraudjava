package fr.eseo.devlogfraude.modele;

/**
 * Enumération des modalités d'épreuve possibles.
 *
 * @author DevLogFraude
 * @version 1.0
 */
public enum Modalite {

    /** Examen sous forme écrite */
    EXAMEN_ECRIT("Examen écrit"),

    /** Examen sous forme orale */
    ORAL("Oral"),

    /** Questionnaire à choix multiples */
    QCM("QCM"),

    /** Examen sur ordinateur */
    SUR_ORDINATEUR("Sur ordinateur"),

    /** Évaluation de projet */
    PROJET("Projet"),

    /** Travaux pratiques */
    TP("TP");

    /** Libellé affiché de la modalité */
    private String libelle;

    /**
     * Constructeur de l'énumération.
     *
     * @param libelle le libellé affiché
     */
    Modalite(String libelle) {
        this.libelle = libelle;
    }

    /**
     * Retourne le libellé de la modalité.
     *
     * @return le libellé
     */
    public String getLibelle() {
        return libelle;
    }

    /**
     * Retourne le libellé de la modalité.
     *
     * @return le libellé
     */
    @Override
    public String toString() {
        return libelle;
    }
}
