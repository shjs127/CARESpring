package org.care.domain;

import java.util.List;

import lombok.Data;

@Data
public class SearchCriteria extends Criteria{

	private String keyword;
	private String orderBy;
	private List<String> valChk;
}
