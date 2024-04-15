package com.example.examprep1.services;

import com.example.examprep1.models.LoggedUser;
import com.example.examprep1.models.dtoS.binding.UserLoginDTO;
import com.example.examprep1.models.dtoS.binding.UserRegisterDTO;
import com.example.examprep1.models.entities.User;
import com.example.examprep1.models.models.UserModel;
import com.example.examprep1.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final LoggedUser loggedUser;

    public UserService(UserRepository userRepository, ModelMapper modelMapper, LoggedUser loggedUser) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.loggedUser = loggedUser;
    }

    public UserModel findUserModelByUsername (String username){
        return modelMapper.map(this.userRepository.findByUsername(username).orElse(null), UserModel.class);
    }

    public UserModel findUserModelById (Long id){
        return modelMapper.map(this.userRepository.findById(id).orElse(null), UserModel.class);
    }

    public void registerUser (UserRegisterDTO userRegisterDTO){
        userRepository.save(modelMapper.map(userRegisterDTO, User.class));
    }

    public void loginUser (UserLoginDTO userLoginDTO){

        User user = userRepository.findByUsername(userLoginDTO.getUsername()).orElseThrow();

        loggedUser.setId(user.getId());

    }

    public void logoutUser (){
        this.loggedUser.setId(null);
    }
}

