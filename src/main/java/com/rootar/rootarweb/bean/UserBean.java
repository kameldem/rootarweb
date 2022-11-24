package com.rootar.rootarweb.bean;

import com.rootar.rootarweb.dao.DAOFactory;
import com.rootar.rootarweb.metier.Usr;
import com.rootar.rootarweb.security.Email;
import com.rootar.rootarweb.security.SecurityTools;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.Serializable;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


@Named("userBean")
@RequestScoped
public class UserBean implements Serializable {

    @Inject
    ApplicationBean applicationBean;
   private boolean resultInsert;
   private Usr newUsr;
    private int idUsr;
    private String nom;
    private String prenom;
    private String login;
    private String email;
    private String password;
    private ArrayList<Usr>listUsr;
    public UserBean() {
        this.nom="";
        this.prenom="";
        this.email="";
        this.password="";
        this.newUsr=new Usr();
    }
    @PostConstruct
    private void init() {
        listUsr= DAOFactory.getUsrDAO().getAll();
        resultInsert=false;

    }



    public void Creer() throws NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MINUTE,10);
        Date expiration = calendar.getTime();
        String url = String.format("/%s?c=%s&e=%s&p=%s&d=%s",
                login,
                SecurityTools.checksum(login+email),
                email,
                applicationBean.passwordHash(password),
                new SimpleDateFormat("dd-MM-yy-HH:mm:ss").format(expiration));
        String urlEncode = SecurityTools.encrypt(url);
        String valideUrl = applicationBean.getAbsolutePath() + "/confirm.jsf?compte=  " + urlEncode;
        StringBuilder body = new StringBuilder("Veuillez cliquer le lien");
        body.append(valideUrl);
        Email.sendEmail(email,"Confirmation",body.toString());


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

    public ApplicationBean getApplicationBean() {
        return applicationBean;
    }

    public void setApplicationBean(ApplicationBean applicationBean) {
        this.applicationBean = applicationBean;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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

    public ArrayList<Usr> getListUsr() {
        return listUsr;
    }

    public void setListUsr(ArrayList<Usr> listUsr) {
        this.listUsr = listUsr;
    }

    public void validerinscription() {

        System.out.println(newUsr.getPrenom());

        resultInsert = DAOFactory.getUsrDAO().insert(newUsr);
        System.out.println(resultInsert);
            if (resultInsert)
                System.out.println("ajout");
            else
                System.out.println("pb ajout");

    }

    public Usr getNewUsr() {
        return newUsr;
    }

    public void setNewUsr(Usr newUsr) {
        this.newUsr = newUsr;
    }
}
