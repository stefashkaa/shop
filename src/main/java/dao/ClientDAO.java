package dao;

import entities.Client;
import java.util.List;

public interface ClientDAO extends EntityDAO {
    String NAME = "name";
    String DEFAULT_ADDRESS = "default_address";

    void addClient(Client client);

    List<Client> getClients();

    Client getClient(String name);

    Client getClient(int id);

    void deleteClient(String name);

    void deleteClient(int id);

    void updateClient(Client client);
}
