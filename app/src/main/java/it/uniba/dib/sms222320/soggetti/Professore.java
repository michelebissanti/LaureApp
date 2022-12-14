package it.uniba.dib.sms222320.soggetti;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import it.uniba.dib.sms222320.eccezioni.EccezioniPersonalizzate;

public class Professore extends AbstractPersona{
    //ESPRESSIONI REGOLARI
    /**
     * Costante REGEX_MATRICOLA relativa all'espressione regolare per il controllo delLa matricola di un professore
     */
    private static final String REGEX_MATRICOLA = "^[0-9]{6}$";
    /**
     * Costante REGEX_CORSO_LAUREA relativa all'espressione regolare per il controllo dei corsi di laurea di un professore
     */
    private static final String REGEX_CORSO_LAUREA = "^[a-zA-Z\\s]+$";
    /**
     * Costante REGEX_MATERIA relativa all'espressione regolare per il controllo delle materie insegnate da un professore
     */
    private static final String REGEX_MATERIA = "^[a-zA-Z0-9\\s]+$";


    //VARIABILI
    /**
     * Variabile matricola relativa alla matricola di uno studente
     */
    private String matricola = null;
    /**
     * Lista corsiDiLaurea relativa ai corsi di laurea del professore
     */
    private List<String> corsiDiLaurea = null;
    /**
     * Lista materieInsegnate relativa alle materie insegnate dal professore
     */
    private List<String> materieInsegnate = null;


    //COSTRUTTORE
    /**
     * Costruttore di un professore
     *
     * @param uid chiave primaria di autenticazione della persona
     * @param nome nome della persona
     * @param cognome cognome della persona
     * @param dataNascita data di nascita della persona
     * @param citta citta della persona
     * @param residenza residenza della persona
     * @param numeroTelefono numero di telefono della persona
     * @param mail e-mail della persona
     * @param matricola matricola identificativa del professore
     * @param corsiDiLaurea corsi di laurea del professore
     * @param materieInsegnate materie insegnate dal professore
     *
     * @throws EccezioniPersonalizzate eccezioni relative all'istanziazione di una persona
     */
    public Professore(String uid, String nome, String cognome, LocalDate dataNascita, String citta, String residenza, String numeroTelefono, String mail, String matricola, List<String> corsiDiLaurea, List<String> materieInsegnate) throws EccezioniPersonalizzate {
        super(uid, nome, cognome, dataNascita, citta, residenza, numeroTelefono, mail);

        if(matricola == null || !matricola.matches(REGEX_MATRICOLA))
            throw new EccezioniPersonalizzate("Matricola non valida");

        if(corsiDiLaurea.size() != 0) {
            for (String corsoDiLaurea: corsiDiLaurea) {
                if(corsoDiLaurea == null || !corsoDiLaurea.matches(REGEX_CORSO_LAUREA))
                    throw new EccezioniPersonalizzate("Corso di laurea non valido");
            }
        }

        if(materieInsegnate.size() != 0) {
            for (String materiaInsegnata: materieInsegnate) {
                if(materiaInsegnata == null || !materiaInsegnata.matches(REGEX_MATERIA))
                    throw new EccezioniPersonalizzate("Materia non valida");
            }
        }

        this.matricola = matricola;
        this.corsiDiLaurea = corsiDiLaurea;
        this.materieInsegnate = materieInsegnate;
    }

    //costruttore con tutto tranne corsi di laure e materie
    public Professore(String uid, String nome, String cognome, LocalDate dataNascita, String citta, String residenza, String numeroTelefono, String mail, String matricola) throws EccezioniPersonalizzate {
        super(uid, nome, cognome, dataNascita, citta, residenza, numeroTelefono, mail);

        if(matricola == null || !matricola.matches(REGEX_MATRICOLA))
            throw new EccezioniPersonalizzate("Matricola non valida");

        this.matricola = matricola;
    }

    //GETTER E SETTER
    /**
     * Metodo getRegexMatricola per la restituzione dell'espressione regolare relativa alla matricola di uno studente
     *
     * @return REGEX_MATRICOLA dello studente
     */
    public String getRegexMatricola() { return REGEX_MATRICOLA; }

    /**
     * Metodo getRegexCorsoLaurea per la restituzione dell'espressione regolare relativa ai corsi di laurea di un professore
     *
     * @return REGEX_CORSO_LAUREA del professore
     */
    public String getRegexCorsoLaurea() { return REGEX_CORSO_LAUREA; }

    /**
     * Metodo getRegexMateria per la restituzione dell'espressione regolare relativa alle materie di un professore
     *
     * @return REGEX_MATERIA del professore
     */
    public String getRegexMateria() { return REGEX_MATERIA; }

    /**
     * Metodo getMatricola per la restituzione della matricola di un professore
     *
     * @return matricola del professore
     */
    public String getMatricola() {
        return matricola;
    }

    /**
     * Metodo getCorsiDiLaurea per la restituzione dei corsi di laurea di un professore
     *
     * @return corsiDiLaurea del professore
     */
    public List<String> getCorsiDiLaurea() {
        return corsiDiLaurea;
    }

    /**
     * Metodo setCorsiDiLaurea per l'impostazione dei corsi di laurea di un professore
     *
     * @param corsiDiLaurea corsi di laurea di un professore
     */
    public void setCorsiDiLaurea(List<String> corsiDiLaurea) {
        this.corsiDiLaurea = corsiDiLaurea;
    }

    /**
     * Metodo getMaterieInsegnate per la restituzione delle materie insegnate da un professore
     *
     * @return materieInsegnate dal professore
     */
    public List<String> getMaterieInsegnate() {
        return materieInsegnate;
    }

    /**
     * Metodo setMaterieInsegnate per l'impostazione delle materie insegnate da un professore
     *
     * @param materieInsegnate materie insegnate da un professore
     */
    public void setMaterieInsegnate(List<String> materieInsegnate) {
        this.materieInsegnate = materieInsegnate;
    }


    //TO STRING
    /**
     * Metodo toString per la visualizzazione delle informazioni relative ad un professore
     *
     * @return stringa contenente le informazioni di un professore
     */
    @Override
    public String toString() {
        return "Professore [" + super.toString() + " matricola=" + matricola + " corsiDiLaurea=" + corsiDiLaurea + " materieInsegnate=" + materieInsegnate + "]";
    }
}
