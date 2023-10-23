package com.cg.neel.igrs.users.utils;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.cg.neel.igrs.utils.Utils;

/**
 * @author Ankush
 *
 */

@MappedSuperclass
public abstract class DateAudit {

	@CreatedDate
	@Column(name = "CREATED_AT", nullable = false, updatable = false)
	protected Date createdAt=Utils.getDate();

	@LastModifiedDate
	@Column(name = "UPDATED_AT")
	protected LocalDateTime updatedAt;
	
	@Column(name="OPTCOUNTER")
	protected int optCounter;
	
	@PrePersist
	public void prePersist() {
		this.updatedAt = Utils.getLocalDateTime();
		//this.optCounter= Utils.getCounter();
	}

	@PreUpdate
	public void preUpdate() {
		this.updatedAt = Utils.getLocalDateTime();
		//this.optCounter= Utils.getCounter();
	}

	
}
