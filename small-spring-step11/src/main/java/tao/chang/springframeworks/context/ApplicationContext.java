package tao.chang.springframeworks.context;


import tao.chang.springframeworks.beans.factory.HierarchicalBeanFactory;
import tao.chang.springframeworks.beans.factory.ListableBeanFactory;
import tao.chang.springframeworks.core.io.ResourceLoader;

public interface ApplicationContext extends ListableBeanFactory, HierarchicalBeanFactory, ResourceLoader, ApplicationEventPublisher {

}
