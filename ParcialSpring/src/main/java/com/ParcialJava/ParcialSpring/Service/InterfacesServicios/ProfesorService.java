package com.ParcialJava.ParcialSpring.Service.InterfacesServicios;


import com.ParcialJava.ParcialSpring.Entidades.DTOs.CursoDTOs.CursoRespuestaDTO;
import com.ParcialJava.ParcialSpring.Entidades.DTOs.ProfesorDTOs.ProfesorPostDTO;
import com.ParcialJava.ParcialSpring.Entidades.DTOs.ProfesorDTOs.ProfesorRespuestaDTO;
import com.ParcialJava.ParcialSpring.Entidades.DTOs.ProfesorDTOs.ProfesorUpdateDTO;
import com.ParcialJava.ParcialSpring.Entidades.Profesor;
import org.hibernate.sql.Update;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProfesorService extends BaseService<Profesor, ProfesorPostDTO, ProfesorUpdateDTO, ProfesorRespuestaDTO> {
}
