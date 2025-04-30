package com.memorykeeper.memoryKeeperSpring.dto;

import com.memorykeeper.memoryKeeperSpring.entity.DementiaData;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Slf4j
public class DementiaDataResponse {
    private int year;
    private String si;
    private String sigungu;
    private String gender;
    private String agegroup;
    private int population;
    private int dementia_patients;
    private double prevalence_rate;
    private int very_mild_cases;
    private int mild_cases;
    private int moderate_cases;
    private int severe_cases;
    private int mci_patients;
    private double mci_prevalence_rate;

    public DementiaData toEntity() {
        return new DementiaData(year, si, sigungu, gender, agegroup,
            population, dementia_patients, prevalence_rate,
            very_mild_cases, mild_cases, moderate_cases,
            severe_cases, mci_patients, mci_prevalence_rate);
    }

    public static DementiaDataResponse fromEntity(DementiaData entity) {
        DementiaDataResponse dto = new DementiaDataResponse();
        dto.setYear(entity.getYear());
        dto.setSi(entity.getSi());
        dto.setSigungu(entity.getSigungu());
        dto.setGender(entity.getGender());
        dto.setAgegroup(entity.getAgegroup());
        dto.setPopulation(entity.getPopulation());
        dto.setDementia_patients(entity.getDementiaPatients());
        dto.setPrevalence_rate(entity.getPrevalenceRate());
        dto.setVery_mild_cases(entity.getVeryMildCases());
        dto.setMild_cases(entity.getMildCases());
        dto.setModerate_cases(entity.getModerateCases());
        dto.setSevere_cases(entity.getSevereCases());
        dto.setMci_patients(entity.getMciPatients());
        dto.setMci_prevalence_rate(entity.getMciPrevalenceRate());
        return dto;
    }
}
