package org.care.service;

import org.care.domain.ArticlePage;

public interface ListArticleService {

  public ArticlePage getArticlePage(int pageNo, int pageV, String searching) throws Exception;

	
}
