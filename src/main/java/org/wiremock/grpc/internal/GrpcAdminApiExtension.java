/*
 * Copyright (C) 2024 Thomas Akehurst
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.wiremock.grpc.internal;

import com.github.tomakehurst.wiremock.admin.Router;
import com.github.tomakehurst.wiremock.extension.AdminApiExtension;
import com.github.tomakehurst.wiremock.http.RequestMethod;

public class GrpcAdminApiExtension implements AdminApiExtension {

  private final GrpcHttpServerFactory grpcHttpServerFactory;

  public GrpcAdminApiExtension(GrpcHttpServerFactory grpcHttpServerFactory) {
    this.grpcHttpServerFactory = grpcHttpServerFactory;
  }

  @Override
  public void contributeAdminApiRoutes(Router router) {
    router.add(
        RequestMethod.POST, "/ext/grpc/reset", new GrpcResetAdminApiTask(grpcHttpServerFactory));
  }

  @Override
  public String getName() {
    return "grpc-admin-api";
  }
}
