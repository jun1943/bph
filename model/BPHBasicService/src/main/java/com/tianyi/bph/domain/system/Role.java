package com.tianyi.bph.domain.system;

import java.util.Date;
import java.util.List;

public class Role {
    private Integer id;

    //角色名
    private String name;

    //预置0：非预置  1：预置
    private Short preset = 0;

    private Date createTime;

    private String note;
    
    private Long userId;//用户id
    
    private String isCheck;

	public String getIsCheck() {
		return isCheck;
	}

	public void setIsCheck(String isCheck) {
		this.isCheck = isCheck;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	//所拥有权限
    private List<Module> modules;
    
    private List<String> moduleIds;
    

	public List<String> getModuleIds() {
		return moduleIds;
	}

	public void setModuleIds(List<String> moduleIds) {
		this.moduleIds = moduleIds;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Short getPreset() {
        return preset;
    }

    public void setPreset(Short preset) {
        this.preset = preset;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

	public List<Module> getModules() {
		return modules;
	}

	public void setModules(List<Module> modules) {
		this.modules = modules;
	}
}