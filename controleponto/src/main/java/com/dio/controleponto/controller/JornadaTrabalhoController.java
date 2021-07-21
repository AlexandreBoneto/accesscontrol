package com.dio.controleponto.controller;

import com.dio.controleponto.model.JornadaTrabalho;
import com.dio.controleponto.service.JornadaTrabalhoService;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jornada")
public class JornadaTrabalhoController {

  JornadaTrabalhoService jornadaTrabalhoService;

  @PostMapping
  public JornadaTrabalho createJornada(@RequestBody JornadaTrabalho jornadaTrabalho){
    return jornadaTrabalhoService.saveJornada(jornadaTrabalho);
  }

  @GetMapping
  public List<JornadaTrabalho> getJornadaList(){
    return jornadaTrabalhoService.findAll();
  }

  @GetMapping("/{idJornada}")
  public ResponseEntity<JornadaTrabalho> getJornadaListById(@PathVariable("idJornada") long idJornada) throws Exception {
    return ResponseEntity.ok(jornadaTrabalhoService.getById(idJornada).orElseThrow(() -> new NoSuchElementException(("Jornada não encontrada"))));
  }
}
