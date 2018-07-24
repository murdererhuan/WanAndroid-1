package com.allen.wanandroid.api;

import com.allen.library.bean.BaseData;
import com.allen.wanandroid.bean.BannerBean;
import com.allen.wanandroid.bean.CategoryBean;
import com.allen.wanandroid.bean.HomeBean;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * <pre>
 *      @author : Allen
 *      e-mail  : lygttpod@163.com
 *      date    : 2018/07/21
 *      desc    :
 *      version : 1.0
 * </pre>
 */
public interface Apiservice {

    /**
     * 获取首页文章列表
     * @param page
     * @return
     */
    @GET("article/list/{page}/json")
    Observable<BaseData<HomeBean>> getHomeArticleList(@Path("page") int page);

    @GET("article/list/{page}/json")
    Observable<BaseData<HomeBean>> getHomeArticleListWithId(@Path("page") int page, @Query("cid") int id);

    @GET("banner/json")
    Observable<BaseData<List<BannerBean>>> getBanner();

    @GET("tree/json")
    Observable<BaseData<List<CategoryBean>>> getCategoryList();
}
