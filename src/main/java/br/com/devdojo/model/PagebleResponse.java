package br.com.devdojo.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import br.com.devdojo.util.CustomSortDeserializer;


public class PagebleResponse<T> extends PageImpl<T> {

	private static final long serialVersionUID = 8525158060252030184L;

    private boolean last;
    private boolean first;
    private int totalPages;

    public PagebleResponse(@JsonProperty("content") List<T> content,
                            @JsonProperty("number") int page,
                            @JsonProperty("size") int size,
                            @JsonProperty("totalElements") long totalElements,
                            @JsonProperty("sort") @JsonDeserialize(using = CustomSortDeserializer.class)
                                    Sort sort) {
        super(content, PageRequest.of(page, size,sort), totalElements);
    }

    public PagebleResponse() {
        super(new ArrayList<>());
    }

    @Override
    public boolean isLast() {
        return last;
    }

    public void setLast(boolean last) {
        this.last = last;
    }

    @Override
    public boolean isFirst() {
        return first;
    }

    public void setFirst(boolean first) {
        this.first = first;
    }

    @Override
    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }
}
