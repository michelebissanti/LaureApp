package it.uniba.dib.sms222320.models;

import java.time.LocalDate;
import java.util.List;

import static it.uniba.dib.sms222320.utils.Constants.Regex;

public class Professor extends User {

    /**
     * Variabile matricola relativa alla matricola di uno studente
     */
    private String matricola;
    /**
     * Lista corsiDiLaurea relativa ai corsi di laurea del professore
     */
    private List<String> corsiDiLaurea;
    /**
     * Lista materieInsegnate relativa alle materie insegnate dal professore
     */
    private List<String> materieInsegnate;

    public Professor(User user, String matricola, List<String> corsiDiLaurea, List<String> materieInsegnate) {
        super(user.getRole(), user.getUsername(), user.getEmail(), user.getPassword(), user.getName(), user.getSurname(), user.getBirthDate(), user.getCity(), user.getAddress(), user.getTelephone());
        this.matricola = matricola;
        this.corsiDiLaurea = corsiDiLaurea;
        this.materieInsegnate = materieInsegnate;
    }

    public Professor() {
        //Do nothing
    }

    public String getMatricola() {
        return matricola;
    }

    public void setMatricola(String matricola) {
        this.matricola = matricola;
    }

    public List<String> getCorsiDiLaurea() {
        return corsiDiLaurea;
    }

    public void setCorsiDiLaurea(List<String> corsiDiLaurea) {
        this.corsiDiLaurea = corsiDiLaurea;
    }

    public List<String> getMaterieInsegnate() {
        return materieInsegnate;
    }

    public void setMaterieInsegnate(List<String> materieInsegnate) {
        this.materieInsegnate = materieInsegnate;
    }
}
