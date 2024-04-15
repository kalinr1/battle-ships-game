package com.example.examprep1.web;

import com.example.examprep1.models.LoggedUser;
import com.example.examprep1.models.models.ShipModel;
import com.example.examprep1.services.ShipService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController extends BaseController{

    private final ShipService shipService;
    private final LoggedUser loggedUser;

    public HomeController(ShipService shipService, LoggedUser loggedUser) {
        this.shipService = shipService;
        this.loggedUser = loggedUser;
    }

    @GetMapping("/")
    public ModelAndView getIndex (){
        if (loggedUser.getId() == null){
            return super.view("index");
        }

        return getHome(new ModelAndView());
    }

    @GetMapping("/static")
    public ModelAndView getStatic (){
        return this.getIndex();
    }


    @GetMapping("/home")
    public ModelAndView getHome (ModelAndView modelAndView){

        if (loggedUser.getId() == null){
            return super.redirect("/");
        }

        List<ShipModel> allShipsOfTheLoggedUser = shipService.findAllShipsOfTheLoggedUser();
        List<ShipModel> allShipsNotOfTheLoggedUser = shipService.findAllShipsNotOfTheLoggedUser();
        List<ShipModel> allShipModelsOrdered = shipService.findAllShipModelsOrdered();

        modelAndView.addObject("allShipsOfTheLoggedUser", allShipsOfTheLoggedUser);
        modelAndView.addObject("allShipsNotOfTheLoggedUser", allShipsNotOfTheLoggedUser);
        modelAndView.addObject("allShipModelsOrdered", allShipModelsOrdered);

        return super.view("home", modelAndView);
    }

    @ModelAttribute
    public List<ShipModel> initLoggedUserShipList (){
        return new ArrayList<>();
    }

    @ModelAttribute
    public List<ShipModel> initOtherUsersShipList (){
        return new ArrayList<>();
    }

    @ModelAttribute
    public List<ShipModel> initAllShipList (){
        return new ArrayList<>();
    }
}
