package com.memorykeeper.memoryKeeperSpring.service;

import com.memorykeeper.memoryKeeperSpring.dto.DementiaDataResponse;
import com.memorykeeper.memoryKeeperSpring.entity.DementiaData;
import com.memorykeeper.memoryKeeperSpring.repository.DementiaDataRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DementiaDataServiceImpl implements DementiaDataService {

    private final DementiaDataRepository dementiaDataRepository;

    public DementiaDataServiceImpl(DementiaDataRepository dementiaDataRepository) {
        this.dementiaDataRepository = dementiaDataRepository;
    }

    @Override
    public List<DementiaDataResponse> findByYear(int year) {
        List<DementiaData> entities = dementiaDataRepository.findByYear(year);
        return entities.stream()
                .map(DementiaDataResponse::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<DementiaDataResponse> findBySearch(int year, String si, String sigungu, String gender, String chartTitle) {
        List<DementiaData> dataList = dementiaDataRepository.findBySearch(
                year,
                (si == null || si.isEmpty()) ? null : si,
                (sigungu == null || sigungu.isEmpty()) ? null : sigungu,
                (gender == null || gender.isEmpty() || gender.equals("all")) ? null : gender
        );

        return dataList.stream().map(data -> {
            DementiaDataResponse dto = new DementiaDataResponse();
            dto.setYear(data.getYear());
            dto.setSi(data.getSi());
            dto.setSigungu(data.getSigungu());
            dto.setGender(data.getGender());
            dto.setAgegroup(data.getAgegroup());

            switch (chartTitle) {
                case "치매 환자 수" -> dto.setDementia_patients(data.getDementiaPatients());
                case "치매 유병률" -> dto.setPrevalence_rate(data.getPrevalenceRate());
                case "경도 환자 수" -> dto.setVery_mild_cases(data.getVeryMildCases());
                case "중등도 환자 수" -> dto.setModerate_cases(data.getModerateCases());
                case "중증 환자 수" -> dto.setSevere_cases(data.getSevereCases());
                case "경도인지장애 환자 수" -> dto.setMci_patients(data.getMciPatients());
                case "경도인지장애 유병률" -> dto.setMci_prevalence_rate(data.getMciPrevalenceRate());
                default -> dto.setDementia_patients(data.getDementiaPatients());
            }
            return dto;
        }).collect(Collectors.toList());
    }
}
