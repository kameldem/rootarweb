package com.rootar.rootarweb.dao;


import com.rootar.rootarweb.metier.Evenements;
import com.rootar.rootarweb.metier.Ville;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class EvenementsDAO extends DAO <Evenements, Evenements> {
    private ResultSet rs;

    protected EvenementsDAO(Connection connexion) {
        super(connexion);
    }

    public ArrayList<Evenements> getEventByVille(Ville ville) {

        ArrayList<Evenements> liste = new ArrayList<>();
        String SQL = " select * from evenements where id_ville =?";
        try (PreparedStatement pstmt = connexion.prepareStatement(SQL)) {


            // Determine the column set column
            if (ville != null) {
                pstmt.setInt(1, ville.getIdVille());
                rs = pstmt.executeQuery();


                while (rs.next()) {

                    liste.add(new Evenements(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), new Ville(ville.getIdVille(), ville.getNomVille())));
                }

                rs.close();
            }


        }
        // Handle any errors that may have occurred.
        catch (Exception e) {
            e.printStackTrace();
        }
        return liste;
    }

    @Override
    public Evenements getByID(int id) {
        return null;
    }

    @Override
    public ArrayList<Evenements> getAll() {
        return null;
    }

    @Override
    public ArrayList<Evenements> getLike(Evenements objet) {
        return null;
    }

    @Override
    public boolean insert(Evenements evenements) {
        String SQL = "INSERT INTO EVENEMENTS (LIBELLE_EVENEMENTS, DATE_DEBUT_EVENEMENTS, DATE_FIN_EVENEMENTS, DESCRIPTION_EVENEMENT, ID_VILLE)" + " VALUES (?,?,?,?,?)";
        try (PreparedStatement pStmt = this.connexion.prepareStatement(SQL)) {
            if (evenements != null) {

                pStmt.setString(1, evenements.getLibelleEvenements());
                pStmt.setString(2, evenements.getDateDebutEvenements());
                pStmt.setString(3, evenements.getDateFinEvenements());
                pStmt.setString(4, evenements.getDescriptionEvenements());
                pStmt.setInt(5, evenements.getVille().getIdVille());

                pStmt.execute();
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }


    @Override
    public boolean update(Evenements evenements) {
        String SQL = "update EVENEMENTS set  LIBELLE_EVENEMENTS = ?, DATE_DEBUT_EVENEMENTS = ?, DATE_FIN_EVENEMENTS = ?, DESCRIPTION_EVENEMENT = ? , ID_VILLE = ?  where ID_EVENEMENTS = ?";
        try (PreparedStatement pStmt = this.connexion.prepareStatement(SQL)) {
            if (evenements != null) {

                pStmt.setString(1, evenements.getLibelleEvenements());
                pStmt.setString(2, evenements.getDateDebutEvenements());
                pStmt.setString(3, evenements.getDateFinEvenements());
                pStmt.setString(4, evenements.getDescriptionEvenements());
                pStmt.setInt(5, evenements.getVille().getIdVille());
                pStmt.setInt(6, evenements.getIdEvenements());

                pStmt.executeUpdate();
                pStmt.close();
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public boolean delete(Evenements evenements) {

        String delete = "DELETE FROM EVENEMENTS WHERE ID_EVENEMENTS= ?";

        try (PreparedStatement pStmt = this.connexion.prepareStatement(delete)) {
            if (evenements != null) {
                pStmt.setInt(1, evenements.getIdEvenements());
                pStmt.executeUpdate();
                pStmt.close();
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
