package com.reptithcm.edu.kiemtrahackathon.repository;

import com.reptithcm.edu.kiemtrahackathon.entity.GamingGear;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GamingGearRepository extends JpaRepository<GamingGear, Long> {
    List<GamingGear> findByIsDeleted(boolean isDeleted);

    Page<GamingGear> findByProductName(String productName, Pageable pageable);
}
