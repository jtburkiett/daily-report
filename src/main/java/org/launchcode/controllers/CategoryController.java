package org.launchcode.controllers;

import org.launchcode.models.Category;
import org.launchcode.models.data.CategoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by JosephT on 6/25/2017.
 */
@Controller
@RequestMapping("category")
public class CategoryController {

    @Autowired
    private CategoryDao categoryDao;


    @RequestMapping(value = "")
    public String index(Model model){
        model.addAttribute("title", "Categories");
        model.addAttribute("items", this.categoryDao.findAll());
        return "category/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddCategories(Model model){
        model.addAttribute("title", "Add Category");
        model.addAttribute(new Category());
        return "category/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddCategories(Model model, @ModelAttribute @Valid Category category, Errors errors){
        if(!errors.hasErrors()) {
            categoryDao.save(category);
            return "redirect:";
        }
        model.addAttribute("title", "Add Category");
        model.addAttribute(new Error());
        model.addAttribute("cheeseTypes", categoryDao.findAll());
        return "category/add";
    }
}

