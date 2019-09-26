package com.cg.contService.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import com.fasterxml.jackson.annotation.JsonFormat;


public class Provision {
		
		@EmbeddedId
		private Composite key;

		public Composite getKey() {
			return key;
		}

		public void setKey(Composite key) {
			this.key = key;
		}
		
		@Transient
		private long timestamp;

		public long getTimestamp() {
			return getKey().getPeriodo().getTime();
		}

		public void setTimestamp(long timestamp) {
			this.timestamp = timestamp;
		}
		
	}
