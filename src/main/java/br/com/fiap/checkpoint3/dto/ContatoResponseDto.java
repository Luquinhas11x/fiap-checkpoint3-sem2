package br.com.fiap.checkpoint3.dto;

import br.com.fiap.checkpoint3.model.Contato;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

@Setter
@Getter
public class ContatoResponseDto {
    private Long id;
    private String nome;
    private static final ModelMapper modelMapper = new ModelMapper();

    public Contato toDto(Contato contato){
        return modelMapper.map(this, Contato.class);
    }
}
