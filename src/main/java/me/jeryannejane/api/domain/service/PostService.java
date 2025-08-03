package me.jeryannejane.api.domain.service;

import me.jeryannejane.api.domain.model.Post;
import me.jeryannejane.api.domain.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public List<Post> findLatest3() {
        return postRepository.findLatest3();
    }
}
