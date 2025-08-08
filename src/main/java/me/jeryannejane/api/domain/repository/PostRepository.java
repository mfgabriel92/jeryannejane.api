package me.jeryannejane.api.domain.repository;

import me.jeryannejane.api.domain.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface PostRepository extends JpaRepository<Post, UUID> {
    @Query("FROM Post p ORDER BY p.createdAt ASC LIMIT 3")
    List<Post> findLatest3();

    Optional<List<Post>> findBySlug(String slug);
}
