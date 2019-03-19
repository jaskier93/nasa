package cosmic.services;

import cosmic.mappers.TagMapper;
import cosmic.models.Planet;
import cosmic.repositories.TagRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class TagService {

    private TagRepository tagRepository;

    public TagService(TagRepository tagRepository, TagMapper tagMapper) {
        this.tagRepository = tagRepository;
        this.tagMapper = tagMapper;
    }

    private TagMapper tagMapper;

}
