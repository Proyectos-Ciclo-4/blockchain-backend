package com.sofka.albertusview.business.gateways;

import com.sofka.albertusview.business.gateways.models.ApplicationViewModel;
import reactor.core.publisher.Mono;

public interface ApplicationViewRespository {

  Mono<ApplicationViewModel> findByUserIde( String applicationUserId );
  Mono<ApplicationViewModel> saveNewApplication( ApplicationViewModel application);
  Mono<ApplicationViewModel> addApplication( ApplicationViewModel application);


}
