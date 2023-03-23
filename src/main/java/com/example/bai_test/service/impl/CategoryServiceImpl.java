package com.example.bai_test.service.impl;

import com.example.bai_test.response.CategoryResponse;
import com.example.bai_test.entity.Category;
import com.example.bai_test.config.mapper.CategoryMapper;
import com.example.bai_test.repository.CategoryRepository;
import com.example.bai_test.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryMapper categoryMapper;


    @Override
    public List<CategoryResponse> getAll() {
        List<CategoryResponse> categoryResponses = new ArrayList<>();
        for (Category ct: categoryRepository.findAll()) {
            categoryResponses.add(categoryMapper.convertToDTO(ct));
        }
        return categoryResponses;    }
}
