package org.example.repository;

import org.example.model.User;
import org.example.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepository implements IRepository<User> {

    private Connection getConnection() throws SQLException {
        return DatabaseConnection.getConnection();
    }

    @Override
    public List<User> findAll() throws SQLException {
        String query = "SELECT * FROM public.users;";
        List<User> userList = new ArrayList<>();
        try (
                PreparedStatement preparedStatement = getConnection().prepareStatement(query);
                ResultSet resultSet = preparedStatement.executeQuery();
        ) {
            System.out.println("Connection successful");
            while (resultSet.next()) {
                userList.add(mapResultSetToUser(resultSet));
            }
        } catch (SQLException e) {
            System.out.println("We have an error: " + e);
        }
        return userList;
    }


    @Override
    public User getById(String id) throws SQLException {
        String query = "SELECT * FROM public.users WHERE id = ?";
        User user = null;
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(query)) {
            preparedStatement.setString(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    user = mapResultSetToUser(resultSet);
                }
            }
        } catch (SQLException e) {
            System.out.println("We have an error: " + e);
        }
        return user;
    }

    @Override
    public void save(User user) {
        String query = """
                    INSERT INTO public.users (id, first_name, last_name, email, last_connection, country, website, username, followers, following)
                    VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
                    ON CONFLICT (id) DO UPDATE SET
                        first_name = EXCLUDED.first_name,
                        last_name = EXCLUDED.last_name,
                        email = EXCLUDED.email,
                        last_connection = EXCLUDED.last_connection,
                        country = EXCLUDED.country,
                        website = EXCLUDED.website,
                        username = EXCLUDED.username,
                        followers = EXCLUDED.followers,
                        following = EXCLUDED.following;
                """;
        try (
                Connection connection = getConnection();
                PreparedStatement preparedStatement = getConnection().prepareStatement(query)
        ) {
            connection.setAutoCommit(false);
            preparedStatement.setString(1, user.getId());
            preparedStatement.setString(2, user.getFirstName());
            preparedStatement.setString(3, user.getLastName());
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.setString(5, user.getLastConnection());
            preparedStatement.setString(6, user.getCountry());
            preparedStatement.setString(7, user.getWebsite());
            preparedStatement.setString(8, user.getUsername());
            preparedStatement.setInt(9, user.getFollowers());
            preparedStatement.setInt(10, user.getFollowing());

            int rowsInserted = preparedStatement.executeUpdate();
            connection.commit();
            if (rowsInserted > 0) {
                System.out.println("User inserted successfully.");
            }
        } catch (SQLException e) {
            System.out.println("We have an error: " + e);
            try (Connection connection = getConnection()) {
                connection.rollback(); // Revertir los cambios si ocurre un error
                System.out.println("Transacción revertida debido a un error: " + e.getMessage());
            } catch (SQLException rollbackEx) {
                System.out.println("Error al intentar revertir la transacción: " + rollbackEx.getMessage());
            }
        }
    }

    @Override
    public void delete(String id) {
        String query = "DELETE FROM public.users WHERE id = ?";

        try (
                PreparedStatement preparedStatement = getConnection().prepareStatement(query)
        ) {
            preparedStatement.setString(1, id);

            int rowsDeleted = preparedStatement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("User deleted successfully.");
            }
        } catch (SQLException e) {
            System.out.println("We have an error: " + e);
        }
    }

    private User mapResultSetToUser(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setId(resultSet.getString("id"));
        user.setFirstName(resultSet.getString("first_name"));
        user.setLastName(resultSet.getString("last_name"));
        user.setEmail(resultSet.getString("email"));
        user.setLastConnection(resultSet.getString("last_connection"));
        user.setCountry(resultSet.getString("country"));
        user.setWebsite(resultSet.getString("website"));
        user.setUsername(resultSet.getString("username"));
        user.setFollowers(resultSet.getInt("followers"));
        user.setFollowing(resultSet.getInt("following"));
        return user;
    }
}
