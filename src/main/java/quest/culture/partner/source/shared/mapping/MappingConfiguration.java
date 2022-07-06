package quest.culture.partner.source.shared.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import quest.culture.partner.source.tourism.mapping.DestinationMapper;
import quest.culture.partner.source.tourism.mapping.PlaceMapper;

@Configuration("enhancedModelMapperConfiguration")
public class MappingConfiguration {

    @Bean
    public EnhancedModelMapper modelMapper() {
        return new EnhancedModelMapper();
    }
    @Bean
    public DestinationMapper destinationMapper() { return new DestinationMapper(); }

    @Bean
    public PlaceMapper placeMapper() { return new PlaceMapper(); }
}