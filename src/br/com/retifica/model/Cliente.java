/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.retifica.model;

/**
 *
 * @author LUCAS
 */
public class Cliente {
    private int idClient;
    private String fullName;
    private String cpf;
    private String rg;
    private String tel;
    private String tel2;
    private String street;
    private String number;
    private String district;
    private String zipCode;
    private String state;
    private String city;
    private String situationClient;
    private int tbRetificaIdRetifica;

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getTel2() {
        return tel2;
    }

    public void setTel2(String tel2) {
        this.tel2 = tel2;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSituationClient() {
        return situationClient;
    }

    public void setSituationClient(String situationClient) {
        this.situationClient = situationClient;
    }

    public int getTbRetificaIdRetifica() {
        return tbRetificaIdRetifica;
    }

    public void setTbRetificaIdRetifica(int tbRetificaIdRetifica) {
        this.tbRetificaIdRetifica = tbRetificaIdRetifica;
    }
    
}
