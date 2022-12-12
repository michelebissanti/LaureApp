package it.uniba.dib.sms222320.eccezioni;

/**
 *
 * Classe EccezioniPersonalizzate che estende Exception e fa riferimento alle eccezioni relative alle classi soggetti
 */
public class EccezioniPersonalizzate extends Exception{
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * Costruttore di EccezioniPersonalizzate
     */
    public EccezioniPersonalizzate() {	}

    /**
     * Costruttore di EccezioniPersonalizzate con messaggio
     *
     * @param msg messaggio relativo ad un'eccezione in particolare
     */
    public EccezioniPersonalizzate(String msg) {
        System.out.println(msg);
    }
}
