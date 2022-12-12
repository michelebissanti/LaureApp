package it.uniba.dib.sms222320.soggetti;

import java.time.LocalDate;
import java.util.Objects;
import it.uniba.dib.sms222320.eccezioni.EccezioniPersonalizzate;

public abstract class AbstractPersona {

//	ESPRESSIONI REGOLARI
    /**
     * Costante REGEX_CODICE_FISCALE relativa all'espressione regolare per il controllo del codice fiscale di una persona generica
     */
    private static final String REGEX_CODICE_FISCALE = "^[a-zA-Z]{6}[0-9]{2}[a-ehl-mpr-tA-EHL-MPR-T][0-9]{2}[a-zA-Z][0-9]{3}[a-zA-Z]$";
    /**
     * Costante REGEX_NOME_COGNOME relativa all'espressione regolare per il controllo del nome e cognome di una persona generica
     */
    private static final String REGEX_NOME_COGNOME = "^[a-zA-Z\\s]+$";
    /**
     * Costante REGEX_CITTA relativa all'espressione regolare per il controllo della citta di una persona generica
     */
    private static final String REGEX_CITTA = "^[a-zA-Z\\s]+$";
    /**
     * Costante REGEX_RESIDENZA relativa all'espressione regolare per il controllo della residenza di una persona generica
     */
    private static final String REGEX_RESIDENZA = "^[a-zA-Z0-9\\s]+$";
    /**
     * Costante REGEX_NUMERO_TELEFONO relativa all'espressione regolare per il controllo del numero di telefono di una persona generica
     */
    private static final String REGEX_NUMERO_TELEFONO = "^[0-9]{9,10}$";
    /**
     * Costante REGEX_MAIL relativa all'espressione regolare per il controllo della mail di una persona generica
     */
    private static final String REGEX_MAIL = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";


//	VARIABILI
    /**
     * Variabile codiceFiscale relativa al codice fiscale di una persona generica
     */
    private String codiceFiscale = null;
    /**
     * Variabile nome relativa al nome di una persona generica
     */
    private String nome = null;
    /**
     * Variabile cognome relativa al cognome di una persona generica
     */
    private String cognome = null;
    /**
     * Variabile dataNascita relativa alla data di nascita di una persona generica
     */
    private LocalDate dataNascita = null;
    /**
     * Variabile citta relativa alla citta di una persona generica
     */
    private String citta = null;
    /**
     * Variabile residenza relativa alla residenza di una persona generica
     */
    private String residenza = null;
    /**
     * Variabile numeroTelefono relativa al numero di telefono di una persona generica
     */
    private String numeroTelefono = null;
    /**
     * Variabile mail relativa all'indirizzo e-mail di una persona generica
     */
    private String mail = null;


//	COSTRUTTORE
    /**
     * Costruttore di una persona generica
     *
     * @param codiceFiscale codice fiscale identificativo della persona
     * @param nome nome della persona
     * @param cognome cognome della persona
     * @param dataNascita data di nascita della persona
     * @param citta citta della persona
     * @param residenza residenza della persona
     * @param numeroTelefono numero di telefono della persona
     * @param mail e-mail della persona
     *
     * @throws EccezioniPersonalizzate eccezioni relative all'istanziazione di una persona
     */
    public AbstractPersona(String codiceFiscale, String nome, String cognome, LocalDate dataNascita, String citta, String residenza, String numeroTelefono, String mail) throws EccezioniPersonalizzate {
        if(codiceFiscale == null || !codiceFiscale.matches(REGEX_CODICE_FISCALE))
            throw new EccezioniPersonalizzate("Codice fiscale non valido");

        if(nome == null || !nome.matches(REGEX_NOME_COGNOME))
            throw new EccezioniPersonalizzate("Nome non valido");

        if(cognome == null || !cognome.matches(REGEX_NOME_COGNOME))
            throw new EccezioniPersonalizzate("Cognome non valido");

        if(dataNascita == null || dataNascita.getYear() < (LocalDate.now().getYear() - 100) || (LocalDate.now().getYear() - dataNascita.getYear()) < 18)
            throw new EccezioniPersonalizzate("Data di nascita non valida");

        if(citta == null || !citta.matches(REGEX_CITTA))
            throw new EccezioniPersonalizzate("Citt� non valida");

        if(residenza == null || !residenza.matches(REGEX_RESIDENZA))
            throw new EccezioniPersonalizzate("Residenta non valida");

        if(numeroTelefono == null || !numeroTelefono.matches(REGEX_NUMERO_TELEFONO))
            throw new EccezioniPersonalizzate("Numero telefono non valido");

        if(mail == null || !mail.matches(REGEX_MAIL))
            throw new EccezioniPersonalizzate("Mail non valida");

        this.codiceFiscale = codiceFiscale.toUpperCase();
        this.nome = stringaSettata(nome);
        this.cognome = stringaSettata(cognome);
        this.dataNascita = dataNascita;
        this.citta = stringaSettata(citta);
        this.residenza = stringaSettata(residenza);
        this.numeroTelefono = numeroTelefono;
        this.mail = mail;
    }


//	GETTER E SETTER
    /**
     * Metodo getRegexCodiceFiscale per la restituzione dell'espressione regolare relativa al codice fiscale di una persona generica
     *
     * @return REGEX_CODICE_FISCALE della persona generica
     */
    public String getRegexCodiceFiscale() { return REGEX_CODICE_FISCALE; }

    /**
     * Metodo getRegexNomeCognome per la restituzione dell'espressione regolare relativa al nome e cognome di una persona generica
     *
     * @return REGEX_NOME_COGNOME della persona generica
     */
    public String getRegexNomeCognome() { return REGEX_NOME_COGNOME; }

