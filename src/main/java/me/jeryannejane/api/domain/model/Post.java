package me.jeryannejane.api.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.OffsetDateTime;
import java.util.UUID;

import static jakarta.persistence.GenerationType.AUTO;

@Entity
@Table(name = "posts")
@Getter
@Setter
public class Post {
    @Id
    @GeneratedValue(strategy = AUTO)
    private UUID id;

    private String title;

    private String slug;

    private String content;

    @CreationTimestamp
    private OffsetDateTime createdAt;

    @UpdateTimestamp
    private OffsetDateTime updatedAt;
}
