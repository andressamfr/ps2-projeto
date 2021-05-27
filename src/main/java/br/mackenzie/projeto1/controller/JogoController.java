package br.mackenzie.projeto1.controller;

import br.mackenzie.projeto1.domain.JogoDTO;
import br.mackenzie.projeto1.entity.Jogo;
import br.mackenzie.projeto1.mapper.JogoMapper;
import br.mackenzie.projeto1.repository.JogoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;

import static org.springframework.http.MediaType.*;

@RestController
@RequestMapping(path = "/api/jogos")
public class JogoController {

    @Autowired
    private JogoRepository jogoRepository;

    @Autowired
    private JogoMapper jogoMapper;

    public JogoController(JogoRepository jogoRepository) {
        this.jogoRepository = jogoRepository;
    }

    @GetMapping(consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Jogo>> listaJogos(@RequestParam("nomeTime") Optional<String> nomeTime) {
        try {
            if (nomeTime.isPresent()) {
                List<Jogo> jogosPesquisa = jogoRepository.findByName(nomeTime.get());
                if (jogosPesquisa.isEmpty()) {
                    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                }
                return new ResponseEntity<>(jogosPesquisa, HttpStatus.OK);
            }

            List<Jogo> jogos = jogoRepository.findAll();
//            List<JogoDTO> jogosDTO = jogoMapper.map(jogos, JogoDTO.class);

            if (jogos.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(jogos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(consumes = {APPLICATION_FORM_URLENCODED_VALUE, MULTIPART_FORM_DATA_VALUE, APPLICATION_JSON_VALUE},
            produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Jogo> create(@Valid @ModelAttribute JogoDTO jogoDTO) {
        System.out.println(jogoDTO);
        Jogo jogo = jogoMapper.map(jogoDTO, Jogo.class);

        try {
            return new ResponseEntity<>(jogoRepository.save(jogo), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Jogo> findById(@PathVariable("id") long id) {
        Optional<Jogo> jogo = jogoRepository.findById(id);
        if (jogo.isPresent()) {
            return new ResponseEntity<>(jogo.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Jogo> update(
            @PathVariable("id") long id,
            @RequestBody Jogo jogo) {
        try {
            Optional<Jogo> _jogo = jogoRepository.findById(id);
            if (_jogo.isPresent()) {
                _jogo.get().setNomeTimeA(jogo.getNomeTimeA());
                _jogo.get().setNomeTimeB(jogo.getNomeTimeB());
                _jogo.get().setGolsTimeA(jogo.getGolsTimeA());
                _jogo.get().setGolsTimeB(jogo.getGolsTimeB());
                return new ResponseEntity<>(jogoRepository.save(_jogo.get()), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<HttpStatus> delete(
            @PathVariable long id) {
        Optional<Jogo> _jogo = jogoRepository.findById(id);
        try {
            if (_jogo.isPresent()) {
                jogoRepository.deleteById(id);
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
