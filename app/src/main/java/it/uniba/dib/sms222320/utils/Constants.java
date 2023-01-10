package it.uniba.dib.sms222320.utils;

public class Constants {

    public static final class Regex {
        /**
         * Costante REGEX_MATRICOLA relativa all'espressione regolare per il controllo delLa matricola di uno studente
         */
        public static final String REGEX_MATRICOLA = "^[0-9]{6}$";
        /**
         * Costante REGEX_CORSO_LAUREA relativa all'espressione regolare per il controllo del corso di laurea di uno studente
         */
        public static final String REGEX_CORSO_LAUREA = "^[a-zA-Z\\s]+$";
        /**
         * Costante REGEX_ANNO_ISCRIZIONE relativa all'espressione regolare per il controllo dell'anno di iscrizione di uno studente
         */
        public static final String REGEX_ANNO_ISCRIZIONE = "^[0-9]{4}\\/[0-9]{4}$";
        /**
         * Costante REGEX_ESAME relativa all'espressione regolare per il controllo degli esami preferiti di uno studente
         */
        public static final String REGEX_ESAME = "^[a-zA-Z0-9\\s]+$";
        /**
         * Costante REGEX_MATERIA relativa all'espressione regolare per il controllo delle materie insegnate da un professore
         */
        public static final String REGEX_MATERIA = "^[a-zA-Z0-9\\s]+$";
    }
}
