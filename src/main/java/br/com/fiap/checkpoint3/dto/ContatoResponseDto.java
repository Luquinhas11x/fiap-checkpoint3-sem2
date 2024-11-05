package br.com.fiap.checkpoint3.dto;

import br.com.fiap.checkpoint3.model.Contato;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

@Setter
@Getter
@Data
public class ContatoResponseDto {
    private Long id;
    private String nome;
}
