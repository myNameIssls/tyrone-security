package cn.tyrone.security.sys.bean;

/**
 * 系统字典类
 * @author slsadmin
 *
 */
public class SysDict {
	
	/**
	 * 主键
	 */
    private String id;

    /**
	 * 字典类型
	 */
    private String dictTypeKey;

    /**
	 * 字典类型值
	 */
    private String dictTypeValue;

    /**
	 * 字典key
	 */
    private String dictKey;

    /**
	 * 字典值
	 */
    private String dictValue;

    /**
	 * 排序
	 */
    private Integer dictOrderBy;

    /**
	 * 是否可用
     * 【0:可用 1:不可用】
	 */
    private String avilable;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDictTypeKey() {
        return dictTypeKey;
    }

    public void setDictTypeKey(String dictTypeKey) {
        this.dictTypeKey = dictTypeKey;
    }

    public String getDictTypeValue() {
        return dictTypeValue;
    }

    public void setDictTypeValue(String dictTypeValue) {
        this.dictTypeValue = dictTypeValue;
    }

    public String getDictKey() {
        return dictKey;
    }

    public void setDictKey(String dictKey) {
        this.dictKey = dictKey;
    }

    public String getDictValue() {
        return dictValue;
    }

    public void setDictValue(String dictValue) {
        this.dictValue = dictValue;
    }

    public Integer getDictOrderBy() {
        return dictOrderBy;
    }

    public void setDictOrderBy(Integer dictOrderBy) {
        this.dictOrderBy = dictOrderBy;
    }

    public String getAvilable() {
        return avilable;
    }

    public void setAvilable(String avilable) {
        this.avilable = avilable;
    }
}