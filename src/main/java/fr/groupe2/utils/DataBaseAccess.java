package fr.groupe2.utils;

import java.sql.DriverManager;
import java.sql.*;

public class DataBaseAccess {

    // Attributs
    private static DataBaseAccess instance;
    private Connection connection;
    private final String url = "jdbc:mysql://localhost:3306/todolistetp?connectTimeout=3000&useSSL=false&allowPublicKeyRetrieval=true";
    private final String username = "root";
    private final String password = "";
    // Méthodes pour se connecter (JDBC)
    private DataBaseAccess() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(url, username, password);
            System.out.println("Vous êtes bien connectés, connexion réussi ! ");
            connection.setAutoCommit(false);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            System.out.println("Erreur lors de la connexion à la base de données : " + ex.getMessage());
        }
    }
    public Connection getConnection() {
        return connection;
    }
    public static DataBaseAccess getInstance() throws SQLException {
        if (instance == null) {
            instance = new DataBaseAccess();
        } else if (instance.getConnection().isClosed()) {
            instance = new DataBaseAccess();
        }
        return instance;
    }

}
