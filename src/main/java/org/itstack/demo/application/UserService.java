package org.itstack.demo.application;

import org.itstack.demo.domain.model.aggregates.UserInfoCollect;
import org.itstack.demo.domain.model.req.UserReq;

/**
 * 微信公众号：bugstack虫洞栈 | 欢迎关注学习专题案例
 * 论坛：http://bugstack.cn
 * Create by 付政委 on @2019
 */
public interface UserService {

    UserInfoCollect queryUserInfoList(UserReq req);

}
