package com.rootar.rootarweb.dao;


import com.rootar.rootarweb.metier.Pays;
import com.rootar.rootarweb.metier.Region;
import com.rootar.rootarweb.metier.TypeClimat;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class RegionDAO extends DAO <Region, Region>{
    private ResultSet rs;
    protected RegionDAO(Connection connexion) {
        super(connexion);
    }


    public ArrayList<Region> searchRegion(String searchView){
        ArrayList<Region> liste = new ArrayList<>();
        String procedureStockee = "{call dbo.SP_RECHERCHE_REGION (?)}";
        try (CallableStatement cStmt = this.connexion.prepareCall(procedureStockee))
        {

            cStmt.setString(1,searchView);

            cStmt.execute();
            rs = cStmt.getResultSet();
            while(rs.next()) {
                Region newRegion= new Region();
                newRegion.setIdRegion(rs.getInt(1));
                newRegion.setNomRegion(rs.getString(2));
                newRegion.setPays(new Pays(rs.getInt(3),rs.getString(4)));
                newRegion.setTypeClimat(new TypeClimat(rs.getInt(5),rs.getString(6)));
                liste.add(newRegion);
            }

            rs.close();
        }

        // Handle any errors that may have occurred.
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return liste;
    }


    public ArrayList<Region> getRegionByPays(Pays pays) {

        ArrayList<Region> liste = new ArrayList<>();
        String SQL= " select * from Region where id_pays =?";
        try (PreparedStatement pstmt = connexion.prepareStatement(SQL)){


            // Determine the column set column

            pstmt.setInt(1,pays.getIdPays());
            rs = pstmt.executeQuery();


            while (rs.next()) {

                liste.add(new Region(rs.getInt(1),rs.getString(2)));
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
    public Region getByID(int id) {
        return null;
    }

    @Override
    public ArrayList<Region> getAll() {
        return null;
    }

    @Override
    public ArrayList<Region> getLike(Region objet) {
        return null;
    }

    @Override
    public boolean insert(Region objet) {
        return false;
    }

    @Override
    public boolean update(Region object) {
        return false;
    }

    @Override
    public boolean delete(Region object) {
        return false;
    }
}