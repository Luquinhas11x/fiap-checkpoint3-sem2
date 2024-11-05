package br.com.fiap.checkpoint3.dto;

import br.com.fiap.checkpoint3.model.Contato;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

@Setter
@Getter
public class ContatoRequestCreateDto {
    private String nome;

}
