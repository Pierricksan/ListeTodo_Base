package fr.groupe2.api;


import fr.groupe2.utils.DataBaseAccess;

import java.sql.*;


public class DataGestion {

    private final Connection connection;
    // On lance une connection
    // Le constrcuteur pour initilialiser la base de données
    public DataGestion() throws SQLException {
        this.connection = DataBaseAccess.getInstance().getConnection();
    }

}

