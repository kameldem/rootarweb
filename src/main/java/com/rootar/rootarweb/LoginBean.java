package com.rootar.rootarweb;

import com.rootar.rootarweb.dao.DAOFactory;
import com.rootar.rootarweb.metier.Usr;
import jakarta.annotation.PostConstruct;
import jakarta.el.MethodExpression;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import org.primefaces.PrimeFaces;

import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;

@Named("loginBean")
@ApplicationScoped
public class LoginBean implements Serializable {
   private boolean resultInsert;
   private Usr newUsr;
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
        this.newUsr=new Usr();
    }
    @PostConstruct
    private void init() {
        listUsr= DAOFactory.getUsrDAO().getAll();
        resultInsert=false;

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

    public void validerInscription() {

        System.out.println("++"+newUsr.getPassword()+"hh");

        resultInsert = DAOFactory.getUsrDAO().insert(newUsr);
        System.out.println(resultInsert);
            if (resultInsert)
                System.out.println("ajout");
            else
                System.out.println("pb ajout");

    }
    public void loginIn() throws NoSuchAlgorithmException {
        FacesMessage message = null;
        boolean loggedIn = false;
        newUsr=DAOFactory.getUsrDAO().searchBymail(mail);
        System.out.println(mail);
        System.out.println(newUsr.getPassword());
        String plainText = password;

        MessageDigest messageDigest = MessageDigest.getInstance("SHA-512");
        byte[] hash = messageDigest.digest( plainText.getBytes(StandardCharsets.UTF_8) );

        System.out.println("Result: " + hash);

        /*if(mail != null && mail.equals(newUsr.getMail()) && password != null && password.equals(newUsr.getPassword())) {
            loggedIn = true;
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome", newUsr.getPrenom());
            System.out.println("compte valider");
        } else {
            loggedIn = false;
            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Loggin Error", "Invalid credentials");
        }

        FacesContext.getCurrentInstance().addMessage(null, message);
        PrimeFaces.current().ajax().addCallbackParam("loggedIn", loggedIn);*/

    }


    public Usr getNewUsr() {
        return newUsr;
    }

    public void setNewUsr(Usr newUsr) {
        this.newUsr = newUsr;
    }
}
