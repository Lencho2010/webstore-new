package com.geoway.webstore.util;

import com.geoway.webstore.entity.TransportTemplate;
import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Lencho
 * @CreateTime: 2021/11/4 21:17
 * @Description:
 */
public class Transport {
    public static String transform(TransportTemplate transportTemplate) {
        try {
            //定义StringTemplateLoader
            StringTemplateLoader loader = new StringTemplateLoader();
            loader.putTemplate("content", transportTemplate.getTemplate());

            //定义Configuration
            Configuration configuration = new Configuration(Configuration.getVersion());
            configuration.setTemplateLoader(loader);

            //定义Template
            Template tpl = configuration.getTemplate("content");

            StringWriter writer = new StringWriter();
            tpl.process(transportTemplate.getTemplateMap(), writer);
            return writer.toString();
        } catch (Exception e) {
            return null;
        }
    }

    //test
    /*public static void main(String[] args) {
        TransportTemplate template = new TransportTemplate();
        template.setTemplate("${name},今年${age}岁，身高${high ! 'unknown'}");
        Map<String, String> map = new HashMap<String, String>();
        map.put("name", "周思承");
        map.put("age", "26");
        template.setTemplateMap(map);
        String transform = Transport.transform(template);
        System.out.println(transform);
    }*/
    public static void main(String[] args) {
        TransportTemplate template = new TransportTemplate();
        template.setTemplate("${user.name},今年${user.age}岁，身高${user.high ! 'unknown'}");
        Map<String, String> map = new HashMap<String, String>();
        map.put("name", "周思承");
        map.put("age", "26");
        Map<String, Object> finalMap = new HashMap<>();
        finalMap.put("user", map);
        template.setTemplateMap(finalMap);
        String transform = Transport.transform(template);
        System.out.println(transform);
    }
}
