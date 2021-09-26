package example.restapi.dto;

import java.util.List;

public class CustomPageResponse <T>  {
	List<T> data;
	Page pageInfo;
	public CustomPageResponse(List<T> data, int pageSize, int pageNumber) {
		this.data = data;
		this.pageInfo = new Page(pageSize, pageNumber);
	}
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
	public Page getPageInfo() {
		return pageInfo;
	}
	public void setPageInfo(Page pageInfo) {
		this.pageInfo = pageInfo;
	}
	
}


class Page {
	int size;
	int number;
	public Page(int s, int n) {
		this.size =s;
		this.number =n;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getSize() {
		return size;
	}
	public int getNumber() {
		return number;
	}
	
}
