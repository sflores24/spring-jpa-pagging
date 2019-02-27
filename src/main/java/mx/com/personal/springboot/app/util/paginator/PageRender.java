package mx.com.personal.springboot.app.util.paginator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;

public class PageRender<T> {
	private String url;
	private Page<T> page;
	private int totalPages;
	private int numberElementsPerPage;
	private int actualPage;
	private List<PageItem> pages;
	
	public PageRender(String url, Page<T> page) {
		super();
		this.url = url;
		this.page = page;
		this.pages = new ArrayList<PageItem>();
		
		actualPage = page.getNumber() + 1;//Considerando que vamos desde la página 0
		numberElementsPerPage = page.getSize();
		totalPages = page.getTotalPages();
		
		int from, to;
		if(totalPages <= numberElementsPerPage) {
			from = 1;
			to = totalPages;
		} else {
			to = numberElementsPerPage;
			if(actualPage <= numberElementsPerPage/2) {
				from = 1;
			} else if(actualPage >= totalPages - numberElementsPerPage/2){
				from = totalPages - numberElementsPerPage + 1;
			} else {
				from = actualPage - numberElementsPerPage/2;
			}
		}
		
		for(int cont=0; cont < to; cont++) {
			pages.add(new PageItem(from + cont, actualPage == from + cont));
		}
	}

	public String getUrl() {
		return url;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public int getActualPage() {
		return actualPage;
	}

	public List<PageItem> getPages() {
		return pages;
	}
	
	public boolean isFirst() {
		return page.isFirst();
	}
	
	public boolean isLast() {
		return page.isLast();
	}
	
	public boolean isHasNext() {
		return page.hasNext();
	}
	
	public boolean isHasPrevious() {
		return page.hasPrevious();
	}
}
