package com.server.dto;

public class PracownikSortowniDto implements PracownikDto{

    private String username;
    private String email;
    private String password;
    private String imie;
    private String nazwisko;
    private String nazwaDzialu;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getNazwaDzialu() {
        return nazwaDzialu;
    }

    public void setNazwaDzialu(String nazwaDzialu) {
        this.nazwaDzialu = nazwaDzialu;
    }
}
