package it.euris.academy.teslabattery_da.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.mysql.cj.x.protobuf.MysqlxDatatypes.Any;
import it.euris.academy.teslabattery_da.data.dto.AssemblyLineDto;
import it.euris.academy.teslabattery_da.data.model.AssemblyLine;
import it.euris.academy.teslabattery_da.repository.AssemblyLineRepository;
import it.euris.academy.teslabattery_da.service.AssemblyLineService;
import it.euris.academy.teslabattery_da.utils.TestSupport;

@SpringBootTest
public class AssemblyLineControllerTest {

  @Autowired
  private AssemblyLineService assemblyLineService;
  
  @MockBean
  private AssemblyLineRepository assemblyLineRepository;
  
  @Test
  void getAll() {
    List<AssemblyLine> mockedAssemblyLines = TestSupport.createAssemblyLineList();
    
    when(assemblyLineRepository.findAll()).thenReturn(mockedAssemblyLines);
    
    List<AssemblyLineDto> assemblyList = assemblyLineService.getAll();
    
    assertEquals(mockedAssemblyLines.size(), assemblyList.size());
  }
  
  @Test
  void get() {
    Long idLong = 12L;
    
    AssemblyLine assemblyToReturn = TestSupport.createAssemblyLine(idLong);
    
    when(assemblyLineRepository.findById(idLong)).thenReturn(Optional.of(assemblyToReturn));
    
    AssemblyLineDto assemblyLineDto = assemblyLineService.get(idLong);
    
    assertEquals(assemblyToReturn.getId().toString(), assemblyLineDto.getId());
  }
  
  @Test
  void post() {
    AssemblyLine assemblyToSave = TestSupport.createAssemblyLine(null);
    AssemblyLine assemblyToReturn = TestSupport.createAssemblyLine(3L);
    
    when(assemblyLineRepository.save(any())).thenReturn(assemblyToReturn);
    
    AssemblyLineDto savedAssembly = assemblyLineService.add(assemblyToSave.toDto());
    
    assertEquals(assemblyToReturn.getId().toString(), savedAssembly.getId());
  }
  
  @Test
  void put() {
    AssemblyLine assemblyToSave = TestSupport.createAssemblyLine(7L);
    AssemblyLine assemblyToReturn = TestSupport.createAssemblyLine(3L);
    
    when(assemblyLineRepository.save(any())).thenReturn(assemblyToReturn);
    
    AssemblyLineDto updatedAssembly = assemblyLineService.update(assemblyToSave.toDto());
    
    assertEquals(updatedAssembly, assemblyToReturn.toDto());
  }
  
  @Test
  void delete() {
    Long idLong = 2L;
    
    doNothing().when(assemblyLineRepository).deleteById(idLong);
    when(assemblyLineRepository.findById(idLong)).thenReturn(Optional.empty());
    
    Boolean deletedBoolean = assemblyLineService.delete(idLong);
    
    assertTrue(deletedBoolean);
  }
}
