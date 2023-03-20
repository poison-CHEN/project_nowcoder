package com.nowcoder.community;

import com.nowcoder.community.util.MailClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

/**
 * @author Sukie
 * @description
 * @create 2023-03-17 10:31
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class MailTests {
    @Autowired
    private MailClient mailClient;

    @Autowired
    private TemplateEngine templateEngine;

    @Test
    public void testTextMail()
    {
        mailClient.sendmail("18255668042@163.com", "Test","你好，自己人");

    }

    @Test
    public void testHtmlMail()
    {
        //先填充值
        Context context = new Context();
        context.setVariable("username", "sunday");
        //模板引擎生成动态网页
        String content = templateEngine.process("/mail/demo.html", context);
        System.out.println(content);

        mailClient.sendmail("18255668042@163.com", "Test2", content);
    }
}
