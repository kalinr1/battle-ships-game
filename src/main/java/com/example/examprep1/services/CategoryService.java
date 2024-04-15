package com.example.examprep1.services;

import com.example.examprep1.models.entities.Category;
import com.example.examprep1.models.enums.CategoryType;
import com.example.examprep1.models.models.CategoryModel;
import com.example.examprep1.repositories.CategoryRepository;
import jakarta.annotation.PostConstruct;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    public CategoryService(CategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }

    @PostConstruct
    private void PostConstruct (){
        if (categoryRepository.count() == 0){

            categoryRepository.saveAllAndFlush(Arrays.stream(CategoryType.values())
                    .map(categoryType -> CategoryModel.builder()
                            .name(categoryType)
                            .description("cool").build())
                    .map(categoryModel -> modelMapper.map(categoryModel, Category.class))
                    .collect(Collectors.toList()));
        }
    }

    public CategoryModel findCategoryModelByType (CategoryType categoryType){
        return modelMapper.map(categoryRepository.findByName(categoryType), CategoryModel.class);
    }
}


//List<CategoryModel> categoryModels = List.of(
//
//                    new CategoryModel(CategoryType.CARGO, "cool1"),
//                    new CategoryModel(CategoryType.CARGO, "cool1"),
//                    new CategoryModel(CategoryType.CARGO, "cool1"),
//
//                    CategoryModel.builder()
//                            .name(CategoryType.BATTLE)
//                            .description("cool").build(),
//
//                    CategoryModel.builder()
//                            .name(CategoryType.CARGO)
//                            .description("cool1").build(),
//
//                    CategoryModel.builder()
//                            .name(CategoryType.PATROL)
//                            .description("cool2").build());
//
//            categoryRepository.saveAllAndFlush(categoryModels.stream()
//                    .map(categoryModel -> modelMapper.map(categoryModel, Category.class))
//                    .toList());
