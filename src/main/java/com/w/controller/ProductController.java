package com.w.controller;

import com.w.common.entity.StateCode;
import com.w.domain.Product;
import com.w.service.ProductService;
import com.w.common.entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassNameProductController
 * @Description
 * @Author ANGLE0
 * @Date2019/11/14 9:07
 * @Version V1.0
 **/
@CrossOrigin
@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

//    @RequestMapping("/update.do")
    @RequestMapping(value = "/{proID}", method = RequestMethod.PUT)
    @ResponseBody
    public Result updateProduct(@PathVariable("proID") int proID, @RequestBody Product product) throws Exception {
        product.setPro_ID(proID);
        int result = productService.updateProduct(product);
        if(result == 1){
            return Result.getUpdateSuccessData();
        }
        return Result.getUpdateFailedData();
    }

//    @RequestMapping("/add.do")
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Result addProduct(Product product) throws Exception {
        int result = productService.addProduct(product);
        if (result == 1){
            return Result.getAddSuccessData();
        }
        return Result.getAddFailedData();
    }

//    @RequestMapping("/del.do")
    @RequestMapping(value = "/{productID}", method = RequestMethod.DELETE)
    @ResponseBody
    public Result deleteProduct(@PathVariable("productID") int productID) throws Exception {
        int result = productService.deleteProduct(productID);
        if (result == 1){
            return Result.getDeleteSuccessData();
        }
        return Result.getDeleteFailedData();
    }

//    @RequestMapping("/findAll.do")
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Result findAll() throws Exception {
        List productList = productService.findAllProduct();
        return new Result(StateCode.SUCCESS, "获取数据成功", productList);
    }
}
