package com.rootar.rootarweb;

import com.rootar.rootarweb.dao.DAOFactory;
import com.rootar.rootarweb.metier.Usr;
import jakarta.annotation.PostConstruct;
import jakarta.el.MethodExpression;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.ArrayList;

@Named("loginBean")
@ApplicationScoped
public class LoginBean implements Serializable {
   private boolean resultInsert;
    private int idUsr;
    private String nom;
    private String prenom;
    private String mail;
    private String password;
    private ArrayList<Usr>listUsr;
    public LoginBean() {
        this.nom="";
        this.prenom="";
        this.mail="";
        this.password="";
    }
    @PostConstruct
    private void init() {
        listUsr= DAOFactory.getUsrDAO().getAll();
        resultInsert=true;

    }

    public int getIdUsr() {
            return idUsr;
        }
    public void setIdUsr(int idUsr) {
            this.idUsr = idUsr;
        }
    public String getNom() {
            return nom;
        }

    public void setNom(String nom) {
            this.nom = nom;
        }

    public String getPrenom() {
            return prenom;
        }

    public void setPrenom(String prenom) {
            this.prenom = prenom;
        }

    public String getMail() {
            return mail;
        }

    public void setMail(String mail) {
            this.mail = mail;
        }

    public String getPassword() {
            return password;
        }
    public void setPassword(String password) {
            this.password = password;
        }

    public ArrayList<Usr> getListUsr() {
        return listUsr;
    }

    public void setListUsr(ArrayList<Usr> listUsr) {
        this.listUsr = listUsr;
    }

    public void login() {

        Usr usr=new Usr();
        usr.setNom("toto");
        usr.setPrenom("titi");
        usr.setMail("vador@gmail.com");
        usr.setPassword("somepassword");
        resultInsert = DAOFactory.getUsrDAO().insert(usr);
        System.out.println(resultInsert);
            if (resultInsert)
                System.out.println("ajout");
            else
                System.out.println("pb ajout");

    }
}
