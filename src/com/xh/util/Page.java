package com.xh.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.github.miemiedev.mybatis.paginator.domain.Order;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

public class Page {
	private int start = 0;
	private int length = 20;

	private List<OrderBy> orders = new ArrayList<OrderBy>();

	public Page() {

	}

	/**
	 * 
	 * @param start
	 *            从start个数据项开始
	 * @param length
	 *            页面数据条数 默认20
	 */
	public Page(int start, int length) {
		this.start = start;
		this.length = length;
	}

	public int getLimit() {
		return length;
	}

	public int getOffset() {
		return start;
	}

	public PageBounds toPageBounds() {
		PageBounds pageBounds = new PageBounds(start / length + 1, length);
		for (OrderBy order : orders) {
			if (StringUtils.isNotBlank(order.getColumn())) {
				pageBounds.getOrders().add(Order.create(order.getColumn(), order.getBy()));
			}
		}
		return pageBounds;
	}

	public List<OrderBy> getOrders() {
		return orders;
	}

	public void setOrders(List<OrderBy> orders) {
		this.orders = orders;
	}
}
