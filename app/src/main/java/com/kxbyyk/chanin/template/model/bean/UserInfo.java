package com.kxbyyk.chanin.template.model.bean;

import java.util.ArrayList;


/**
 * 用户基本信息
 * @author dyj
 */
public class UserInfo  {

    private static final long serialVersionUID = 5868922611733870505L;
    private String userId; //用户主键
    private String roleId; //角色主键
    private String yhbh; //用户编号
    private String yhxm; //用户姓名
    private String yhsp; //用户首拼
    private String yhbz; //用户备注
    private String sfzh; //身份证号
    private String lxdh; //联系电话
    private String dlzh; //登录账号
    private String dlmm; //登录密码
    private String scdlip; //上次登录IP
    private String scdlsj; //上次登录时间
    private String bcdlip; //本次登录IP
    private String bcdlsj; //本次登录时间
    private String manageSymbol; //管理标志
    private String deleteStatus; //删除状态
    private String createUserId; //创建人员
    private String createTime; //创建时间
    private String updateUserId; //更新人员
    private String updateTime; //更新时间
    //------------------------
  	//业务逻辑使用属性
  	//------------------------

    
    
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }


    public String getYhbh() {
        return yhbh;
    }

    public void setYhbh(String yhbh) {
        this.yhbh = yhbh == null ? null : yhbh.trim();
    }

    public String getYhxm() {
        return yhxm;
    }

    public void setYhxm(String yhxm) {
        this.yhxm = yhxm == null ? null : yhxm.trim();
    }

    public String getYhsp() {
        return yhsp;
    }

    public void setYhsp(String yhsp) {
        this.yhsp = yhsp == null ? null : yhsp.trim();
    }

    public String getYhbz() {
        return yhbz;
    }

    public void setYhbz(String yhbz) {
        this.yhbz = yhbz == null ? null : yhbz.trim();
    }


    public String getSfzh() {
        return sfzh;
    }

    public void setSfzh(String sfzh) {
        this.sfzh = sfzh == null ? null : sfzh.trim();
    }

    public String getLxdh() {
        return lxdh;
    }

    public void setLxdh(String lxdh) {
        this.lxdh = lxdh == null ? null : lxdh.trim();
    }

    public String getDlzh() {
        return dlzh;
    }

    public void setDlzh(String dlzh) {
        this.dlzh = dlzh == null ? null : dlzh.trim();
    }

    public String getDlmm() {
        return dlmm;
    }

    public void setDlmm(String dlmm) {
        this.dlmm = dlmm == null ? null : dlmm.trim();
    }

    public String getScdlip() {
        return scdlip;
    }

    public void setScdlip(String scdlip) {
        this.scdlip = scdlip == null ? null : scdlip.trim();
    }

    public String getScdlsj() {
        return scdlsj;
    }

    public void setScdlsj(String scdlsj) {
        this.scdlsj = scdlsj == null ? null : scdlsj.trim();
    }

    public String getBcdlip() {
        return bcdlip;
    }

    public void setBcdlip(String bcdlip) {
        this.bcdlip = bcdlip == null ? null : bcdlip.trim();
    }

    public String getBcdlsj() {
        return bcdlsj;
    }

    public void setBcdlsj(String bcdlsj) {
        this.bcdlsj = bcdlsj == null ? null : bcdlsj.trim();
    }

    public String getManageSymbol() {
        return manageSymbol;
    }

    public void setManageSymbol(String manageSymbol) {
        this.manageSymbol = manageSymbol == null ? null : manageSymbol.trim();
    }



    public String getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(String deleteStatus) {
        this.deleteStatus = deleteStatus == null ? null : deleteStatus.trim();
    }

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId == null ? null : createUserId.trim();
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    public String getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(String updateUserId) {
        this.updateUserId = updateUserId == null ? null : updateUserId.trim();
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime == null ? null : updateTime.trim();
    }


    
    String json = "{" +
            "  \"code\": \"1000\"," +
            "  \"data\": {" +
            "    \"userId\": \"2\"," +
            "    \"roleId\": \"/\"," +
            "    \"yhlx\": {" +
            "      \"dictId\": \"63653357add24274933ca736c19b99f3\"," +
            "      \"dictCode\": \"1029-0001\"," +
            "      \"dictName\": \"普通\"," +
            "      \"dictPiny\": \"pt\"," +
            "      \"dictSort\": 1," +
            "      \"redactSymbol\": \"1025-0001\"," +
            "      \"enableStatus\": \"1001-0003\"," +
            "      \"deleteStatus\": \"1003-0001\"," +
            "      \"createUserId\": \"1\"," +
            "      \"createTime\": \"2017-04-11 15:00:00\"," +
            "      \"updateUserId\": \"1\"," +
            "      \"updateTime\": \"2017-04-11 15:00:00\"," +
            "      \"dictType\": {" +
            "        \"typeCode\": \"1029\"" +
            "      }" +
            "    }," +
            "    \"yhbh\": \"1\"," +
            "    \"yhxm\": \"张三\"," +
            "    \"yhsp\": \"zs\"," +
            "    \"yhbz\": \"有钱\"," +
            "    \"yhxb\": {" +
            "      \"dictCode\": \"男\"" +
            "    }," +
            "    \"sfzh\": \"110101198506020011\"," +
            "    \"lxdh\": \"15281012555\"," +
            "    \"dlzh\": \"zs\"," +
            "    \"dlmm\": \"1\"," +
            "    \"scdlip\": \"10.64.1.30\"," +
            "    \"scdlsj\": \"2017-06-30 11:38:27\"," +
            "    \"bcdlip\": \"10.64.1.22\"," +
            "    \"bcdlsj\": \"2017-06-30 14:09:19\"," +
            "    \"manageSymbol\": \"1029-0001\"," +
            "    \"enableStatus\": {" +
            "      \"dictId\": \"414181b0987f4fdfa4bc4082996196aa\"," +
            "      \"dictCode\": \"1001-0003\"," +
            "      \"dictName\": \"已启用\"," +
            "      \"dictPiny\": \"yqy\"," +
            "      \"dictSort\": 1," +
            "      \"redactSymbol\": \"1025-0001\"," +
            "      \"enableStatus\": \"1001-0003\"," +
            "      \"deleteStatus\": \"1003-0001\"," +
            "      \"createUserId\": \"1\"," +
            "      \"createTime\": \"2017-04-11 15:00:00\"," +
            "      \"updateUserId\": \"1\"," +
            "      \"updateTime\": \"2017-04-11 15:00:00\"," +
            "      \"dictType\": {" +
            "        \"typeCode\": \"1001\"" +
            "      }" +
            "    }," +
            "    \"deleteStatus\": \"1003-0001\"," +
            "    \"createUserId\": \"1\"," +
            "    \"createTime\": \"2017-06-30 14:00:00\"," +
            "    \"updateUserId\": \"1\"," +
            "    \"updateTime\": \"2017-06-30 14:00:00\"," +
            "    \"yz\": {" +
            "      \"id\": \"aaa782ca8e214f51b3506fd89daaaafe\"," +
            "      \"mc\": \"永丰立交桥加油站\"," +
            "      \"sp\": \"yfljqjyz\"," +
            "      \"dz\": \"永丰立交桥\"," +
            "      \"bz\": \"\"," +
            "      \"lxry\": \"林长春\"," +
            "      \"lxdh\": \"13888888888\"" +
            "    }," +
            "    \"yps\": [" +
            "      {" +
            "        \"id\": \"ee54a4d7dba643dbae41e29e65ad6d94\"," +
            "        \"zl\": {" +
            "          \"dictId\": \"fe6bc61869cf4e30aa59b6847c40f670\"," +
            "          \"dictCode\": \"2037-0001\"," +
            "          \"dictName\": \"汽油\"," +
            "          \"dictPiny\": \"qy\"," +
            "          \"dictSort\": 1," +
            "          \"redactSymbol\": \"1025-0001\"," +
            "          \"enableStatus\": \"1001-0003\"," +
            "          \"deleteStatus\": \"1003-0001\"," +
            "          \"createUserId\": \"1\"," +
            "          \"createTime\": \"2017-04-11 15:00:00\"," +
            "          \"updateUserId\": \"1\"," +
            "          \"updateTime\": \"2017-04-11 15:00:00\"," +
            "          \"dictType\": {" +
            "            \"typeCode\": \"2037\"" +
            "          }" +
            "        }," +
            "        \"bh\": 92," +
            "        \"deleteStatus\": \"1003-0001\"," +
            "        \"createUserId\": \"1\"," +
            "        \"createUserName\": \"超级管理员\"," +
            "        \"createTime\": \"2017-06-30 15:14:23\"," +
            "        \"updateUserId\": \"1\"," +
            "        \"updateUserName\": \"超级管理员\"," +
            "        \"updateTime\": \"2017-06-30 15:14:23\"" +
            "      }," +
            "      {" +
            "        \"id\": \"2c8f9f204d5c4b558b5b9a564bfa673b\"," +
            "        \"zl\": {" +
            "          \"dictId\": \"fe6bc61869cf4e30aa59b6847c40f670\"," +
            "          \"dictCode\": \"2037-0001\"," +
            "          \"dictName\": \"汽油\"," +
            "          \"dictPiny\": \"qy\"," +
            "          \"dictSort\": 1," +
            "          \"redactSymbol\": \"1025-0001\"," +
            "          \"enableStatus\": \"1001-0003\"," +
            "          \"deleteStatus\": \"1003-0001\"," +
            "          \"createUserId\": \"1\"," +
            "          \"createTime\": \"2017-04-11 15:00:00\"," +
            "          \"updateUserId\": \"1\"," +
            "          \"updateTime\": \"2017-04-11 15:00:00\"," +
            "          \"dictType\": {" +
            "            \"typeCode\": \"2037\"" +
            "          }" +
            "        }," +
            "        \"bh\": 95," +
            "        \"deleteStatus\": \"1003-0001\"," +
            "        \"createUserId\": \"1\"," +
            "        \"createUserName\": \"超级管理员\"," +
            "        \"createTime\": \"2017-06-30 15:14:31\"," +
            "        \"updateUserId\": \"1\"," +
            "        \"updateUserName\": \"超级管理员\"," +
            "        \"updateTime\": \"2017-06-30 15:14:31\"" +
            "      }," +
            "      {" +
            "        \"id\": \"db1d32d2bede4665a1b106f3b3d86241\"," +
            "        \"zl\": {" +
            "          \"dictId\": \"fe6bc61869cf4e30aa59b6847c40f670\"," +
            "          \"dictCode\": \"2037-0001\"," +
            "          \"dictName\": \"汽油\"," +
            "          \"dictPiny\": \"qy\"," +
            "          \"dictSort\": 1," +
            "          \"redactSymbol\": \"1025-0001\"," +
            "          \"enableStatus\": \"1001-0003\"," +
            "          \"deleteStatus\": \"1003-0001\"," +
            "          \"createUserId\": \"1\"," +
            "          \"createTime\": \"2017-04-11 15:00:00\"," +
            "          \"updateUserId\": \"1\"," +
            "          \"updateTime\": \"2017-04-11 15:00:00\"," +
            "          \"dictType\": {" +
            "            \"typeCode\": \"2037\"" +
            "          }" +
            "        }," +
            "        \"bh\": 93," +
            "        \"deleteStatus\": \"1003-0001\"," +
            "        \"createUserId\": \"1\"," +
            "        \"createUserName\": \"超级管理员\"," +
            "        \"createTime\": \"2017-06-30 15:14:43\"," +
            "        \"updateUserId\": \"1\"," +
            "        \"updateUserName\": \"超级管理员\"," +
            "        \"updateTime\": \"2017-06-30 15:14:43\"" +
            "      }," +
            "      {" +
            "        \"id\": \"5b3c005061d84851857be92af67600dc\"," +
            "        \"zl\": {" +
            "          \"dictId\": \"fe6bc61869cf4e30aa59b6847c40f670\"," +
            "          \"dictCode\": \"2037-0001\"," +
            "          \"dictName\": \"汽油\"," +
            "          \"dictPiny\": \"qy\"," +
            "          \"dictSort\": 1," +
            "          \"redactSymbol\": \"1025-0001\"," +
            "          \"enableStatus\": \"1001-0003\"," +
            "          \"deleteStatus\": \"1003-0001\"," +
            "          \"createUserId\": \"1\"," +
            "          \"createTime\": \"2017-04-11 15:00:00\"," +
            "          \"updateUserId\": \"1\"," +
            "          \"updateTime\": \"2017-04-11 15:00:00\"," +
            "          \"dictType\": {" +
            "            \"typeCode\": \"2037\"" +
            "          }" +
            "        }," +
            "        \"bh\": 97," +
            "        \"deleteStatus\": \"1003-0001\"," +
            "        \"createUserId\": \"1\"," +
            "        \"createUserName\": \"超级管理员\"," +
            "        \"createTime\": \"2017-06-30 15:14:48\"," +
            "        \"updateUserId\": \"1\"," +
            "        \"updateUserName\": \"超级管理员\"," +
            "        \"updateTime\": \"2017-06-30 15:14:48\"" +
            "      }," +
            "      {" +
            "        \"id\": \"5691c43d36a74a0b96605efe1a9842c6\"," +
            "        \"zl\": {" +
            "          \"dictId\": \"fe6bc61869cf4e30aa59b6847c40f670\"," +
            "          \"dictCode\": \"2037-0001\"," +
            "          \"dictName\": \"汽油\"," +
            "          \"dictPiny\": \"qy\"," +
            "          \"dictSort\": 1," +
            "          \"redactSymbol\": \"1025-0001\"," +
            "          \"enableStatus\": \"1001-0003\"," +
            "          \"deleteStatus\": \"1003-0001\"," +
            "          \"createUserId\": \"1\"," +
            "          \"createTime\": \"2017-04-11 15:00:00\"," +
            "          \"updateUserId\": \"1\"," +
            "          \"updateTime\": \"2017-04-11 15:00:00\"," +
            "          \"createUserId\": \"1\"," +
            "          \"createUserName\": \"超级管理员\"," +
            "          \"createTime\": \"2017-06-30 15: 14: 53\"," +
            "          \"updateUserId\": \"1\"," +
            "          \"updateUserName\": \"超级管理员\"," +
            "          \"updateTime\": \"2017-06-30 15: 16: 42\"" +
            "        }," +
            "        {" +
            "          \"id\": \"b568dba573ad482a86f6ee859713b5ea\"," +
            "          \"zl\": {" +
            "            \"dictId\": \"b23007dc2a054c62bb2e72efc75318d3\"," +
            "            \"dictCode\": \"2037-0003\"," +
            "            \"dictName\": \"柴油\"," +
            "            \"dictPiny\": \"cy\"," +
            "            \"dictSort\": 1," +
            "            \"redactSymbol\": \"1025-0001\"," +
            "            \"enableStatus\": \"1001-0003\"," +
            "            \"deleteStatus\": \"1003-0001\"," +
            "            \"createUserId\": \"1\"," +
            "            \"createTime\": \"2017-04-11 15: 00: 00\"," +
            "            \"updateUserId\": \"1\"," +
            "            \"updateTime\": \"2017-04-11 15: 00: 00\"," +
            "            \"dictType\": {" +
            "              \"typeCode\": \"2037\"" +
            "            }" +
            "          }," +
            "          \"bh\": 90," +
            "          \"deleteStatus\": \"1003-0001\"," +
            "          \"createUserId\": \"1\"," +
            "          \"createUserName\": \"超级管理员\"," +
            "          \"createTime\": \"2017-06-30 15: 14: 58\"," +
            "          \"updateUserId\": \"1\"," +
            "          \"updateUserName\": \"超级管理员\"," +
            "          \"updateTime\": \"2017-06-30 15: 14: 58\"" +
            "        }" +
            "      ]" +
            "    }" +
            "  }";
}