package org.folio.bulkops.client;

import com.fasterxml.jackson.databind.JsonNode;
import org.folio.bulkops.domain.bean.HoldingsRecord;
import org.folio.bulkops.domain.bean.HoldingsRecordCollection;
import org.folio.bulkops.domain.bean.ItemLocationCollection;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@FeignClient(name = "holdings-storage/holdings")
public interface HoldingsClient {

  @GetMapping(value = "/{holdingsRecordId}", produces = MediaType.APPLICATION_JSON_VALUE)
  JsonNode getHoldingById(@PathVariable String holdingsRecordId);

  @PutMapping(value = "/{holdingsId}")
  void updateHoldingsRecord(@RequestBody HoldingsRecord holdingsRecord, @PathVariable String holdingsId);

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  HoldingsRecordCollection getHoldingsByQuery(@RequestParam String query, @RequestParam long offset, @RequestParam long limit);

}
