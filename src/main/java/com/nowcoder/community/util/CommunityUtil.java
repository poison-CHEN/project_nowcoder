package com.nowcoder.community.util;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.DigestUtils;

import java.security.DigestException;
import java.util.UUID;

/**
 * @author Sukie
 * @description
 * @create 2023-03-19 15:15
 */
public class CommunityUtil {

    //生成随机字符串作为激活码，生成图片的名字
    public static String generateUUID()
    {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    //MD5加密，保存密码进数据库的时候，对密码进行一个加密操作，MD5只能加密不能解密
    public static String md5(String key)
    {
        if(StringUtils.isBlank(key))
            return null;
        else
            return DigestUtils.md5DigestAsHex(key.getBytes());
    }
}
