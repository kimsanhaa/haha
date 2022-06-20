package sanha.book.haha.service.posts;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sanha.book.haha.domain.posts.Posts;
import sanha.book.haha.domain.posts.PostsRepository;
import sanha.book.haha.web.dto.PostsResponseDto;
import sanha.book.haha.web.dto.PostsSaveRequestDto;
import sanha.book.haha.web.dto.PostsUpdateRequestDto;

import javax.transaction.Transactional;
@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto){
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto){
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() ->new IllegalArgumentException("해당 게시글이 없습니다. id="+id));

            posts.update(requestDto.getTitle(),requestDto.getContent());

            return id;
    }

    public PostsResponseDto findById(Long id){
        Posts entity = postsRepository.findById(id).orElseThrow(()-> new IllegalArgumentException(("해당 게시글이 없습니다. id="+id)));
        return new PostsResponseDto(entity);
    }
}
