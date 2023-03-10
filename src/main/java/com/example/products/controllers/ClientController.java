package com.example.products.controllers;

import com.example.products.ServiceImp.IClientService;
import com.example.products.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("client")
@CrossOrigin("*")
public class ClientController {
    @Autowired
    private IClientService clientService;
    @PostMapping("/addClient")
    public Client saveClient(@RequestBody Client client){
        return clientService.saveClient(client);
    }
    @GetMapping("/clients")
    public List<Client> findAlClients(){
        return clientService.getClients();
    }
    @GetMapping("/clientById/{id}")
    public Client findClientById(@PathVariable long id){
        return clientService.getClientById(id);
    }
    @PutMapping("/update")
    public Client updateClient(@RequestBody Client client){

        return clientService.updateClient(client);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteClient(@PathVariable long id){

        return clientService.deleteClient(id);
    }

}
