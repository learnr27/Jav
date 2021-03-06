package com.me.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.me.dto.MovieListBean;
import com.me.service.IMainService;
import com.me.service.ISearchService;

@Controller
@RequestMapping("/search")
public class MainContorller {
	@Autowired
	ISearchService mSearchService;
	
	
	/**
	 * 获取最新的电影
	 * */
	@RequestMapping(value="/last",method=RequestMethod.GET)
	@ResponseBody
	public Object getLastMovieList(@RequestParam("index")int index)
	{
		List<MovieListBean> beans = mSearchService.getLastMovieList(index);
		return beans;
	}
	
	/**
	 * 根据关键字搜索电影
	 * */
	@RequestMapping("/search")
	@ResponseBody
	public Object getMovieListByKey(@RequestParam("index")int index,@RequestParam("order")int order,@RequestParam("key")String key){
		List<MovieListBean> beans = mSearchService.getMovieLstByKey(index, order,key);
		return beans;
	}
	
	/**
	 * 根据电影的类型搜索电影
	 * 
	 * */
	@RequestMapping("/type")
	@ResponseBody
	public List<MovieListBean> getMovieListByType(@RequestParam("index")int index,@RequestParam("order")int order,@RequestParam("type")String type){
		List<MovieListBean> beans = mSearchService.getMovieListByType(index, order,type);
		return beans;
	}
	
	
	/**根据电影导演搜索电影*/
	@RequestMapping("/director")
	@ResponseBody
	public Object getMovieListByDirector(@RequestParam("index")int index,@RequestParam("order")int order,@RequestParam("director")String director){
		List<MovieListBean> beans = mSearchService.getMovieListByDirector(index, order,director);
		return beans;
	}
	
	
	/**根据电影演员搜索电影*/
	@RequestMapping("/actor")
	@ResponseBody
	public Object getMovieListByActor(@RequestParam("index")int index,@RequestParam("order")int order,@RequestParam("actor")String actor){
		List<MovieListBean> beans = mSearchService.getMovieListByActor(index, order,actor);
		return beans;
	}
	
	
	
	/**根据时间段搜索电影*/
	@RequestMapping("/time")
	@ResponseBody
	public Object getMovieListByTime(@RequestParam("index")int index,@RequestParam("order")int order,@RequestParam("time")String time){
		List<MovieListBean> beans = mSearchService.getMovieListByTime(index, order,time);
		return beans;
	}
	
	
	
	/**根据评分查看电影*/
	@RequestMapping("/rating")
	@ResponseBody
	public Object getMovieListByRating(@RequestParam("index")int index,@RequestParam("order")int order,@RequestParam("rating")String rating){
		int ra = Integer.valueOf(rating);
		List<MovieListBean> beans = mSearchService.getMovieListByRating(index, order,ra);
		return beans;
	}
	
	
	/**综合查询*/
	@RequestMapping("/group")
	@ResponseBody
	public Object getMovieListByGroup(@RequestParam("index")int index,@RequestParam("order")int order
			,@RequestParam(value="key",required=false)String key
			,@RequestParam(value="type",required=false)String type
			,@RequestParam(value="time",required=false)String time
			,@RequestParam(value="actor",required=false)String actor
			,@RequestParam(value="director",required=false)String director,
			@RequestParam(value="rating",required=false)String rating){
		
		List<MovieListBean> beans = mSearchService.getMovieListByGroup(index, order,key,actor,director,time,
				rating,type);
		return beans;
	}
	

	
	
	
	
	
}
