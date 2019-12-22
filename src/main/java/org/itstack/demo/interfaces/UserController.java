package org.itstack.demo.interfaces;

import com.alibaba.fastjson.JSON;
import org.itstack.demo.application.UserService;
import org.itstack.demo.domain.model.aggregates.UserInfoCollect;
import org.itstack.demo.domain.model.req.UserReq;
import org.itstack.demo.infrastructure.common.EasyResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 微信公众号：bugstack虫洞栈 | 欢迎关注学习专题案例
 * 论坛：http://bugstack.cn
 * Create by 付政委 on @2019
 */
@Controller
@RequestMapping("/api/user/")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Resource
    private UserService userService;

    @RequestMapping(path = "queryUserInfoList", method = RequestMethod.GET)
    @ResponseBody
    public EasyResult queryUserInfoList(String json, String page, String limit) {
        try {
            logger.info("查询用户信息列表开始。json：{}", json);
            UserReq req = JSON.parseObject(json, UserReq.class);
            if (null == req) req = new UserReq();
            req.setPage(page, limit);
            UserInfoCollect userInfoCollect = userService.queryUserInfoList(req);
            logger.info("查询用户信息列表完成。userInfoCollect：{}", JSON.toJSONString(userInfoCollect));
            return EasyResult.buildEasyResultSuccess(userInfoCollect.getCount(), userInfoCollect.getUserInfoList());
        } catch (Exception e) {
            logger.error("查询用户信息列表失败。json：{}", json, e);
            return EasyResult.buildEasyResultError(e);
        }
    }

}
