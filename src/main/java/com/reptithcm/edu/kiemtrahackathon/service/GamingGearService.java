package com.reptithcm.edu.kiemtrahackathon.service;

import com.reptithcm.edu.kiemtrahackathon.dto.GamingGearDtoRequest;
import com.reptithcm.edu.kiemtrahackathon.entity.GamingGear;
import com.reptithcm.edu.kiemtrahackathon.exception.AppException;
import com.reptithcm.edu.kiemtrahackathon.exception.ErrorCode;
import com.reptithcm.edu.kiemtrahackathon.repository.GamingGearRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class GamingGearService {
    // them moi
    // lay danh sach
    // cap nhap all
    // cap nhap 1 phan
    // xoa
    private final GamingGearRepository gamingGearRepository;

    public List<GamingGear> getAll(){
        return gamingGearRepository.findByIsDeleted(false);
    }

    @Transactional
    public GamingGear createNew(GamingGearDtoRequest request){
        GamingGear gamingGear = GamingGear.builder()
                .productName(request.getProductName())
                .price(request.getPrice())
                .serialCode(request.getSerialCode())
                .type(request.getType())
                .build();

        return gamingGearRepository.save(gamingGear);
    }

    @Transactional
    public GamingGear updateAllInfo(Long id, GamingGearDtoRequest request){
        GamingGear gamingGear = gamingGearRepository.findById(id).orElseThrow(() -> new AppException(ErrorCode.NOT_FOUND));

        GamingGear gamingGearUpdate = GamingGear.builder()
                .id(id)
                .productName(request.getProductName())
                .price(request.getPrice())
                .serialCode(request.getSerialCode())
                .type(request.getType())
                .build();

        return gamingGearRepository.save(gamingGearUpdate);
    }

    @Transactional
    public GamingGear updateInfo(Long id, GamingGearDtoRequest request){
        GamingGear gamingGear = gamingGearRepository.findById(id).orElseThrow(() -> new AppException(ErrorCode.NOT_FOUND));

        GamingGear gamingGearUpdate = GamingGear.builder()
                .id(id)
                .productName(request.getProductName() != null ? request.getProductName() : gamingGear.getProductName())
                .price(request.getPrice() > 0 ? request.getPrice() : gamingGear.getPrice())
                .serialCode(request.getSerialCode() != null ? request.getSerialCode() : gamingGear.getSerialCode())
                .type(request.getType() != null ? request.getType() : gamingGear.getType())
                .build();

        return gamingGearRepository.save(gamingGearUpdate);
    }

    @Transactional
    public boolean deleteGamingGear(Long id){
        GamingGear gamingGear = gamingGearRepository.findById(id).orElseThrow(() -> new AppException(ErrorCode.NOT_FOUND));

        gamingGear.setDeleted(true);
        gamingGearRepository.save(gamingGear);
        return true;
    }
}
