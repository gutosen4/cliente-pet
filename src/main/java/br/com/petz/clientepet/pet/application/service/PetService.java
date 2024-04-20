package br.com.petz.clientepet.pet.application.service;

import br.com.petz.clientepet.pet.application.api.PetRequest;
import br.com.petz.clientepet.pet.application.api.PetResponse;
import br.com.petz.clientepet.pet.domain.Pet;

import java.util.UUID;

public interface PetService {
    PetResponse criaPet(UUID idCliente, PetRequest petRequest);
}
