package com.server.dto;

public class NowaPrzesylkaDto {

    private String imieinazwisko;
    private String tel;
    private String email;
    private String kodpocztowy;
    private String miejscowosc;
    private String ulica;
    private String nrdomu;
    private String nrlokalu;
    private String typ;
    private String rozmiar;

    public String getImieinazwisko() {
        return imieinazwisko;
    }

    public void setImieinazwisko(String imieinazwisko) {
        this.imieinazwisko = imieinazwisko;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getKodpocztowy() {
        return kodpocztowy;
    }

    public void setKodpocztowy(String kodpocztowy) {
        this.kodpocztowy = kodpocztowy;
    }

    public String getMiejscowosc() {
        return miejscowosc;
    }

    public void setMiejscowosc(String miejscowosc) {
        this.miejscowosc = miejscowosc;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public String getNrdomu() {
        return nrdomu;
    }

    public void setNrdomu(String nrdomu) {
        this.nrdomu = nrdomu;
    }

    public String getNrlokalu() {
        return nrlokalu;
    }

    public void setNrlokalu(String nrlokalu) {
        this.nrlokalu = nrlokalu;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public String getRozmiar() {
        return rozmiar;
    }

    public void setRozmiar(String rozmiar) {
        this.rozmiar = rozmiar;
    }

    @Override
    public String toString() {
        return "NowaPrzesylkaDto{" +
                "imieinazwisko='" + imieinazwisko + '\'' +
                ", tel='" + tel + '\'' +
                ", email='" + email + '\'' +
                ", kodpocztowy='" + kodpocztowy + '\'' +
                ", miejscowosc='" + miejscowosc + '\'' +
                ", ulica='" + ulica + '\'' +
                ", nrdomu='" + nrdomu + '\'' +
                ", nrlokalu='" + nrlokalu + '\'' +
                ", typ='" + typ + '\'' +
                ", rozmiar='" + rozmiar + '\'' +
                '}';
    }
}
