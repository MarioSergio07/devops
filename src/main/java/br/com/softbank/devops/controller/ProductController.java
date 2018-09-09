package br.com.softbank.devops.controller;

import br.com.softbank.devops.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService productService;

    @GetMapping("/all")
    public ModelAndView listAll() {
        ModelAndView mv = new ModelAndView("product/products");
        mv.addObject("products", productService.findAll());
        return mv;
    }
}
