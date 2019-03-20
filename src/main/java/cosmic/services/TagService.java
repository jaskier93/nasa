package cosmic.services;

import cosmic.mappers.TagMapper;
import cosmic.models.dtos.TagDto;
import cosmic.repositories.TagRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TagService {

    private TagRepository tagRepository;

    public TagService(TagRepository tagRepository, TagMapper tagMapper) {
        this.tagRepository = tagRepository;
        this.tagMapper = tagMapper;
    }

    private TagMapper tagMapper;

    public List<TagDto> getTags() {
        return tagRepository
                .findAll()
                .stream()
                .map(tagMapper::map)
                .collect(Collectors.toList());
    }

}
