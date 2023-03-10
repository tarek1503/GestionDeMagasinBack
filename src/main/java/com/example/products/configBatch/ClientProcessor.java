package com.example.products.configBatch;

import com.example.products.entity.Client;
import org.springframework.batch.item.ItemProcessor;

public class ClientProcessor implements ItemProcessor<Client, Client> {

    @Override
    public Client process(Client client) throws Exception {
        return client;
    }
}
