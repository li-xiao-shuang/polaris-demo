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

import com.tencent.polaris.api.core.ProviderAPI;
import com.tencent.polaris.api.rpc.InstanceHeartbeatRequest;
import com.tencent.polaris.api.rpc.InstanceRegisterRequest;
import com.tencent.polaris.api.rpc.InstanceRegisterResponse;
import com.tencent.polaris.factory.api.DiscoveryAPIFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author lixiaoshuang
 */
@RestController
@RequestMapping("polaris")
public class ProviderController {
    
    private ProviderAPI providerAPI = DiscoveryAPIFactory.createProviderAPI();
    
    /**
     * 服务注册
     *
     * @return
     */
    @RequestMapping("register")
    public String register() {
        
        InstanceRegisterRequest request = new InstanceRegisterRequest();
        request.setNamespace("default");
        request.setService("dummy");
        request.setHost("127.0.0.1");
        request.setPort(8111);
        request.setTtl(5);
        InstanceRegisterResponse register = providerAPI.register(request);
        hartBeta();
        
        return register.getInstanceId();
    }
    
    /**
     * 上报心跳
     */
    public void hartBeta() {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        scheduledExecutorService.scheduleAtFixedRate(() -> {
            InstanceHeartbeatRequest request = new InstanceHeartbeatRequest();
            request.setNamespace("default");
            request.setService("dummy");
            request.setHost("127.0.0.1");
            request.setPort(8111);
            providerAPI.heartbeat(request);
            System.out.println("hart beata");
        }, 0, 5, TimeUnit.SECONDS);
    }
}
