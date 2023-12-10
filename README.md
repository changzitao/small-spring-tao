# small-spring

setp为不同阶段的创建，alls为全部small-spring的搭建

## 特点：

1. 完成Bean在Spring的完整生命，周期,包括BeanDefinition扫描注册、策略实例化、依赖注入、Aware感知、 后置处理与初始化等,支持Singleton与Prototype两种作用域;
2. 基于观察者模式实现应用事件发布监听功能模块,构建应用事件、广播器与监听者组件实现功能,并发布容器刷新事件;
3. 基于Jdk动态代理实现AOP,根据用户定义的切入点表达式封装通知,创建织入横切逻辑的代理对象以达到对目标类型的AOP功能增强。
4. 使用三级缓存解决循环依赖问题 :设置实例缓存解决单例Bean属性注入时的循环依赖情况，设置第三级缓存对代理对象循环依赖问题的解决提供支持。

## 不足：

  未实现ConfigurationClassPostProcessor（注解配置类注入bean），未实现order.priorityOrder接口，未对postprocessor 进行排序，对propertyvalues的处理放在 postProcessAfterInitialization，
    对增强类的包装在resolveBeforeInstantiation中进行处理，及通知器的排序调用（暂时只支持before）。

## ps:

  后续将对InstantiationAwareBeanPostProcessor的方法进行重构及子类实现，将处理时机进行更正，并提供注解注入（不可刷新的bean容器）将流程进行完善。
