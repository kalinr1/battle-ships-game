package com.example.examprep1.services;

import com.example.examprep1.models.LoggedUser;
import com.example.examprep1.models.dtoS.binding.ShipAddDTO;
import com.example.examprep1.models.entities.Ship;
import com.example.examprep1.models.entities.User;
import com.example.examprep1.models.models.CategoryModel;
import com.example.examprep1.models.models.ShipModel;
import com.example.examprep1.models.models.UserModel;
import com.example.examprep1.repositories.ShipRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ShipService {

    private final ShipRepository shipRepository;
    private final UserService userService;
    private final CategoryService categoryService;

    private final ModelMapper modelMapper;
    private final LoggedUser loggedUser;

    public ShipService(ShipRepository shipRepository, UserService userService, CategoryService categoryService, ModelMapper modelMapper, LoggedUser loggedUser) {
        this.shipRepository = shipRepository;
        this.userService = userService;
        this.categoryService = categoryService;
        this.modelMapper = modelMapper;
        this.loggedUser = loggedUser;
    }

    public void addShip (ShipAddDTO shipAddDTO){

        UserModel userModelById = userService.findUserModelById(loggedUser.getId());
        CategoryModel categoryModelByType = categoryService.findCategoryModelByType(shipAddDTO.getCategory());

        Ship shipToSave = modelMapper.map(ShipModel.builder()
                .name(shipAddDTO.getName())
                .health(shipAddDTO.getHealth())
                .power(shipAddDTO.getPower())
                .created(shipAddDTO.getCreated())
                .user(userModelById)
                .category(categoryModelByType)
                .build(), Ship.class);

        this.shipRepository.saveAndFlush(shipToSave);

    }

    public void shipBattle (String userShipName, String otherShipName){
        ShipModel userShipModel = modelMapper.map(shipRepository.findByName(userShipName).orElseThrow(), ShipModel.class);
        ShipModel otherUserShipModel = modelMapper.map(shipRepository.findByName(otherShipName).orElseThrow(), ShipModel.class);

        otherUserShipModel.setHealth(otherUserShipModel.getHealth() - userShipModel.getPower());

        if (otherUserShipModel.getHealth() <= 0){
            shipRepository.delete(modelMapper.map(otherUserShipModel, Ship.class));
        }
        else {
            shipRepository.saveAndFlush(modelMapper.map(otherUserShipModel, Ship.class));
        }
    }

    public List<ShipModel> findAllShipsOfTheLoggedUser (){
        return shipRepository.findAllByUser(modelMapper.map(userService.findUserModelById(loggedUser.getId()), User.class))
                .stream()
                .map(ship -> modelMapper.map(ship, ShipModel.class))
                .collect(Collectors.toList());
    }

    public List<ShipModel> findAllShipsNotOfTheLoggedUser (){
        return shipRepository.findAllByUserNot(modelMapper.map(userService.findUserModelById(loggedUser.getId()), User.class))
                .stream()
                .map(ship -> modelMapper.map(ship, ShipModel.class))
                .collect(Collectors.toList());
    }

    public List<ShipModel> findAllShipModelsOrdered (){
        return shipRepository.findAll().stream()
                .map(ship -> modelMapper.map(ship, ShipModel.class))
                .sorted(Comparator.comparing(ShipModel::getName).thenComparing(ShipModel::getHealth).thenComparing(ShipModel::getPower))
                .collect(Collectors.toList());
    }
}
