package com.reptithcm.edu.kiemtrahackathon.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.lang.reflect.Type;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class GamingGear {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String productName;
    private String serialCode;
    private double price;
    private String type = Type.KEYBOARD.name();
    private boolean isDeleted = false;


    @AllArgsConstructor
    @Getter
    public enum Type{
        KEYBOARD,
        MOUSE_HEADSET
        ;
//        private String result;
    }


}
