/*
 * Copyright 2021 Gypsophila open source organization.
 *
 * Licensed under the Apache License,Version2.0(the"License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.polaris;

import com.tencent.polaris.factory.api.RouterAPIFactory;
import com.tencent.polaris.router.api.core.RouterAPI;
import com.tencent.polaris.router.api.rpc.ProcessLoadBalanceRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lixiaoshuang
 */
@RestController
@RequestMapping(path = "polaris")
public class RouterController {
    
    private RouterAPI routerAPI  = RouterAPIFactory.createRouterAPI();
    
    @RequestMapping(path = "/router")
    public String router(){
//        ProcessLoadBalanceRequest processLoadBalanceRequest = new ProcessLoadBalanceRequest();
//        processLoadBalanceRequest.setCriteria();
//        processLoadBalanceRequest.setLbPolicy();
//        processLoadBalanceRequest.setDstInstances();
//        routerAPI.processLoadBalance();
        return "";
    }
}
