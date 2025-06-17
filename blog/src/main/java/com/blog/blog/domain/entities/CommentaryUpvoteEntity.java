package com.blog.blog.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(
    name = "commentary_upvotes",
    uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "commentary_id"})
)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CommentaryUpvoteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id", nullable = false)
    private UserEntity author;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "commentary_id", nullable = false)
    private CommentaryEntity commentary;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CommentaryUpvoteEntity that)) return false;
        return Objects.equals(author, that.author) &&
               Objects.equals(commentary, that.commentary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, commentary);
    }

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

}
