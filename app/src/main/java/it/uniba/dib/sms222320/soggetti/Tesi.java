package it.uniba.dib.sms222320.soggetti;

import java.util.List;
import java.util.Objects;
import it.uniba.dib.sms222320.eccezioni.EccezioniPersonalizzate;

public class Tesi {
//  ESPRESSIONI REGOLARI
    /**
     * Costante REGEX_STRINGHE relativa all'espressione regolare per il controllo delle stringhe
     */
    private static final String REGEX_STRINGHE = "^[a-zA-Z\\s]+$";

//	VARIABILI
    /**
     * Variabile codice relativo al codice identificativo della tesi
     */
    private String codice = null;
    /**
     * Variabile argomento relativo all'argomento della tesi
     */
    private String argomento = null;
    /**
     * Variabile tipo relativo al tipo (sperimentale/compilativa) della tesi
     */
    private TipoTesi tipo = null;
    /**
     * Variabile descrizione relativa alla descrizione della tesi
     */
    private String descrizione = null;
    /**
     * Variabile tempistiche relativa al tempo minimo previsto in giorni per la tesi
     */
    private Integer tempistiche = null;
    /**
     * Variabile mediaVoti relativa alla media minima necessaria per la tesi
     */
    private Float mediaVoti = null;
    /**
     * Lista esamiNecessari relativa agli esami necessari per la tesi
     */
    private List<String> esamiNecessari = null;
    /**
     * Lista skills relativa alle skills necessare per la tesi
     */
    private List<String> skills = null;
    /**
     * Lista progettiCorrelati relativa ai progetti correlati alla tesi
     */
    private List<String> progettiCorrelati = null;
    /**
     * Variabile relatore relativa al relatore della tesi
     */
    private String relatore = null;
    /**
     * Lista coRelatori relativa ai possibili co relatori della tesi
     */
    private List<String> coRelatori = null;


