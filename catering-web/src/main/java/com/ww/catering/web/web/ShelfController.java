package com.ww.catering.web.web;

import com.ww.catering.web.common.ResponseDTO;
import com.ww.catering.web.common.ReturnCode;
import com.ww.catering.web.dao.model.ResourceModel;
import com.ww.catering.web.dao.model.ShelfModel;
import com.ww.catering.web.service.ShelfService;
import com.ww.catering.web.service.ResourceService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wei.wang
 * @version 2018年3月25日10:04:09
 */

@Controller
@RequestMapping("/shelf")
public class ShelfController {

    @Resource
    ShelfService shelfService;

    @Resource
    ResourceService resourceService;

    @ResponseBody
    @RequestMapping(value = "/updateAgree", method = {RequestMethod.GET, RequestMethod.POST})
    public ResponseDTO<String> updateAgree(String uid, long rid) {

        ResponseDTO<String> responseDTO = shelfService.updateAgree(uid, rid, 1);
        return responseDTO;
    }

    @ResponseBody
    @RequestMapping(value = "/updateShelf", method = {RequestMethod.GET, RequestMethod.POST})
    public ResponseDTO<String> updateShelf(String uid, long rid) {

        ResponseDTO<String> responseDTO = shelfService.updateShelf(uid, rid, 1);
        return responseDTO;
    }

    @ResponseBody
    @RequestMapping(value = "/selectByUidAndRid", method = {RequestMethod.GET, RequestMethod.POST})
    public ResponseDTO<ShelfModel> selectByUidAndRid(String uid, long rid) {

        ResponseDTO<ShelfModel> responseDTO = shelfService.selectByUidAndRid(uid, rid);
        return responseDTO;
    }

    @ResponseBody
    @RequestMapping(value = "/selectShelfByUid", method = {RequestMethod.GET, RequestMethod.POST})
    public ResponseDTO<List<Object>> selectByUid(String uid) {

        ResponseDTO<List<Object>> result = new ResponseDTO<>(ReturnCode.ACTIVE_FAILURE);

        ResponseDTO<List<ShelfModel>> responseDTO = shelfService.selectByUid(uid);

        if (responseDTO.getCode() == ReturnCode.ACTIVE_SUCCESS.code()) {
            List<Object> objects = new ArrayList<>();

            for (ShelfModel shelfModel : responseDTO.getAttach()) {
                if (shelfModel.getShelf() > 0) {

                    ResponseDTO<ResourceModel> resourceModelResponseDTO = resourceService.selectById(shelfModel.getRid());

                    if (resourceModelResponseDTO.getCode() == ReturnCode.ACTIVE_SUCCESS.code()) {
                        Map<String, Object> map = new HashMap<>(3);
                        map.put("isAgree", shelfModel.getAgree());
                        map.put("isShelf", shelfModel.getShelf());
                        map.put("data", resourceModelResponseDTO.getAttach());
                        objects.add(map);
                    }
                }
            }
            result.setReturnCode(ReturnCode.ACTIVE_SUCCESS);
            result.setAttach(objects);
        }
        return result;
    }
}
