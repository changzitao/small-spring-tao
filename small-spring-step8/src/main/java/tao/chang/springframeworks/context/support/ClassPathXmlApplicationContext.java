package tao.chang.springframeworks.context.support;

import tao.chang.springframeworks.beans.BeanException;

public class ClassPathXmlApplicationContext extends AbstractXmlApplicationContext {
    private String [] configLocations;
    @Override
    protected String[] getConfigLocations() {


        return configLocations;
    }

    public ClassPathXmlApplicationContext() {
    }

    public ClassPathXmlApplicationContext(String[] configLocations) throws BeanException{
        this.configLocations = configLocations;
        refresh();
    }

    public ClassPathXmlApplicationContext(String configLocations) throws BeanException {
        this(new String[]{configLocations});
    }
}
