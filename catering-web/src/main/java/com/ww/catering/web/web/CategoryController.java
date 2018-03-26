package com.ww.catering.web.web;

import com.ww.catering.web.common.ResponseDTO;
import com.ww.catering.web.dao.model.CategoryModel;
import com.ww.catering.web.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wei.wang
 * @version 2018年3月26日10:04:09
 */

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Resource
    CategoryService categoryService;


    @ResponseBody
    @RequestMapping(value = "/getAll", method = {RequestMethod.GET, RequestMethod.POST})
    public ResponseDTO<List<CategoryModel>> getAll() {

        ResponseDTO<List<CategoryModel>> responseDTO = categoryService.selectAll();
        return responseDTO;
    }
}
