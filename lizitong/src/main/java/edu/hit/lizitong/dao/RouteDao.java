package edu.hit.lizitong.dao;

import edu.hit.lizitong.domain.Route;

import java.util.List;

public interface RouteDao {
    public int findTotalCount(int cid);

    public List<Route> findByPage(int cid, int start, int pageSize);
}
