package com.melcoc.bluewhale.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

public class BaseController<GreatRepository, ArticleRepository> {
    private final GreatRepository greatRepository;
    private final ArticleRepository articleRepository;
    //Spring团队推荐的做法是用构造器来引入依赖，而不是直接使用@Autowired引入
    @Autowired
    public BaseController(GreatRepository greatRepository,
                          ArticleRepository articleRepository) {
        this.greatRepository = greatRepository;
        this.articleRepository=articleRepository;
    }

//    @RequestMapping({"/","/index"})
//    public String index(){
//        return "index";
//    }

}
