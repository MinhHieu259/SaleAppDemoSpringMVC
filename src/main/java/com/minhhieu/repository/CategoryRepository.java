/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.minhhieu.repository;

import com.minhhieu.pojos.Category;
import java.util.List;

/**
 *
 * @author ASUS
 */
public interface CategoryRepository {
    List<Category> getCategories();
    Category getCategoryById(int cateId);
}
