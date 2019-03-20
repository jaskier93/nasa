package cosmic.mappers;

import cosmic.commons.Mapper;
import cosmic.models.Planet;
import cosmic.models.Tag;
import cosmic.models.dtos.TagDto;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class TagMapper implements Mapper<Tag, TagDto> {

    @Override
    public TagDto map(Tag from) {

        Set<String> planets = from
                .getPlanets()
                .stream()
                .map(planetsToStrings.INSTANCE)
                .collect(Collectors.toSet());

        return TagDto
                .builder()
                .title(from.getTitle())
                .planets(planets)
                .build();
    }

    @Override
    public Tag revers(TagDto to) {
        return null;

    }

    ;

    private enum planetsToStrings implements Function<Planet,String> {
        INSTANCE;

        @Override
        public String apply(Planet planet) {
            return planet.getPlanetName();
        }
    }

}
