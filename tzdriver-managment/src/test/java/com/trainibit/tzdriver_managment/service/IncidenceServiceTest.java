package com.trainibit.tzdriver_managment.service;

import com.trainibit.tzdriver_managment.entity.Incidence;
import com.trainibit.tzdriver_managment.mapper.IncidenceMapper;
import com.trainibit.tzdriver_managment.repository.IncidenceRepository;
import com.trainibit.tzdriver_managment.response.IncidenceResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;
import java.util.UUID;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class IncidenceServiceTest {

    //instancias simuladas de las dependencias con la notaciòn mockito
   /* @Autowired
    private IncidenceMapper incidenceMapper;
    @Autowired
    private IncidenceRepository incidenceRepository;
    @Autowired
    private IncidenceTypeRepository incidenceTypeRepository;*/

    @Mock
    private IncidenceRepository incidenceRepository;
    @Mock
    private IncidenceMapper incidenceMapper;

//clase bajo prueba
    private IncidenceService incidenceService;

//Inicializar los mocks
    @BeforeEach
    void setUp() {
        // Inicializa los mocks antes de cada prueba
        MockitoAnnotations.openMocks(this);
        // Crea la instancia de la clase bajo prueba (Inyecta los mocks)

        incidenceService = new IncidenceService(incidenceRepository, incidenceMapper);
    }

    @Test
    public void shouldBeFindById(){
        //Arrage
        //1.1 Definir entradas
        //Se necesita de una nueva incidencia, ingresar un uuid y una respuesta de incidenceResponse
        //Definir propiedades
        Incidence incidence = new Incidence();
        UUID uuid = UUID.randomUUID();
        //1.2 Definir salidas
        IncidenceResponse incidenceResponse = new IncidenceResponse();

        //1.3 Configuracion del mock para mi repositorio
        when(incidenceRepository.findByUuid(uuid)).thenReturn(Optional.of(incidence));

        //Configuracion del mock para mi mapper
        when(incidenceMapper.mapEntityToResponse(incidence)).thenReturn(incidenceResponse);

        //2. Act
        IncidenceResponse resultado= incidenceService.findById(uuid);

        assertNotNull(resultado);
        //3. Assert
        //numero de veces que se manda a llamar el metodo findbyid
        verify(incidenceRepository).findByUuid(uuid);
        verify(incidenceMapper).mapEntityToResponse(incidence);



}
}
