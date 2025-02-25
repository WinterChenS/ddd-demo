package com.baiyan.ddd.core.user.domain.model;

import cn.hutool.core.collection.CollUtil;
import com.baiyan.ddd.base.model.ddd.AggregateRoot;
import com.baiyan.ddd.base.model.result.BaseUuidEntity;
import com.baiyan.ddd.core.infrastructure.repository.po.RolePO;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 用户聚合根
 *
 * @author baiyan
 */
@Getter
@NoArgsConstructor
public class User extends BaseUuidEntity implements AggregateRoot {

    /**
     * 用户名
     */
    private String userName;

    /**
     * 用户真实名称
     */
    private String realName;

    /**
     * 用户手机号
     */
    private String phone;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 用户地址
     */
    private Address address;

    /**
     * 用户单位
     */
    private Unit unit;

    /**
     * 角色
     */
    private List<Role> roles;

    public User(String userName, String realName, String phone, String password) {
        this.userName = userName;
        this.realName = realName;
        this.phone = phone;
        this.password = password;
    }

    /**
     * 根据角色id设置角色信息
     *
     * @param roleIds 角色id
     */
    public void bindRoleByRoleId(List<Long> roleIds){
        this.roles = roleIds.stream()
                .map(roleId->new Role(roleId,null,null))
                .collect(Collectors.toList());
    }

    /**
     * 设置角色信息
     *
     * @param roles
     */
    public void bindRoleByRolePo(List<RolePO> roles){
        if(CollUtil.isEmpty(roles)){
            return;
        }
        this.roles = roles.stream()
                .map(e->new Role(e.getId(),e.getCode(),e.getName()))
                .collect(Collectors.toList());
    }

    /**
     * 设置用户地址信息
     *
     * @param province 省
     * @param city 市
     * @param county 区
     */
    public void bindAddress(String province,String city,String county){
        this.address = new Address(province,city,county);
    }

    /**
     * 设置用户单位信息
     *
     * @param unitId
     * @param unitName
     */
    public void bindUnit(Long unitId,String unitName){
        this.unit = new Unit(unitId,unitName);
    }

}
