package com.example.warehouse.Servis;

import com.example.warehouse.Entity.Client;
import com.example.warehouse.Model.ClientDto;
import com.example.warehouse.Model.Result;
import com.example.warehouse.Repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class ClientService {
    ClientRepository clientRepository;

    public List<Client> getClint() {
        return clientRepository.findAll();
    }

    public Result postClient(ClientDto clientDto) {
        List<Client> clint = getClint();
        Stream<Boolean> booleanStream = clint.stream().map(client -> client.getPhoneNumber().equals(clientDto.getPhoneNumber()));
        List<Boolean> booleans = booleanStream.toList();
        int cout = 0;
        for (Boolean aBoolean : booleans) {
            if (aBoolean) {
                cout++;
            }
        }
        if (cout == 0)  {
            Client client = new Client();
            client.setName(clientDto.getName());
            client.setPhoneNumber(clientDto.getPhoneNumber());
            clientRepository.save(client);
            return new Result("qoshildi",true);
        }
        return new Result("qoshilmadi yoki bunday client bor",false);
    }

    public Result putClient(Integer id, ClientDto clientDto) {
        Optional<Client> byId = clientRepository.findById(id);
        if (byId.isPresent()) {
            Client client = byId.get();
            client.setName(clientDto.getName());
            client.setPhoneNumber(clientDto.getPhoneNumber());
            clientRepository.save(client);
            return new Result("ozgartrildi",true);
        }
        return new Result("ozgarmadi",false);
    }
    public Result deleteClient(Integer id) {
        clientRepository.deleteById(id);
        return new Result("ochirildi",false);
    }
}
