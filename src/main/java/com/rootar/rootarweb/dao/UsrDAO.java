package com.rootar.rootarweb.dao;

import com.rootar.rootarweb.metier.Usr;
import com.rootar.rootarweb.service.RootarSearch;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class UsrDAO extends DAO <Usr, RootarSearch>{
    private ResultSet rs;
    protected UsrDAO(Connection connexion) {
        super(connexion);
    }
   public boolean ins(){
        return true;
   }

    public Usr getByEmail(String email) {
        Usr newUsr= new Usr();
        String SQL= " select * from USR  where MAIL_USR=? ";
        try (PreparedStatement pstmt = connexion.prepareStatement(SQL)){

            // Determine the column set column

            pstmt.setString(1,email);
            rs = pstmt.executeQuery();

            while (rs.next()) {

               newUsr=new Usr(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5), rs.getString(6));
            }
            rs.close();

        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return newUsr;
    }
    @Override
    public ArrayList<Usr> getAll() {

        ArrayList<Usr> liste = new ArrayList<>();
        try (Statement stmt = connexion.createStatement()){


            // Determine the column set column

            String strCmd = "SELECT * FROM USR";
            rs = stmt.executeQuery(strCmd);


            while (rs.next()) {


                liste.add(new Usr(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5), rs.getString(6)));

            }
            rs.close();

        }
        // Handle any errors that may have occurred.
        catch (Exception e) {
            e.printStackTrace();
        }
        return liste;

    }

    @Override
    public ArrayList<Usr> getLike(RootarSearch objet) {

        return null;
    }
  @Override
    public Usr getByID(int id) {
        Usr newUsr= new Usr();
        String SQL= " select * from USR  where ID_USR=? ";
        try (PreparedStatement pstmt = connexion.prepareStatement(SQL)){

            // Determine the column set column

            pstmt.setInt(1,id);
            rs = pstmt.executeQuery();

            while (rs.next()) {

               newUsr=new Usr(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
            }
            rs.close();

        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return newUsr;
    }
  @Override
    public boolean insert(Usr usr) {
       String SHA2_512="SHA2_512";
      System.out.println(usr.getPassword() +"---------sr");
        String SQL = "INSERT INTO USR(NOM_USR,PRENOM_USR,MAIL_USR,PASSWORD_USR,LOGIN_USR) "+" VALUES (?,?,?,(HASHBYTES('SHA2_512',?)),?)";

        try (PreparedStatement pStmt = this.connexion.prepareStatement(SQL))
        {

            if(usr != null) {
                pStmt.setString(1, usr.getNom());
                pStmt.setString(2,usr.getPrenom());
                pStmt.setString(3, usr.getEmail());
                pStmt.setString(4, usr.getPassword());
                pStmt.setString(5, usr.getLogin());

                pStmt.execute();
            }
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Usr usr) {
        return false;
    }

    @Override
    public boolean delete(Usr object) {
        return false;
    }
}
