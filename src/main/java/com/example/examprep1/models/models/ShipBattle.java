package com.example.examprep1.models.models;

import com.example.examprep1.validations.shipCheck.ShipCheck;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ShipBattle {

    @ShipCheck
    private String userShip;
    @ShipCheck
    private String otherShip;
}
