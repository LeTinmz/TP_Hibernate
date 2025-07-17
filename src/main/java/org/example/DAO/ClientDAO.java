package org.example.DAO;

import org.example.Entities.Client;

public class ClientDAO extends BaseDAO<Client> {

    public ClientDAO(Class<Client> clientClass) {
        super(clientClass);
    }
}
