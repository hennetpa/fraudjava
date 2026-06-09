package fr.eseo.devlogfraude.modele;

/**
 * Enumération des cursus reconnus par le système.
 *
 * @author DevLogFraude
 * @version 1.0
 */
public enum Cursus {

    /** Première année ingénieur */
    E1("E1"),

    /** Deuxième année ingénieur */
    E2("E2"),

    /** Troisième année ingénieur - filière e */
    E3E("E3e"),

    /** Troisième année ingénieur - filière a */
    E3A("E3a"),

    /** Quatrième année ingénieur */
    E4("E4"),

    /** Cinquième année ingénieur */
    E5("E5");

    /** Libellé du cursus */
    private String libelle;

    /**
     * Constructeur de l'énumération.
     *
     * @param libelle le libellé du cursus
     */
    Cursus(String libelle) {
        this.libelle = libelle;
    }

    /**
     * Retourne le libellé du cursus.
     *
     * @return le libellé
     */
    public String getLibelle() {
        return libelle;
    }

    /**
     * Recherche un cursus par son libellé (insensible à la casse).
     *
     * @param libelle le libellé à rechercher
     * @return le cursus correspondant ou null si non trouvé
     */
    public static Cursus fromLibelle(String libelle) {
        for (Cursus c : values()) {
            if (c.libelle.equalsIgnoreCase(libelle)) {
                return c;
            }
        }
        return null;
    }

    /**
     * Retourne le libellé du cursus.
     *
     * @return le libellé
     */
    @Override
    public String toString() {
        return libelle;
    }
}
