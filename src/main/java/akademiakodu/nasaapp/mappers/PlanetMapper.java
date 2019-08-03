package akademiakodu.nasaapp.mappers;

import akademiakodu.nasaapp.commons.Mapper;
import akademiakodu.nasaapp.models.Planet;
import akademiakodu.nasaapp.models.Tag;
import akademiakodu.nasaapp.models.dtos.PlanetDto;
import org.springframework.stereotype.Component;

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
                .map(tagsToStringList.INSTANCE)
                .collect(Collectors.toList());

        return PlanetDto
                .builder()
                .planetName(f.getPlanetName())
                .distanceFromSun(f.getDistanceFromSun())
                .oneWayLightTimeToTheSun(f.getOneWayLightTimeToTheSun())
                .lengthOfYear(f.getLengthOfYear())
                .planetType(f.getPlanetType())
                .planetInfo(f.getPlanetInfo())
                .planetImage(f.getPlanetImage())
                .tags(tags)
                .build();
    }

    @Override
    public Planet revers(PlanetDto to) {
        return Planet
                .builder()
                .planetName(to.getPlanetName())
                .distanceFromSun(to.getDistanceFromSun())
                .oneWayLightTimeToTheSun(to.getOneWayLightTimeToTheSun())
                .lengthOfYear(to.getLengthOfYear())
                .planetType(to.getPlanetType())
                .planetInfo(to.getPlanetInfo())
                .planetImage(to.getPlanetImage())
                .build();
    }

    private enum tagsToStringList implements Function<Tag, String> {
        INSTANCE;

        @Override
        public String apply(Tag tag) {
            return tag.getTitle();
        }
    }


}
