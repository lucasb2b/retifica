/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.retifica.model;

import java.util.Date;

/**
 *
 * @author LUCAS
 */
public class User {
    private int idUser;
    private String fullName;
    private String email;
    private String password;
    private String joinDate;
    private String accessLevel;
    private String situation_user;
    private int tbRetificaIdRetifica;

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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

    public String getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }

    public String getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(String accessLevel) {
        this.accessLevel = accessLevel;
    }

    public String getSituation_user() {
        return situation_user;
    }

    public void setSituation_user(String situation_user) {
        this.situation_user = situation_user;
    }

    public int getTbRetificaIdRetifica() {
        return tbRetificaIdRetifica;
    }

    public void setTbRetificaIdRetifica(int tbRetificaIdRetifica) {
        this.tbRetificaIdRetifica = tbRetificaIdRetifica;
    }
    
}
