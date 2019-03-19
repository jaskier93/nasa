package cosmic.models;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "planets")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Planet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "planet_name")
    private String planetName;
    @Column(name = "distance_from_sun")
    private long distanceFromSun;
    @Column(name = "one_Way_Light_Time_To_The_Sun")
    private double oneWayLightTimeToTheSun;
    @Column(name = "length_of_year")
    private long lengthOfYear;
    @Column(name = "planet_type")
    private String planetType;
    @Column(name = "planet_info")
    private String planetInfo;
    @Column(name = "planet_image")
    private String planetImage;
}
