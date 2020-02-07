package me.nathan.book.springboot.service.posts;

import lombok.RequiredArgsConstructor;
import me.nathan.book.springboot.domain.posts.Posts;
import me.nathan.book.springboot.domain.posts.PostsRepository;
import me.nathan.book.springboot.web.dto.PostsResponseDto;
import me.nathan.book.springboot.web.dto.PostsSaveRequestDto;
import me.nathan.book.springboot.web.dto.PostsUpdateRequestsDto;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestsDto requestDto) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id)
                .orElseThrow(() -> new
                        IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        return new PostsResponseDto(entity);
    }

}
