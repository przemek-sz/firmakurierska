package com.server.dto;

public class AllKlientDto implements UserDto{

    private Long id;
    private String username;
    private String email;
    private String imieinazwisko;
    private String kodpocztowy;
    private String miasto;
    private String ulica;
    private String numerdomu;
    private String nrlokalu;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImieinazwisko() {
        return imieinazwisko;
    }

    public void setImieinazwisko(String imieinazwisko) {
        this.imieinazwisko = imieinazwisko;
    }

    public String getKodpocztowy() {
        return kodpocztowy;
    }

    public void setKodpocztowy(String kodpocztowy) {
        this.kodpocztowy = kodpocztowy;
    }

    public String getMiasto() {
        return miasto;
    }

    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public String getNumerdomu() {
        return numerdomu;
    }

    public void setNumerdomu(String numerdomu) {
        this.numerdomu = numerdomu;
    }

    public String getNrlokalu() {
        return nrlokalu;
    }

    public void setNrlokalu(String nrlokalu) {
        this.nrlokalu = nrlokalu;
    }

    @Override
    public String toString() {
        return "AllKlientDto{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", imieinazwisko='" + imieinazwisko + '\'' +
                ", kodpocztowy='" + kodpocztowy + '\'' +
                ", miasto='" + miasto + '\'' +
                ", ulica='" + ulica + '\'' +
                ", numerdomu='" + numerdomu + '\'' +
                ", nrlokalu='" + nrlokalu + '\'' +
                '}';
    }
}
