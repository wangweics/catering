package com.ww.catering.web.service;

import com.ww.catering.web.common.ResponseDTO;
import com.ww.catering.web.common.ReturnCode;
import com.ww.catering.web.dao.CategoryMapper;
import com.ww.catering.web.dao.model.CategoryModel;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wei.wang
 * @version 2018年3月25日10:04:09
 */
@Service
public class CategoryService {

    @Resource
    CategoryMapper categoryMapper;


    public ResponseDTO<List<CategoryModel>> selectAll() {

        ResponseDTO<List<CategoryModel>> responseDTO = new ResponseDTO<>(ReturnCode.ACTIVE_FAILURE);

        try {
            List<CategoryModel> resourceModels = categoryMapper.selectAll();
            responseDTO.setAttach(resourceModels);
            responseDTO.setReturnCode(ReturnCode.ACTIVE_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            responseDTO.setReturnCode(ReturnCode.ACTIVE_EXCEPTION);
        }
        return responseDTO;
    }
}
