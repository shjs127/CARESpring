package org.care.domain;

import java.util.List;

public class ArticlePage {

	private int total;
	private int currentPage;
	private List<BoardInfo> list;
	private List<BoardPicInfo> picList;
	private int totalPages;
	private int startPage;
	private int endPage;
	private int pageV = 10;
	

	public ArticlePage(int total, int currentPage, int size, List<BoardInfo> list) {
		this.total = total;
		this.currentPage = currentPage;
		this.list = list;
		this.pageV = size;
		if (total == 0) {
			totalPages = 0;
			startPage = 0;
			endPage = 0;
		} else {
			totalPages = total / size;
			if (total % size > 0) {
				totalPages++;
			}
			int modVal = currentPage % 5;
			startPage = currentPage / 5 * 5 + 1;
			if (modVal == 0)
				startPage -= 5;

			endPage = startPage + 4;
			if (endPage > totalPages)
				endPage = totalPages;
		}
	}

	public ArticlePage(List<BoardPicInfo> picList) {
		this.picList = picList;
	}

	public int getTotal() {
		return total;
	}

	public boolean hasNoArticles() {
		return total == 0;
	}

	public boolean hasArticles() {
		return total > 0;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public List<BoardInfo> getList() {
		return list;
	}

	public int getStartPage() {
		return startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public int getPageV() {
		return pageV;
	}

	public List<BoardPicInfo> getPicList() {
		return picList;
	}

	public void setPicList(List<BoardPicInfo> picList) {
		this.picList = picList;
	}

}
