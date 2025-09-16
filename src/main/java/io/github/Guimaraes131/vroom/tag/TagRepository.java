package io.github.Guimaraes131.vroom.tag;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TagRepository extends JpaRepository<Tag, UUID> {
    boolean existsByCoordinate(String coordinate);
}
