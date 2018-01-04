package com.kxbyyk.chanin.template.model.bean;



/**
 * 版本基本信息
 * @author dyj
 */
public class BbXx {

	private static final long serialVersionUID = -4964409270796425307L;
	private String id;//主键
    private String bblx;//版本类型
    private Integer bbbh;//版本编号
    private String bbmc;//版本名称
    private String fbsk;//发布时刻
    private String gxnr;//更新内容
    private String xzdz;//下载地址
    private String xzmc;//下载名称
    private Integer xzcs;//下载次数
    private Integer azcs;//安装次数
    private String createUserId;//创建人员
    private String createTime;//创建时间
    private String updateUserId;//跟新人员
    private String updateTime;//更新时间
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getBblx() {
        return bblx;
    }

    public void setBblx(String bblx) {
        this.bblx = bblx == null ? null : bblx.trim();
    }

    public Integer getBbbh() {
        return bbbh;
    }

    public void setBbbh(Integer bbbh) {
        this.bbbh = bbbh;
    }

    public String getBbmc() {
        return bbmc;
    }

    public void setBbmc(String bbmc) {
        this.bbmc = bbmc == null ? null : bbmc.trim();
    }

    public String getFbsk() {
        return fbsk;
    }

    public void setFbsk(String fbsk) {
        this.fbsk = fbsk == null ? null : fbsk.trim();
    }

    public String getXzdz() {
        return xzdz;
    }

    public void setXzdz(String xzdz) {
        this.xzdz = xzdz == null ? null : xzdz.trim();
    }

    public String getXzmc() {
        return xzmc;
    }

    public void setXzmc(String xzmc) {
        this.xzmc = xzmc == null ? null : xzmc.trim();
    }

    public Integer getXzcs() {
        return xzcs;
    }

    public void setXzcs(Integer xzcs) {
        this.xzcs = xzcs;
    }

    public Integer getAzcs() {
        return azcs;
    }

    public void setAzcs(Integer azcs) {
        this.azcs = azcs;
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

    public String getGxnr() {
        return gxnr;
    }

    public void setGxnr(String gxnr) {
        this.gxnr = gxnr == null ? null : gxnr.trim();
    }
}