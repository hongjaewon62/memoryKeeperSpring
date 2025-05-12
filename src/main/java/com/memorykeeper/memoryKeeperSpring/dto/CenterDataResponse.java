package com.memorykeeper.memoryKeeperSpring.dto;

import com.memorykeeper.memoryKeeperSpring.entity.CenterData;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Slf4j
public class CenterDataResponse {
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

    public static CenterDataResponse toDto(CenterData entity) {
        CenterDataResponse dto = new CenterDataResponse();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setType(entity.getType());
        dto.setRoadnameaddress(entity.getRoadnameaddress());
        dto.setLotnumberaddress(entity.getLotnumberaddress());
        dto.setLatitude(entity.getLatitude());
        dto.setLongitude(entity.getLongitude());
        dto.setEstablished(entity.getEstablished());
        dto.setArea(entity.getArea());
        dto.setInformation(entity.getInformation());
        dto.setDoctor(entity.getDoctor());
        dto.setNurse(entity.getNurse());
        dto.setSocialworker(entity.getSocialworker());
        dto.setOther(entity.getOther());
        dto.setOrganizationname(entity.getOrganizationname());
        dto.setRepresentativename(entity.getRepresentativename());
        dto.setPhonenumber(entity.getPhonenumber());
        dto.setProgram(entity.getProgram());
        dto.setRevisiondate(entity.getRevisiondate());
        dto.setCode(entity.getCode());
        dto.setProvidername(entity.getProvidername());
        return dto;
    }

    public static CenterData fromDto(CenterData dto) {
        CenterData entity = new CenterData();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setType(dto.getType());
        entity.setRoadnameaddress(dto.getRoadnameaddress());
        entity.setLotnumberaddress(dto.getLotnumberaddress());
        entity.setLatitude(dto.getLatitude());
        entity.setLongitude(dto.getLongitude());
        entity.setEstablished(dto.getEstablished());
        entity.setArea(dto.getArea());
        entity.setInformation(dto.getInformation());
        entity.setDoctor(dto.getDoctor());
        entity.setNurse(dto.getNurse());
        entity.setSocialworker(dto.getSocialworker());
        entity.setOther(dto.getOther());
        entity.setOrganizationname(dto.getOrganizationname());
        entity.setRepresentativename(dto.getRepresentativename());
        entity.setPhonenumber(dto.getPhonenumber());
        entity.setProgram(dto.getProgram());
        entity.setRevisiondate(dto.getRevisiondate());
        entity.setCode(dto.getCode());
        entity.setProvidername(dto.getProvidername());
        return entity;
    }
}
