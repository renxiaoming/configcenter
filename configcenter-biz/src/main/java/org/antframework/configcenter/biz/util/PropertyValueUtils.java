/* 
 * 作者：钟勋 (e-mail:zhongxunking@163.com)
 */

/*
 * 修订记录:
 * @author 钟勋 2018-12-08 23:41 创建
 */
package org.antframework.configcenter.biz.util;

import org.antframework.boot.core.Contexts;
import org.antframework.common.util.facade.FacadeUtils;
import org.antframework.configcenter.facade.api.PropertyValueService;
import org.antframework.configcenter.facade.info.PropertyValueInfo;
import org.antframework.configcenter.facade.order.FindAppProfilePropertyValuesOrder;
import org.antframework.configcenter.facade.result.FindAppProfilePropertyValuesResult;

import java.util.List;

/**
 * 配置value工具类
 */
public class PropertyValueUtils {
    // 配置value服务
    private static final PropertyValueService PROPERTY_VALUE_SERVICE = Contexts.getApplicationContext().getBean(PropertyValueService.class);

    /**
     * 查找应用在指定环境的所有配置value
     *
     * @param appId     应用id
     * @param profileId 环境id
     * @return 配置value
     */
    public static List<PropertyValueInfo> findAppProfilePropertyValues(String appId, String profileId) {
        FindAppProfilePropertyValuesOrder order = new FindAppProfilePropertyValuesOrder();
        order.setAppId(appId);
        order.setProfileId(profileId);

        FindAppProfilePropertyValuesResult result = PROPERTY_VALUE_SERVICE.findAppProfilePropertyValues(order);
        FacadeUtils.assertSuccess(result);
        return result.getPropertyValues();
    }
}