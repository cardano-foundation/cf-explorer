package com.sotatek.cardanocommonapi.pagination;

import com.sotatek.cardanocommonapi.enums.ESortType;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Pagination {

  private Integer page;

  private Integer size;

  private Map<String, ESortType> sorts;
}
