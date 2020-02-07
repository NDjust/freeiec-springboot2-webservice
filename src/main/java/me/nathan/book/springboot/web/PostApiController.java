package me.nathan.book.springboot.web;

import lombok.RequiredArgsConstructor;
import me.nathan.book.springboot.service.PostsService;
import me.nathan.book.springboot.web.dto.PostsResponseDto;
import me.nathan.book.springboot.web.dto.PostsSaveRequestDto;
import me.nathan.book.springboot.web.dto.PostsUpdateRequestsDto;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostApiController {

    private final PostsService postsService;

    @PutMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestsDto requestDto) {
        return postsService.update(id, requestDto);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById (@PathVariable Long id) {
        return postsService.findById(id);
    }
}
