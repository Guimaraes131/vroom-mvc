package io.github.Guimaraes131.vroom.tag;

import io.github.Guimaraes131.vroom.exception.InvalidOperationException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TagService {

    private final TagRepository repository;

    public void create(Tag tag) {
        if (tag.getIsAvailable()) {
            tag.setColor(null);
        }

        repository.save(tag);
    }

    public Optional<Tag> get(UUID id) {
        return repository.findById(id);
    }

    public void delete(Tag tag) {
        if (!tag.isDeletable()) {
            throw new InvalidOperationException("Cannot delete a Tag that is being used.");
        }

        repository.delete(tag);
    }

    public List<Tag> index(String color) {
        Tag tag = new Tag();
        tag.setColor(color);

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnoreNullValues()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.EXACT);

        Example<Tag> example = Example.of(tag, matcher);

        return repository.findAll(example);
    }
}
