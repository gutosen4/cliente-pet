package br.com.petz.clientepet.pet.application.api;

import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Value
@Builder
public class PetResponse {
    private UUID idPet;
}
