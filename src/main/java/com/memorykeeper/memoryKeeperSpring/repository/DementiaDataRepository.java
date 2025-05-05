package com.memorykeeper.memoryKeeperSpring.repository;

import com.memorykeeper.memoryKeeperSpring.entity.DementiaData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DementiaDataRepository extends JpaRepository<DementiaData, Integer> {
    List<DementiaData> findByYear(int year);
    @Query("SELECT d FROM DementiaData d " +
            "WHERE d.year = :year " +
            "AND (:si IS NULL OR d.si = :si) " +
            "AND (:sigungu IS NULL OR d.sigungu = :sigungu) " +
            "AND (:gender IS NULL OR d.gender = :gender) " +
            "AND d.agegroup NOT IN ('남계', '여계', '60세이상', '65세이상')")
    List<DementiaData> findBySearch(@Param("year") int year,
                                    @Param("si") String si,
                                    @Param("sigungu") String sigungu,
                                    @Param("gender") String gender);
}
