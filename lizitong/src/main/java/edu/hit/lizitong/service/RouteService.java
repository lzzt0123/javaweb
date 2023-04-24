package edu.hit.lizitong.service;

import edu.hit.lizitong.domain.PageBean;
import edu.hit.lizitong.domain.Route;

public interface RouteService {
    public PageBean<Route> pageQuery(int cid,int currentPage,int pageSize);
}
