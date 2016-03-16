package com.urjamitra.cluster.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="CLUSTER_MASTER")
public class ClusterDO {

	@Id
	@Column(name="CLUSTER_ID")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="my_seq_gen")
	@SequenceGenerator(name="my_seq_gen",sequenceName="USER_ID_SEQ")
	private long clusterId;
	
	
	@Column(name="CLUSTER_NAME")
	private String clusterName;
	
	
}
