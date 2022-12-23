package org.folio.bulkops.client;

import org.folio.bulkops.domain.bean.ItemLocation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "locations")
public interface LocationClient {

  @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  ItemLocation getLocationById(@PathVariable String id);

}