    /**
     * Metodo getRegexCitta per la restituzione dell'espressione regolare relativa alla città di una persona generica
     *
     * @return REGEX_CITTA della persona generica
     */
    public String getRegexCitta() { return REGEX_CITTA; }

    /**
     * Metodo getRegexResidenza per la restituzione dell'espressione regolare relativa alla residenza di una persona generica
     *
     * @return REGEX_RESIDENZA della persona generica
     */
    public String getRegexResidenza() { return REGEX_RESIDENZA; }

    /**
     * Metodo getRegexNumeroTelefono per la restituzione dell'espressione regolare relativa al numero di una persona generica
     *
     * @return REGEX_NUMERO_TELEFONO della persona generica
     */
    public String getRegexNumeroTelefono() { return REGEX_NUMERO_TELEFONO; }

    /**
     * Metodo getRegexMail per la restituzione dell'espressione regolare relativa alla mail di una persona generica
     *
     * @return REGEX_MAIL della persona generica
     */
    public String getRegexMail() { return REGEX_MAIL; }

    /**
     * Metodo getCodiceFiscale per la restituzione del codice fiscale di una persona generica
     *
     * @return codiceFiscale della persona generica
     */
    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    /**
     * Metodo getNome per la restituzione del nome di una persona generica
     *
     * @return nome della persona generica
     */
    public String getNome() {
        return nome;
    }

    /**
     * Metodo setNome per l'impostazione del nome di una persona generica
     *
     * @param nome nome della persona generica
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Metodo getCognome per la restituzione del cognome di una persona generica
     *
     * @return cognome della persona generica
     */
    public String getCognome() {
        return cognome;
    }

    /**
     * Metodo setCognome per l'impostazione del cognome di una persona generica
     *
     * @param cognome cognome della persona generica
     */
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    /**
     * Metodo getDataNascita per la restituzione della data di nascita di una persona generica
     *
     * @return dataDiNascita della persona generica
     */
    public LocalDate getDataNascita() {
        return dataNascita;
    }

    /**
     * Metodo setDataNascita per l'impostazione della data di nascita di una persona generica
     *
     * @param dataNascita data di nascita della persona generica
     */
    public void setDataNascita(LocalDate dataNascita) {
        this.dataNascita = dataNascita;
    }

    /**
     * Metodo getCitta per la restituzione della citta di una persona generica
     *
     * @return citta della persona generica
     */
    public String getCitta() {
        return citta;
    }

    /**
     * Metodo setCitta per l'impostazione della citta di una persona generica
     *
     * @param citta citta della persona generica
     */
    public void setCitta(String citta) {
        this.citta = citta;
    }

    /**
     * Metodo getResidenza per la restituzione della residenza di una persona generica
     *
     * @return residenza della persona generica
     */
    public String getResidenza() {
        return residenza;
    }

    /**
     * Metodo setResidenza per l'impostazione della residenza di una persona generica
     *
     * @param residenza residenza della persona generica
     */
    public void setResidenza(String residenza) {
        this.residenza = residenza;
    }

    /**
     * Metodo getNumeroTelefono per la restituzione del numero di telefono di una persona generica
     *
     * @return numeroTelefono della persona generica
     */
    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    /**
     * Metodo setNumeroTelefono per l'impostazione del numero di telefono di una persona generica
     *
     * @param numeroTelefono numero di telefono della persona generica
     */
    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    /**
     * Metodo getMail per la restituzione della mail di una persona generica
     *
     * @return mail della persona generica
     */
    public String getMail() {
        return mail;
    }

    /**
     * Metodo setMail per l'impostazione della mail di una persona generica
     *
     * @param mail numero di telefono della persona generica
     */
    public void setMail(String mail) {
        this.mail = mail;
    }


    //	HASH CODE ED EQUALS
    /**
     * Metodo hashCode sul codice fiscale di una persona generica
     *
     * @return codice hash del codice fiscale della persona generica
     */
    @Override
    public int hashCode() {
        return Objects.hash(codiceFiscale);
    }

    /**
     * Metodo equals sui codici fiscali di persone generiche
     *
     * @param obj oggetto in input da equiparare
     *
     * @return risulatato dell'equiparazione tra i codici fiscali
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        AbstractPersona other = (AbstractPersona) obj;
        return Objects.equals(codiceFiscale, other.codiceFiscale);
    }


//	TO STRING
    /**
     * Metodo toString per la visualizzazione delle informazioni relative ad una persona generica
     *
     * @return stringa con le informazioni relative ad una persona generica
     */
    @Override
    public String toString() {
        return "codiceFiscale=" + codiceFiscale + ", nome=" + nome + ", cognome=" + cognome + ", dataNascita=" + dataNascita +  ", citta=" + citta + ", residenza=" + residenza + ", numeroTelefono=" + numeroTelefono + ", mail=" + mail;
    }


//	ALTRI METODI
    /**
     * Metodo stringaSettata per l'impostazione della visualizzazione delle stringhe (prima lettera maiuscola e altre minuscole)
     *
     * @param stringa stringa per la quale effettuare il controllo
     *
     * @return stringa settata nel modo corretto
     */
    public String stringaSettata(String stringa) {
        String stringa1 = stringa.toLowerCase();
        String stringa2 = "";

        for(int i = 0; i < stringa1.length(); i++) {
            if(i == 0 || stringa1.charAt(i-1) == ' ') {
                stringa2 += Character.toUpperCase(stringa1.charAt(i));
            } else {
                stringa2 += stringa1.charAt(i);
            }
        }

        return stringa2;
    }
}
