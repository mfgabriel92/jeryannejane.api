package me.jeryannejane.api.api.controller;

import lombok.RequiredArgsConstructor;
import me.jeryannejane.api.api.response.PostResponse;
import me.jeryannejane.api.api.response.PostSummaryResponse;
import me.jeryannejane.api.domain.service.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/api/v1/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @GetMapping("latest")
    public ResponseEntity<List<PostSummaryResponse>> findLatest3() {
        var post = postService.findLatest3();
        return ok(post);
    }

    @GetMapping("{slug}")
    public ResponseEntity<List<PostResponse>> findBySlug(@PathVariable String slug) {
        var post = postService.findBySlug(slug);
        return ok(post);
    }
}
