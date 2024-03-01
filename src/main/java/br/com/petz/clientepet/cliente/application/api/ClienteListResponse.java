package br.com.petz.clientepet.cliente.application.api;

import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public class ClienteListResponse {
    private UUID idCliente;
    private String nomeCompleto;
    private String cpf;
    private String email;
    private String celular;

}
