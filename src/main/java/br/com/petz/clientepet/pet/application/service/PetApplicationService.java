package br.com.petz.clientepet.pet.application.service;

import br.com.petz.clientepet.cliente.application.service.ClienteService;
import br.com.petz.clientepet.pet.application.api.PetClienteDetalheResponse;
import br.com.petz.clientepet.pet.application.api.PetClienteListResponse;
import br.com.petz.clientepet.pet.application.api.PetRequest;
import br.com.petz.clientepet.pet.application.api.PetResponse;
import br.com.petz.clientepet.pet.application.repository.PetRepository;
import br.com.petz.clientepet.pet.domain.Pet;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Log4j2
@RequiredArgsConstructor
public class PetApplicationService implements PetService {

    private final ClienteService clienteService;
    private final PetRepository petRepository;

    @Override
    public PetResponse criaPet(UUID idCliente, PetRequest petRequest) {
        log.info("[inicia] PetApplicationService - criaPet");
        clienteService.buscaClienteAtravesId(idCliente);
        Pet pet = petRepository.salvaPet(new Pet(idCliente, petRequest));
        log.info("[finaliza] PetApplicationService - criaPet");
        return new PetResponse(pet.getIdPet());
    }

    @Override
    public List<PetClienteListResponse> buscaPetsDoClienteComId(UUID idCliente) {
        log.info("[inicia] PetApplicationService - buscaPetsDoClienteComId");
        clienteService.buscaClienteAtravesId(idCliente);
        List<Pet> petsDoCliente = petRepository.buscaPetsDoClienteComId(idCliente);
        log.info("[finaliza] PetApplicationService - buscaPetsDoClienteComId");
        return PetClienteListResponse.converte(petsDoCliente);
    }

    @Override
    public PetClienteDetalheResponse buscaPetDoClienteComId(UUID idCliente, UUID idPet) {
        log.info("[inicia] PetApplicationService - buscaPetDoClienteComId");
        clienteService.buscaClienteAtravesId(idCliente);
        Pet pet = petRepository.buscaPetPeloId(idPet);
        log.info("[finaliza] PetApplicationService - buscaPetDoClienteComId");
        return new PetClienteDetalheResponse(pet);
    }

    @Override
    public void deletaPetDoClienteComId(UUID idCliente, UUID idPet) {
        log.info("[inicia] PetApplicationService - deletaPetDoClienteComId");
        log.info("[finaliza] PetApplicationService - deletaPetDoClienteComId");
    }
}
