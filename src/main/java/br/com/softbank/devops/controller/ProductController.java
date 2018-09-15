package br.com.softbank.devops.controller;

import br.com.softbank.devops.model.Filter;
import br.com.softbank.devops.model.Product;
import br.com.softbank.devops.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService productService;

    @GetMapping("/all")
    public ModelAndView listAll() {
        ModelAndView mv = new ModelAndView("product/products");
        mv.addObject("products", productService.findAll());
        mv.addObject("messageProductList", "listFound");
        return mv;
    }

    @GetMapping("/detail/{id}")
    public ModelAndView details(@PathVariable("id") Long id ) {
        ModelAndView mv = new ModelAndView("product/detail");
        Product product = productService.findById(id);
        mv.addObject("product", product);
        return mv;
    }

    @PostMapping("/filter")
    public ModelAndView filter(Filter filter) {
        ModelAndView mv = new ModelAndView("product/products");
        Iterable<Product> listProducts = productService.filter(filter);

        if(listProducts == null) {
            mv.addObject("messageProductList", "notFound");
        } else {
            mv.addObject("messageProductList", "listFound");
            mv.addObject("products", listProducts);

        }
        return mv;
    }

    @GetMapping("/filter")
    public ModelAndView filterGet() {
        ModelAndView mv = new ModelAndView("redirect/all");
        return mv;
    }
}
