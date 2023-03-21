package tao.chang.springframeworks.beans.factory.xml;

import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.XmlUtil;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import tao.chang.springframeworks.beans.BeanException;
import tao.chang.springframeworks.beans.PropertyValue;
import tao.chang.springframeworks.beans.factory.config.BeanDefinition;
import tao.chang.springframeworks.beans.factory.config.BeanReference;
import tao.chang.springframeworks.beans.factory.support.AbstractBeanDefinitionReader;
import tao.chang.springframeworks.beans.factory.support.BeanDefinitionRegistry;
import tao.chang.springframeworks.core.io.Resource;
import tao.chang.springframeworks.core.io.ResourceLoader;

import javax.sql.rowset.spi.XmlReader;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Documented;

public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader {
    public XmlBeanDefinitionReader(BeanDefinitionRegistry beanDefinitionRegistry) {
        super(beanDefinitionRegistry);
    }

    public XmlBeanDefinitionReader(BeanDefinitionRegistry beanDefinitionRegistry, ResourceLoader resourceLoader) {
        super(beanDefinitionRegistry, resourceLoader);
    }

    @Override
    public void loadBeanDefinitions(Resource resource) throws BeanException {
        try {
            try (InputStream inputStream = resource.getInputStream()) {
                doLoadBeanDefinitions(inputStream);
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException("IOException parsing XML document from" + resource, e);
        }
    }

    @Override
    public void loadBeanDefinitions(Resource... resources) throws BeanException {
        for (Resource resource : resources) {
            loadBeanDefinitions(resource);
        }
    }

    @Override
    public void loadBeanDefinitions(String location) throws BeanException {
        ResourceLoader resourceLoader = getResource();
        Resource resource = resourceLoader.getResource(location);
        loadBeanDefinitions(resource);
    }

    protected void doLoadBeanDefinitions(InputStream inputStream) throws ClassNotFoundException {
        Document documented = XmlUtil.readXML(inputStream);
        Element root = documented.getDocumentElement();
        NodeList childNodes = root.getChildNodes();

        for(int i=0;i<childNodes.getLength();i++){

            if(!(childNodes.item(i) instanceof Element))continue;

            if(! "bean".equals(childNodes.item(i).getNodeName()))continue;

            Element bean = (Element) childNodes.item(i);
            String id = bean.getAttribute("id");
            String  name = bean.getAttribute("name");
            String  className = bean.getAttribute("class");
            Class<?> clazz = Class.forName(className);
            String beanName = StrUtil.isNotEmpty(id)?id:name;
            if(StrUtil.isEmpty(beanName)){
                beanName = StrUtil.lowerFirst(clazz.getSimpleName());

            }

            BeanDefinition beanDefinition = new BeanDefinition(clazz);
            for(int j=0;j<bean.getChildNodes().getLength();j++){
                if(!(bean.getChildNodes().item(j) instanceof Element))continue;
                if(! "property".equals(bean.getChildNodes().item(j).getNodeName()))continue;
                Element property = (Element) bean.getChildNodes().item(j);
                String attrName = property.getAttribute("name");
                String attrValue = property.getAttribute("value");
                String attrRef = property.getAttribute("ref");
                Object value = StrUtil.isNotEmpty(attrRef)? new BeanReference(attrRef) :attrValue;
                PropertyValue propertyValue = new PropertyValue(attrName,value);
                beanDefinition.getPropertyValues().addPropertyValue(propertyValue);

            }


            if(getRegistry().containsBeanDefinition(beanName)){
                throw  new BeanException("Duplicate beanName ["+beanName+"] is not allowed");
            }
            getRegistry().registryBeanDefinition(beanName,beanDefinition);
        }
    }
}
