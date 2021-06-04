package com.epam.esm.model.dao.impl;

import com.epam.esm.exception.ConnectionDataBaseException;
import com.epam.esm.model.dao.ConnectionPool;
import com.epam.esm.model.dao.TagDAO;
import com.epam.esm.model.dao.query.SqlTagQuery;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Component
public class TagDAOImpl implements TagDAO {

    public void addTag(String name) {
        ConnectionPool pool = ConnectionPool.getInstance();
        try (Connection connection = pool.getConnection();
             PreparedStatement statement = connection.prepareStatement(SqlTagQuery.ADD_TAG)) {
            statement.setString(1, name);
            statement.executeUpdate();
        } catch (SQLException ex) {
            //обработать
            System.out.println("We have problem with connection to db");
        } catch (ConnectionDataBaseException e) {
            //обработать
        }
    }

    public void deleteTag(int idTag) {
        ConnectionPool pool = ConnectionPool.getInstance();
        try (Connection connection = pool.getConnection();
             PreparedStatement statement = connection.prepareStatement(SqlTagQuery.DELETE_TAG)) {
            statement.setInt(1, idTag);
            statement.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ConnectionDataBaseException e) {
            System.out.println("We have problem with connection pool");
        }
    }
}
