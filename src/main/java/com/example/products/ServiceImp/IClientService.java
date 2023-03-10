package com.example.products.ServiceImp;

import com.example.products.entity.Client;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public interface IClientService {
    Client saveClient(Client client);
    List<Client> getClients();
    Client getClientById(long id);

    String deleteClient(long id);
    Client updateClient(Client client);
}
