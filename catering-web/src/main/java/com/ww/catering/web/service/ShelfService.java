package com.ww.catering.web.service;

import com.ww.catering.web.common.ResponseDTO;
import com.ww.catering.web.common.ReturnCode;
import com.ww.catering.web.dao.ShelfMapper;
import com.ww.catering.web.dao.model.ShelfModel;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wei.wang
 * @version 2018年3月25日10:04:09
 */
@Service
public class ShelfService {

    @Resource
    ShelfMapper shelfMapper;

    public ResponseDTO<String> insert(ShelfModel shelfModel) {

        ResponseDTO<String> responseDTO = new ResponseDTO<>(ReturnCode.ACTIVE_FAILURE);
        try {
            int insert = shelfMapper.insert(shelfModel);
            if (insert > 0) {
                responseDTO.setReturnCode(ReturnCode.ACTIVE_SUCCESS);
            }
        } catch (Exception e) {
            e.printStackTrace();
            responseDTO.setReturnCode(ReturnCode.ACTIVE_EXCEPTION);
        }
        return responseDTO;
    }

    public ResponseDTO<String> updateAgree(String uid, long rid, int agree) {

        ResponseDTO<String> responseDTO = new ResponseDTO<>(ReturnCode.ACTIVE_FAILURE);
        try {
            int updateAgree = shelfMapper.updateAgree(uid, rid, agree);
            if (updateAgree > 0) {
                responseDTO.setReturnCode(ReturnCode.ACTIVE_SUCCESS);
            }
        } catch (Exception e) {
            e.printStackTrace();
            responseDTO.setReturnCode(ReturnCode.ACTIVE_EXCEPTION);
        }
        return responseDTO;
    }

    public ResponseDTO<String> updateShelf(String uid, long rid, int shelf) {

        ResponseDTO<String> responseDTO = new ResponseDTO<>(ReturnCode.ACTIVE_FAILURE);
        try {
            int updateShelf = shelfMapper.updateShelf(uid, rid, shelf);
            if (updateShelf > 0) {
                responseDTO.setReturnCode(ReturnCode.ACTIVE_SUCCESS);
            }
        } catch (Exception e) {
            e.printStackTrace();
            responseDTO.setReturnCode(ReturnCode.ACTIVE_EXCEPTION);
        }
        return responseDTO;
    }

    public ResponseDTO<ShelfModel> selectByUidAndRid(String uid, long rid) {

        ResponseDTO<ShelfModel> responseDTO = new ResponseDTO<>(ReturnCode.ACTIVE_FAILURE);

        try {
            ShelfModel shelfModels = shelfMapper.selectByUidAndRid(uid, rid);
            responseDTO.setAttach(shelfModels);
            responseDTO.setReturnCode(ReturnCode.ACTIVE_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            responseDTO.setReturnCode(ReturnCode.ACTIVE_EXCEPTION);
        }
        return responseDTO;
    }

    public ResponseDTO<List<ShelfModel>> selectByUid(String uid) {

        ResponseDTO<List<ShelfModel>> responseDTO = new ResponseDTO<>(ReturnCode.ACTIVE_FAILURE);

        try {
            List<ShelfModel> shelfModels = shelfMapper.selectByUid(uid);
            responseDTO.setAttach(shelfModels);
            responseDTO.setReturnCode(ReturnCode.ACTIVE_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            responseDTO.setReturnCode(ReturnCode.ACTIVE_EXCEPTION);
        }
        return responseDTO;
    }
}
