package com.reptithcm.edu.kiemtrahackathon.controller;

import com.reptithcm.edu.kiemtrahackathon.dto.GamingGearDtoRequest;
import com.reptithcm.edu.kiemtrahackathon.entity.GamingGear;
import com.reptithcm.edu.kiemtrahackathon.exception.AppException;
import com.reptithcm.edu.kiemtrahackathon.exception.ErrorCode;
import com.reptithcm.edu.kiemtrahackathon.service.GamingGearService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/gaming-gear")
public class GamingGearController {
    private final GamingGearService gamingGearService;

    @GetMapping
    public ResponseEntity<List<GamingGear>> getAll(){
        return ResponseEntity.ok(gamingGearService.getAll());
    }

    @PostMapping
    public ResponseEntity<GamingGear> createGamingGear(@RequestBody GamingGearDtoRequest request){
        return ResponseEntity.ok(gamingGearService.createNew(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<GamingGear> updateAllInfo(@PathVariable Long id, @Valid @RequestBody GamingGearDtoRequest request,
                                                    BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            throw new AppException(ErrorCode.DATA_NOT_VALID);
        }

        return ResponseEntity.ok(gamingGearService.updateAllInfo(id, request));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<GamingGear> updateInfo(@PathVariable Long id,@RequestBody GamingGearDtoRequest request){
        return ResponseEntity.ok(gamingGearService.updateInfo(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteGamingGear(@PathVariable Long id){

        return ResponseEntity.ok(gamingGearService.deleteGamingGear(id));
    }
}
