package sanha.book.haha.web;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import sanha.book.haha.service.posts.PostsService;

@Controller
public class indexController {

    private final PostsService postsService;

    public indexController(PostsService postsService) {
        this.postsService = postsService;
    }


    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("posts",postsService.findAllDesc());
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave(){
        return "/posts-save";
    }


}
