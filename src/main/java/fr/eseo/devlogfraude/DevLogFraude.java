package fr.eseo.devlogfraude;

import fr.eseo.devlogfraude.gestion.GestionFormulaires;
import fr.eseo.devlogfraude.menu.Menu;
import fr.eseo.devlogfraude.modele.*;
import fr.eseo.devlogfraude.modele.fraude.*;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe principale de l'application DevLogFraude.
 * Initialise les données de test et lance le menu principal.
 *
 * @author DevLogFraude
 * @version 1.0
 */
public class DevLogFraude {
    Epreuve epreuve1 = new Epreuve(
            "INFO-301",
            LocalDate.of(2026, 5, 15),
            LocalTime.of(8, 0),
            Duration.ofHours(2),
            "E3e",
            Modalite.EXAMEN_ECRIT
    );
}
