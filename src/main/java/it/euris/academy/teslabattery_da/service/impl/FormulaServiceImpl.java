package it.euris.academy.teslabattery_da.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.euris.academy.teslabattery_da.data.dto.FormulaDto;
import it.euris.academy.teslabattery_da.data.model.Formula;
import it.euris.academy.teslabattery_da.exception.IdMustBeNullException;
import it.euris.academy.teslabattery_da.exception.IdMustNotBeNullException;
import it.euris.academy.teslabattery_da.repository.FormulaRepository;
import it.euris.academy.teslabattery_da.service.FormulaService;

@Service
public class FormulaServiceImpl implements FormulaService {

  @Autowired
  FormulaRepository formulaRepository;
  
  @Override
  public List<FormulaDto> getAll() {
    return formulaRepository.findAll()
        .stream().map(Formula::toDto)
        .collect(Collectors.toList());
  }

  @Override
  public FormulaDto get(Long id) {
    Optional<Formula> formula = formulaRepository.findById(id);
    
    if(formula.isPresent()) {
      return formula.get().toDto();
    }
    return null;
  }

  @Override
  public FormulaDto add(FormulaDto dto) {
    if(dto.getId() != null) {
      throw new IdMustBeNullException();
    }
    return formulaRepository.save(dto.toModel()).toDto();
  }

  @Override
  public FormulaDto update(FormulaDto dto) {
    if(dto.getId() == null) {
      throw new IdMustNotBeNullException();
    }
    return formulaRepository.save(dto.toModel()).toDto();
  }

  @Override
  public Boolean delete(Long id) {
    formulaRepository.deleteById(id);
    
    return formulaRepository.findById(id).isEmpty();
  }

}
