package cosmic.mappers;

import cosmic.commons.Mapper;
import cosmic.models.Planet;
import cosmic.models.Tag;
import cosmic.models.dtos.PlanetDto;
import org.apache.catalina.LifecycleState;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Max;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class PlanetMapper implements Mapper<Planet, PlanetDto> {

    @Override
    public PlanetDto map(Planet f) {

        List<String> tags = f
                .getTags()
                .stream()
                .map(tagsToStringsList.INSTANCE)
                .collect(Collectors.toList());

        return PlanetDto
                .builder()
                .planetName(f.getPlanetName())
                .distanceFromSun(f.getDistanceFromSun())
                .lengthOfYear(f.getLengthOfYear())
                .oneWayLightTimeToTheSun(f.getOneWayLightTimeToTheSun())
                .planetImage(f.getPlanetImage())
                .planetInfo(f.getPlanetInfo())
                .planetType(f.getPlanetType())
                .tags(tags)
                .build();

    }

    @Override
    public Planet revers(PlanetDto to) {
        return Planet
                .builder()
                .planetName(to.getPlanetName())
                .distanceFromSun(to.getDistanceFromSun())
                .lengthOfYear(to.getLengthOfYear())
                .oneWayLightTimeToTheSun(to.getOneWayLightTimeToTheSun())
                .planetImage(to.getPlanetImage())
                .planetInfo(to.getPlanetInfo())
                .planetType(to.getPlanetType())
                .build();

    }

    private enum tagsToStringsList implements Function<Tag, String> {
        INSTANCE;

        @Override
        public String apply(Tag tag) {
           return tag.getTitle();
        }
    }

}

