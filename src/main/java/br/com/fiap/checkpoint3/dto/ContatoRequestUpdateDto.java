package br.com.fiap.checkpoint3.dto;

import br.com.fiap.checkpoint3.model.Contato;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

@Getter
@Setter
public class ContatoRequestUpdateDto {
    private String nome;
}
