/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.minhhieu.controller;

import com.minhhieu.pojos.Cart;
import com.minhhieu.pojos.Category;
import com.minhhieu.service.CategoryService;
import com.minhhieu.service.ProductService;
import com.minhhieu.utils.Utils;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author ASUS
 */
@Controller
@ControllerAdvice
public class HomeController {
    
    @Autowired
    private CategoryService categoryService;
    
    @Autowired
    private ProductService productService;
    @ModelAttribute
    public void commonAttrs(Model model, HttpSession session){
        model.addAttribute("categories", this.categoryService.getCategories());
        model.addAttribute("cartCounter", Utils.countCart((Map<Integer, Cart>) session.getAttribute("cart")));
        model.addAttribute("currentUser", session.getAttribute("currentUser"));
    }
    
    @GetMapping("/")
    public String index(Model model, @RequestParam(required = false) Map<String, String> params,
            HttpSession session){
        String kw = params.getOrDefault("kw", null);
        int page = Integer.parseInt(params.getOrDefault("page", "1"));
        String cateId = params.get("CateId");
        if(cateId == null){
            model.addAttribute("products", this.productService.getProducts(kw, page));
        } else {
            Category c = this.categoryService.getCategoryById(Integer.parseInt(cateId));
            model.addAttribute("products", c.getProductCollection());
        }
        
        model.addAttribute("productCounter", this.productService.countProduct());
        model.addAttribute("hotProducts", this.productService.getHotProducts(6));
        model.addAttribute("mostProducts", this.productService.getMostDiscussProducts(6));
        model.addAttribute("currentUser", session.getAttribute("currentUser"));
        return "index";
    }
}
