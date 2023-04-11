package com.mybatis.exam.real.domain;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

/**
 * @author jinho.oh @date 2020-01-29
 */

@Getter
@Setter
public class BatchGroupDomain {
	long batch_group_id;
	String batch_group_name;
	String activation;
	LocalDateTime start_time;
	LocalDateTime end_time;
	int batch_cycle;
	
	String interval_class;
	int interval_time;
	String batch_user;
}
