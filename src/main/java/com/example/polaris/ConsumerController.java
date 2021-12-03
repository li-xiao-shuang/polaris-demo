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

import com.alibaba.fastjson.JSONObject;
import com.tencent.polaris.api.core.ConsumerAPI;
import com.tencent.polaris.api.pojo.Instance;
import com.tencent.polaris.api.rpc.GetAllInstancesRequest;
import com.tencent.polaris.api.rpc.InstancesResponse;
import com.tencent.polaris.factory.api.DiscoveryAPIFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lixiaoshuang
 */
@RestController
@RequestMapping("polaris")
public class ConsumerController {
    
    private ConsumerAPI consumerAPI = DiscoveryAPIFactory.createConsumerAPI();
    
    /**
     * 获取全部实例
     *
     * @param namespace
     * @param service
     * @return
     */
    @RequestMapping(path = "get")
    public String getInstance(@RequestParam("namespace") String namespace, @RequestParam("service") String service) {
        GetAllInstancesRequest request = new GetAllInstancesRequest();
        request.setNamespace(namespace);
        request.setService(service);
        InstancesResponse allInstance = consumerAPI.getAllInstance(request);
        Instance[] instances = allInstance.getInstances();
        for (Instance instance : instances) {
            System.out.println(instance.toString());
        }
        return JSONObject.toJSONString(instances);
    }
}
