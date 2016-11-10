package com.palm.lingcai.controller.futian;

import com.google.common.collect.Maps;
import com.palm.lingcai.entity.futian.*;
import com.palm.lingcai.service.futian.*;
import com.palm.lingcai.util.CookieHelper;
import com.palm.lingcai.util.LcbJson;


import com.palm.lingcai.util.ReadExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 福田汽车相关接口
 * Created by nzhmac on 16/9/5.
 */
@Controller
@RequestMapping("futian")
public class FutianController {

    @Autowired
    FutianUserImgService futianUserImgService;
    @Autowired
    FutianProvinceService futianProvinceService;
    @Autowired
    FutianCityService futianCityService;
    @Autowired
    FutianDealerInfoService futianDealerInfoService;
    @Autowired
    FutianUserInfoService futianUserInfoService;

    /**
     * 福田汽车首页跳转地址
     * @return
     */
    @RequestMapping("ftindex.html")
    public String ftindex(HttpSession session, @RequestParam(value = "channelId", required = false) Integer channelId, HttpServletRequest request, HttpServletResponse response){
        if(channelId == null){
            String ftCid = CookieHelper.getValue(request, "ft_cid");
            CookieHelper.addCookie(response, "ft_cid", StringUtils.isEmpty(ftCid)? "": ftCid, 31536000);
        } else {
            CookieHelper.addCookie(response, "ft_cid", channelId.toString(), 31536000);
        }

        String v = request.getParameter("v");
        if(!StringUtils.isEmpty(v)){
            session.setAttribute("v", v);
        }
        return "futian/ftindex";
    }

    /**
     * 福田汽车报名跳转地址
     * @return
     */
    @RequestMapping("signup.html")
    public String signup(HttpSession session, @RequestParam(value = "channelId", required = false) Integer channelId, HttpServletRequest request, HttpServletResponse response){

        if(channelId == null){
            String ftCid = CookieHelper.getValue(request, "ft_cid");
            CookieHelper.addCookie(response, "ft_cid", StringUtils.isEmpty(ftCid)? "": ftCid, 31536000);
        } else {
            CookieHelper.addCookie(response, "ft_cid", channelId.toString(), 31536000);
        }

        String v = request.getParameter("v");
        if(!StringUtils.isEmpty(v)){
            session.setAttribute("v", v);
        }
        return "futian/signup";
    }

    /**
     * 福田汽车获取省市接口
     * @param type city:城市  province:省
     * @param provinceId
     * @return
     */
    @ResponseBody
    @RequestMapping("getPCInfo.json")
    public String getPCInfo(@RequestParam("type") String type, @RequestParam(value = "provinceId", required = false) Integer provinceId){
        Map<String, Object> searchParam = Maps.newHashMap();
        Map<String, Object> reMap = Maps.newHashMap();
        if("city".equals(type) && provinceId != null){
            searchParam.put("provinceId", provinceId);
            List<FutianCity> fcs = futianCityService.search(searchParam);
            reMap.put("clist", fcs);
        } else if("province".equals(type)){
            List<FutianProvince> fps = futianProvinceService.search(searchParam);
            reMap.put("plist", fps);
        }
        return LcbJson.toJSONString(reMap);
    }

    /**
     * 根据城市获取经常商列表信息接口
     * @param cityId
     * @return
     */
    @ResponseBody
    @RequestMapping("getDealer.json")
    public String getDealer(@RequestParam("cityId") Integer cityId, @RequestParam(value = "carType", defaultValue = "") String carType){
        Map<String, Object> searchParam = Maps.newHashMap();
        Map<String, Object> reMap = Maps.newHashMap();
        searchParam.put("city", cityId);
        if(!StringUtils.isEmpty(carType)){
            searchParam.put("carType", carType+";");
        }
        List<FutianDealerInfo> fdis = futianDealerInfoService.search(searchParam);
        reMap.put("list", fdis);
        return LcbJson.toJSONString(reMap);
    }

    /**
     * 保存用户报名信息接口
     * @param request
     * @param fui
     * @return
     */
    @ResponseBody
    @RequestMapping("saveSignup.json")
    public String saveSignup(HttpServletRequest request, HttpServletResponse response, FutianUserInfo fui){
        Map<String, Object> reMap = Maps.newHashMap();
        if(fui.getUname() == null || fui.getMobile() == null || fui.getProvince() == null || fui.getCity() == null ||
                fui.getCarType() == null || fui.getBrand() == null || fui.getDealerId() == null){
            reMap.put("result", false);
            reMap.put("msg", "请求参数异常，请认真填写后提交！");
        }else{
            try {
                String ftCid = CookieHelper.getValue(request, "ft_cid");
                fui.setChannelId(StringUtils.isEmpty(ftCid)? null: Integer.valueOf(ftCid));
                fui.setCreateTime(new Date());
                futianUserInfoService.insert(fui);
                CookieHelper.addCookie(response, "ft_uid", StringUtils.isEmpty(fui.getId()) ? "" : fui.getId().toString(), 31536000);
                CookieHelper.addCookie(response, "ft_did", StringUtils.isEmpty(fui.getDealerId())? "": fui.getDealerId().toString(), 31536000);
                reMap.put("result", true);
                reMap.put("msg", "信息保存成功！");
            } catch (NumberFormatException e) {
                reMap.put("result", false);
                reMap.put("msg", "信息保存异常，请及时与我们联系！");
                e.printStackTrace();
            }
        }
        return LcbJson.toJSONString(reMap);
    }

