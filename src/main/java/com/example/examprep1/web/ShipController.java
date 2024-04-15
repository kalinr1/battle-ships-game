package com.example.examprep1.web;

import com.example.examprep1.models.LoggedUser;
import com.example.examprep1.models.dtoS.binding.ShipAddDTO;
import com.example.examprep1.models.entities.Ship;
import com.example.examprep1.models.models.ShipBattle;
import com.example.examprep1.models.models.ShipModel;
import com.example.examprep1.services.ShipService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/ships")
public class ShipController extends BaseController{

    private final ShipService shipService;
    private final LoggedUser loggedUser;

    public ShipController(ShipService shipService, LoggedUser loggedUser) {
        this.shipService = shipService;
        this.loggedUser = loggedUser;
    }

    @GetMapping("/add")
    public ModelAndView getAdd (ModelAndView modelAndView){

        if (loggedUser.getId() == null){
            return super.redirect("/users/login");
        }

        return super.view("ship-add");
    }

    @PostMapping("/add")
    public ModelAndView postAdd (@Validated ShipAddDTO shipAddDTO,
                                      BindingResult bindingResult,
                                      ModelAndView modelAndView){

        if (loggedUser.getId() == null){
            return super.redirect("/");
        }

        if (bindingResult.hasErrors()) {
            return super.view("ship-add", modelAndView.addObject("shipAddDTO", shipAddDTO));
        }

        shipService.addShip(shipAddDTO);

        return super.redirect("/home");
    }

    @PostMapping("/battle")
    public ModelAndView postBattle (@Validated ShipBattle shipBattle,
                                    BindingResult bindingResult,
                                    ModelAndView modelAndView){

        if (bindingResult.hasErrors()) {
            return super.redirect("/home");
        }

        shipService.shipBattle(shipBattle.getUserShip(), shipBattle.getOtherShip());

        return super.redirect("/home");
    }

    @ModelAttribute
    public ShipAddDTO initShipAddDTO (){
        return new ShipAddDTO();
    }


}
