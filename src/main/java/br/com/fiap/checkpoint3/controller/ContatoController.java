package br.com.fiap.checkpoint3.controller;

import br.com.fiap.checkpoint3.dto.ContatoRequestCreateDto;
import br.com.fiap.checkpoint3.dto.ContatoRequestUpdateDto;
import br.com.fiap.checkpoint3.dto.ContatoResponseDto;
import br.com.fiap.checkpoint3.mapper.ContatoMapper;
import br.com.fiap.checkpoint3.repository.ContatoRepository;
import br.com.fiap.checkpoint3.service.ContatoService;
import br.com.fiap.checkpoint3.view.ContatoFullView;
import br.com.fiap.checkpoint3.view.ContatoSimpleView;
import br.com.fiap.checkpoint3.view.ContatoViewType;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contatos")
@RequiredArgsConstructor
public class ContatoController {

    private final ContatoService contatoService;
    private final ContatoMapper contatoMapper;
    private final ContatoRepository contatoRepository;

    @GetMapping
    public ResponseEntity<List<ContatoResponseDto>> list() {
        List<ContatoResponseDto> dtos = contatoService.list()
                .stream()
                .map(contatoMapper::toDto)
                .toList();

        return ResponseEntity.ok().body(dtos);
    }

    @PostMapping
    public ResponseEntity<ContatoResponseDto> create(@RequestBody ContatoRequestCreateDto dto) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(
                        contatoMapper.toDto(
                                contatoService.save(contatoMapper.toModel(dto)))
                );
    }

    @PutMapping("{id}")
    public ResponseEntity<ContatoResponseDto> update(
            @PathVariable Long id,
            @RequestBody ContatoRequestUpdateDto dto) {
        if (!contatoService.existsById(id)){
            throw new RuntimeException("Id inexistente");
        }
        return ResponseEntity.ok()
                .body(
                        contatoMapper.toDto(
                                contatoService.save(contatoMapper.toModel(id, dto)))
                );
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        if (!contatoService.existsById(id)){
            throw new RuntimeException("Id inexistente");
        }

        contatoService.delete(id);
    }

    @GetMapping("{id}")
    public ResponseEntity<ContatoResponseDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok()
                .body(
                        contatoService
                                .findById(id)
                                .map(contatoMapper::toDto)
                                .orElseThrow(() -> new RuntimeException("Id inexistente"))
                );
    }

    @GetMapping("/find")
    public  ResponseEntity<?> findByNome(
            @RequestParam String nome,
            ContatoViewType type) {

        return switch (type) {
            case FULL -> ResponseEntity.ok().body(contatoRepository.findAllByNomeContains(nome, ContatoFullView.class));
            case SIMPLE ->
                    ResponseEntity.ok().body(contatoRepository.findAllByNomeContains(nome, ContatoSimpleView.class));
        };
    }
}