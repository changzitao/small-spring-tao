package tao.chang.springframework.context;

import tao.chang.springframework.beans.factory.HierarchicalBeanFactory;
import tao.chang.springframework.beans.factory.ListableBeanFactory;
import tao.chang.springframework.core.io.ResourceLoader;


public interface ApplicationContext extends ListableBeanFactory, HierarchicalBeanFactory, ResourceLoader, ApplicationEventPublisher {
}
