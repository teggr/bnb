package com.robintegg.bnb.db;

import java.util.Date;

//@MappedSuperclass
//@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {

//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

//	@CreatedDate
//	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;

//	@LastModifiedDate
//	@Temporal(TemporalType.TIMESTAMP)
	private Date lastModifiedDate;

	public Long getId() {
		return id;
	}

	protected void setId(Long id) {
		this.id = id;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

}
