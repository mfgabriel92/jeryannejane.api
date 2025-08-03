package me.jeryannejane.api.api.controller;

import me.jeryannejane.api.api.response.PostSummaryResponse;
import me.jeryannejane.api.domain.model.Post;
import me.jeryannejane.api.domain.service.PostService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/api/v1/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;
    private final ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<PostSummaryResponse>> findLatest3() {
        var posts = postService.findLatest3();
        var response = map(posts);
        return ok(response);
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
