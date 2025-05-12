package com.memorykeeper.memoryKeeperSpring.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="centerdata")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CenterData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String type;
    private String roadnameaddress;
    private String lotnumberaddress;
    private Double latitude;
    private Double longitude;
    private String established;
    private String area;
    private String information;
    private Integer doctor;
    private Integer nurse;
    private Integer socialworker;
    private String other;
    private String organizationname;
    private String Representativename;
    private String phonenumber;
    private String program;
    private String revisiondate;
    private Integer code;
    private String providername;
}
