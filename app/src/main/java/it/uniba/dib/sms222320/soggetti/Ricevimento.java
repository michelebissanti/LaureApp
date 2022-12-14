package it.uniba.dib.sms222320.soggetti;

import java.time.LocalDate;
import java.util.Objects;
import it.uniba.dib.sms222320.eccezioni.EccezioniPersonalizzate;

public class Ricevimento {
    //VARIABILI
    /**
     * Variabile codice relativo al codice identificativo del riferimento
     */
    private String codice = null;
    /**
     * Variabile tesi relativo alla tesi alla quale è associato il ricevimento
     */
    private String tesi = null;
    /**
     * Variabile task relativa al task associato il ricevimento
     */
    private String task = null;
    /**
     * Variabile studente relativo allo studente alla quale è associato il ricevimento
     */
    private String studente = null;
    /**
     * Variabile data relativo alla data del ricevimento
     */
    private LocalDate data = null;


    //COSTRUTTORE
    /**
     * Costruttore di un ricevimento
     *
     * @param codice codice identificativo di un ricevimento
     * @param tesi tesi alla quale fa riferimento il ricevimento
     * @param task task al quale fa riferimento il ricevimento
     * @param studente studente il quale ha richiesto il ricevimento
     * @param data data del ricevimento
     *
     * @throws EccezioniPersonalizzate eccezioni relative all'istanziazione di un ricevimento
     */
    public Ricevimento(String codice, String tesi, String task, String studente, LocalDate data) throws EccezioniPersonalizzate {
        if(codice == null)
            throw new EccezioniPersonalizzate("Codice non valido");

        if(tesi == null)
            throw new EccezioniPersonalizzate("Tesi non valida");

        if(task == null)
            throw new EccezioniPersonalizzate("Task non valida");

        if(studente == null)
            throw new EccezioniPersonalizzate("Studente non valido");

        if(data == null)
            throw new EccezioniPersonalizzate("Data non valida");

        this.codice = codice;
        this.tesi = tesi;
        this.task = task;
        this.studente = studente;
        this.data = data;
    }


    //COSTRUTTORE SENZA ASSOCIAZIONE DEL TASK
    /**
     * Costruttore di un ricevimento
     *
     * @param codice codice identificativo di un ricevimento
     * @param tesi tesi alla quale fa riferimento il ricevimento
     * @param studente studente il quale ha richiesto il ricevimento
     * @param data data del ricevimento
     *
     * @throws EccezioniPersonalizzate eccezioni relative all'istanziazione di un ricevimento
     */
    public Ricevimento(String codice, String tesi, String studente, LocalDate data) throws EccezioniPersonalizzate {
        if(codice == null)
            throw new EccezioniPersonalizzate("Codice non valido");

        if(tesi == null)
            throw new EccezioniPersonalizzate("Tesi non valida");

        if(studente == null)
            throw new EccezioniPersonalizzate("Studente non valido");

        if(data == null)
            throw new EccezioniPersonalizzate("Data non valida");

        this.codice = codice;
        this.tesi = tesi;
        this.studente = studente;
        this.data = data;
    }


    //GETTER E SETTER
    /**
     * Metodo getCodice per la restituzione del codice di un ricevimento
     *
     * @return codice del ricevimento
     */
    public String getCodice() {
        return codice;
    }

    /**
     * Metodo getTesi per la restituzione della tesi alla quale fa riferimento il ricevimento
     *
     * @return tesi del ricevimento
     */
    public String getTesi() {
        return tesi;
    }

    /**
     * Metodo setTesi per l'impostazione della tesi alla quale fa riferimento il ricevimento
     *
     * @param tesi tesi del ricevimento
     */
    public void setTesi(String tesi) {
        this.tesi = tesi;
    }

    /**
     * Metodo getTesi per la restituzione del task al quale fa riferimento il ricevimento
     *
     * @return task del ricevimento
     */
    public String getTask() {
        return task;
    }

    /**
     * Metodo setTesi per l'impostazione del task al quale fa riferimento il ricevimento
     *
     * @param task task del ricevimento
     */
    public void setTask(String task) {
        this.task = task;
    }

    /**
     * Metodo getStudente per la restituzione dello studente che ha richiesto il ricevimento
     *
     * @return studente richiedente del ricevimento
     */
    public String getStudente() {
        return studente;
    }

    /**
     * Metodo setTesi per l'impostazione dello studente che ha richiesto il ricevimento
     *
     * @param studente studente richiedente del ricevimento
     */
    public void setStudente(String studente) {
        this.studente = studente;
    }

    /**
     * Metodo getData per la restituzione della data del ricevimento
     *
     * @return data del ricevimento
     */
    public LocalDate getData() {
        return data;
    }

    /**
     * Metodo setData per l'impostazione della data del ricevimento
     *
     * @param data data fine del ricevimento
     */
    public void setData(LocalDate data) {
        this.data = data;
    }


    //HASH CODE E EQUALS
    /**
     * Metodo hashCode sul codice di un ricevimento
     *
     * @return codice hash del codice di un ricevimento
     */
    @Override
    public int hashCode() {
        return Objects.hash(codice);
    }

    /**
     * Metodo equals sui codici dei ricevimenti
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
        Ricevimento other = (Ricevimento) obj;
        return Objects.equals(codice, other.codice);
    }


    //TO STRING
    /**
     * Metodo toString per la visualizzazione delle informazioni relative ad un ricevimento
     *
     * @return stringa con le informazioni relative ad un ricevimento
     */
    @Override
    public String toString() {
        return "Ricevimento{" +
                "codice='" + codice + '\'' +
                ", tesi='" + tesi + '\'' +
                ", task='" + task + '\'' +
                ", studente='" + studente + '\'' +
                ", data=" + data +
                '}';
    }
}
