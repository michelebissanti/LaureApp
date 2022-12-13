package it.uniba.dib.sms222320.soggetti;

import java.util.List;
import java.util.Objects;
import it.uniba.dib.sms222320.eccezioni.EccezioniPersonalizzate;

public class Tesi {
//  ESPRESSIONI REGOLARI


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
    private String tipo = null;
    /**
     * Variabile descrizione relativa alla descrizione della tesi
     */
    private String descrizione = null;
    /**
     * Variabile tempistiche relativa al tempo minimo previsto per la tesi
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
    public Tesi(String codice, String argomento, String tipo, String descrizione, Integer tempistiche, Float mediaVoti, List<String> esamiNecessari, List<String> skills, List<String> progettiCorrelati, String relatore, List<String> coRelatori) throws EccezioniPersonalizzate {


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
}
