package fr.eseo.devlogfraude.modele;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Duration;

/**
 * Représente une épreuve dans le système de gestion des fraudes.
 * Une épreuve est identifiée par un code ECUE et possède une date,
 * une heure, une durée, un cursus et une modalité.
 *
 * @author DevLogFraude
 * @version 1.0
 */
public class Epreuve {

    /** Code ECUE identifiant l'épreuve */
    private String ecue;

    /** Date de passage de l'épreuve */
    private LocalDate date;

    /** Heure de début de l'épreuve */
    private LocalTime heure;

    /** Durée de l'épreuve */
    private Duration duree;

    /** Cursus concerné par l'épreuve */
    private String cursus;

    /** Modalité de l'épreuve */
    private Modalite modalite;

    // -------------------------------------------------------------------------
    // Constructeurs
    // -------------------------------------------------------------------------

    /**
     * Constructeur par défaut.
     */
    public Epreuve() {
        this.ecue = "";
        this.date = LocalDate.now();
        this.heure = LocalTime.now();
        this.duree = Duration.ZERO;
        this.cursus = "";
        this.modalite = Modalite.EXAMEN_ECRIT;
    }

    /**
     * Constructeur initialisant l'ensemble des attributs.
     *
     * @param ecue     code ECUE de l'épreuve
     * @param date     date de l'épreuve
     * @param heure    heure de début
     * @param duree    durée de l'épreuve
     * @param cursus   cursus concerné
     * @param modalite modalité de l'épreuve
     */
    public Epreuve(String ecue, LocalDate date, LocalTime heure, Duration duree,
                   String cursus, Modalite modalite) {
        this.ecue = ecue;
        this.date = date;
        this.heure = heure;
        this.duree = duree;
        this.cursus = cursus;
        this.modalite = modalite;
    }

    // -------------------------------------------------------------------------
    // Getters et Setters
    // -------------------------------------------------------------------------

    /**
     * Retourne le code ECUE.
     *
     * @return le code ECUE
     */
    public String getEcue() {
        return ecue;
    }

    /**
     * Définit le code ECUE.
     *
     * @param ecue le code ECUE
     */
    public void setEcue(String ecue) {
        this.ecue = ecue;
    }

    /**
     * Retourne la date de l'épreuve.
     *
     * @return la date
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * Définit la date de l'épreuve.
     *
     * @param date la date
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }

    /**
     * Retourne l'heure de début de l'épreuve.
     *
     * @return l'heure de début
     */
    public LocalTime getHeure() {
        return heure;
    }

    /**
     * Définit l'heure de début de l'épreuve.
     *
     * @param heure l'heure de début
     */
    public void setHeure(LocalTime heure) {
        this.heure = heure;
    }

    /**
     * Retourne la durée de l'épreuve.
     *
     * @return la durée
     */
    public Duration getDuree() {
        return duree;
    }

    /**
     * Définit la durée de l'épreuve.
     *
     * @param duree la durée
     */
    public void setDuree(Duration duree) {
        this.duree = duree;
    }

    /**
     * Retourne le cursus concerné.
     *
     * @return le cursus
     */
    public String getCursus() {
        return cursus;
    }

    /**
     * Définit le cursus concerné.
     *
     * @param cursus le cursus
     */
    public void setCursus(String cursus) {
        this.cursus = cursus;
    }

    /**
     * Retourne la modalité de l'épreuve.
     *
     * @return la modalité
     */
    public Modalite getModalite() {
        return modalite;
    }

    /**
     * Définit la modalité de l'épreuve.
     *
     * @param modalite la modalité
     */
    public void setModalite(Modalite modalite) {
        this.modalite = modalite;
    }

    // -------------------------------------------------------------------------
    // Méthodes
    // -------------------------------------------------------------------------

    /**
     * Retourne une représentation textuelle de l'épreuve.
     *
     * @return la représentation textuelle
     */
    @Override
    public String toString() {
        return "Epreuve{"
                + "ecue='" + ecue + '\''
                + ", date=" + date
                + ", heure=" + heure
                + ", duree=" + duree.toMinutes() + "min"
                + ", cursus='" + cursus + '\''
                + ", modalite=" + modalite
                + '}';
    }
}
