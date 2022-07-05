package quest.culture.partner.source.tourism.mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import quest.culture.partner.source.shared.mapping.EnhancedModelMapper;
import quest.culture.partner.source.tourism.domain.model.entity.Destination;
import quest.culture.partner.source.tourism.resource.CreateDestinationResource;
import quest.culture.partner.source.tourism.resource.DestinationResource;

import java.io.Serializable;
import java.util.List;


public class DestinationMapper implements Serializable {
    @Autowired
    EnhancedModelMapper mapper;

    // Object Mapping
    public DestinationResource toResource(Destination model) {
        return mapper.map(model, DestinationResource.class);
    }

    public Page<DestinationResource> modelListPage(List<Destination> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, DestinationResource.class), pageable, modelList.size());
    }

    public Destination toModel(CreateDestinationResource resource) {
        return mapper.map(resource, Destination.class);
    }
}
