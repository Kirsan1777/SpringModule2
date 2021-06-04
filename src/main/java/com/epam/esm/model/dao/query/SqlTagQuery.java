package com.epam.esm.model.dao.query;

public class SqlTagQuery {
    public static final String ADD_TAG = "INSERT tag(name) VALUES (?)";
    public static final String DELETE_TAG = "DELETE FROM tag WHERE id = ?";
}
