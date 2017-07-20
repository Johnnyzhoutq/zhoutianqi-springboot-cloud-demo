package com.lvmama.pangolin.core;

/**
 * 项目常量
 */
public final class ProjectConstant {
    public static final String BASE_PACKAGE = "com.lvmama.pangolin";//项目基础包名称，根据自己公司的项目修改

    public static final String MODEL_PACKAGE = BASE_PACKAGE + ".entity.hotel";//Model所在包
    public static final String MAPPER_PACKAGE = BASE_PACKAGE + ".mybatis.hotel";//Mapper所在包
    public static final String SERVICE_PACKAGE = BASE_PACKAGE + ".hotel.service";//Service所在包
    public static final String SERVICE_IMPL_PACKAGE = SERVICE_PACKAGE + ".impl";//ServiceImpl所在包
    public static final String CONTROLLER_PACKAGE = BASE_PACKAGE + ".web";//Controller所在包

    public static final String MAPPER_INTERFACE_REFERENCE = BASE_PACKAGE + ".core.Mapper";//Mapper插件基础接口的完全限定名
}