    //COSTRUTTORE
    /**
     * Costruttore di una tesi
     *
     * @param codice codice identificativo della tesi
     * @param argomento argomento della tesi
     * @param tipo tipo (sperimentale/compilativo) della tesi
     * @param descrizione descrizione della tesi
     * @param tempistiche tempo minimo per la tesi
     * @param mediaVoti media minima per la tesi
     * @param esamiNecessari esami necessari per la tesi
     * @param skills skills per la tesi
     * @param progettiCorrelati progetti correlati alla tesi
     * @param relatore relatore della tesi
     * @param coRelatori possibili co relatori della tesi
     *
     * @throws EccezioniPersonalizzate eccezioni relative all'istanziazione di una tesi
     */
    public Tesi(String codice, String argomento, TipoTesi tipo, String descrizione, Integer tempistiche, Float mediaVoti, List<String> esamiNecessari, List<String> skills, List<String> progettiCorrelati, String relatore, List<String> coRelatori) throws EccezioniPersonalizzate {
        if(codice == null)
            throw new EccezioniPersonalizzate("Codice non valido");

        if(argomento == null || !argomento.matches(REGEX_STRINGHE))
            throw new EccezioniPersonalizzate("Argomento non valido");

        if(tipo == null)
            throw new EccezioniPersonalizzate("Tipo non valido");

        if(descrizione == null || !descrizione.matches(REGEX_STRINGHE))
            throw new EccezioniPersonalizzate("Descrizione non valida");

        if(tempistiche == null || tempistiche < 0)
            throw new EccezioniPersonalizzate("Tempistiche non valide");

        if(mediaVoti == null || mediaVoti < 18 || mediaVoti > 30)
            throw new EccezioniPersonalizzate("Media voti non valida");

        if(esamiNecessari.size() != 0) {
            for (String esame: esamiNecessari) {
                if(esame == null || !esame.matches(REGEX_STRINGHE))
                    throw new EccezioniPersonalizzate("Esame non valido");
            }
        }

        if(skills.size() != 0) {
            for (String skill: skills) {
                if(skill == null || !skill.matches(REGEX_STRINGHE))
                    throw new EccezioniPersonalizzate("Skill non valida");
            }
        }

        if(progettiCorrelati.size() != 0) {
            for (String progetto: progettiCorrelati) {
                if(progetto == null || !progetto.matches(REGEX_STRINGHE))
                    throw new EccezioniPersonalizzate("Progetto non valido");
            }
        }

        if(relatore == null)
            throw new EccezioniPersonalizzate("Relatore non valido");

        if(coRelatori.size() != 0) {
            for (String coRelatore: coRelatori) {
                if(coRelatore == null)
                    throw new EccezioniPersonalizzate("Co relatore non valido");
            }
        }

        this.codice = codice;
        this.argomento = argomento;
        this.tipo = tipo;
        this.descrizione = descrizione;
        this.tempistiche = tempistiche;
        this.mediaVoti = mediaVoti;
        this.esamiNecessari = esamiNecessari;
        this.skills = skills;
        this.progettiCorrelati = progettiCorrelati;
        this.relatore = relatore;
        this.coRelatori = coRelatori;
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
     * Metodo getCodice per la restituzione del codice di una tesi
     *
     * @return codice della tesi
     */
    public String getCodice() {
        return codice;
    }

    /**
     * Metodo getArgomento per la restituzione dell'argomento di una tesi
     *
     * @return argomento della tesi
     */
    public String getArgomento() {
        return argomento;
    }

    /**
     * Metodo setArgomento per l'impostazione dell'argomento di una tesi
     *
     * @param argomento argomento della tesi
     */
    public void setArgomento(String argomento) {
        this.argomento = argomento;
    }

    /**
     * Metodo getTipo per la restituzione del tipo di una tesi
     *
     * @return tipo della tesi
     */
    public TipoTesi getTipo() {
        return tipo;
    }

    /**
     * Metodo setTipo per l'impostazione del tipo di una tesi
     *
     * @param tipo tipo della tesi
     */
    public void setTipo(TipoTesi tipo) {
        this.tipo = tipo;
    }

    /**
     * Metodo getDescrizione per la restituzione della descrizione di una tesi
     *
     * @return descrizione della tesi
     */
    public String getDescrizione() {
        return descrizione;
    }

    /**
     * Metodo setDescrizione per l'impostazione della descrizione di una tesi
     *
     * @param descrizione descrizione della tesi
     */
    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    /**
     * Metodo getTempistiche per la restituzione delle tempistiche minime per una tesi
     *
     * @return tempistiche della tesi
     */
    public Integer getTempistiche() {
        return tempistiche;
    }

    /**
     * Metodo setTempistiche per l'impostazione delle tempistiche minime per una tesi
     *
     * @param tempistiche tempistiche minime per una tesi
     */
    public void setTempistiche(Integer tempistiche) {
        this.tempistiche = tempistiche;
    }

    /**
     * Metodo getMediaVoti per la restituzione della media minima dei voti per una tesi
     *
     * @return mediaVoti per una tesi
     */
    public Float getMediaVoti() {
        return mediaVoti;
    }

    /**
     * Metodo setMediaVoti per l'impostazione delle tempistiche minime per una tesi
     *
     * @param mediaVoti media voti minima per una tesi
     */
    public void setMediaVoti(Float mediaVoti) {
        this.mediaVoti = mediaVoti;
    }

    /**
     * Metodo getEsamiNecessari per la restituzione della lista degli esami necessari per una tesi
     *
     * @return esamiNecessari per una tesi
     */
    public List<String> getEsamiNecessari() {
        return esamiNecessari;
    }

    /**
     * Metodo setEsamiNecessari per l'impostazione della lista di esami necessari per una tesi
     *
     * @param esamiNecessari esami necessari per una tesi
     */
    public void setEsamiNecessari(List<String> esamiNecessari) {
        this.esamiNecessari = esamiNecessari;
    }

    /**
     * Metodo getSkills per la restituzione della lista delle skills necessarie per una tesi
     *
     * @return skills necessarie per una tesi
     */
    public List<String> getSkills() {
        return skills;
    }

    /**
     * Metodo setSkills per l'impostazione della lista delle skills necessarie per una tesi
     *
     * @param skills skills necessarie per una tesi
     */
    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    /**
     * Metodo getProgettiCorrelati per la restituzione della lista dei progetti correlati ad una tesi
     *
     * @return progettiCorrelati ad una tesi
     */
    public List<String> getProgettiCorrelati() {
        return progettiCorrelati;
    }

    /**
     * Metodo setProgettiCorrelati per l'impostazione della lista dei progetti correlati ad una tesi
     *
     * @param progettiCorrelati progetti correlati ad una tesi
     */
    public void setProgettiCorrelati(List<String> progettiCorrelati) {
        this.progettiCorrelati = progettiCorrelati;
    }

    /**
     * Metodo getRelatore per la restituzione del relatore per una tesi
     *
     * @return relatore per una tesi
     */
    public String getRelatore() {
        return relatore;
    }

    /**
     * Metodo setRelatore per l'impostazione del relatore per una tesi
     *
     * @param relatore relatore per una tesi
     */
    public void setRelatore(String relatore) {
        this.relatore = relatore;
    }

    /**
     * Metodo getCoRelatori per la restituzione della lista dei co relatori di una tesi
     *
     * @return coRelatori di una tesi
     */
    public List<String> getCoRelatori() {
        return coRelatori;
    }

    /**
     * Metodo setCoRelatori per l'impostazione della lista dei co relatori di una tesi
     *
     * @param coRelatori co relatori di una tesi
     */
    public void setCoRelatori(List<String> coRelatori) {
        this.coRelatori = coRelatori;
    }


    //HASH CODE E EQUALS
    /**
     * Metodo hashCode sul codice di una tesi
     *
     * @return codice hash del codice di una tesi
     */
    @Override
    public int hashCode() {
        return Objects.hash(codice);
    }

    /**
     * Metodo equals sui codici delle tesi
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
        Tesi other = (Tesi) obj;
        return Objects.equals(codice, other.codice);
    }


    //TO STRING
    /**
     * Metodo toString per la visualizzazione delle informazioni relative ad una tesi
     *
     * @return stringa con le informazioni relative ad una tesi
     */
    @Override
    public String toString() {
        return "Tesi{" +
                "codice='" + codice + '\'' +
                ", argomento='" + argomento + '\'' +
                ", tipo='" + tipo + '\'' +
                ", descrizione='" + descrizione + '\'' +
                ", tempistiche=" + tempistiche +
                ", mediaVoti=" + mediaVoti +
                ", esamiNecessari=" + esamiNecessari +
                ", skills=" + skills +
                ", progettiCorrelati=" + progettiCorrelati +
                ", relatore='" + relatore + '\'' +
                ", coRelatori=" + coRelatori +
                '}';
    }
}
