package dev.nishiduka.cae.telao.outbound.impl;

import dev.nishiduka.cae.telao.core.domain.dtos.AgendamentoDTO;
import dev.nishiduka.cae.telao.core.domain.dtos.AgendamentoPontualEntity;
import dev.nishiduka.cae.telao.core.domain.dtos.AgendamentoRecorrenteEntity;
import dev.nishiduka.cae.telao.core.domain.dtos.SalaEntity;
import dev.nishiduka.cae.telao.core.repository.AgendamentoPontualRepository;
import dev.nishiduka.cae.telao.core.repository.AgendamentoRecorrenteRepository;
import dev.nishiduka.cae.telao.outbound.AgendamentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AgendamentoServiceImpl implements AgendamentoService {

    @Autowired
    private final AgendamentoRecorrenteRepository recorrenteRepository;

    @Autowired
    private final AgendamentoPontualRepository pontualRepository;

    public List<AgendamentoDTO> listarAgendamentosSemana(int semana) {
        List<AgendamentoRecorrenteEntity> recorrente = recorrenteRepository.findAll();
        List<AgendamentoPontualEntity> pontual = pontualRepository.findBySemana(semana - 1);

        return mesclarAgendamentos(recorrente, pontual);
    }

    @Override
    public List<AgendamentoDTO> listarAgendamentosSalaSemana(Long salaId, int semana) {
        List<AgendamentoRecorrenteEntity> recorrente = recorrenteRepository.findBySalaId(salaId);
        List<AgendamentoPontualEntity> pontual = pontualRepository.findBySalaIdAndSemana(salaId, semana - 1);

        return mesclarAgendamentos(recorrente, pontual);
    }

    private List<AgendamentoDTO> mesclarAgendamentos(List<AgendamentoRecorrenteEntity> recorrentes, List<AgendamentoPontualEntity> pontuais) {
        Map<String, AgendamentoDTO> agendamentoMap = new HashMap<>();

        for (AgendamentoRecorrenteEntity recorrente : recorrentes) {
            String key = recorrente.getDiaSemana() + recorrente.getHoraInicio();
            agendamentoMap.put(key, new AgendamentoDTO(recorrente));
        }

        for (AgendamentoPontualEntity pontual : pontuais) {
            String key = pontual.getData().toString() + pontual.getHorarioInicio();
            agendamentoMap.put(key, new AgendamentoDTO(pontual));
        }

        return new ArrayList<>(agendamentoMap.values());
    }
}
