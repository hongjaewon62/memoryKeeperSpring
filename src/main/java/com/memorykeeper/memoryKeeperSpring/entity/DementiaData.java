package com.memorykeeper.memoryKeeperSpring.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "statistics")
public class DementiaData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer year;
    private String si;
    private String sigungu;
    private String gender;
    private String agegroup;
    private Integer population;
    private Integer dementiaPatients;
    private Double prevalenceRate;
    private Integer veryMildCases;
    private Integer mildCases;
    private Integer moderateCases;
    private Integer severeCases;
    private Integer mciPatients;
    private Double mciPrevalenceRate;

    public DementiaData() {

    }
    public DementiaData(
        int year, String si, String sigungu, String gender, String agegroup,
        int population, int dementiaPatients, double prevalenceRate,
        int veryMildCases, int mildCases, int moderateCases, int severeCases,
        int mciPatients, double mciPrevalenceRate) {
        this.year = year;
        this.si = si;
        this.sigungu = sigungu;
        this.gender = gender;
        this.agegroup = agegroup;
        this.population = population;
        this.dementiaPatients = dementiaPatients;
        this.prevalenceRate = prevalenceRate;
        this.veryMildCases = veryMildCases;
        this.mildCases = mildCases;
        this.moderateCases = moderateCases;
        this.severeCases = severeCases;
        this.mciPatients = mciPatients;
        this.mciPrevalenceRate = mciPrevalenceRate;
    }
}
