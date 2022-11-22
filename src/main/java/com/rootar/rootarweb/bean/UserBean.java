package com.rootar.rootarweb.bean;

import com.rootar.rootarweb.dao.DAOFactory;
import com.rootar.rootarweb.metier.Usr;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.inject.Named;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;

@Named("loginBean")
@ApplicationScoped
public class UserBean implements Serializable {
   private boolean resultInsert;
   private Usr newUsr;
    private int idUsr;
    private String nom;
    private String prenom;
    private String mail;
    private String password;
    private ArrayList<Usr>listUsr;
    public UserBean() {
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
    public void loginIn() throws NoSuchAlgorithmException, InvalidKeySpecException {
        FacesMessage message = null;
        boolean loggedIn = false;
        newUsr=DAOFactory.getUsrDAO().searchBymail(mail);
        System.out.println("hash java: " + get_SHA_512_SecurePassword(password));
        System.out.println("hash bdd: " + newUsr.getPassword());
        String hashBdd = get_SHA_512_SecurePassword(password);

        if(validatePassword(get_SHA_512_SecurePassword(password),newUsr.getPassword())) {
            System.out.println("equal");

         }
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

    private static String get_SHA_512_SecurePassword(String passwordToHash) {
        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            //md.update(salt.getBytes());
            //String salt
            byte[] bytes = md.digest(passwordToHash.getBytes());
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16)
                        .substring(1));
            }
            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return generatedPassword;
    }
    private static boolean validatePassword(String originalPassword, String storedPassword)
            throws NoSuchAlgorithmException, InvalidKeySpecException
    {
        String[] parts = storedPassword.split(":");
        int iterations = Integer.parseInt(parts[0]);

        byte[] salt = fromHex(parts[1]);
        byte[] hash = fromHex(parts[2]);

        PBEKeySpec spec = new PBEKeySpec(originalPassword.toCharArray(),
                salt, iterations, hash.length * 8);
        SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        byte[] testHash = skf.generateSecret(spec).getEncoded();

        int diff = hash.length ^ testHash.length;
        for(int i = 0; i < hash.length && i < testHash.length; i++)
        {
            diff |= hash[i] ^ testHash[i];
        }
        return diff == 0;
    }
    private static byte[] fromHex(String hex) throws NoSuchAlgorithmException
    {
        byte[] bytes = new byte[hex.length() / 2];
        for(int i = 0; i < bytes.length ;i++)
        {
            bytes[i] = (byte)Integer.parseInt(hex.substring(2 * i, 2 * i + 2), 16);
        }
        return bytes;
    }
    public Usr getNewUsr() {
        return newUsr;
    }

    public void setNewUsr(Usr newUsr) {
        this.newUsr = newUsr;
    }
}
