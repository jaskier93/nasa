package cosmic.mappers;

import cosmic.commons.Mapper;
import cosmic.models.Tag;
import cosmic.models.dtos.TagDto;
import org.springframework.stereotype.Component;

@Component
public class TagMapper implements Mapper<Tag, TagDto> {

    @Override
    public TagDto map(Tag from) {
        return null;
    }

    @Override
    public Tag revers(TagDto to) {
        return null;
    }

}
