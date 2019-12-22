package org.itstack.demo.infrastructure.repository;

import org.itstack.demo.domain.model.aggregates.UserInfoCollect;
import org.itstack.demo.domain.model.req.UserReq;
import org.itstack.demo.domain.model.vo.UserInfo;
import org.itstack.demo.domain.repostory.IUserRepository;
import org.itstack.demo.infrastructure.dao.IUserDao;
import org.itstack.demo.infrastructure.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 微信公众号：bugstack虫洞栈 | 欢迎关注学习专题案例
 * 论坛：http://bugstack.cn
 * Create by 付政委 on @2019
 */
@Repository("userRepository")
public class UserRepository implements IUserRepository {

    @Resource
    private IUserDao userDao;

    @Override
    public UserInfoCollect queryUserInfoList(UserReq req) {
        Long count = userDao.queryUserInfoCount(req);
        List<User> userList = userDao.queryUserInfoList(req);
        List<UserInfo> userInfoList = new ArrayList<>();
        userList.forEach(user -> {
            UserInfo userInfo = new UserInfo();
            userInfo.setUserId(user.getId());
            userInfo.setName(user.getName());
            userInfo.setAge(user.getAge());
            userInfo.setAddress(user.getAddress());
            userInfo.setEntryTime(user.getEntryTime());
            userInfo.setStatus(user.getStatus());
            userInfoList.add(userInfo);
        });
        return new UserInfoCollect(count, userInfoList);
    }

}
