package cosmic.mappers;

import cosmic.commons.Mapper;
import cosmic.models.Planet;
import cosmic.models.dtos.PlanetDto;
import org.springframework.stereotype.Component;

@Component
public class PlanetMapper implements Mapper<Planet, PlanetDto> {

    @Override
    public PlanetDto map(Planet f) {
        return PlanetDto
                .builder()
                .planetName(f.getPlanetName())
                .distanceFromSun(f.getDistanceFromSun())
                .lengthOfYear(f.getLengthOfYear())
                .oneWayLightTimeToTheSun(f.getOneWayLightTimeToTheSun())
                .planetImage(f.getPlanetImage())
                .planetInfo(f.getPlanetInfo())
                .planetType(f.getPlanetType())
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
    }

