package sanha.book.haha.web;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sanha.book.haha.web.dto.HelloResponseDto;

@RestController
public class HelloController {

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name, @RequestParam("amount") int amount){
        System.out.println("hello/dto");
        return new HelloResponseDto(name,amount);
    }

}
