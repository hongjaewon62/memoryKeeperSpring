package com.memorykeeper.memoryKeeperSpring.repository;

import com.memorykeeper.memoryKeeperSpring.entity.CenterData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CenterDataRepository extends JpaRepository<CenterData, Integer> {
    @Query("SELECT c FROM CenterData c " +
            "WHERE (:roadnameaddress IS NULL OR c.roadnameaddress LIKE %:roadnameaddress%) " +
            "AND (:name IS NULL OR c.name LIKE %:name%)")
    List<CenterData> searchCenters(
            @Param("roadnameaddress") String roadnameaddress,
            @Param("name") String name
    );
}
