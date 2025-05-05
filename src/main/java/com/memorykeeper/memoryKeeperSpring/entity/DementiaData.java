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
    private Double population;
    private Double dementiaPatients;
    private Double prevalenceRate;
    private Double veryMildCases;
    private Double mildCases;
    private Double moderateCases;
    private Double severeCases;
    private Double mciPatients;
    private Double mciPrevalenceRate;

    public DementiaData() {}

    public DementiaData(
        int year, String si, String sigungu, String gender, String agegroup,
        double population, double dementiaPatients, double prevalenceRate,
        double veryMildCases, double mildCases, double moderateCases, double severeCases,
        double mciPatients, double mciPrevalenceRate) {
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
