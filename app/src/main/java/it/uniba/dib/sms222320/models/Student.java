package it.uniba.dib.sms222320.models;

import java.time.LocalDate;
import java.util.List;

import static it.uniba.dib.sms222320.utils.Constants.Regex;

public class Student extends User {

    /**
     * Attributo relativo alla matricola di uno studente
     */
    private String matricola;
    /**
     * Attributo relativo al corso di laurea di uno studente
     */
    private String corsoDiLaurea;
    /**
     * Attributo relativo all'anno di iscrizione di uno studente
     */
    private String annoIscrizione;
    /**
     * Attributo relativo alla media dei voti di uno studente
     */
    private Double media;
    /**
     * Attributo relativo alla lista di tesi preferite di uno studente
     */
    private String idListaTesi;

    public Student(User user, String matricola, String corsoDiLaurea, String annoIscrizione, Double media, String idListaTesi) {
        super(user.getRole(), user.getUsername(), user.getEmail(), user.getPassword(), user.getName(), user.getSurname(), user.getBirthDate(), user.getCity(), user.getAddress(), user.getTelephone());
        this.matricola = matricola;
        this.corsoDiLaurea = corsoDiLaurea;
        this.annoIscrizione = annoIscrizione;
        this.media = media;
        this.idListaTesi = idListaTesi;
    }

    public String getMatricola() {
        return matricola;
    }

    public void setMatricola(String matricola) {
        this.matricola = matricola;
    }

    public String getCorsoDiLaurea() {
        return corsoDiLaurea;
    }

    public void setCorsoDiLaurea(String corsoDiLaurea) {
        this.corsoDiLaurea = corsoDiLaurea;
    }

    public String getAnnoIscrizione() {
        return annoIscrizione;
    }

    public void setAnnoIscrizione(String annoIscrizione) {
        this.annoIscrizione = annoIscrizione;
    }

    public Double getMedia() {
        return media;
    }

    public void setMedia(Double media) {
        this.media = media;
    }

    public String getIdListaTesi() {
        return idListaTesi;
    }

    public void setIdListaTesi(String IdListaTesi) {
        this.idListaTesi = idListaTesi;
    }
}
