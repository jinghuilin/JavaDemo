package util;

public class PageUtil {
	private int pageSize = 4;
	private int pageIndex = 1;
	private int prePageIndex;
	private int nextPageIndex;
	private int totalRecords;
	private int totalPages;
	
	public PageUtil() {}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getPrePageIndex() {
		if(pageIndex > 1){
			prePageIndex = pageIndex -1 ;
		}else{
			prePageIndex = 1;
		}
		return prePageIndex;
	}

	public int getNextPageIndex() {
		if(pageIndex < totalPages){
			nextPageIndex = pageIndex + 1;
		}else{
			nextPageIndex = totalPages;
		}
		return nextPageIndex;
	}

	public int getTotalPages() {
		if(totalRecords%pageSize == 0){
			totalPages = totalRecords/pageSize;
		}else{
			totalPages = totalRecords/pageSize + 1;
		}
		return totalPages;
	}

	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
	}
}
