package sm.springboot.mingleoccean.web.model;

import java.util.Date;

import javax.validation.constraints.Size;

public class File {
	
	private long id;
	private long parentId;
	
	@Size(min=5, message="File name should have minimum of 5 characters")
	private String name;
	
	private String createdBy;
	private Date creationDate;
	private String type;
	
	public File() {}
	
	public File(long id, long parentId, String name, String createdBy, Date creationDate, String type) {
		super();
		this.id = id;
		this.parentId = parentId;
		this.name = name;
		this.createdBy = createdBy;
		this.creationDate = creationDate;
		this.type = type;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getCreatedBy() {
		return createdBy;
	}
	
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
	public Date getCreationDate() {
		return creationDate;
	}
	
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getParentId() {
		return parentId;
	}

	public void setParentId(long parentId) {
		this.parentId = parentId;
	}

	@Override
	public String toString() {
		return "File [id=" + id + ", parentId=" + parentId + ", name=" + name + ", createdBy=" + createdBy
				+ ", creationDate=" + creationDate + ", type=" + type + "]";
	}	
		
}
