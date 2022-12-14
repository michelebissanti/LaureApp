package it.uniba.dib.sms222320.soggetti;

import java.time.LocalDate;
import java.util.Objects;

import it.uniba.dib.sms222320.eccezioni.EccezioniPersonalizzate;

public class Task {
    //ESPRESSIONI REGOLARI
    /**
     * Costante REGEX_STRINGHE relativa all'espressione regolare per il controllo delle stringhe
     */
    private static final String REGEX_STRINGHE = "^[a-zA-Z\\s]+$";


    //VARIABILI
    /**
     * Variabile codice relativo al codice identificativo del task
     */
    private String codice = null;
    /**
     * Variabile tesi relativo alla tesi alla quale è associato il task
     */
    private String tesi = null;
    /**
     * Variabile studente relativo allo studente alla quale è associato il task
     */
    private String studente = null;
    /**
     * Variabile testo relativo alla descrizione del task
     */
    private String testo = null;
    /**
     * Variabile stato relativo allo stato del task
     */
    private StatoTask stato = null;
    /**
     * Variabile dataInizio relativo alla data di inizio del task
     */
    private LocalDate dataInizio = null;
    /**
     * Variabile stato relativo alla data di fine del task
     */
    private LocalDate dataFine = null;


    //COSTRUTTORE
    /**
     * Costruttore di un task
     *
     * @param codice codice identificativo di un task
     * @param tesi tesi alla quale fa riferimento il task
     * @param studente studente al quale è riferito il task
     * @param testo testo descrittivo del task
     * @param stato stato (non iniziato/da completare/completato) del task
     * @param dataInizio data di inizio del task
     * @param dataFine data di fine del task
     *
     * @throws EccezioniPersonalizzate eccezioni relative all'istanziazione di un task
     */
    public Task(String codice, String tesi, String studente, String testo, StatoTask stato, LocalDate dataInizio, LocalDate dataFine) throws EccezioniPersonalizzate {
        if(codice == null)
            throw new EccezioniPersonalizzate("Codice non valido");

        if(tesi == null)
            throw new EccezioniPersonalizzate("Tesi non valido");

        if(studente == null)
            throw new EccezioniPersonalizzate("Studente non valido");

        if(testo == null || !testo.matches(REGEX_STRINGHE))
            throw new EccezioniPersonalizzate("Testo non valido");

        if(stato == null)
            throw new EccezioniPersonalizzate("Stato non valido");

        if(dataInizio == null)
            throw new EccezioniPersonalizzate("Data inizio non valido");

        if(dataFine == null)
            throw new EccezioniPersonalizzate("Data fine non valido");

        this.codice = codice;
        this.tesi = tesi;
        this.studente = studente;
        this.testo = testo;
        this.stato = stato;
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
    }


    //GETTER E SETTER
    /**
     * Metodo getRegexStringhe per la restituzione dell'espressione regolare relativa alle stringhe
     *
     * @return REGEX_STRINGHE
     */
    public String getRegexStringhe() {
        return REGEX_STRINGHE;
    }

    /**
     * Metodo getCodice per la restituzione del codice di un task
     *
     * @return codice della tesi
     */
    public String getCodice() {
        return codice;
    }

    /**
     * Metodo getTesi per la restituzione della tesi alla quale fa riferimento un task
     *
     * @return tesi del task
     */
    public String getTesi() {
        return tesi;
    }

    /**
     * Metodo setTesi per l'impostazione della tesi alla quale fa riferimento un tesi
     *
     * @param tesi tesi del task
     */
    public void setTesi(String tesi) {
        this.tesi = tesi;
    }

    /**
     * Metodo getStudente per la restituzione dello studente che ha richiesto il task
     *
     * @return studente richiedente del task
     */
    public String getStudente() {
        return studente;
    }

    /**
     * Metodo setTesi per l'impostazione dello studente che ha richiesto il task
     *
     * @param studente studente richiedente del task
     */
    public void setStudente(String studente) {
        this.studente = studente;
    }

    /**
     * Metodo getTesto per la restituzione del testo del task
     *
     * @return testo del task
     */
    public String getTesto() {
        return testo;
    }

    /**
     * Metodo setTesto per l'impostazione del testo del task
     *
     * @param testo testo del task
     */
    public void setTesto(String testo) {
        this.testo = testo;
    }

    /**
     * Metodo getStato per la restituzione dello stato del task
     *
     * @return stato del task
     */
    public StatoTask getStato() {
        return stato;
    }

    /**
     * Metodo setStato per l'impostazione dello stato del task
     *
     * @param stato stato del task
     */
    public void setStato(StatoTask stato) {
        this.stato = stato;
    }

    /**
     * Metodo getDataInizio per la restituzione della data di inizio del task
     *
     * @return dataInizio del task
     */
    public LocalDate getDataInizio() {
        return dataInizio;
    }

    /**
     * Metodo setDataInizio per l'impostazione della data di inizio del task
     *
     * @param dataInizio data inizio del task
     */
    public void setDataInizio(LocalDate dataInizio) {
        this.dataInizio = dataInizio;
    }

    /**
     * Metodo getDataFine per la restituzione della data di fine del task
     *
     * @return dataFine del task
     */
    public LocalDate getDataFine() {
        return dataFine;
    }

    /**
     * Metodo setDataFine per l'impostazione della data di fine del task
     *
     * @param dataFine data fine del task
     */
    public void setDataFine(LocalDate dataFine) {
        this.dataFine = dataFine;
    }


    //HASH CODE E EQUALS
    /**
     * Metodo hashCode sul codice di un task
     *
     * @return codice hash del codice di un task
     */
    @Override
    public int hashCode() {
        return Objects.hash(codice);
    }

    /**
     * Metodo equals sui codici dei task
     *
     * @param obj oggetto in input da equiparare
     *
     * @return risulatato dell'equiparazione tra i codici
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Task other = (Task) obj;
        return Objects.equals(codice, other.codice);
    }


    //TO STRING
    /**
     * Metodo toString per la visualizzazione delle informazioni relative ad un task
     *
     * @return stringa con le informazioni relative ad un task
     */
    @Override
    public String toString() {
        return "Task{" +
                "codice='" + codice + '\'' +
                ", tesi='" + tesi + '\'' +
                ", studente='" + studente + '\'' +
                ", testo='" + testo + '\'' +
                ", stato=" + stato +
                ", dataInizio=" + dataInizio +
                ", dataFine=" + dataFine +
                '}';
    }
}
