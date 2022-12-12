package it.uniba.dib.sms222320.soggetti;

import java.time.LocalDate;
import java.util.Objects;
import it.uniba.dib.sms222320.eccezioni.EccezioniPersonalizzate;

public class Studente extends AbstractPersona{
    //ESPRESSIONI REGOLARI
    /**
     * Costante REGEX_MATRICOLA relativa all'espressione regolare per il controllo delLa matricola di uno studente
     */
    private static final String REGEX_MATRICOLA = "^[0-9]{6}$";
    /**
     * Costante REGEX_CORSO_LAUREA relativa all'espressione regolare per il controllo del corso di laurea di uno studente
     */
    private static final String REGEX_CORSO_LAUREA = "^[a-zA-Z\\s]+$";
    /**
     * Costante REGEX_ANNO_ISCRIZIONE relativa all'espressione regolare per il controllo dell'anno di iscrizione di uno studente
     */
    private static final String REGEX_ANNO_ISCRIZIONE = "^[0-9]{4}\\/[0-9]{4}$";


    //VARIABILI
    /**
     * Variabile matricola relativa alla matricola di uno studente
     */
    private String matricola = null;
    /**
     * Variabile corsoDiLaurea relativa al corso di laurea di uno studente
     */
    private String corsoDiLaurea = null;
    /**
     * Variabile annoIscrizione relativa all'anno di iscrizione di uno studente
     */
    private String annoIscrizione = null;
    /**
     * Variabile media relativa alla media dei voti di uno studente
     */
    private Float media = null;


    //COSTRUTTORE
    /**
     * Costruttore di uno studente
     *
     * @param codiceFiscale codice fiscale identificativo della persona
     * @param nome nome della persona
     * @param cognome cognome della persona
     * @param dataNascita data di nascita della persona
     * @param citta citta della persona
     * @param residenza residenza della persona
     * @param numeroTelefono numero di telefono della persona
     * @param mail e-mail della persona
     * @param matricola matricola identificativa dello studente
     * @param corsoDiLaurea corso di laurea dello studente
     * @param annoIscrizione anno di iscrizione dello studente
     * @param media media dei voti dello studente
     *
     * @throws EccezioniPersonalizzate eccezioni relative all'istanziazione di una persona
     */
    public Studente(String codiceFiscale, String nome, String cognome, LocalDate dataNascita, String citta, String residenza, String numeroTelefono, String mail, String matricola, String corsoDiLaurea, String annoIscrizione, Float media) throws EccezioniPersonalizzate {
        super(codiceFiscale, nome, cognome, dataNascita, citta, residenza, numeroTelefono, mail);

        if(matricola == null || !matricola.matches(REGEX_MATRICOLA))
            throw new EccezioniPersonalizzate("Matricola non valida");

        if(corsoDiLaurea == null || !corsoDiLaurea.matches(REGEX_CORSO_LAUREA))
            throw new EccezioniPersonalizzate("Corso di laurea non valido");

        if(annoIscrizione == null || !annoIscrizione.matches(REGEX_ANNO_ISCRIZIONE))
            throw new EccezioniPersonalizzate("Anno iscrizione non valido");

        if(media == null || media < 18 || media > 30)
            throw new EccezioniPersonalizzate("Media non valida");

        this.matricola = matricola;
        this.corsoDiLaurea = stringaSettata(corsoDiLaurea);
        this.annoIscrizione = annoIscrizione;
        this.media = media;
    }

    //GETTER E SETTER
    /**
     * Metodo getRegexMatricola per la restituzione dell'espressione regolare relativa alla matricola di uno studente
     *
     * @return REGEX_MATRICOLA dello studente
     */
    public String getRegexMatricola() { return REGEX_MATRICOLA; }

    /**
     * Metodo getRegexCorsoLaurea per la restituzione dell'espressione regolare relativa al corso di laurea di uno studente
     *
     * @return REGEX_CORSO_LAUREA dello studente
     */
    public String getRegexCorsoLaurea() { return REGEX_CORSO_LAUREA; }

    /**
     * Metodo getRegexAnnoIscrizione per la restituzione dell'espressione regolare relativa all'anno di iscrizione di uno studente
     *
     * @return REGEX_CORSO_LAUREA dello studente
     */
    public String getRegexAnnoIscrizione() { return REGEX_CORSO_LAUREA; }

    /**
     * Metodo getMatricola per la restituzione della matricola di uno studente
     *
     * @return matricola dello studente
     */
    public String getMatricola() {
        return matricola;
    }

    /**
     * Metodo getCorsoDiLaurea per la restituzione del corso di laurea di uno studente
     *
     * @return corsoDiLaurea dello studente
     */
    public String getCorsoDiLaurea() {
        return corsoDiLaurea;
    }

    /**
     * Metodo setCorsoDiLaurea per l'impostazione del corso di laurea di uno studente
     *
     * @param corsoDiLaurea corso di laurea di uno studente
     */
    public void setCorsoDiLaurea(String corsoDiLaurea) {
        this.corsoDiLaurea = corsoDiLaurea;
    }

    /**
     * Metodo getAnnoIscrizione per la restituzione dell'anno di iscrizione di uno studente
     *
     * @return annoIscrizione dello studente
     */
    public String getAnnoIscrizione() {
        return annoIscrizione;
    }

    /**
     * Metodo setAnnoIscrizione per l'impostazione dell'anno di iscrizione di uno studente
     *
     * @param annoIscrizione anno di iscrizione di uno studente
     */
    public void setAnnoIscrizione(String annoIscrizione) {
        this.annoIscrizione = annoIscrizione;
    }

    /**
     * Metodo getMedia per la restituzione della media dei voti di uno studente
     *
     * @return media dello studente
     */
    public Float getMedia() {
        return media;
    }

    /**
     * Metodo setMedia per l'impostazione della media dei voti di uno studente
     *
     * @param media media dei voti di uno studente
     */
    public void setMedia(Float media) {
        this.media = media;
    }

    //TO STRING
    /**
     * Metodo toString per la visualizzazione delle informazioni relative ad uno studente
     *
     * @return stringa contenente le informazioni di uno studente
     */
    @Override
    public String toString() {
        return "Studente [" + "matricola=" + matricola + super.toString() + " corsoDiLaurea=" + corsoDiLaurea + " annoIscrizione=" + annoIscrizione + " media=" + media + "]";
    }
}
