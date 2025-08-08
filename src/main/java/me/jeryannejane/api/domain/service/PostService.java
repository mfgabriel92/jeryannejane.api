package me.jeryannejane.api.domain.service;

import lombok.RequiredArgsConstructor;
import me.jeryannejane.api.api.response.PostResponse;
import me.jeryannejane.api.api.response.PostSummaryResponse;
import me.jeryannejane.api.domain.exception.EntityNotFoundException;
import me.jeryannejane.api.domain.model.Post;
import me.jeryannejane.api.domain.repository.PostRepository;
import org.modelmapper.ModelMapper;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final ModelMapper mapper;

    @Cacheable(value = "latest-posts", keyGenerator = "customKeyGenerator")
    public List<PostSummaryResponse> findLatest3() {
        var posts = postRepository.findLatest3();
        return map(posts);
    }

    @Cacheable(value = "post", keyGenerator = "customKeyGenerator")
    public List<PostResponse> findBySlug(String slug) {
        var post = findOrFail(slug);
        return post.stream().map(p -> mapper.map(p, PostResponse.class)).toList();
    }

    private List<Post> findOrFail(String slug) {
        return postRepository
            .findBySlug(slug)
            .orElseThrow(EntityNotFoundException::new);
    }

    private PostSummaryResponse map(Post post) {
        return mapper.map(post, PostSummaryResponse.class);
    }

    private List<PostSummaryResponse> map(List<Post> posts) {
        return posts.stream()
            .map(this::map)
            .toList();
    }
}
