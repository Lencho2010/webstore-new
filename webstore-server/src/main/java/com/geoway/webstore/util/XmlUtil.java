package com.geoway.webstore.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.util.StringUtil;
import org.dom4j.*;
import org.dom4j.io.OutputFormat;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.List;

/**
 * @Author: Lencho
 * @CreateTime: 2021/11/4 19:27
 * @Description:
 */
public class XmlUtil {
    public static OutputFormat xmlFormat() {
        OutputFormat xmlFormat = OutputFormat.createPrettyPrint();
        xmlFormat.setEncoding("gb2312");
        // 设置换行
        xmlFormat.setNewlines(true);
        // 生成缩进
        xmlFormat.setIndent(true);
        // 使用4个空格进行缩进, 可以兼容文本编辑器
        xmlFormat.setIndent("    ");
        return xmlFormat;
    }

    public static JSONObject xml2Json(String xmlStr) {
        Document doc = xml2Doc(xmlStr);
        JSONObject json = new JSONObject();
        dom4j2Json(doc.getRootElement(), json);
        return json;
    }

    public static Document xml2Doc(String xmlStr) {
        Document doc;
        try {
            doc = DocumentHelper.parseText(xmlStr);
        } catch (DocumentException e) {
            throw new RuntimeException("xml解析失败:" + e.getMessage());
        }
        return doc;
    }


    private static void dom4j2Json(Element element, JSONObject json) {
        //如果是属性
        for (Object o : element.attributes()) {
            Attribute attr = (Attribute) o;
            if (!StringUtil.isEmpty(attr.getValue())) {
                json.put("@" + attr.getName(), attr.getValue());
            }
        }
        List<Element> chdEl = element.elements();
        //如果没有子元素,只有一个值
        if (chdEl.isEmpty() && !StringUtil.isEmpty(element.getText())) {
            json.put(element.getName(), element.getText());
        }
        //有子元素
        for (Element e : chdEl) {
            //子元素也有子元素
            if (!e.elements().isEmpty()) {
                JSONObject chdjson = new JSONObject();
                dom4j2Json(e, chdjson);
                Object o = json.get(e.getName());
                if (o != null) {
                    JSONArray jsona = null;
                    //如果此元素已存在,则转为jsonArray
                    if (o instanceof JSONObject) {
                        JSONObject jsono = (JSONObject) o;
                        json.remove(e.getName());
                        jsona = new JSONArray();
                        jsona.add(jsono);
                        jsona.add(chdjson);
                    } else if (o instanceof JSONArray) {
                        jsona = (JSONArray) o;
                        jsona.add(chdjson);
                    }
                    json.put(e.getName(), jsona);
                } else {
                    if (!chdjson.isEmpty()) {
                        json.put(e.getName(), chdjson);
                    }
                }
            } else {
                //子元素没有子元素
                for (Object o : e.attributes()) {
                    Attribute attr = (Attribute) o;
                    if (!StringUtil.isEmpty(attr.getValue())) {
                        json.put("@" + attr.getName(), attr.getValue());
                    }
                }
                if (!e.getText().isEmpty()) {
                    json.put(e.getName(), e.getText());
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> T fromXml(String xmlString, Class<T> clazz) throws JAXBException {
        return  (T) JAXBContext.newInstance(clazz)
                .createUnmarshaller()
                .unmarshal(new StringReader(xmlString.trim()));
    }


    public static String toXmlString(Object obj, String encoding) {
        String result = null;
        try {
            JAXBContext context = JAXBContext.newInstance(obj.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.setProperty(Marshaller.JAXB_ENCODING, encoding);
            StringWriter writer = new StringWriter();
            marshaller.marshal(obj, writer);
            result =writer.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
