package br.com.fiap.checkpoint3.mapper;

import br.com.fiap.checkpoint3.dto.ContatoRequestCreateDto;
import br.com.fiap.checkpoint3.dto.ContatoRequestUpdateDto;
import br.com.fiap.checkpoint3.dto.ContatoResponseDto;
import br.com.fiap.checkpoint3.model.Contato;
import jakarta.persistence.Entity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ContatoMapper {
    @Autowired
    private ModelMapper modelMapper;

    public ContatoResponseDto toDto(Contato contato) {
        return modelMapper.map(contato, ContatoResponseDto.class);
    }

    public Contato toModel(ContatoRequestCreateDto dto) {
        return modelMapper.map(dto, Contato.class);
    }

    public Contato toModel(Long id, ContatoRequestUpdateDto dto) {
        Contato result = modelMapper.map(dto, Contato.class);
        result.setId(id);
        return result;
    }
}
