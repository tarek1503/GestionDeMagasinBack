package com.example.products.service;

import com.example.products.repository.ClientRepository;
import com.example.products.ServiceImp.IClientService;
import com.example.products.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService implements IClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Client saveClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public List<Client> getClients() {
        return clientRepository.findAll();
    }

    @Override
    public Client getClientById(long id) {
        return clientRepository.findById(id).orElse(null);
    }



    @Override
    public String deleteClient(long id) {
        clientRepository.deleteById(id);
        return "client removed!"+id;
    }

    @Override
    public Client updateClient(Client client) {
        Client existingClient = clientRepository.findById(client.getId()).orElse(null);
        existingClient.setFirstName(client.getFirstName());
        existingClient.setLastName(client.getLastName());
        existingClient.setMobile(client.getMobile());
        return clientRepository.save(existingClient);
    }
}
