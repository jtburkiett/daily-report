package org.launchcode.controllers;

import org.launchcode.models.Category;
import org.launchcode.models.Report;
import org.launchcode.models.data.CategoryDao;
import org.launchcode.models.data.ReportDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

/**
 * Created by LaunchCode
 */
@Controller
@RequestMapping("report")
public class ReportController {

    @Autowired
    private ReportDao reportDao;

    // Request path: /report
    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("reports", reportDao.findAll());
        model.addAttribute("title", "Reports");

        return "report/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddCheeseForm(Model model) {
        model.addAttribute("title", "Add Report");
        model.addAttribute(new Report());
        return "report/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddCheeseForm(@ModelAttribute  @Valid Report newReport,
                                       Errors errors, Model model) {

        if (!errors.hasErrors()) {
            reportDao.save(newReport);
            return "redirect:";
        }
        model.addAttribute("title", "Add Report");
        return "report/add";
    }

    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveCheeseForm(Model model) {
        model.addAttribute("reports", reportDao.findAll());
        model.addAttribute("title", "Remove Report");
        return "report/remove";
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveCheeseForm(@RequestParam int[] reportIds) {

        for (int reportId : reportIds){
            reportDao.delete(reportId);
        }
        return "redirect:";
    }

}
