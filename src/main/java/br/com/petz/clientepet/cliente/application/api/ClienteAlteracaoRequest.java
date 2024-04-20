package br.com.petz.clientepet.cliente.application.api;

import br.com.petz.clientepet.cliente.domain.Sexo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

import java.time.LocalDate;
@Value
public class ClienteAlteracaoRequest {
    @NotBlank
    private String nomeCompleto;
    @NotBlank
    private String celular;
    private String telefone;
    private Sexo sexo;
    @NotNull
    private LocalDate dataNascimento;
    @NotNull
    private Boolean aceitaTermos;
}