    /**
     * 福田汽车上传发票跳转地址
     * @return
     */
    @RequestMapping("upload.html")
    public String upload(){
        return "futian/upload";
    }

    /**
     * 用户保存发票图片信息接口
     * @param img
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping("saveUserImg.json")
    public String saveUserImg(@RequestParam("img") String img, HttpServletRequest request){
        Map<String, Object> reMap = Maps.newHashMap();
        try {
            FutianUserImg fui = new FutianUserImg();
            fui.setIfUse(0);
            fui.setImg(img);
            String ftCid = CookieHelper.getValue(request, "ft_cid");
            fui.setChannelId(StringUtils.isEmpty(ftCid)? null: Integer.valueOf(ftCid));
            String ftDid = CookieHelper.getValue(request, "ft_did");
            fui.setDealerId(StringUtils.isEmpty(ftDid)? null: Integer.valueOf(ftDid));
            String ftUid = CookieHelper.getValue(request, "ft_uid");
            fui.setUserId(StringUtils.isEmpty(ftUid)? null: Integer.valueOf(ftUid));
            fui.setCreateTime(new Date());
            futianUserImgService.insert(fui);
            reMap.put("result", true);
            reMap.put("msg", "信息保存成功！");
        } catch (NumberFormatException e) {
            reMap.put("result", false);
            reMap.put("msg", "信息保存异常，请及时与我们联系！");
            e.printStackTrace();
        }
        return LcbJson.toJSONString(reMap);
    }

    /**
     * 后台查看列表
     * @param model
     * @return
     */
    @RequestMapping("adminList.html")
    public String adminList(Model model){
        List<Map<String, Object>> list = futianUserInfoService.adminList();
        model.addAttribute("list", list);
        return "futian/adminList";
    }

    /**
     * 后台查看上传图片列表
     * @param model
     * @return
     */
    @RequestMapping("adminImgList.html")
    public String adminImgList(Model model){
        List<Map<String, Object>> list = futianUserImgService.adminImgList();
        model.addAttribute("list", list);
        return "futian/adminImgList";
    }

    /**
     * 经销商信息初始化使用
     * @return
     */
    @ResponseBody
    @RequestMapping("initDealerInfo")
    public String initDealerInfo(){
        List<Map<String, Object>> list = null;
        Map<Integer, String> param = Maps.newHashMap();
        param.put(0, "province");
        param.put(1, "city");
        param.put(2, "dealerName");
        param.put(4, "clientCity");
        param.put(5, "address");
        param.put(6, "tel");
        String carType = "时代";
        try {
            list = new ReadExcelUtil().readExcel("/Users/nzhmac/时代瑞沃经销商（金刚驳运）.xls", param);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (list != null) {
            for(Map<String, Object> map: list){
                if(map.get("province").toString().equals("省份")){
                    continue;
                }
                Map<String, Object> searchParam = Maps.newHashMap();
                searchParam.put("dealerName", map.get("dealerName").toString());
                List<FutianDealerInfo> reList = futianDealerInfoService.search(searchParam);
                FutianDealerInfo futianDealerInfo = null;
                if (reList.size() == 1){
                    futianDealerInfo = reList.get(0);
                    futianDealerInfo.setCarType(StringUtils.isEmpty(futianDealerInfo.getCarType())? carType+";": futianDealerInfo.getCarType().indexOf(carType+";") == -1? futianDealerInfo.getCarType()+carType+";": futianDealerInfo.getCarType());
                    futianDealerInfoService.update(futianDealerInfo);
                }
                if(reList.size() == 0){
                    futianDealerInfo = new FutianDealerInfo();
                    System.out.println("======= 经销商不存在 ===="+map.get("dealerName"));
                    futianDealerInfo.setCarType(carType + ";");
                    futianDealerInfo.setDealerName(map.get("dealerName").toString());
                    futianDealerInfo.setAddress(map.get("address").toString());
                    futianDealerInfo.setTel(map.get("tel").toString());
                    Map<String, Object> searchParam1 = Maps.newHashMap();
                    searchParam1.put("province", map.get("province").toString());
                    List<FutianProvince> fp = futianProvinceService.search(searchParam1);
                    FutianProvince sfp = null;
                    if (fp.size() == 1){
                        sfp = fp.get(0);
                    }
                    if(fp.size() == 0){
                        sfp = new FutianProvince();
                        sfp.setProvince(map.get("province").toString());
                        futianProvinceService.insert(sfp);
                    }

                    searchParam1.put("city", map.get("city").toString());
                    List<FutianCity> fc = futianCityService.search(searchParam1);
                    FutianCity sfc = null;
                    if (fc.size() == 1){
                        sfc = fc.get(0);
                    }
                    if(fc.size() == 0){
                        sfc = new FutianCity();
                        sfc.setProvinceId(sfp.getId());
                        sfc.setCity(map.get("city").toString());
                        futianCityService.insert(sfc);
                    }
                    futianDealerInfo.setClientCity(sfc.getId());
                    futianDealerInfo.setProvince(sfp.getId());
                    futianDealerInfo.setCity(sfc.getId());
                    futianDealerInfoService.insert(futianDealerInfo);
                }
            }


        }
        return null;
    }
}
