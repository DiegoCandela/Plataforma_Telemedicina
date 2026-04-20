package com.telemedicina.plataforma.service;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.Objects;

import com.telemedicina.plataforma.factory.*;
import com.telemedicina.plataforma.model.*;
import com.telemedicina.plataforma.repository.*;
import com.telemedicina.plataforma.bridge.*;
import com.telemedicina.plataforma.composite.OrdenMedicaLeaf;
import com.telemedicina.plataforma.composite.PlanCompuesto;
import com.telemedicina.plataforma.composite.PrescripcionLeaf;
import com.telemedicina.plataforma.decorator.ConsultaBase;
import com.telemedicina.plataforma.decorator.ConsultaComponent;
import com.telemedicina.plataforma.decorator.HistorialDecorator;
import com.telemedicina.plataforma.decorator.NotificacionDecorator;

@Service
@RequiredArgsConstructor
public class ConsultaService {

        private final ConsultaRepository consultaRepository;
        private final PrescripcionRepository prescripcionRepository;
        private final OrdenMedicaRepository ordenMedicaRepository;
        private final PacienteRepository pacienteRepository;
        private final MedicoRepository medicoRepository;
        private final TipoConsultaProvider tipoConsultaProvider;

        public Consulta crearConsulta(LocalDateTime fecha, Long pacienteId, Long medicoId, String tipo) {

                Objects.requireNonNull(fecha, "fecha no puede ser null");
                Objects.requireNonNull(pacienteId, "pacienteId no puede ser null");
                Objects.requireNonNull(medicoId, "medicoId no puede ser null");
                Objects.requireNonNull(tipo, "tipo no puede ser null");

                Paciente paciente = pacienteRepository.findById(pacienteId)
                                .orElseThrow(() -> new RuntimeException("Paciente no encontrado"));

                Medico medico = medicoRepository.findById(medicoId)
                                .orElseThrow(() -> new RuntimeException("Medico no encontrado"));

                AbstractMedicalFactory factory = FactoryProvider.getFactory("MEDICO");
                Consulta consulta = factory.crearConsulta(paciente, medico);

                consulta.setFecha(fecha);

                TipoConsultaImplementor implementor = tipoConsultaProvider.obtener(tipo);

                consulta.setTipoConsulta(implementor);

                consulta.ejecutarConsulta();

                ConsultaComponent componente = new ConsultaBase(consulta);

                componente = new NotificacionDecorator(componente);
                componente = new HistorialDecorator(componente);

                componente.ejecutar();

                return consultaRepository.save(consulta);
        }

        public Prescripcion crearPrescripcion(Long consultaId, String medicamento, String indicaciones) {

                Objects.requireNonNull(consultaId, "consultaId no puede ser null");

                Consulta consulta = consultaRepository.findById(consultaId)
                                .orElseThrow(() -> new RuntimeException("Consulta no encontrada"));

                AbstractMedicalFactory factory = FactoryProvider.getFactory("MEDICO");

                Prescripcion prescripcion = factory.crearPrescripcion(
                                consulta,
                                medicamento,
                                indicaciones);

                Objects.requireNonNull(prescripcion, "Error al crear la prescripción");

                return prescripcionRepository.save(prescripcion);
        }

        public OrdenMedica crearOrdenMedica(String tipoOrden, String estado) {

                AbstractMedicalFactory factory = FactoryProvider.getFactory("MEDICO");

                OrdenMedica orden = factory.crearOrdenMedica(tipoOrden, estado);

                Objects.requireNonNull(orden, "Error al crear la orden médica");

                return ordenMedicaRepository.save(orden);
        }

        public Consulta clonarConsulta(Long consultaId) {

                Consulta original = consultaRepository.findById(consultaId)
                                .orElseThrow(() -> new RuntimeException("Consulta no encontrada"));

                Consulta copia = original.clone();

                copia.setFecha(original.getFecha().plusDays(1));
                copia.setEstado("ACTIVA");

                return consultaRepository.save(copia);
        }

        public void mostrarPlanAtencion(Long consultaId) {

                Consulta consulta = consultaRepository.findById(consultaId)
                                .orElseThrow(() -> new RuntimeException("Consulta no encontrada"));

                PlanCompuesto planPrincipal = new PlanCompuesto("Plan General");

                // Subplan (esto es lo que lo hace REALMENTE Composite)
                PlanCompuesto subPlan = new PlanCompuesto("Tratamiento inicial");

                prescripcionRepository.findAll().forEach(p -> subPlan.agregar(new PrescripcionLeaf(p)));

                ordenMedicaRepository.findAll().forEach(o -> subPlan.agregar(new OrdenMedicaLeaf(o)));

                planPrincipal.agregar(subPlan);

                planPrincipal.mostrar();
        }
}