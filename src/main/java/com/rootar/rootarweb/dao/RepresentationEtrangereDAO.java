package com.rootar.rootarweb.dao;



import com.rootar.rootarweb.metier.Pays;
import com.rootar.rootarweb.metier.RepresentationEtrangere;
import com.rootar.rootarweb.metier.Ville;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class RepresentationEtrangereDAO extends DAO <RepresentationEtrangere, RepresentationEtrangere> {
    private ResultSet rs;
    protected RepresentationEtrangereDAO(Connection connexion) {
        super(connexion);
    }

    public ArrayList<RepresentationEtrangere> getRepEtrangeresByPays(Pays pays) {

        ArrayList<RepresentationEtrangere> liste = new ArrayList<>();
        String SQL= " select * from representation_etrangere where id_pays =?";
        try (PreparedStatement pstmt = connexion.prepareStatement(SQL)){


            // Determine the column set column

            pstmt.setInt(1,pays.getIdPays());
            rs = pstmt.executeQuery();


            while (rs.next()) {

                liste.add(new RepresentationEtrangere(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4)));
            }
            rs.close();

        }
        // Handle any errors that may have occurred.
        catch (Exception e) {
            e.printStackTrace();
        }
        return liste;
    }
    public ArrayList<RepresentationEtrangere> getRepEtrangeresByVille(Ville ville) {

        ArrayList<RepresentationEtrangere> liste = new ArrayList<>();
        String SQL= " select * from representation_etrangere where id_ville=?";
        try (PreparedStatement pstmt = connexion.prepareStatement(SQL)){


            // Determine the column set column
            if(ville != null) {
                pstmt.setInt(1, ville.getIdVille());
                rs = pstmt.executeQuery();


                while (rs.next()) {

                    liste.add(new RepresentationEtrangere(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
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
    public RepresentationEtrangere getByID(int id) {
        return null;
    }

    @Override
    public ArrayList<RepresentationEtrangere> getAll() {
        return null;
    }

    @Override
    public ArrayList<RepresentationEtrangere> getLike(RepresentationEtrangere objet) {
        return null;
    }

    @Override
    public boolean insert(RepresentationEtrangere representationEtrangere) {
        String SQL = "INSERT INTO REPRESENTATION_ETRANGERE (LIBELLE_REPRESENTATION, TELEPHONE, ADRESSE, ID_PAYS, ID_VILLE)" + " VALUES (?,?,?,?,?)";
        try (PreparedStatement pStmt = this.connexion.prepareStatement(SQL)) {
            if (representationEtrangere != null) {

                pStmt.setString(1, representationEtrangere.getLibelleRepEtrangere());
                pStmt.setString(2, representationEtrangere.getTelephone());
                pStmt.setString(3, representationEtrangere.getAdresse());
                pStmt.setInt(4, representationEtrangere.getPays().getIdPays());
                pStmt.setInt(5, representationEtrangere.getVille().getIdVille());

                pStmt.execute();
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public boolean update(RepresentationEtrangere representationEtrangere) {
        String SQL = "update REPRESENTATION_ETRANGERE set  LIBELLE_REPRESENTATION = ?, TELEPHONE = ?, ADRESSE = ?, ID_PAYS = ? , ID_VILLE = ?  where ID_REPRESENTATION = ?";
        try (PreparedStatement pStmt = this.connexion.prepareStatement(SQL)) {
            if (representationEtrangere != null) {

                pStmt.setString(1, representationEtrangere.getLibelleRepEtrangere());
                pStmt.setString(2, representationEtrangere.getTelephone());
                pStmt.setString(3, representationEtrangere.getAdresse());
                pStmt.setInt(4, representationEtrangere.getPays().getIdPays());
                pStmt.setInt(5, representationEtrangere.getVille().getIdVille());
                pStmt.setInt(6, representationEtrangere.getIdRepEtrangere());

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
    public boolean delete(RepresentationEtrangere representationEtrangere) {
        String delete = "DELETE FROM REPRESENTATION_ETRANGERE WHERE ID_REPRESENTATION= ?";

        try (PreparedStatement pStmt = this.connexion.prepareStatement(delete)) {
            if (representationEtrangere != null) {
                pStmt.setInt(1, representationEtrangere.getIdRepEtrangere());
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
