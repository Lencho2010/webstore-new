package com.geoway.webstore.util;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.Version;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import sun.misc.BASE64Encoder;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Lencho
 * @CreateTime: 2021/11/3 18:17
 * @Description:
 */
public class ExportWordUtil {
    public static void exportWord(Map dataMap, String templatePath, String templateName, String outFilePath, String outFilename) throws IOException, TemplateException {
        //第一步：创建一个Configuration对象，直接new一个对象。构造方法的参数就是freemarker对于的版本号。
        Configuration configuration = new Configuration(Configuration.getVersion());
        //FreeMarkerConfigurer configuration = new FreeMarkerConfigurer();
        // 第二步：设置模板文件所在的路径。
        configuration.setDirectoryForTemplateLoading(new File(templatePath));
        //第三步：设置模板文件使用的字符集。一般就是utf-8.
        configuration.setDefaultEncoding("utf-8");
        // 第四步：加载一个模板，创建一个模板对象。
        Template template = configuration.getTemplate(templateName);
        // 第五步：创建一个模板使用的数据集，可以是pojo也可以是map。一般是Map。

        FileOutputStream fileOutputStream = new FileOutputStream(new File(outFilePath + File.separator + outFilename));
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, "UTF-8");
        Writer outWriter = new BufferedWriter(outputStreamWriter);
        // Writer outWriter = new FileWriter(new File(outFilePath + File.separator + outFilename));

        try {
            template.process(dataMap, outWriter);
        } catch (TemplateException e) {
            e.printStackTrace();
        }

        outWriter.close();
        fileOutputStream.close();
    }

    /**
     * 根据ftl模板导出word文件
     *
     * @param t            实体类
     * @param templateName 模板文件名
     * @param path         导出的word文件路径
     */
    public static <T> void exportWordForFreemarker(T t, String templateName, String path) {
        //Configuration 用于读取ftl文件
        Configuration configuration = new Configuration(new Version("2.3.0"));
        configuration.setDefaultEncoding("utf-8");
        configuration.setClassForTemplateLoading(ExportWordUtil.class, File.separator + "templates");
        Writer out = null;

        try {
            //输出文档路径及名称
            File outFile = new File(path);
            //以utf-8的编码读取ftl文件
            Template template = configuration.getTemplate(File.separator + templateName, "utf-8");

            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile), "utf-8"), 10240);

            template.process(t, out);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e1) {
            e1.printStackTrace();
        } finally {
            try {
                if (out != null) out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 获取图片的Base64位编码
     */
    public static String getImgBase64(String path) {
        InputStream in = null;
        byte[] data = null;
        try {
            in = new FileInputStream(path);
            data = new byte[in.available()];
            in.read(data);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //对字节数组Base64编码
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(data);
    }

    public static void test() {
        Map<String, String> dataMap = new HashMap<>();
        dataMap.put("name", "朵朵");
        dataMap.put("age", "2");
        try {
            Resource classPathResource = new ClassPathResource("templates");
            String path = classPathResource.getFile().getPath();
            File workDirFile = new File("D://test");
            if (!workDirFile.exists()) {
                workDirFile.mkdirs();
            }
            ExportWordUtil.exportWord(dataMap, path, "test.xml", "D://test", "test.docx");
        } catch (IOException | TemplateException e) {
            e.printStackTrace();
        }
    }

    public static void test2() {
        Configuration cfg = new Configuration(Configuration.getVersion());
        try {
            cfg.setDirectoryForTemplateLoading(new File("E:/ftl"));
            Template template = cfg.getTemplate("hello.ftl");
            Map<String, String> map = new HashMap<>();
            map.put("hello", "Hello FreeMarker!");

            StringWriter stringWriter = new StringWriter();
            template.process(map, stringWriter);
            String resultStr = stringWriter.toString();
            System.out.println(resultStr);
        } catch (IOException | TemplateException e) {
            e.printStackTrace();
        }
    }
}
