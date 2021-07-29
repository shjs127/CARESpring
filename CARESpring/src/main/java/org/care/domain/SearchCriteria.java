package org.care.domain;

import lombok.Data;

@Data
public class SearchCriteria extends Criteria{

	private String keyword;
	private String orderBy;
}
