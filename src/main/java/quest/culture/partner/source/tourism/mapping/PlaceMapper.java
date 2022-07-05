package quest.culture.partner.source.tourism.mapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import quest.culture.partner.source.shared.mapping.EnhancedModelMapper;
import quest.culture.partner.source.tourism.domain.model.entity.Place;
import quest.culture.partner.source.tourism.resource.CreatePlaceResource;
import quest.culture.partner.source.tourism.resource.PlaceResource;
import quest.culture.partner.source.tourism.resource.UpdatePlaceResource;

import java.io.Serializable;
import java.util.List;

public class PlaceMapper implements Serializable{
    @Autowired
    EnhancedModelMapper mapper;

    // Object Mapping
    public PlaceResource toResource(Place model) {
        return mapper.map(model, PlaceResource.class);
    }

    public Page<PlaceResource> modelListPage(List<Place> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, PlaceResource.class), pageable, modelList.size());
    }

    public Place toModel(CreatePlaceResource resource) {
        return mapper.map(resource, Place.class);
    }

    public Place toModel(UpdatePlaceResource resource) {
        return mapper.map(resource, Place.class);
    }
}
