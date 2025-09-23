package io.github.Guimaraes131.vroom.motorcycle;


import io.github.Guimaraes131.vroom.motorcycle.dto.MotorcycleForm;
import io.github.Guimaraes131.vroom.motorcycle.enums.ProblemCategory;
import io.github.Guimaraes131.vroom.tag.Tag;
import io.github.Guimaraes131.vroom.tag.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MotorcycleService {

    private final MotorcycleRepository repository;
    private final TagRepository tagRepository;

    public Motorcycle toEntity(MotorcycleForm dto) {
        Tag tag = tagRepository.findById(dto.getTagId())
                .orElseThrow(() -> new RuntimeException("Tag não encontrada"));

        return Motorcycle.builder()
                .model(dto.getModel())
                .problemDescription(dto.getProblemDescription())
                .problem(dto.getProblem())
                .chassis(dto.getChassis())
                .licensePlate(dto.getLicensePlate())
                .tag(tag)
                .build();
    }

    public void create(Motorcycle motorcycle) {
        motorcycle.getTag().setIsAvailable(false);
        motorcycle.getTag().setColor(motorcycle.getProblem().getAssociatedColor());

        repository.save(motorcycle);
    }

    public Optional<Motorcycle> get(UUID id) {
        return repository.findById(id);
    }

    public void delete(Motorcycle motorcycle) {
        motorcycle.getTag().setIsAvailable(true);
        motorcycle.getTag().setColor(null);
        repository.delete(motorcycle);
    }

    public List<Motorcycle> index(ProblemCategory problem) {
        Motorcycle motorcycle = new Motorcycle();
        motorcycle.setProblem(problem);

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.EXACT)
                .withIgnoreNullValues();

        Example<Motorcycle> example = Example.of(motorcycle, matcher);

        return repository.findAll(example);
    }

    public void update(Motorcycle motorcycle) {
        motorcycle.getTag().setColor(motorcycle.getProblem().getAssociatedColor());
        repository.save(motorcycle);
    }
}
