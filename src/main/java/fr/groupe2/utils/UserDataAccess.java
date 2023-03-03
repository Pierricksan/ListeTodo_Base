package fr.groupe2.utils;

import fr.groupe2.models.User;
import java.sql.*;

public class UserDataAccess {
    private final Connection connection;

    public UserDataAccess() {
        this.connection = DataBaseAccess.getConnection();
    }

    public User addOneUser(User user) {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO utilisateur (nom, prenom) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, user.getNom());
            statement.setString(2, user.getPrenom());
            statement.executeUpdate();
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                int id = generatedKeys.getInt(1);
                user.setId(id);
            }
            generatedKeys.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
    public User findById(int id) {
        User user = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM utilisateur WHERE id = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String prenom = resultSet.getString("prenom");
                String nom = resultSet.getString("nom");
                user = new User(id, prenom, nom);
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
    public void update(User user) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE utilisateur SET nom = ?, prenom = ? WHERE id = ?");
            preparedStatement.setString(1, user.getNom());
            preparedStatement.setString(2, user.getPrenom());
            preparedStatement.setInt(3, user.getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void delete(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM utilisateur WHERE id = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}